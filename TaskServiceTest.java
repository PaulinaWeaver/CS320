// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

class TaskServiceTest {
    
    private TaskService taskService;
    
    @BeforeEach
    void init() {
        taskService = TaskService.getInstance();
        // Clear any existing tasks before each test
        taskService.getTasks().clear();
    }
    
    // Helper method to create a valid task
    private Task createValidTask(String taskId) {
        return new Task(taskId, "Sample Task", "Sample Description");
    }

    // Helper method to get the current size of the task list
    private int getCurrentSizeOfTaskList() {
        return taskService.getTasks().size();
    }

    @Test
    void testAddNewTask_TaskAddedSuccessfully() {
        Task task = createValidTask("123");

        int initialSize = getCurrentSizeOfTaskList(); // Get initial task list size

        // Add the new task
        boolean isAdded = taskService.add(task);

        // Assert that the task was added successfully
        assertTrue(isAdded, "Task should be added successfully.");

        // Verify that the task exists in the tasks map
        assertNotNull(taskService.getTasks().get("123"), "Task should exist in the map.");
        assertEquals(task, taskService.getTasks().get("123"), "Retrieved task should match the added one.");

        // Verify that the size of the task list increased by 1
        assertEquals(initialSize + 1, getCurrentSizeOfTaskList(), "Task list size should increase by 1.");
    }

    @Test
    void testAddingDuplicateTask_TaskNotAddedAgain_ReturnFalse() {
        Task task = createValidTask("123");

        // Add the task for the first time and verify it was added
        boolean isAddedFirstTime = taskService.add(task);
        assertTrue(isAddedFirstTime, "First addition should succeed.");

        int sizeAfterFirstAdd = getCurrentSizeOfTaskList();

        // Attempt to add the same task again
        boolean isAddedAgain = taskService.add(task);

        // Assert that adding the same task returns false
        assertFalse(isAddedAgain, "Adding an existing task should return false.");

        // Verify that the task remains unchanged
        assertEquals(task, taskService.getTasks().get("123"), "The task data should remain unchanged.");

        // Verify that the size of the list did not increase
        assertEquals(sizeAfterFirstAdd, getCurrentSizeOfTaskList(), "Task list size should remain the same after attempting to add a duplicate.");
    }
    
    @Test
    void testDeleteTask_TaskSuccessfullyRemovedFromList() {
        // Create a new task
        Task task = createValidTask("123");

        // Add the task to the service
        taskService.add(task);

        int initialSize = getCurrentSizeOfTaskList(); // Get the initial size of the task list

        // Delete the task by its taskId
        boolean isDeleted = taskService.delete("123");

        // Assert that the task was deleted successfully
        assertTrue(isDeleted, "Deleting an existing task should return true.");

        // Verify the task no longer exists in the tasks map
        assertNull(taskService.getTasks().get("123"), "Deleted task should not exist in the tasks list.");

        // Verify that the size of the list decreased by 1
        assertEquals(initialSize - 1, getCurrentSizeOfTaskList(), "Task list size should decrease by 1 after deletion.");
    }
    
    @Test
    void testDeleteNonExistentTask_NoTasksDeleted() {
        // Add a valid task
        Task task = createValidTask("123");
        taskService.add(task);

        int initialSize = getCurrentSizeOfTaskList(); // Get the initial size of the task list

        // Try to delete a non-existent task (task with ID "999")
        boolean result = taskService.delete("999");

        // Assert that the delete operation failed (it should return false)
        assertFalse(result, "Deleting a non-existent task should return false.");

        // Verify that the task list size remains unchanged
        assertEquals(initialSize, getCurrentSizeOfTaskList(), "Task list size should remain the same after attempting to delete a non-existent task.");

        // Verify that the original task still exists
        assertTrue(taskService.getTasks().containsKey("123"), "The original task should still exist in the task list.");
    }
    
    @Test
    void testUpdateTask_ValidInput_TaskUpdatedSuccessfully() {
        // Create a new task
        Task task = createValidTask("123");

        // Add the task to the service
        taskService.add(task);

        int initialSize = getCurrentSizeOfTaskList(); // Get the initial size of the task list

        // Create an updated task with new values
        Task updatedTask = new Task("123", "Updated Task", "Updated Description");

        // Update the task
        boolean isUpdated = taskService.update("123", updatedTask);

        // Assert that the task was updated successfully
        assertTrue(isUpdated, "Task should be updated successfully.");

        // Verify that the task's details were updated
        assertEquals("Updated Task", taskService.getTasks().get("123").getTaskName());
        assertEquals("Updated Description", taskService.getTasks().get("123").getTaskDescription());

        // Verify that the size of the task list remains the same after the update
        assertEquals(initialSize, getCurrentSizeOfTaskList(), "Task list size should remain the same after updating a task.");
    }
    
    @Test
    void testUpdateTask_InvalidData_UpdateNotSuccessful() {
        // Add a valid task
        Task task = new Task("123", "Task 123", "Description for task 123");
        taskService.add(task);

        // Create a new task object for updating with valid data initially
        Task updatedTask = new Task("123", "Task 123", "Description for task 123");

        // Try to update the task with invalid data (empty task name)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            updatedTask.setTaskName(""); // Set invalid task name
            taskService.update("123", updatedTask); // This should throw an exception due to invalid task name
        });
        // Verify the exception message
        assertEquals("Invalid task name", exception.getMessage());
        
        // Try to update the task with invalid task description (empty)
        IllegalArgumentException descriptionException = assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(""); // Set invalid task description
            taskService.update("123", task); // This should throw an exception due to invalid task description
        });
        assertEquals("Invalid task description", descriptionException.getMessage());

        // Verify that the task's data remains unchanged 
        Task storedTask = taskService.getTasks().get("123");
        assertNotNull(storedTask);
        assertEquals("Task 123", storedTask.getTaskName());
        assertEquals("Description for task 123", storedTask.getTaskDescription());
    }
    
    @Test
    void testUpdateTask_TaskNotFound_ReturnFalse() {
        // Try to update a task with a non-existent ID ("999")
        Task updated = new Task("999", "Nonexistent Task", "This task does not exist");

        // Ensure that the task with ID "999" does not exist (we haven't added it)
        assertNull(taskService.getTasks().get("999"), "Task with ID 999 should not exist.");

        // Try to update a task with a non-existent ID
        boolean isUpdated = taskService.update("999", updated);

        // Assert that the update operation failed (returns false)
        assertFalse(isUpdated, "Updating a non-existent task should return false.");

        // Verify that the task list has not been altered (no new task added)
        assertNull(taskService.getTasks().get("999"), "Task with ID 999 should still not exist after the update attempt.");
    }
}

