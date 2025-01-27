/*
 * LILY DELLER
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//our main method 
//TO DO FOR REDO 
/*
 * need the output to organize based on shearing time AND arrival time 
 * 
 */
public class SheepShearingScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name (src/Sheep.txt): ");
        String fileName = scanner.nextLine();

        ArrayList<Sheep> sheeps = readSheepFile(fileName);
        if (sheeps != null) {
            scheduleShearing(sheeps);
        }
    }
 // this will read the sheep scheduling file and return with said print out
    private static ArrayList<Sheep> readSheepFile(String fileName) {
        ArrayList<Sheep> sheeps = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\t");
                String name = parts[0];
                int shearingTime = Integer.parseInt(parts[1]);
                int arrivalTime = Integer.parseInt(parts[2]);
                sheeps.add(new Sheep(name, shearingTime, arrivalTime));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }
        return sheeps;
    }
  //schedules the sheep shearing based on priority and prints said schedule
    private static void scheduleShearing(ArrayList<Sheep> sheeps) {
        MinHeap<Sheep> waitHeap = new MinHeap<>();
        int currentTime = 0;
        System.out.println("Shearing Schedule:");
        while (!sheeps.isEmpty() || !waitHeap.isEmpty()) {
            while (!sheeps.isEmpty() && sheeps.get(0).arrivalTime <= currentTime) {
                waitHeap.add(sheeps.remove(0));
            }
            if (!waitHeap.isEmpty()) {
                Sheep nextSheep = waitHeap.remove();
                System.out.println("Name: " + nextSheep.name + ", Shear Time: " + nextSheep.shearingTime + ", Arrival Time: " + nextSheep.arrivalTime);
                currentTime += nextSheep.shearingTime;
            } else if (!sheeps.isEmpty()) {
                currentTime = sheeps.get(0).arrivalTime;
            }
        }
    }
}