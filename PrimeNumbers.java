
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
  
	// Function used to check input is a valid positive number 
	public static int checkInput(String numInput) {
		int num;
		// Try to cast input to an integer
		try {
			num = Integer.parseInt(numInput); 
			// If it is less than zero then input is invalid
			if(num < 0) {
				System.out.println("Please enter a number greater than zero");
				return -1;
			}	  
		}
		// If unable to cast then input is invalid
		catch(Exception e) {
			System.out.println("Please enter a valid integer");
			return -1;
		}
		// Return the integer
		return num;		
	}
	
	// Boolean function used to compare the minimum and maximum numbers and make sure they are different
	public static boolean compareNumbers(int min, int max) {
		// Return false if the minimum is greater than the maximum
		if(min > max){
			System.out.println("Minimum cannot be greater than maximum");
			return false;
		}
		// Return false if both numbers are the same
		else if(min == max){
			System.out.println("Minimum and maximum must be different");
			return false;
		}
		// Else return true
		return true;
	}
	
    public static void main(String[] args) {      
		// Variables to store the minimum and maximum numbers input
        int min;            
        int max;            
		// If two arguements are supplied
		if(args.length >= 2) {
			// Check that both numbers are valid
			min = checkInput(args[0]);
			max = checkInput(args[1]);
			// If either input is not valid then exit program
			if(min == -1 || max == -1)  {
				System.exit(0);
			}
			// If minimum number is greater than or equal to maximum number then exit program 
			else if(!compareNumbers(min, max)){
				System.exit(0);
			}
		}
		// If one arguement is supplied assume minimum to be zero
		else if(args.length == 1) {
			min = 0;
			max = checkInput(args[0]);
			if(max == -1) {
				System.exit(0);
			}
			else if(!compareNumbers(min, max)){
				System.exit(0);
			}
		}
		// Else no arguement supplied so ask user to enter number
		else {
			
			System.out.println("Enter two numbers to see all the prime numbers between them");
			// Continuous loop
			while(true){
				// Read in user input
				Scanner sc = new Scanner(System.in);

				// Read in minimum number
				// Continue looping while input is not valid
				while(true){   
					System.out.println("Enter a minimum number");
					// Check input is valid
					min = checkInput(sc.next());
					// If it is valid then break out of loop
					if(min != -1) {
						break;
					}
				}		
				// Read in maximum number
				while(true){          
					System.out.println("Enter a maximum number");
					max = checkInput(sc.next());
					if(max != -1) {
						break;
					}
				}
				// If minimum number is less than maximum number then break out of loop
				if(compareNumbers(min, max)) {
					break;
				}
			}
		}
          
        // Arraylist to store the prime numbers between the minimum and maximum
        List<Integer> primeNumbers = new ArrayList<>();
        // Iterate through each number from the minimum up to the maximum
        for(int i=min;i<= max;i++) {
            // If number is even
            if(i%2 == 0){
                // If it is 2 then add it to list of prime numbers
                if(i == 2){
                    primeNumbers.add(i);
                }
            }
            // Else number is odd
            else{
                // If it is 1 then add it to list of prime numbers
                if(i == 1){
                    primeNumbers.add(i);
                }
                else{
                    // Calculate the square root of the number and floor it to make it a whole number
                    double sqRoot = Math.floor(Math.sqrt(i));
                    // Variable to determine whether or not number is prime
					boolean isPrime = true;
					// Start at 3 and continue up to the square root
					for(int j=3;j<= sqRoot;j++){
						// If j divides evenly into i then it is not prime so break out of loop
						if(i%j == 0){
							isPrime = false;
							break;
						}
					}
					// If number is still prime then add it to list of prime numbers
					if(isPrime){
						primeNumbers.add(i);
					}  
                }
            }
        }
        // Show the number of prime numbers
        System.out.println("There are " + primeNumbers.size() + " prime numbers between " + min + " and " + max);
        // Iterate through each prime number
        for(int i=0;i<= primeNumbers.size()-1;i++){
            // If it is not the final number in list then print number followed by a comma
            if(i < primeNumbers.size()-1){
                System.out.print(primeNumbers.get(i) + ", ");
            }
            // Else it is the final number so print it without a comma
            else{
                System.out.print(primeNumbers.get(i));
            }
        }	
    }
}
