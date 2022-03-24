import tasktracker.history.InMemoryHistoryManager;
import tasktracker.manager.InMemoryTaskManager;
import tasktracker.manager.Managers;
import tasktracker.tasks.Epic;
import tasktracker.tasks.Status;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import static tasktracker.tasks.Status.*;

public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        Managers managers = new Managers();

        inMemoryTaskManager.create(new Task("0", "какие-то дела 1", Status.NEW));
        inMemoryTaskManager.create(new Task("1d", "какие-то дела 2", Status.NEW));
        inMemoryTaskManager.create(new Task("2", "какие-то дела 3", Status.NEW));
        inMemoryTaskManager.getTaskById(0);
        inMemoryTaskManager.getTaskById(2);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(1);
        inMemoryTaskManager.getTaskById(2);
//        inMemoryTaskManager.deleteTaskById(1);
//        inMemoryTaskManager.deleteTasks();

        inMemoryTaskManager.create(new Subtask("0", "под дела 1", NEW));
        inMemoryTaskManager.create(new Subtask("1",
                "под дела 2", DONE));
        inMemoryTaskManager.create(new Subtask("2", "под дела 3", NEW));
        inMemoryTaskManager.getSubtaskById(1);
        inMemoryTaskManager.getSubtaskById(2);
        inMemoryTaskManager.getSubtaskById(0);
        inMemoryTaskManager.getSubtaskById(0);
        inMemoryTaskManager.getSubtaskById(0);
        inMemoryTaskManager.getSubtaskById(2);
//        inMemoryTaskManager.deleteSubtasksById(0);
//        inMemoryTaskManager.deleteSubtasks();

       inMemoryTaskManager.create(new Epic("0", "переезд в новую квартиру", NEW));
       inMemoryTaskManager.getEpicById(0);
//       inMemoryTaskManager.deleteEpicById(0);
//       inMemoryTaskManager.deleteEpics();

//       System.out.println(managers.getDefaultHistory());
       System.out.println("------------------------------------------");
       System.out.println(inMemoryTaskManager.getInMemoryHistoryManager());
    }
}
