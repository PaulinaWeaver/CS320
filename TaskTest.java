// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import task.Task;

class TaskTest {
	
	// Helper method to create a valid Task
	private Task createValidTask() {
		return new Task("123", "Task 123", "Description for task 123");
	}

	// Test valid Contact creation
	@Test
	void testTaskId_ValidInput_TaskIdCreatedSuccessfully() {
	    Task task = createValidTask();
	    assertEquals("123", task.getTaskId()); // Check task ID
	}

	@Test
	void testTaskName_ValidInput_TaskNameCreatedSuccessfully() {
	    Task task = createValidTask();
	    assertEquals("Task 123", task.getTaskName()); // Check task name
	}

	@Test
	void testTaskDescription_ValidInput_TaskDescriptionCreatedSuccessfully() {
	    Task task = createValidTask();
	    assertEquals("Description for task 123", task.getTaskDescription()); // Check task description
	}

    
    // Test Task creation with boundary values
	@Test
	void testTaskId_BoundaryValues_TaskIdCreatedSuccessfully() {
	    Task task = new Task("1234567890", "Task 123456789012345", "Description for task 12345678901234567890123456789");
	    assertEquals("1234567890", task.getTaskId()); // Check task ID
	}

	@Test
	void testTaskName_BoundaryValues_TaskNameCreatedSuccessfully() {
	    Task task = new Task("1234567890", "Task 123456789012345", "Description for task 12345678901234567890123456789");
	    assertEquals("Task 123456789012345", task.getTaskName()); // Check task name
	}

	@Test
	void testTaskDescription_BoundaryValues_TaskDescriptionCreatedSuccessfully() {
	    Task task = new Task("1234567890", "Task 123456789012345", "Description for task 12345678901234567890123456789");
	    assertEquals("Description for task 12345678901234567890123456789", task.getTaskDescription()); // Check task description
	}
    
    // Test for task ID too long
    @Test
    void testTaskIdIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("012345678901", "Task 1", "Description for task 1");
        });  
    }

    // Test for null task ID
    @Test
    void testTaskIdIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task 1", "Description for task 1");
        });  
    }

    // Test for empty task ID (only spaces)
    @Test
    void testTaskIdIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("          ", "Task 1", "Description for task 1");
        });  
    }
    // Test for task name too long
    @Test
    void testTaskNameIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task 12345678901234567890", "Description for task 1");
        });  
    }

    // Test for null task name
    @Test
    void testTaskNameIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", null, "Description for task 1");
        });  
    }

    // Test for empty task name (only spaces)
    @Test
    void testTaskNameIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "         ", "Description for task 1");
        });  
    }
    // Test for task description too long
    @Test
    void testTaskDescriptionIsTooLong_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task 1", "Description for task 123456789012345678901234567890123456789012345678901234567890");
        });  
    }

    // Test for null task description
    @Test
    void testTaskDescriptionIsNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task 1", null);
        });  
    }

    // Test for empty task description (only spaces)
    @Test
    void testTaskDescriptionIsSpace_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "Task 1", "          ");
        });  
    }
    
    // --- Testing setters ---
    
    // Test setting a valid task name 
    @Test
    void testSetTaskName_ValidInput_SetterSuccessful() {
    	Task task = createValidTask();
        task.setTaskName("Task 456");
        assertEquals("Task 456", task.getTaskName());
    }
    
    // Test for task name too long 
    @Test
    void testSetTaskNameIsTooLong_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("Task 12345678901234567890");
        });  
    }

    // Test for null task name 
    @Test
    void testSetTaskNameIsNull_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null);
        });  
    }

    // Test for empty task name (only spaces)
    @Test
    void testSetTaskNameIsSpace_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("          ");
        });  
    }
    
    // Test setting a valid task description 
    @Test
    void testSetTaskDescription_ValidInput_SetterSuccessful() {
    	Task task = createValidTask();

        task.setTaskDescription("Description for task 456");
        assertEquals("Description for task 456", task.getTaskDescription());
    }

    // Test for task description too long 
    @Test
    void testSetTaskDescriptionIsTooLong_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("Description for task 123456789012345678901234567890123456789012345678901234567890");
        });  
    }

    // Test for null task description 
    @Test
    void testSetTaskDescriptionIsNull_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null);
        });  
    }

    // Test for empty task description (only spaces)
    @Test
    void testSetTaskDescriptionIsSpace_ThrowsException() {
        Task task = new Task("123", "Task 123", "Description for task 123");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("          ");
        });  
    }
}
