package tasktracker.manager;

import tasktracker.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private int count = 0;
    List<Task> historyTask = new ArrayList<>();

    @Override
    public void add(Task task) {
        count++;
        if(count >= 11){
            historyTask.add(task);
            historyTask.remove(0);
        } else {
            historyTask.add(task);
        }

    }

    @Override
    public List<Task> getHistory() {
        return historyTask;
    }

    @Override
    public String toString() {
        return "InMemoryHistoryManager{" +
                "count=" + count +
                ", historyTask=" + historyTask +
                '}';
    }
}
