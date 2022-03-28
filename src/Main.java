import tasktracker.history.InMemoryHistoryManager;
import tasktracker.manager.InMemoryTaskManager;
import tasktracker.manager.Managers;
import tasktracker.tasks.Epic;
import tasktracker.tasks.StatusTask;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import static tasktracker.tasks.StatusTask.*;

public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        Managers managers = new Managers();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

        inMemoryTaskManager.create(new Task("0", "какие-то дела 1", StatusTask.NEW));
        inMemoryTaskManager.create(new Task("1", "какие-то дела 2", StatusTask.NEW));
        inMemoryTaskManager.create(new Task("2", "какие-то дела 3", StatusTask.NEW));
        inMemoryTaskManager.getTaskById(0);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(2);
        inMemoryTaskManager.getTaskById(1);
//        inMemoryTaskManager.deleteTaskById(2);
//        inMemoryTaskManager.deleteTasks();
        inMemoryTaskManager.create(new Epic("3", "эпик 1", NEW));
        inMemoryTaskManager.getEpicById(0);

        inMemoryTaskManager.create(new Subtask(0, "sub 1", "ffvfdvfd", NEW));
        inMemoryTaskManager.create(new Subtask(0, "sub 2", "ffvfdvfd", NEW));

        inMemoryTaskManager.create(new Epic("6" , "epic 2", NEW));
        inMemoryTaskManager.getEpicById(3);



//       System.out.println(managers.getDefaultHistory());
       System.out.println("------------------------------------------");
       System.out.println(inMemoryTaskManager.getInMemoryHistoryManager());
    }
}
