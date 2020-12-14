import gsu.OperationType;
import gsu.ThreadGenerator;

import java.util.Scanner;

public class Runner{
    public static void main(String[] args) throws InterruptedException {


        Scanner scan = new Scanner(System.in);
        System.out.println("Count of threads: ");
        int countOfThreads = scan.nextInt();
        System.out.println("Maximal value: ");
        int maxValue = scan.nextInt();
        System.out.println("Choose an operation (+/-/*)");
        String operationType = scan.next();

        OperationType op = OperationType.ADDITION;

        switch (operationType){
            case "+":
                op = OperationType.ADDITION;
                break;
            case "-":
                op = OperationType.SUBTRACTION;
                break;
            case "*":
                op = OperationType.MULTIPLICATION;
                break;
            default:
                System.out.println("ERROR!");
        }

        ThreadGenerator calculator;
        calculator = new ThreadGenerator(countOfThreads, op, maxValue);
        calculator.execute();
        System.out.println("RESULT: " + calculator.getResult());

    }
}