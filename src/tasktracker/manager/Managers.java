package tasktracker.manager;

import tasktracker.history.HistoryManager;
import tasktracker.history.InMemoryHistoryManager;

public class Managers{

    public TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory(){

        return new InMemoryHistoryManager();
    }
}
