package tasktracker.manager;

import tasktracker.history.HistoryManager;
import tasktracker.history.InMemoryHistoryManager;
import tasktracker.tasks.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager{

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private ArrayList<Subtask> subtasks = new ArrayList<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

    HistoryManager inMemoryHistoryManager = Managers.getDefaultHistory();

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
    public void updateTask(Task task) {
        if (this.tasks.containsKey(task.getId())) {
            this.tasks.put(task.getId(), task);
        }
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
    public Task updateTaskStatusById(Integer taskId, StatusTask status) {
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
        if (epics.containsKey(subtask.getEpicId())) {
            Epic epic = epics.get(subtask.getEpicId());
            subtasks.add(getSubtaskId(), subtask);
            epic.setSubtasks(subtasks);
            epics.put(getEpicId(), epic);
        }
    }

    @Override
    public void updateSubTask(Subtask subtask) {
        if (this.subtasks.contains(subtask.getId())) {
            this.subtasks.add(subtask.getId(), subtask);
        }
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
    public Subtask updateSubtaskStatusById(Integer subtaskId, StatusTask status) {
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
        epics.put(getEpicId(), epic);
    }

    @Override
    public void updateEpic(Epic epic) {
        if (this.epics.containsKey(epic.getId())) {
            this.epics.put(epic.getId(), epic);
        }
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
                StatusTask valueStatus = valueSubtask.getStatus();
                if(valueStatus != StatusTask.DONE) {
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
