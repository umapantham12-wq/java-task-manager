import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String taskName;
    boolean isCompleted;

    Task(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false;
    }
}

public class TaskManager {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- TASK MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting Task Manager. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task name: ");
        String name = sc.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.taskName +
                    " [" + (t.isCompleted ? "Completed" : "Pending") + "]");
        }
    }

    static void completeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as completed: ");
        int num = sc.nextInt();

        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).isCompleted = true;
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();

        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}

