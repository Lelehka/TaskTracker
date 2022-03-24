package tasktracker.history;

import tasktracker.tasks.Task;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager{
    private final static int maxSize = 10;
    private List<Task> historyTask = new ArrayList<>(maxSize);
    private HistoryLinkedList<Task> historyLinkedList = new HistoryLinkedList<>();
    private Map<Integer, Task> history = new HashMap<>();

    private int id = 0;

    public int getId() {
        return id++;
    }

    @Override
    public void add(Task task) {
        historyLinkedList.linkLast(task);

        Task taskHistory = historyLinkedList.getTasks();

        history.put(getId(), taskHistory);

        for (Integer i : history.keySet()) {
            Task tasks = history.get(i);
            if(historyTask.size() >= maxSize){
                historyTask.add(tasks);
                historyTask.remove(0);
            } else {
                historyTask.add(tasks);
            }
        }

        Set<Task> historySet = new HashSet<>(historyTask);
        historyTask.clear();
        historyTask.addAll(historySet);
    }

    @Override
    public void remove(Task task){
        if (historyTask.contains(task)){
            historyTask.remove(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        return historyTask;
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
