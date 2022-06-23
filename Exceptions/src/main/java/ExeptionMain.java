import com.customException.MyCustomException;
import org.w3c.dom.ls.LSInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExeptionMain {
    public static void main(String[] args) {

        //Variables
        Scanner sc = new Scanner(System.in);
        System.out.println("index number 0-3");
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
            System.out.println("code in our finally block will execute will activate anyway." +
                    "\n");
        }


        //Here I created a try catch block that takes user input
        try {
            System.out.println(a + "\n");
        } catch (Exception e) {
            System.out.println("This is our catch block - This was the error " + e + "\n");
        } finally {
            System.out.println("code in our finally block will execute will activate anyway." + "\n");
        }


        try {
            checkAge(17);
        } catch (NullPointerException | ArithmeticException ae) {
            System.out.println("This is our catch block - This was the error " + ae);
        }

        //here we take user input, but it is safe if age is lower than needed.\
        System.out.println("What is your age?" + "\n");
        a = sc.nextInt();
        try {
            checkAge(a);
        } catch (NullPointerException | ArithmeticException ae) {
            System.out.println("This is our catch block - This was the error " + ae.getMessage() + "\n");
        }


        //here takes in user input for checkAge method
        //This will throw a big Exception if input is less than 21
        /*
        a = sc.nextInt();
        checkAge(a);
         */


        //here we are handling our custom Exception
        try {
            useCustomException("i");
        } catch (MyCustomException mce) {
            System.out.println(mce);
        }


        // this will not work because we are removing the throws IOException from the main method
        /*
        //BufferedReader reads text from a character input stream
        //InputStreamReader takes a string input through system.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //readLine() is marked to say it 'throws' a IO Exception
        //that is why it is giving us a red line under the method
        String input = br.readLine();
        System.out.println(input.length());
        //this is used to prevent memory leaks, but isn't necessary
        //br.close();

        String input2 = br.readLine();
        System.out.println(input2);


        input = br.readLine();
        System.out.println(input);
*/

        //here is where we can handle out IOResource
        System.out.println("What is your name?");
        try {
            System.out.println(useIOResource());
        } catch (Exception e) {

        }

    }


    public static void checkAge(int age) {

        if (age < 21) {
            // using the 'throws' keyword allows you to throw a specific error.

            throw new ArithmeticException("ACCESS DENIED!!! - maybe when you are older.");

        } else {
            System.out.println("The butler will show you in.");

        }


    }


    public static void useCustomException(String name) throws MyCustomException {
        if (name.length() < 2) {
            //throw new ArithmeticException("");
            throw new MyCustomException("Name has to have more than one letter.");
        }
    }

    public static String useIOResource() throws Exception {
        BufferedReader br = null;
        String userInput = "";
        br = new BufferedReader(new InputStreamReader(System.in));

        userInput = br.readLine();

        return "Hello " + userInput;
    }


}
