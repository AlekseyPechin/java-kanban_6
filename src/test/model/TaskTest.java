package test.model;

import main.interfaces.TaskManager;
import main.model.Task;
import static main.model.Status.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.managers.Managers;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private static final TaskManager TASK_MANAGER = Managers.getDefault();
    private static final Task TASK_FOR_TEST = new Task(
            "Test addNewTask",
            "Test addNewTask description",
            NEW
    );

    private Task savedTask;
    private int taskId;

    @BeforeEach
    void BeforeEach() {
        taskId = TASK_MANAGER.addNewTask(TASK_FOR_TEST);
        savedTask = TASK_MANAGER.getTaskById(taskId);
    }

    @Test
    void getName() {
        final String nameTask = TASK_FOR_TEST.getName();
        final String nameSavedTask = savedTask.getName();

        assertEquals(nameTask, nameSavedTask, "Неверное имя задачи");
    }

    @Test
    void getDescription() {
        final String descriptionTask = TASK_FOR_TEST.getDescription();
        final String descriptionSavedTask = savedTask.getDescription();

        assertEquals(descriptionTask, descriptionSavedTask, "Неверное описание задачи");
    }

    @Test
    void getId() {
        final int idSavedTask = savedTask.getId();

        assertEquals(taskId, idSavedTask, "Неверный Id задачи");
    }
}