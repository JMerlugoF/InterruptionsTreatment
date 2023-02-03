import java.util.Random;

public class InterruptHandler {
    private static final int MAX_TYPES_OF_INTERRUPTION = 5;
    private int[] interruptions;
    private Random rand;

    public InterruptHandler() {
        interruptions = new int[MAX_TYPES_OF_INTERRUPTION];
        rand = new Random();
    }

    public synchronized void handleInterrupt(int threadId) {
        int interruptionType = rand.nextInt(MAX_TYPES_OF_INTERRUPTION);
        interruptions[interruptionType]++;
        System.out.println("Interrupção tipo " + interruptionType + " gerada pelo thread " + threadId);

        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadId + " foi interrompido");
        }
    }

    public synchronized void treatInterruptions() {
        int maxPriority = -1;
        int maxPriorityIndex = -1;
        for (int i = 0; i < MAX_TYPES_OF_INTERRUPTION; i++) {
            if (interruptions[i] > maxPriority) {
                maxPriority = interruptions[i];
                maxPriorityIndex = i;
            }
        }

        if (maxPriorityIndex >= 0) {
            System.out.println("Interrupção tipo " + maxPriorityIndex + " tratada");
            interruptions[maxPriorityIndex]--;
            notify();
        }
    }
}