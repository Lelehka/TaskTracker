package tasktracker.tasks;

public class Subtask extends Task{

    public Subtask(String nameTask, String taskDescription, Status status) {
        super(nameTask, taskDescription, status);
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
        return super.toString();
    }
}
