package tasktracker.history;

import tasktracker.tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager{
    private final static int maxSize = 10;
    private List<Task> historyTask = new ArrayList<>(maxSize);
    private HistoryLinkedList<Task> historyLinkedList = new HistoryLinkedList<>();
    private Map<Integer, Task> history = new HashMap<>();

    @Override
    public void add(Task task) {
        history.put(task.getId(), task);

        historyLinkedList.linkLast(task);
        Task tasks = historyLinkedList.getTasks();

        for (Integer i : history.keySet()){
            if (i.equals(tasks.getId())) {
                historyLinkedList.removeNode(tasks);
                historyTask.remove(tasks);
                history.remove(tasks.getId());
                historyTask.add(tasks);
            } else {
                historyTask.add(task);
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        return historyTask;
    }

    @Override
    public void remove(int id) {
        historyTask.remove(id);
    }

    @Override
    public String toString() {
        return "InMemoryHistoryManager{" +
                "history=" + history +
                '}' + '\n';
    }

    public class HistoryLinkedList<T> {

        private Node<T> head;
        private Node<T> tail;
        private int size = 0;

        public void linkLast(T element){
            final Node<T> oldTail = tail;
            final Node<T> newNode = new Node<>(oldTail, element, null);
            tail = newNode;
            if (oldTail != null) {
                oldTail.next = newNode;
            } else {
                head = oldTail;
            }
            size++;
        }

        public T getTasks() {
            return tail.data;
        }

        public void removeNode(T element){
            Node<T> current = head;

            while (current != null && current.data != element) {
                current = current.next;
            }
            if (current == null) {
                return;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }

        }

        public int size() {
            return this.size;
        }
    }
}
