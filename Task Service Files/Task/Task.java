/*
* Anthony Lee Hancock
* CS 320
* Prof. Kraya
* 12/7/2023
*/

package Task;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class Task {
    // Unique identifier for each task
    private String taskID;

    // Task properties
    private String taskName;
    private String taskDescription;

    // AtomicLong used to generate unique task IDs
    private static AtomicLong idGenerator = new AtomicLong();

    // Set to store used contact IDs
    private static Set<String> usedIds = ConcurrentHashMap.newKeySet();

    // Constructor initializes a task with a unique ID and sets its name and description
    public Task(String taskName, String taskDescription) {
        // Generate a unique task ID using AtomicLong
        do {
            this.taskID = String.valueOf(idGenerator.getAndIncrement());
        } while (!usedIds.add(this.taskID));

        // Set task name and description using setter methods
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    // Getter method for retrieving the task ID
    public String getTaskID() {
        return taskID;
    }

    // Getter method for retrieving the task name
    public String getTaskName() {
        return taskName;
    }

    // Getter method for retrieving the task description
    public String getTaskDescription() {
        return taskDescription;
    }

    // Setter method for updating the task name
    public void setTaskName(String taskName) {
        // Check if the provided taskName is null or empty
        if (taskName == null || taskName.isEmpty()) {
            this.taskName = "null";
        }
        // Check if the length of the taskName exceeds 10 characters
        else if (taskName.length() > 20) {
            // Truncate the taskName to the first 10 characters
            this.taskName = taskName.substring(0, 20);
        }
        // Check if the length of the taskName is equal to 20 characters
        else if (taskName.length() == 20) {
            this.taskName = taskName;
        }
        // If the taskName is within the acceptable range, set it as is
        else {
            this.taskName = taskName;
        }
    }

    // Setter method for updating the task description
    public void setTaskDescription(String taskDescription) {
        // Check if the provided taskDescription is null or empty
        if (taskDescription == null || taskDescription.isEmpty()) {
            this.taskDescription = "null";
        }
        // Check if the length of the taskDescription exceeds 30 characters
        else if (taskDescription.length() > 30) {
            // Truncate the taskDescription to the first 30 characters
            this.taskDescription = taskDescription.substring(0, 30);
        }
        // If the taskDescription is within the acceptable range, set it as is
        else {
            this.taskDescription = taskDescription;
        }
    }
}
