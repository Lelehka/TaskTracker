package tasktracker.manager;

import tasktracker.tasks.Epic;
import tasktracker.tasks.StatusTask;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {

    void create(Task task);

    void create(Subtask subtask);

    void create(Epic epic);

    void updateTask(Task task);

    void updateSubTask(Subtask subtask);

    void updateEpic(Epic epic);

    HashMap<Integer, Task> getTasks();

    HashMap<Integer, Epic> getEpics();

    ArrayList<Subtask> getSubtasks();

    Task getTaskById(Integer id);

    Subtask getSubtaskById(Integer id);

    Epic getEpicById(Integer id);

    Task updateTaskStatusById(Integer id, StatusTask status);

    Subtask updateSubtaskStatusById(Integer id, StatusTask status);

    void updateEpicStatus();

    void deleteTasks();

    void deleteSubtasks();

    void deleteEpics();

    void deleteTaskById(Integer id);

    void deleteSubtasksById(Integer id);

    void deleteEpicById(Integer id);

    List<Task> getInMemoryHistoryManager();
}
