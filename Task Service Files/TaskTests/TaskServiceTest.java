/*
 * Anthony Lee Hancock
 * CS 320
 * Prof. Kraya
 * 12/7/2023
 */

package TaskTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Task.TaskService;

class TaskServiceTest {

    private TaskService service;

    // Set up a common environment before each test
    @BeforeEach
    void setUp() {
        // Initialize a new TaskService before each test to ensure a clean state
        service = new TaskService();
    }

    // Test to update task name
    @Test
    @DisplayName("Update taskName")
    @Order(1)
    void testUpdateTaskName() {
        // Add a task with a specific taskID
        service.addTask("Task Name", "Test");
        // Update the task name
        service.updateTaskName("New Task", "3");
        // Display the task list for verification
        service.displayTaskList();
        // Check if the task name was updated correctly
        assertEquals("New Task", service.getTask("3").getTaskName(), "Test Failed: taskName was not updated.");
    }

    // Test to update task description
    @Test
    @DisplayName("Update taskDescription")
    @Order(2)
    void testUpdateTaskDesc() {
        // Add a task with a specific taskID
        service.addTask("Test", "Description");
        // Update the task description
        service.updateTaskDesc("New Description", "1");
        // Display the task list for verification
        service.displayTaskList();
        // Check if the task description was updated correctly
        assertEquals("New Description", service.getTask("1").getTaskDescription(), "Test Failed: taskDescription was not updated.");
    }

    // Test to ensure that service correctly deletes tasks
    @Test
    @DisplayName("Delete Task")
    @Order(3)
    void testDeleteContact() {
        // Add a task with a specific taskID
        service.addTask("Task Name", "Description");
        // Delete the task
        service.deleteTask("0");
        // Display the task list for verification
        service.displayTaskList();
        // Check if the task was deleted (size of taskList should be 0)
        assertEquals(0, service.taskList.size(), "Test Failed: The contact was not deleted.");
    }

    // Test to ensure that service can add a task
    @Test
    @DisplayName("Task added")
    @Order(4)
    void testAddContact() {
        // Add a task with a specific taskID
        service.addTask("Task Name", "Description");
        // Display the task list for verification
        service.displayTaskList();
        // Check if the task was added correctly (task should not be null)
        assertNotNull(service.getTask("0"), "Test Failed: Task was not added correctly.");
    }
}
