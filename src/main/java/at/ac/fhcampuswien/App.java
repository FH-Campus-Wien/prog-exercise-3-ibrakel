package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    // Aufgabe 1
    public static void oneMonthCalendar(int numberOfDays,int startingDay){
    int count = 0;
    for (int j=1;j<startingDay;j++){
        System.out.print("  ");
        System.out.print(" ");
        count++;
    }
        for (int i = 1;i<=numberOfDays;i++){
        System.out.printf("%2d ",i);
        count++;
        if ( (count)%7==0){
            System.out.print("\n");
        }
    }
        if (count%7!=0){System.out.print("\n");}
    }

    // Aufgabe 2

    public static long[] lcg(long seed){
        long[] generatedArray = new long[10];
        // formel : X[i+1] = ( a*X[i] + c) % m
        long a = 1103515245;
        long c = 12345;
        long m = (long)Math.pow(2,31);

        // initialise first term of the recursive sequence by setting X[0] to the given seed value.
        generatedArray[0] = (a * seed + c) % m;
        // run the first term through the sequence to get the rest 9 values
        for (int i=1;i<10;i++){
            generatedArray[i] = (a*generatedArray[i-1] + c ) % m;
        }
        return generatedArray;
    }

    // Aufgabe 3
    public static int randomNumberBetweenOneAndHundred(){
        int randint = (int) (Math.random() * (100) + 1);
        return randint;
    }

    public static void guessingGame( int numberToGuess){
        int count = 1;
        boolean guess = false;
        Scanner scan = new Scanner(System.in);
        int attempt;
        while(guess == false){
            System.out.print("Guess number "+count+": ");
            attempt = scan.nextInt();
            if (count >= 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }
            if (attempt > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
                count++;
            }
            else if (attempt < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
                count++;
            }
            else if (attempt == numberToGuess){
                System.out.println("You won wisenheimer!");
                guess = true;
            }

        }

    }

    // Aufgabe 4
    public static boolean swapArrays(int[] numbers1, int[] numbers2){
        if (numbers1.length != numbers2.length){
            return false;}
        System.out.print("Array 1: \n{");
        for (int i=0;i<numbers1.length;i++){
            System.out.print(numbers1[i]+"\t");
        }
        System.out.print("\b}\n");
        System.out.print("Array 2: \n{");
        for (int i=0;i<numbers2.length;i++){
            System.out.print(numbers2[i]+"\t");
        }
        System.out.print("\b}\n");
        System.out.println("After swap:");
        int tmp;
        for (int i=0;i<numbers2.length;i++){
            tmp = numbers1[i];
            numbers1[i] = numbers2[i];
            numbers2[i]=tmp;
        }
        System.out.print("Array 1: \n{");
        for (int i=0;i<numbers1.length;i++){
            System.out.print(numbers1[i]+"\t");
        }
        System.out.print("\b}\n");
        System.out.print("Array 2: \n{");
        for (int i=0;i<numbers2.length;i++){
            System.out.print(numbers2[i]+"\t");
        }
        System.out.print("\b}\n\n");

        return true;
    }

    // Aufgabe 5
    public static char toUpper(char X){
        X = (char)((int)X - 32);
        return X;
    }
    public static char toLower(char X){
        X = (char)((int)X + 32);
        return X;
    }
    public static String camelCase(String input) {
        char[] text = input.toCharArray();
        // count valid characters
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            if ((int) text[i] >= 65 & (int) text[i] <= 90 | (int) text[i] >= 97 & (int) text[i] <= 122) {
                //              uppercase                               lowercase                                 special character
                count++;
            }
        }
        // handle the first char
        if ((int) text[0] > 97 & (int) text[0] < 123) {
            text[0] = toUpper(text[0]);
        }
        // initialise new char array with length of count
        char[] properCamelCase = new char[count];
        // iteratively check the cases and change as needed
        int k = 0;
        properCamelCase[k] = text[0];
        k++;
        for (int j = 1; j < text.length; j++) {
            // check if its uppercase following a space, if true -> lower it
            if ((int) text[j] >= 65 & (int) text[j] <= 90) {
                if ((int) text[j - 1] != 32) {
                    text[j] = toLower(text[j]);
                }
                properCamelCase[k] = text[j];
                k++;
            }
            // check if its lowercase follwing a space, if true -> upper it
            else if ((int) text[j] >= 97 & (int) text[j] <= 122) {
                if ((int) text[j - 1] == 32) {
                    text[j] = toUpper(text[j]);
                }
                properCamelCase[k] = text[j];
                k++;
            }
        }
        StringBuilder builder = new StringBuilder();

        String output = String.valueOf(builder.append(properCamelCase));
        return output;
    }

    // Aufgabe 6
    public static int checkDigit(int[] iban){
        int ibanLength = iban.length;
        int weighingThePosition;
        int digitWeight;
        int ibanSum = 0;

        for (int i = 0; i < ibanLength; i++) {
            weighingThePosition = i + 2; // add 2 to the index
            digitWeight = weighingThePosition * iban[i]; // multiply the weight to the value in that position
            ibanSum += digitWeight; // add to the sum of values
        }

        int remainder = ibanSum % 11;
        int check = 11 - remainder;

        // exceptions:
        if (check == 10)
            check = 0;
        else if (check == 11)
            check = 5;

        return check;
    }


    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        String line ="AnY noise annoYs an oYster but a noisY noise annoYs an oYster more.";
        String line2 = camelCase(line);
        System.out.println(line2);
        System.out.println((int) 'A');
        int[] numbers1= {1,34,5,4,3,2};
        int[] numbers2= {4,64,201,4,3,2};
        boolean returnValue = swapArrays(numbers1,numbers2);
        oneMonthCalendar(31,7);
        oneMonthCalendar(28,1);
        oneMonthCalendar(30,4);



    }
}