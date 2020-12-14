package gsu;

public class CalculatorThread extends Thread {

    private final int maxValue;
    private final int minValue;
    private long result;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int maxValue, int minValue) {
        this.maxValue = maxValue;
        this.minValue = minValue;

    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " is starting...");
           for (int i = this.minValue; i <= this.maxValue; i++) {
                this.result += result*i;

        }
        System.out.println("Result of " + threadName + " is " + this.result);
    }
}
