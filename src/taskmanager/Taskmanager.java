package taskmanager;

import java.util.Scanner;

public class Taskmanager {

    
    public static void main(String[] args) {
       package taskmanager;

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

    
    

