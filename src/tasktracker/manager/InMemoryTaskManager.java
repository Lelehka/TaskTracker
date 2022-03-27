package tasktracker.manager;

import tasktracker.history.InMemoryHistoryManager;
import tasktracker.tasks.Epic;
import tasktracker.tasks.Status;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager{

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private ArrayList<Subtask> subtasks = new ArrayList<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();

    private Integer taskId = 0;
    private Integer subtaskId = 0;
    private Integer epicId = 0;

    public Integer getTaskId() {
        return taskId++;
    }

    public Integer getSubtaskId() {
        return subtaskId++;
    }

    public Integer getEpicId() {
        return epicId++;
    }

    //методы для задач
    @Override
    public void create(Task task) {
        tasks.put(getTaskId(), task);
    }

    @Override
    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    @Override
    public Task getTaskById(Integer taskId) {
        Task valueTask = tasks.get(taskId);
        inMemoryHistoryManager.add(valueTask);
        return valueTask;
    }

    @Override
    public Task updateTaskStatusById(Integer taskId, Status status) {
        if(tasks.containsKey(taskId)) {
            Task valueTask = tasks.get(taskId);
            valueTask.setStatus(status);
            return tasks.put(taskId, valueTask);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTasks() {
        for (Integer i : tasks.keySet()) {
            Task task = tasks.get(i);
            inMemoryHistoryManager.remove(task.getId());
        }
        tasks.clear();
    }

    @Override
    public void deleteTaskById(Integer idTask){
        Task task = tasks.remove(idTask);
        inMemoryHistoryManager.remove(task.getId());
    }

    //методы для подзадач
    @Override
    public void create(Subtask subtask) {
        subtasks.add(getSubtaskId(), subtask);
    }

    @Override
    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    @Override
    public Subtask getSubtaskById(Integer subtaskId) {
        Subtask valueSubtask = subtasks.get(subtaskId);
        inMemoryHistoryManager.add(valueSubtask);
        return valueSubtask;
    }

    @Override
    public Subtask updateSubtaskStatusById(Integer subtaskId, Status status) {
        Subtask valueSubtask = subtasks.get(subtaskId);
        valueSubtask.setStatus(status);
        return subtasks.set(subtaskId, valueSubtask);
    }

    @Override
    public void deleteSubtasks(){
        for (int i = 0; i < subtasks.size(); i++) {
            Task task = subtasks.get(i);
            inMemoryHistoryManager.remove(task.getId());
        }
        subtasks.clear();
    }

    @Override
    public void deleteSubtasksById(Integer subtaskId) {
        Task task = subtasks.get(subtaskId);
        inMemoryHistoryManager.remove(task.getId());
        subtasks.remove(subtaskId);
    }

    //методы для Эпик
    @Override
    public void create(Epic epic) {
        epic.setSubtasks(subtasks);
        epics.put(getEpicId(), epic);
    }

    @Override
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    @Override
    public Epic getEpicById(Integer epicId) {
        Epic valueEpic = epics.get(epicId);
        inMemoryHistoryManager.add(valueEpic);
        return valueEpic;
    }

    @Override
    public void updateEpicStatus() {
        for (Integer epicId : epics.keySet()){
            Epic valueEpic = epics.get(epicId);
            for (int i = 0; i < subtasks.size(); i++){
                Subtask valueSubtask = subtasks.get(i);
                Status valueStatus = valueSubtask.getStatus();
                if(valueStatus != Status.DONE) {
                    valueSubtask.setStatus(valueStatus);
                } else {
                    valueEpic.setStatus(valueStatus);
                    epics.put(epicId, valueEpic);
                }
            }
        }
    }

    @Override
    public void deleteEpics(){
        for (Integer epic : epics.keySet()) {
            Task task = epics.get(epic);
            inMemoryHistoryManager.remove(task.getId());
        }
        epics.clear();
    }

    @Override
    public void deleteEpicById(Integer idEpic) {
        Task task = epics.remove(idEpic);
        inMemoryHistoryManager.remove(task.getId());
    }

    public List<Task> getInMemoryHistoryManager() {
        return inMemoryHistoryManager.getHistory();
    }
}
