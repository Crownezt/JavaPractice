package Chapter5;

public class DiamondAsterisks {
    public static void main(String[] args) {
//        int number = 9;
//        char character = '*';
//        for(int row = 0; row <= number; row++){
//            for(int column = 0; column < row; column++) {
//                System.out.printf(" " + character + " ");
//            }
//            System.out.println();
//
//        }
        int number = 7;

        int m, n;

        // Outer loop 1
        // prints the first half diamond
        for (m = 1; m <= number; m++) {
            // Inner loop 1 print whitespaces inbetween
            for (n = 1; n <= number - m; n++) {
                System.out.print(" ");
            }

            // Inner loop 2 prints star
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }

            // Ending line after each row
            System.out.println();
        }

        // Outer loop 2
        // Prints the second half diamond
        for (m = number - 1; m > 0; m--) {

            // Inner loop 1 print whitespaces inbetween
            for (n = 1; n <= number - m; n++) {
                System.out.print(" ");
            }

            // Inner loop 2 print star
            for (n = 1; n <= m * 2 - 1; n++) {
                System.out.print("*");
            }

            // Ending line after each row
            System.out.println();
        }
    }
}
