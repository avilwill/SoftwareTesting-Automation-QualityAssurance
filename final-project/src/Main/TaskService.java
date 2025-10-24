package Main;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    //add contacts with a unique ID.
    public boolean addTask(Task task, String description) {
        if (tasks.containsKey(task.getTaskId())) {
            return false; // ID must be unique
        }
        task.setDescription(description);
        tasks.put(task.getTaskId(), task);
        return true;
    }

    //delete contacts per contact ID.
    public boolean deleteTask(String taskId) {
        return tasks.remove(taskId) != null;
    }

    //update contact fields per contact ID.
    public boolean updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            return false;
        }
        if (name != null) task.setName(name);
        if (description != null) task.setDescription(description);
        return true;
    }
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
