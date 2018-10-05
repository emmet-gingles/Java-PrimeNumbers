
package primenumbers;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
  
    public static void main(String[] args) {        
        int min;            // variable to store the minimum number input
        int max;            // variable to store the maximum number input 
        
        // continue loop while inputs are not valid
        while(true){
            System.out.println("Enter two numbers to see all the prime numbers between them");
            // used for reading user input
            Scanner sc = new Scanner(System.in);

            // Read in minimum number
            // continue looping while input is not valid
            while(true){   
                System.out.println("Enter a minimum number");
                // read input as string
                String input = sc.next();
                // attempt to convert input to a number
                try{
                    min = Integer.parseInt(input); 
                    // if number is greater than zero then break out of while loop
                    if(min > 0){
                        break;
                    }
                    System.out.println("Please enter a number greater than zero");
                }
                catch(Exception e){
                    System.out.println("Please enter a valid number");
                }
            }
            
            // Read in maximum number
            while(true){          
                System.out.println("Enter a maximum number");
                String input = sc.next();
                try{
                    max = Integer.parseInt(input); 
                    if(max > 0){
                        break;
                    }
                    System.out.println("Please enter a number greater than zero");
                }
                catch(Exception e){
                    System.out.println("Please enter a valid number");
                }
             }

            // check that minimum number is less thsn maximum number
            if(min > max){
                System.out.println("Start number cannot be greater than end number");
            }
            // check that the numbers are not the same
            else if(min == max){
                System.out.println("Start number and end number must be different");
            }
            // else both inputs are valid so break out of loop
            else{
                break;
            }
        }
        
        // arraylist to store the prime numbers between the minimum and maximum
        List<Integer> primeNumbers = new ArrayList<>();
        // loop through each number from the minimum up to the maximum
        for(int i=min;i<= max;i++){
            // if number is even
            if(i%2 == 0){
                // if it is 2 then add it to list of prime numbers
                if(i == 2){
                    primeNumbers.add(i);
                }
            }
            // else number is odd
            else{
                // if it is 1 then add it to list of prime numbers
                if(i == 1){
                    primeNumbers.add(i);
                }
                else{
                    // calculate the square root of the number
                    double sqRoot = Math.sqrt(i);
                    // check that the square root is not the square of another number
                    if(sqRoot != Math.floor(sqRoot)){
                        // floor it to ensure it is a whole number
                        sqRoot = Math.floor(sqRoot);
                        // variable to determine whether or not number is prime
                        boolean isPrime = true;
                        // start at 3 and continue up to the square root
                        for(int j=3;j<= sqRoot;j++){
                            // if j divides evenly into i then it is not prime so break out of loop
                            if(i%j == 0){
                                isPrime = false;
                                break;
                            }
                        }
                        // if number is still prime then add it to list of prime numbers
                        if(isPrime){
                            primeNumbers.add(i);
                        }
                    }   
                }
            }
        }
        // show the number of prime numbers
        System.out.println("There are " + primeNumbers.size() + " prime numbers between " + min + " and " + max);
        // loop through each prime number
        for(int i=0;i<= primeNumbers.size()-1;i++){
            // if index is not the final index then print number followed by a comma
            if(i< primeNumbers.size()){
                System.out.print(primeNumbers.get(i) + ", ");
            }
            // else it is the final index so just print number
            else{
                System.out.print(primeNumbers.get(i));
            }
        }   
    }
}
