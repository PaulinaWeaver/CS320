// Paulina Weaver
// CS 320 Project 1
// 02-16-2025

package task;

public class Task {
	private String taskId;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskId, String taskName, String taskDescription) {
        if (taskId == null || taskId.length() > 10 || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task ID");
        }
        if (taskName == null || taskName.length() > 20 || taskName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task name");
        }
        if (taskDescription == null || taskDescription.length() > 50 || taskDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid task description");
        }
        
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // Getters and Setters
    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20 || taskName.trim().isEmpty()) {
        	throw new IllegalArgumentException("Invalid task name");
        }
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 50 || taskDescription.trim().isEmpty()) {
        	throw new IllegalArgumentException("Invalid task description");
        }
        this.taskDescription = taskDescription;
    }
}
