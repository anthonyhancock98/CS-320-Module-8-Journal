/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package TaskTests;

import static org.junit.jupiter.api.Assertions.*;

import Task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

class TaskTest {
    private Task task;

    // This method is executed before each test method to set up the initial state.
    @BeforeEach
    public void setUp() {
        task = new Task("TestTask", "TestDescription");
    }

    // TaskID Tests

    // Test to check if taskID has a length less than or equal to 10.
    @Test
    @DisplayName("taskID <= 10")
    public void testTaskLessThan10() {
        Task task = new Task("test", "test");

        assertTrue(task.getTaskID().length() <= 10);
    }
    // Test to check if taskID is not null.
    @Test
    @DisplayName("taskID != Null")
    public void testTaskNotNull() {
        Task task = new Task("test", "test");

        assertNotNull(task.getTaskID(), "Test Failed: testID is null");
    }
    // I've added this test to ensure that
    // the contactID is unique
    @Test
    @DisplayName("TaskID is Unique")
    public void testTaskIdUnique(){
        // Create two contacts
        Task task1 = new Task("test", "test");
        Task task2 = new Task("test", "test");

        // Ensure that their task IDs are unique
        assertNotEquals(task1.getTaskID(), task2.getTaskID(), "Test Failed: Task IDs are not unique");
        // Print out the taskID for further confidence
        System.out.println(task1.getTaskID());
        System.out.println(task2.getTaskID());
    }

    // TaskName Tests
    // Test to check if taskName has a length less than or equal to 20.
    @Test
    @DisplayName("taskName > 20 characters")
    void testTaskNameWithMoreThanTwentyCharacters() {
        Task task = new Task("TestTestTestTestTestTest", "Description");
        assertTrue(task.getTaskName().length() <= 20, "Test Failed: test name has more than 20 characters.");
    }
    // Test to check if taskName has a length less than or equal to 20.
    @Test
    @DisplayName("taskName < 20 characters")
    void testTaskNameWithLessThanTwentyCharacters() {
        Task task = new Task("Test", "Description");
        assertTrue(task.getTaskName().length() <= 20, "Test Failed: testName has more than 20 characters.");
    }
    // Test to check if taskName is equal to 20 characters
    @Test
    @DisplayName("taskName == 20 characters")
    void testTaskNameEqualTo20Characters() {
        Task task = new Task("12345678901234567890", "Description");
        assertTrue(task.getTaskName().length() == 20, "Test Failed: testName does not equal 20 characters.");
        System.out.println(task.getTaskName());
    }
    // Test to check if taskName is not null.
    @Test
    @DisplayName("taskName == null")
    void testTaskNameNotNull() {
        Task task = new Task(null, "Description");
        assertNotNull(task.getTaskName(), "Test Failed: testName was null.");
    }

    // TaskDescription Tests
    // Test to check if taskDescription has a length less than or equal to 50.
    @Test
    @DisplayName("taskDescription > 50 characters")
    void testTaskDescWithMoreThanFiftyCharacters() {
        Task task = new Task("Name", "This is 10" + "This is 10" + "This is 10" + "This is 10" + "This is 10" + "This is 10");
        assertTrue(task.getTaskDescription().length() <= 50, "Task Failed: taskDescription has more than 50 characters");
    }
    // Test to check if taskDescription has a length less than or equal to 50.
    @Test
    @DisplayName("taskDescription > 50 characters")
    void testTaskDescWithLessThanFiftyCharacters() {
        Task task = new Task("Name", "Test");
        assertTrue(task.getTaskDescription().length() <= 50, "Test Failed: taskDescription has more than 50 characters");
    }
    // Test to check if taskDescription is not null.
    @Test
    @DisplayName("taskDescription == null")
    void testTaskDescNotNull() {
        Task task = new Task("Name", null);
        assertNotNull(task.getTaskDescription(), "Test Failed: taskDescription was null");
    }
}
