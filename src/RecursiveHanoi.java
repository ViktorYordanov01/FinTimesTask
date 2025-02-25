import java.util.*;

public class RecursiveHanoi {
    public static void hanoiTowerSolution(int numberOfRods, char fromRod, char toRod, char auxRod) {  
        if(numberOfRods == 0){
            System.out.println("Unfortunately, no solution has founded.");
            return;
        }
        else if (numberOfRods == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        hanoiTowerSolution(numberOfRods - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + numberOfRods + " from " + fromRod + " to " + toRod);
        hanoiTowerSolution(numberOfRods - 1, auxRod, toRod, fromRod);
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input the number of the disks:");
            int n = sc.nextInt(); 
            System.out.println("Here is the colution of the given problem:");
            hanoiTowerSolution(n, 'A', 'C', 'B');
        } 
    }
}


