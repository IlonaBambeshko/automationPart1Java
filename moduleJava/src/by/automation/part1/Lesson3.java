package by.automation.part1;

import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        make_string_in_square_brackets();

        int[][] nums = {{0, 1, 2, 1, 1, 4, 5}, {3, 4, 5, 1, 1}};
        int result = count_ones(nums);

        int a = 3;
        int number = recurs(a);

        sum_of_2_numbers();
    }

    public static void make_string_in_square_brackets() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String name = in.nextLine();
        System.out.println("[" + name + "]");
    }

    public static int count_ones(int[][] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 1) {
                    c++;
                }
            }
        }
        System.out.println("Quantity of ones is " + c);
        return c;
    }

    public static int recurs(int x) {
        System.out.println("Get a number: " + x);
        x = x * 2;
        while (x < 30) {
            System.out.println("Recursion worked, number = " + x);
            return recurs(x);
        }
        System.out.println("\nRecursion ended. Number is greater than 30: " + x);
        return x;
    }

    public static double sum_of_2_numbers() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double number1 = in.nextDouble();
        System.out.println("Enter second number: ");
        double number2 = in.nextDouble();
        double sum = number2 + number1;
        System.out.println("Sum of your numbers is " + sum);
        return sum;
    }
}
