// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import task.Task;

public class TaskService {
    private static TaskService instance; // Singleton instance
    private Map<String, Task> tasks; // Store tasks

    // Private constructor to prevent instantiation and initialize the tasks map
    private TaskService() {
        tasks = new ConcurrentHashMap<>();
    }

    // Public method to get the single instance
    public static TaskService getInstance() {
        if (instance == null) {
            instance = new TaskService();
        }
        return instance;
    }

    // Add a task
    public boolean add(Task task) {
    	return tasks.putIfAbsent(task.getTaskId(), task) == null;
    }

    // Delete a task
    public boolean delete(String taskId) {
        return tasks.remove(taskId) != null;
    }

    // Update a task
    public boolean update(String taskId, Task updatedTask) {
        Task existing = tasks.get(taskId);

        if (existing != null) {
            // The setters in Task will handle validation, throwing IllegalArgumentException if invalid
            existing.setTaskName(updatedTask.getTaskName());
            existing.setTaskDescription(updatedTask.getTaskDescription());
            return true;
        }
        return false; // Task not found
    }

    // Getter for tasks map (used for testing)
    public Map<String, Task> getTasks() {
        return tasks;
    }
}

