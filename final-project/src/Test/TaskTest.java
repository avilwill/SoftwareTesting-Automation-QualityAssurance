package Test;
import Main.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    // Test creating a task with valid inputs and verifying getters
    @Test
    void testGetters() {
        Task task = new Task("1", "main.Task 1", "main.Task 1 Description");
        Assertions.assertEquals("1", task.getTaskId());
        Assertions.assertEquals("main.Task 1", task.getName());
        Assertions.assertEquals("main.Task 1 Description", task.getDescription());
        System.out.println("Danielle Williams M4 CS 320 Milestone");
    }

    // Test setting name and description with valid inputs and verifying the changes
    // With assertEquals to check for correct values on valid inputs
    @Test
    void testSetName() {
        Task task = new Task("2", "main.Task 2", "main.Task 2 Description");
        task.setName("main.Task 2");
        Assertions.assertEquals("main.Task 2", task.getName());
    }

    @Test
    void testSetDescription() {
        Task task = new Task("3", "main.Task 3", "main.Task 3 Description");
        task.setDescription("main.Task 3 Description");
        Assertions.assertEquals("main.Task 3 Description", task.getDescription());
    }


    // **********TEST COMMENTED OUT SUCCESSFUL - COMMENTED TO AVOID FAILED TEST RUN**********
//    ************************FEEL FREE TO UNCOMMENT AND TEST*******************************************
//    @Test
//    void testSetNameError() {
//        main.Task task = new main.Task("2", "main.Task 2 hghghghghghghghghghghghghghghghghghgh", "main.Task 2 Description");
//        task.setName("main.Task 2 hghghghghghghghghghghghghghghghghghgh");
//        assertEquals("main.Task 2 hghghghghghghghghghghghghghghghghghgh", task.getName());
//    }
}

