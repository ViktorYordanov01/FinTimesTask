import java.util.Scanner;
import java.util.Stack;


public class NonRecursiveHanoi {
    public static void hanoiTowerSolution (int n, char fromRod, char toRod, char auxRod) {
        int totalMoves = (1 << n) - 1; // 2^n - 1 total moves
        // Pegs representation (A, B, C)
        char[] rods = {fromRod, toRod, auxRod};
        // If n is even, swap destination and auxiliary to match the correct order
        if (n % 2 == 0) {
            char temp = toRod;
            toRod = auxRod;
            auxRod = temp;
        }
        // Using an array to represent three pegs as stacks
        @SuppressWarnings("unchecked")
        Stack<Integer>[] pegs = new Stack[3];
        for (int i = 0; i < 3; i++) {
            pegs[i] = new Stack<>();
        }
        // Push all disks onto the source rod
        for (int i = n; i >= 1; i--) {
            pegs[0].push(i);
        }
        // Perform the moves
        for (int i = 1; i <= totalMoves; i++) {
            int fromIndex = (i & i - 1) % 3; // Find the source peg
            int toIndex = ((i | i - 1) + 1) % 3; // Find the destination peg
            // Move the top disk from one peg to another
            int disk = pegs[fromIndex].pop();
            pegs[toIndex].push(disk);
            System.out.println("Move disk " + disk + " from " + rods[fromIndex] + " to " + rods[toIndex]);
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input number of disks:");
            int n = sc.nextInt(); // Number of disks
            System.out.println("The algorithm looks like this:");
            hanoiTowerSolution (n, 'A', 'C', 'B'); // A = source, C = destination, B = auxiliary
        }
    }
}
