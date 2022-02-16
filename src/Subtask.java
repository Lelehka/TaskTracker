public class Subtask extends Task{

    Integer idSubTask = 0;

    public Subtask(String nameTask, String taskDescription, String status) {
        super(nameTask, taskDescription, status);
    }

    public Integer getIdSubTask() {
        return idSubTask;
    }

    public void setIdSubTask(Integer idSubTask) {
        this.idSubTask = idSubTask;
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
