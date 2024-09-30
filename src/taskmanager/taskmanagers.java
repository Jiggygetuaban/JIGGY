package taskmanager;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private int id;
    private String name;
    private int priority;
    private boolean isCompleted;

    public Task(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isCompleted = false; 
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Task: " + name + ", Priority: " + priority + ", Completed: " + (isCompleted ? "Yes" : "No");
    }
}

public class TaskManager {
    private ArrayList<Task> tasks;
    private int nextId;

    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1; 
    }

    public void addTask(String name, int priority) {
        Task newTask = new Task(nextId++, name, priority);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void removeTask(int id) {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                taskToRemove = task;
                break;
            }
        }
        
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Removed task: " + taskToRemove);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public void markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsCompleted();
                System.out.println("Marked task as completed: " + task);
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        do {
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter the task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter the priority level (1-5): ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    taskManager.addTask(taskName, priority);
                    break;
                case "2":
                    taskManager.viewTasks();
                    break;
                case "3":
                    System.out.print("Enter task ID to remove: ");
                    int removeId = Integer.parseInt(scanner.nextLine());
                    taskManager.removeTask(removeId);
                    break;
                case "4":
                    System.out.print("Enter task ID to mark as completed: ");
                    int completeId = Integer.parseInt(scanner.nextLine());
                    taskManager.markTaskAsCompleted(completeId);
                    break;
                case "5":
                    System.out.println("Exiting Task Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!command.equals("5"));

        scanner.close();
    }
}
