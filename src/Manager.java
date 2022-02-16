import java.util.HashMap;

public class Manager {
    //Статусы "NEW", "IN_PROGRESS", "DONE"
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();

    Integer id = 0;
    Integer idEpic = 0;

    public Integer getId() {
        return id++;
    }

    public Integer getIdEpic() {
        return idEpic++;
    }

    //методы для задач
    public void saveTask(Task task) {
        tasks.put(getId(), task);
    }

    public void printTask() {
        for (Integer idTask : tasks.keySet()) {
            System.out.println(idTask + " " + tasks.get(idTask));
        }
    }

    public void printIdTask(Integer idTask) {
        if(tasks.containsKey(idTask)) {
            Task valueTask = tasks.get(idTask);
            System.out.println(idTask + " " + valueTask);
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void changeStatusTask(Integer idTask, String status) {
        if(tasks.containsKey(idTask)) {
            Task valueTask = tasks.get(idTask);
            valueTask.status = status;
            tasks.put(idTask, valueTask);
            System.out.println("Статус изменен!");
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void changeIdTask(Integer idTask, Integer idNewTask) {
        if(tasks.containsKey(idTask)) {
            Task valueTask = tasks.get(idTask);
            valueTask.idTask = idNewTask;
            tasks.put(valueTask.getIdTask(), valueTask);
            tasks.remove(idTask);
            System.out.println("Идентификатор изменен!");
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void removeTask(){
        tasks.clear();
    }

    public void removeIdTask(Integer idTask){
        tasks.remove(idTask);
    }

    //методы для подзадач
    public void saveSubTask(Subtask subtask){
        subtasks.put(getId(), subtask);
    }

    public void printSubTask(){
        for (Integer idSubTask : subtasks.keySet()){
            System.out.println(idSubTask + " " + subtasks.get(idSubTask));
        }
    }

    public void printIdSubTask(Integer idSubTask) {
        if (subtasks.containsKey(idSubTask)){
            Subtask valueSubTask = subtasks.get(idSubTask);
            System.out.println(idSubTask + " " + valueSubTask);
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void changeStatusSubTask(Integer idSubTask, String status) {
        if(subtasks.containsKey(idSubTask)) {
            Subtask valueSubTask = subtasks.get(idSubTask);
            valueSubTask.status = status;
            subtasks.put(idSubTask, valueSubTask);
            System.out.println("Статус изменен!");
        }
    }

    public void changeidSubTask(Integer idSubTask, Integer idNewSubTask) {
        if(subtasks.containsKey(idSubTask)){
            Subtask valueSubTask = subtasks.get(idSubTask);
            valueSubTask.idSubTask = idNewSubTask;
            subtasks.put(valueSubTask.getIdSubTask(), valueSubTask);
            subtasks.remove(idSubTask);
            System.out.println("Идентификатор изменен!");
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void removeSubTask(){
        subtasks.clear();
    }

    public void removeIdSubTask(Integer idSubTask){
        subtasks.remove(idSubTask);
    }

    //методы для Эпик
    public void saveEpic(Epic epic) {
        epic.setSubtasks(subtasks);
        epics.put(getIdEpic(), epic);
    }

    public void printEpic() {
        for (Integer idEpic : epics.keySet()) {
            System.out.println(idEpic + " " + epics.get(idEpic));
            for (Integer idSubTask : subtasks.keySet()) {
                System.out.println(idSubTask + " " + subtasks.get(idSubTask));
            }
        }
    }

    //печать подзадачи по id эпика
    public void printSubTaskFromEpic(Integer idEpic) {
        if(epics.containsKey(idEpic)) {
            Epic valueEpic = epics.get(idEpic);
            for (Integer idSubTask : subtasks.keySet()) {
                System.out.println(idSubTask + " " + subtasks.get(idSubTask));
            }
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void changeIdEpic(Integer idEpic, Integer idNewEpic) {
        if(epics.containsKey(idEpic)) {
            Epic valueEpic = epics.get(idEpic);
            valueEpic.idEpic = idNewEpic;
            epics.put(valueEpic.getIdEpic(), valueEpic);
            epics.remove(idEpic);
            System.out.println("Идентификатор изменен!");
        } else {
            System.out.println("Такого идентификатора нет!");
        }
    }

    public void changeStatusEpic() {
        String status = "NEW";
        for(Integer idEpic : epics.keySet()) {
            Epic valueEpic = epics.get(idEpic);
            System.out.println(valueEpic.status);
            for (Integer idSubTask : subtasks.keySet()) {
                Subtask valueSubTask = subtasks.get(idSubTask);
                if(!valueSubTask.status.equals(status)) {
                    status = valueSubTask.status;
                } else {
                    valueEpic.status = status;
                    epics.put(idEpic, valueEpic);
                }
            }
        }

    }

    public void removeEpic(){
        epics.clear();
    }

    public void removeIdEpic(Integer idEpic){
        epics.remove(idEpic);
    }
}
