import tasktracker.history.HistoryManager;
import tasktracker.history.InMemoryHistoryManager;
import tasktracker.manager.InMemoryTaskManager;
import tasktracker.manager.Managers;
import tasktracker.manager.TaskManager;
import tasktracker.tasks.*;

import static tasktracker.tasks.StatusTask.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();
        HistoryManager inMemoryHistoryManager = Managers.getDefaultHistory();

        taskManager.create(new Task(GenerateId.getId(),"0", "какие-то дела 1", StatusTask.NEW));
        taskManager.create(new Task(GenerateId.getId(), "1", "какие-то дела 2", StatusTask.NEW));
        taskManager.create(new Task(GenerateId.getId(),"2", "какие-то дела 3", StatusTask.NEW));
        taskManager.getTaskById(0);
        taskManager.getTaskById(1);
        taskManager.getTaskById(2);
        taskManager.getTaskById(1);
//        taskManager.deleteTaskById(2);
//        taskManager.deleteTasks();
        taskManager.create(new Epic(GenerateId.getId(), "3", "эпик 1", NEW));
        taskManager.getEpicById(3);

        taskManager.create(new Subtask(3, GenerateId.getId(), "sub 1", "ffvfdvfd", NEW));
        taskManager.create(new Subtask(3, GenerateId.getId(), "sub 2", "ffvfdvfd", NEW));

        taskManager.create(new Epic(GenerateId.getId(),"4" , "epic 2", NEW));
        taskManager.getEpicById(4);



       System.out.println("------------------------------------------");
        System.out.println(inMemoryHistoryManager.getHistory());
       System.out.println(taskManager.getInMemoryHistoryManager());
    }
}
