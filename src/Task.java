import java.util.Objects;

public class Task{
    protected String nameTask;
    protected String taskDescription;
    protected String status;
    protected int idTask;

    public Task(String nameTask, String taskDescription, String status) {
        this.nameTask = nameTask;
        this.taskDescription = taskDescription;
        this.status = status;
    }

    public int getIdTask() {
        return idTask++;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idTask == task.idTask && Objects.equals(nameTask, task.nameTask) && Objects.equals(taskDescription, task.taskDescription) && Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameTask, taskDescription, idTask, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
