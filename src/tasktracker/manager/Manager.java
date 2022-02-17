package tasktracker.manager;

import tasktracker.tasks.Epic;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    //Статусы "NEW", "IN_PROGRESS", "DONE"
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private ArrayList<Subtask> subtasks = new ArrayList<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();

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
    public void saveTask(Task task) {
        tasks.put(getTaskId(), task);
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public Task getTaskById(Integer taskId) {
        Task valueTask = tasks.get(taskId);
        return valueTask;
    }

    public Task updateTaskStatusById(Integer taskId, String status) {
        if(tasks.containsKey(taskId)) {
            Task valueTask = tasks.get(taskId);
            valueTask.setStatus(status);
            return tasks.put(taskId, valueTask);
        } else {
            return null;
        }
    }

    public void removeTasks(){
        tasks.clear();
    }

    public void removeTaskById(Integer idTask){
        tasks.remove(idTask);
    }

    //методы для подзадач
    public void saveSubtasks(Subtask subtask){
        subtasks.add(getSubtaskId(), subtask);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Subtask getSubtaskBtId(Integer subtaskId) {
        Subtask valueSubtask = subtasks.get(subtaskId);
        return valueSubtask;
    }

    public Subtask updateSubtaskStatusById(Integer subtaskId, String status){
        Subtask valueSubtask = subtasks.get(subtaskId);
        valueSubtask.setStatus(status);
        return subtasks.set(subtaskId, valueSubtask);
    }

    public void removeSubtasks(){
        subtasks.clear();
    }

    public void removeSubtaskById(Integer subtaskId){
        subtasks.remove(subtaskId);
    }

    //методы для Эпик
    public void saveEpic(Epic epic) {
        epic.setSubtasks(subtasks);
        epics.put(getEpicId(), epic);
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public Epic getEpicById(Integer epicId) {
        Epic valueEpic = epics.get(epicId);
        return valueEpic;
    }

    public void updateEpicStatus(){
        String status = "NEW";
        for (Integer epicId : epics.keySet()){
            Epic valueEpic = epics.get(epicId);
            for (int i = 0; i < subtasks.size(); i++){
                Subtask valueSubtask = subtasks.get(i);
                if(!(valueSubtask.getStatus().equals(status))) {
                    status = valueSubtask.getStatus();
                } else {
                    valueEpic.setStatus(status);
                    epics.put(epicId, valueEpic);
                }
            }
        }
    }

    public void removeEpics(){
        epics.clear();
    }

    public void removeEpicById(Integer idEpic){
        epics.remove(idEpic);
    }
}
