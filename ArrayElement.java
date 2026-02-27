import java.util.Scanner;
public class ArrayElement {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array index: ");
        int position = input.nextInt();
        try {
            int value = numbers[position];
            System.out.println("Element at index " + position + " is: " + value);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range.");
        } 
        finally {
            System.out.println("Program execution completed.");
        }

        input.close();
    }
}