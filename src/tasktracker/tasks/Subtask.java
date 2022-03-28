package tasktracker.tasks;

public class Subtask extends Task{

    private int epicId;

    public Subtask(String nameTask, String taskDescription, StatusTask status) {
        super(nameTask, taskDescription, status);
    }

    public Subtask(int epicId, String nameTask, String taskDescription, StatusTask status) {
        super(nameTask, taskDescription, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {

         return getId() + ": tasktracker.tasks.Task{" + epicId + " = " +
                "nameTask='" + nameTask + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status='" + getStatus() + '\'' +
                '}' + '\n';
    }
}
