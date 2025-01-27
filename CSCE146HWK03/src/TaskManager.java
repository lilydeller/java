//LILY DELLER
import java.io.File; // We'll use this to work with files.
import java.io.FileNotFoundException; // helps handle file-related errors.
import java.io.PrintWriter; // 
import java.util.Scanner; //  allows us to take input from the user.

// main class for handling tasks
public class TaskManager {
    private static GenLL<Task>[] organizedTasks; // where we store our tasks

    // constructor for TaskManager.
    public TaskManager() {
        // initialize 
        organizedTasks = new GenLL[5]; // 5 levels
        for (int i = 0; i < organizedTasks.length; i++) {
            organizedTasks[i] = new GenLL<>(); // each priority level has its own list of tasks.
        }
    }
    
    //  main method where the program starts execution.
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(); // make a new TaskManager object.

        Scanner scanner = new Scanner(System.in); // to take input from the user.
        boolean running = true; // keeps the program running until the user decides to quit.

        while (running) {
            // display menu options to the user.
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Print Tasks");
            System.out.println("4. Read Tasks from File");
            System.out.println("5. Write Tasks to File");
            System.out.println("0. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // get the user's choice.
            scanner.nextLine(); // 

            // actions based on user's choice.
            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    removeTask(scanner);
                    break;
                case 3:
                    printTasks();
                    break;
                case 4:
                    readTasksFromFile(scanner);
                    break;
                case 5:
                    writeTasksToFile(scanner);
                    break;
                case 0:
                    running = false; // Exit the loop and end the program.
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 0 to 5.");
            }
        }

        scanner.close(); // close the scanner when done.
    }

    // method adds a task to the list.
    private static void addTask(Scanner scanner) {
        System.out.print("Enter task action: ");
        String action = scanner.nextLine(); // task action from user.
        System.out.print("Enter task priority (0 to 4): ");
        int priority = scanner.nextInt(); // task priority from user.
        scanner.nextLine(); 

        Task newTask = new Task(action, priority); // make a new task object.
        organizedTasks[priority].add(newTask); // add the task to the appropriate priority level.
        System.out.println("Task added successfully.");
    }

    // method removes a task from the list.
    private static void removeTask(Scanner scanner) {
        System.out.print("Enter task priority to remove (0 to 4): ");
        int priority = scanner.nextInt(); // get priority of task to remove.
        scanner.nextLine(); 
        System.out.print("Enter task action to remove: ");
        String action = scanner.nextLine(); 
        organizedTasks[priority].removeTask(organizedTasks, priority, action); 
    }

    // method prints all tasks.
    private static void printTasks() {
        for (int i = 0; i < organizedTasks.length; i++) {
            System.out.println("Priority " + i + " tasks:");
            ListNode<Task> current = organizedTasks[i].head; // start from the head of each priority level.
            while (current != null) {
                System.out.println(current.data); 
                current = current.next;
            }
        }
    }

    // method reads tasks from a file.
    private static void readTasksFromFile(Scanner scanner) {
        System.out.print("Enter the file name to read tasks from: ");
        String fileName = scanner.nextLine(); // file name from user.
        File file = new File(fileName); // create a File object.
        try {
            Scanner fileScanner = new Scanner(file); 
            for (int i = 0; i < organizedTasks.length; i++) {
                organizedTasks[i] = new GenLL<Task>(); 
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // read each line from the file.
                String[] parts = line.split("\t"); 
                if (parts.length == 2) {
                    int priority = Integer.parseInt(parts[0]); 
                    String action = parts[1]; 
                    Task task = new Task(action, priority); 
                    organizedTasks[priority].add(task); 
                } else {
                    System.out.println("Ignoring invalid line: " + line);
                }
            }
            System.out.println("Tasks loaded from file successfully.");
            fileScanner.close(); // close the file scanner when done.
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // method writes tasks to a file.
    private static void writeTasksToFile(Scanner scanner) {
        System.out.print("Enter the file name to write tasks to: ");
        String fileName = scanner.nextLine(); // get file name from user.
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (int i = 0; i < organizedTasks.length; i++) {
                ListNode<Task> current = organizedTasks[i].head; 
                while (current != null) {
                    writer.println(i + "\t" + current.data.getAction()); 
                    current = current.next;
                }
            }
            System.out.println("Tasks written to file successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
