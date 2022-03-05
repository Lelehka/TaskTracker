package tasktracker.manager;

import tasktracker.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final static int maxSize = 10;
    private List<Task> historyTask = new ArrayList<>(maxSize);

    @Override
    public void add(Task task) {
        if(historyTask.size() >= maxSize){
            historyTask.add(task);
            historyTask.remove(0);
        } else {
            historyTask.add(task);
        }

    }

    public void deleteHistory(Task task){
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
                "historyTask=" + historyTask +
                '}';
    }
}
