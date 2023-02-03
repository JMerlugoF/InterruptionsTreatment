import java.util.Scanner;

public class InterruptionsTreatment {
    public static void main(String[] args) {
        InterruptHandler interruptHandler = new InterruptHandler();
        InterruptThread[] interruptThreads = new InterruptThread[10];
        for (int i = 0; i < interruptThreads.length; i++) {
            interruptThreads[i] = new InterruptThread(interruptHandler, i);
            interruptThreads[i].start();
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Pressione enter para tratar interrupções");
            scanner.nextLine();
            interruptHandler.treatInterruptions();
        }
    }
}