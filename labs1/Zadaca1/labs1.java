// ENG: For a given array of random numbers given from standard input, perform a shift of all zeros at the beginning of the sequence.
//Print the transformed array to standard output.//
// ( Input : 12
//1 9 8 4 0 0 2 7 0 6 0 9
//Output : Transformiranata niza e:
//0 0 0 0 1 9 8 4 2 7 6 9 ) //

import java.util.Scanner;

public class ShiftZerosToBeginning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.println("Transformiranata niza e:");
        for (int i = 0; i < n; i++) {
            if (array[i] == 0) {
                System.out.print("0 ");
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                System.out.print(array[i]);
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
        }

        scanner.close();
    }
}
