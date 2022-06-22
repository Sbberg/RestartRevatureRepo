import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class ExeptionMain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int[] intArray = {1, 2, 3, 4};


        // this will cause an IndexOutOfBounds exception because this array doesn't have 8 or more values
        //System.out.println(intArray[7]);


        //testing the same logic but with a try catch block
        try {

            System.out.println(intArray[7]);
        } catch (Exception e) {
            System.out.println("This is our catch block - This was the error " + e);
        } finally {
            System.out.println("code in our finally block will execute will activate anyway." +
                    "\n");
        }

        try {

            System.out.println(intArray[3]);
        } finally {
            System.out.println("code in our finally block will execute will activate anyway.");
        }


        //Here I created a try catch block that takes user input
        try {
            System.out.println(a);

        } catch (Exception e) {
            System.out.println("This is our catch block - This was the error " + e);

        } finally {
            System.out.println("code in our finally block will execute will activate anyway." +
                    "\n");

        }

        //here takes in user input for checkAge method
        int age = sc.nextInt();
        checkAge(age);

        try {
            checkAge(17);
        } catch (NullPointerException | ArithmeticException ae) {
            System.out.println("This is our catch block - This was the error " + ae);
        }



    }


    public static void checkAge(int age){

        if(age < 21){
            // using the 'throws' keyword allows you to throw a specific error.

            throw new ArithmeticException("ACCESS DENIED!!! - maybe when you are older.");

        }else{
            System.out.println("The butler will show you in.");

        }


    }


}
