//LILY DELLER
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// generic Queue implementation
class Queue<T> {
    // our node class for holding data and pointing to the next node
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // front/ rear pointers for the queue
    private Node<T> front;
    private Node<T> rear;

    // the constructor will initialize the queue
    public Queue() {
        this.front = null;
        this.rear = null;
    }
   
    // enqueue method to add an item to the queue
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // dequeue method to remove and return the front item from the queue
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    // to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

// our class for simulating robot commands on a board
public class RobotCommandSimulator {
    // constants for representing different elements on the board
    private static final char EMPTY_SPACE = '_';
    private static final char OBSTACLE = 'X';
    private static final char ROBOT = 'O';

    // the main method to run the simulation
    public static void main(String[] args) {
        System.out.println("Welcome to the Robot Simulator");
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

        try {
            while (true) {
                // read the board file and commands file
                System.out.println("Enter file for the Board:");
                String boardFile = reader.readLine();
                char[][] board = readBoard(boardFile);

                System.out.println("Enter file for the Robot Commands:");
                String commandFile = reader.readLine();
                Queue<String> commands = readCommands(commandFile);

                // if both board and commands are valid, simulate the commands
                if (board != null && commands != null) {
                    simulateCommands(board, commands);
                }

                // prompt user if they want to quit
                System.out.println("WANT TO QUIT? Enter \"true\" to quit or hit enter to run another simulation:");
                String quit = reader.readLine();
                if (quit.equals("true")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to read the board from a file
    private static char[][] readBoard(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            char[][] board = new char[10][10];
            String line;
            int row = 0;
            // it'll read each line of the file to populate the board
            while ((line = reader.readLine()) != null && row < 10) {
                for (int col = 0; col < line.length() && col < 10; col++) {
                    char ch = line.charAt(col);
                    if (ch == EMPTY_SPACE || ch == OBSTACLE) {
                        board[row][col] = ch;
                    } else {
                        System.out.println("Invalid character in board file: " + ch);
                        return null;
                    }
                }
                row++;
            }
            return board;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // our method to read commands from a file and store them in a queue
    private static Queue<String> readCommands(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Queue<String> commands = new Queue<>();
            String line;
            // to read each line of the file and enqueue valid commands
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Move ") && (line.endsWith("Up") || line.endsWith("Down") || line.endsWith("Left") || line.endsWith("Right"))) {
                    commands.enqueue(line);
                } else {
                    System.out.println("Invalid command in command file: " + line);
                }
            }
            return commands;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // our method to simulate the commands on the board
    private static void simulateCommands(char[][] board, Queue<String> commands) {
        int row = 0, col = 0;
        board[row][col] = ROBOT;
        System.out.println("SIMULATION STARTING!!!");

        int commandCount = 0;
        // to process each command from the queue
        while (!commands.isEmpty()) {
            System.out.println("Command " + commandCount++);
            printBoard(board);

            String command = commands.dequeue();
            // to execute the command and handle collisions
            switch (command) {
                case "Move Up":
                    if (row > 0 && board[row - 1][col] != OBSTACLE) {
                        board[row][col] = EMPTY_SPACE;
                        row--;
                        board[row][col] = ROBOT;
                    } else {
                        System.out.println("CRASH");
                        return;
                    }
                    break;
                case "Move Down":
                    if (row < 9 && board[row + 1][col] != OBSTACLE) {
                        board[row][col] = EMPTY_SPACE;
                        row++;
                        board[row][col] = ROBOT;
                    } else {
                        System.out.println("CRASH");
                        return;
                    }
                    break;
                case "Move Left":
                    if (col > 0 && board[row][col - 1] != OBSTACLE) {
                        board[row][col] = EMPTY_SPACE;
                        col--;
                        board[row][col] = ROBOT;
                    } else {
                        System.out.println("CRASH");
                        return;
                    }
                    break;
                case "Move Right":
                    if (col < 9 && board[row][col + 1] != OBSTACLE) {
                        board[row][col] = EMPTY_SPACE;
                        col++;
                        board[row][col] = ROBOT;
                    } else {
                        System.out.println("CRASH");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid command: " + command);
                    break;
            }
        }

        System.out.println("THE END!!!!");
    }

    // final method to print the current state of the board
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println();
    }
}

