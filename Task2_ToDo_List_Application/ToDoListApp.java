import java.io.*;
import java.util.*;

public class ToDoListApp {
    private static final String FILE_NAME = "tasks.dat"; // File to save tasks
    private List<Task> tasks;

    public ToDoListApp() {
        this.tasks = loadTasks(); // Load tasks from file when app starts
    }

    // Display the menu
    private void displayMenu() {
        System.out.println("\n===== TO-DO LIST APPLICATION =====");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Remove Task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    // Add a new task
    private void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        scanner.nextLine();  // Consume the newline
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        saveTasks();
        System.out.println("Task added successfully.");
    }

    // View all tasks
    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Mark a task as completed
    private void markTaskAsCompleted(Scanner scanner) {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markAsCompleted();
            saveTasks();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Remove a task
    private void removeTask(Scanner scanner) {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to remove: ");
        int taskNumber = scanner.nextInt();

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            saveTasks();
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Save tasks to a file
    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    // Load tasks from a file
    private List<Task> loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    // Run the application loop
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> markTaskAsCompleted(scanner);
                case 4 -> removeTask(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new ToDoListApp().run();
    }
}

