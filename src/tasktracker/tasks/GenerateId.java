package tasktracker.tasks;

public class GenerateId {

    private static int id = 0;

    public static int getId() {
        return id++;
    }
}
