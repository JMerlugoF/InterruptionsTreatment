public class InterruptThread extends Thread {
    private InterruptHandler interruptHandler;
    private int threadId;

    public InterruptThread(InterruptHandler interruptHandler, int threadId) {
        this.interruptHandler = interruptHandler;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (true) {
            interruptHandler.handleInterrupt(threadId);
        }
    }
}