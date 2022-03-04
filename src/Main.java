import tasktracker.manager.InMemoryHistoryManager;
import tasktracker.manager.InMemoryTaskManager;
import tasktracker.manager.Managers;
import tasktracker.tasks.Epic;
import tasktracker.tasks.Status;
import tasktracker.tasks.Subtask;
import tasktracker.tasks.Task;

import static tasktracker.tasks.Status.*;

public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        Managers managers = new Managers();

        inMemoryTaskManager.create(new Task("0", "написать список продуктов", Status.NEW));
        inMemoryTaskManager.create(new Task("1", "написать список продуктов", Status.NEW));
        inMemoryTaskManager.create(new Task("2", "написать список продуктов", Status.NEW));
        System.out.println(inMemoryTaskManager.getTaskById(0));
        System.out.println(inMemoryTaskManager.getTaskById(2));
        System.out.println(inMemoryTaskManager.getTaskById(1));
        System.out.println(inMemoryTaskManager.getTaskById(0));
        System.out.println(inMemoryTaskManager.getTaskById(1));
        System.out.println(inMemoryTaskManager.getTaskById(2));

        inMemoryTaskManager.create(new Subtask("0", "нужно купить коробки, скотч", NEW));
        inMemoryTaskManager.create(new Subtask("1",
                "грузовой автомобиль, заказать на пятницу к 15:00", DONE));
        inMemoryTaskManager.create(new Subtask("2", "узнать где есть ближайший ремонт ключей", NEW));
        System.out.println(inMemoryTaskManager.getSubtaskById(1));
        System.out.println(inMemoryTaskManager.getSubtaskById(2));
        System.out.println(inMemoryTaskManager.getSubtaskById(0));
        System.out.println(inMemoryTaskManager.getSubtaskById(0));

       inMemoryTaskManager.create(new Epic("0", "переезд в новую квартиру", NEW));
       System.out.println(inMemoryTaskManager.getEpicById(0));

       System.out.println(managers.getDefaultHistory());
       System.out.println(inMemoryTaskManager.getInMemoryHistoryManager());
    }
}
