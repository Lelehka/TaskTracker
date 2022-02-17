import tasktracker.manager.Manager;
import tasktracker.tasks.Epic;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.saveTask(new Task("Покупка", "написать список продуктов", "NEW"));
        System.out.println(manager.getTaskById(0));
        System.out.println(manager.updateTaskStatusById(0, "Done"));
        manager.removeTasks();

        manager.saveSubtasks(new Subtask("Собрать вещи", "нужно купить коробки, скотч", "NEW"));
        manager.saveSubtasks(new Subtask("Заказать машину",
                "грузовой автомобиль, заказать на пятницу к 15:00", "DONE"));
        manager.saveSubtasks(new Subtask("Сделать дубликат ключей", "узнать где есть ближайший ремонт ключей", "NEW"));
        System.out.println(manager.getSubtasks());
        System.out.println(manager.updateSubtaskStatusById(0,"DONE"));
        System.out.println(manager.updateSubtaskStatusById(2,"DONE"));
        System.out.println(manager.getSubtasks());

        manager.saveEpic(new Epic("Переезд", "переезд в новую квартиру", "NEW"));
        System.out.println(manager.getEpicById(0));
        manager.updateEpicStatus();
        System.out.println((manager.getEpics()));
    }
}
