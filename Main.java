import java.util.Scanner

/**
 * Apply some array operations with a terminal menu.
 */
public class Main {
    public static void main(String[] args) {
        boolean wannaContinue = true;
        boolean arrayCreated = false;
        boolean notPrintResult;
        int[] array = {0}; // To silence the compiler
        int result = 0; // To silence the compiler
        int size;

        int choice = 0;
        final int CREATE_ARRAY = 1;
        final int FIND_MINIMUM = 2;
        final int FIND_MAXIMUM = 3;
        final int FIND_AVERAGE = 4;
        final int FIND_SUM = 5;

        Scanner scanner = new Scanner(System.in);

        while (wannaContinue){
            System.out.println();

            notPrintResult = false;
            System.out.printf("Please choose an operation:%n" +
                    "1- Create an array containing random numbers%n" +
                    "2- Find minimum in the array%n" +
                    "3- Find maximum in the array%n" +
                    "4- Find the average in the array%n" +
                    "5- Find the sum of odd or even indexes in the array%n");

            if (arrayCreated){
                System.out.println("You may create a new array or continue to work on" +
                        "the existing one.");
            }
            else {
                System.out.println("You must create an array, only valid input is 1.");
            }

            choice = takeValidInput(1,5);

            System.out.println();

            if (!arrayCreated && choice != CREATE_ARRAY){
                System.out.println("You must create an initial array. Invalid Choice!");
                continue;
            }

            switch (choice){
                case CREATE_ARRAY:
                    System.out.println("Please enter the size of the array: ");
                    size = takeValidInput(1, Integer.MAX_VALUE);
                    array = createRandomArray(size);
                    System.out.println("The array has been created.");
                    notPrintResult = true;
                    arrayCreated = true;
                    break;
                case FIND_MINIMUM:
                    result = findMinimum(array);
                    break;
                case FIND_MAXIMUM:
                    result = findMaximum(array);
                    break;
                case FIND_AVERAGE:
                    result = findAverage(array);
                    break;
                case FIND_SUM:
                    System.out.println("Please enter any odd number to add odd indexes," +
                            "or any even number to add even indexes.");
                    evenOrOdd = takeValidInput(Integer.MIN_VALUE, Integer.MAX_VALUE);
                    notPrintResult = true;
                    break;
                default:
                    notPrintResult = true;
                    System.out.println("Your input is not between 1 and 5.");
            }

            if (!notPrintResult){
                System.out.println("Your result is: " + result);
            }

            System.out.print("Do you want to continue (Enter 1 to continue," +
                    " any other number to exit: ");
            if (!scanner.nextLine().equals("1")){
                wannaContinue = false;
            }
        }
    }

    /**
    * Lower and upper bounds are both inclusive.
    */
    public static int takeValidInput(int lowerBound, int upperBound){
        boolean invalidEntered;
        boolean noLowerBound = lowerBound == Integer.MIN_VALUE;
        boolean noUpperBound = upperBound == Integer.MAX_VALUE;
        int output = 0; // To silence the compiler

        Scanner scanner = new Scanner(System.in);
        String prompt = String.format("%nPlease enter an integer");

        if (noLowerBound && !noUpperBound){
            prompt += " less than or equal to " + upperBound;
        }
        else if (!noLowerBound && noUpperBound) {
            prompt += " greater than or equal to " + lowerBound;
        }
        else if (!noLowerBound && !noUpperBound) {
            prompt += " between " + lowerBound + " and " + upperBound;
        }
        prompt += ": ";

        do {
            invalidEntered = false;
            System.out.println(prompt);

            if (scanner.hasNextInt()){
                output = scanner.nextInt();
            }
            else {
                invalidEntered = true;
                scanner.nextLine();
                continue;
            }

            if (output < lowerBound || output > upperBound){
                invalidEntered = true;
            }

        } while(invalidEntered);

        return output;
    }
}