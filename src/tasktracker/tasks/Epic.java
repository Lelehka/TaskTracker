package tasktracker.tasks;

import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task{

    protected ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String nameTask, String taskDescription, Status status) {
        super(nameTask, taskDescription, status);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return subtasks.equals(epic.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasks);
    }

    @Override
    public String toString() {
        return "tasktracker.tasks.Epic{" +
                "nameTask='" + nameTask + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", status='" + getStatus() + '\'' +
                ", subtasks=" + subtasks +
                '}' + '\n';
    }
}
