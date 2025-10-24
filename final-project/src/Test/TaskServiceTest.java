package Test;
//import files from main package and junit library for testing

import Main.Task;
import Main.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;

class TaskServiceTest {

    // test the add task using assertTrue, assertFalse, to verify expected outcomes.
    @Test
    void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("1", "task 1", "Desc");
        Assertions.assertTrue(service.addTask(task, "Desc"));
        Assertions.assertEquals(task, service.getTask("1"));
    }

    // test duplicate id using assertTrue, assertFalse methods to verify expected outcomes.
    @Test
    void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "task 1", "Desc1");
        Task task2 = new Task("1", "task 1", "Desc2");
        Assertions.assertTrue(service.addTask(task1, "Desc1"));
        Assertions.assertFalse(service.addTask(task2, "Desc2"));
    }

    // test the delete task success using assertTrue, and assertNull methods to verify expected outcomes.
    @Test
    void testDeleteTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("2", "task 2", "Desc");
        service.addTask(task, "Desc");
        Assertions.assertTrue(service.deleteTask("2"));
        assertNull(service.getTask("2"));
    }

    // test the delete task not found using assertFalse method to verify expected outcomes.
    @Test
    void testDeleteTaskNotFound() {
        TaskService service = new TaskService();
        Assertions.assertFalse(service.deleteTask("nonexistent"));
    }

    // test the update task success and not found using assertTrue and assertEquals methods to verify expected outcomes.
    @Test
    void testUpdateTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("3", "task 3", "OldDesc");
        service.addTask(task, "OldDesc");
        Assertions.assertTrue(service.updateTask("3", "task 3", "NewDesc"));
        Task updated = service.getTask("3");
        Assertions.assertEquals("task 3", updated.getName());
        Assertions.assertEquals("NewDesc", updated.getDescription());
    }

    // test for tasks not found using assertFalse method to verify expected outcomes.
    @Test
    void testUpdateTaskNotFound() {
        TaskService service = new TaskService();
        Assertions.assertFalse(service.updateTask("nonexistent", "task 0", "Desc"));
    }

    // get task using assertEquals and assertNull methods to verify expected outcomes.
    @Test
    void testGetTask() {
        TaskService service = new TaskService();
        Task task = new Task("4", "task 4", "Desc");
        service.addTask(task, "Desc");
        Assertions.assertEquals(task, service.getTask("4"));
        assertNull(service.getTask("nonexistent"));
    }
}
