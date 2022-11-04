package ViewHandler;

public abstract class CustomTimer {

    /**
     * Creates a time delay of specified milliseconds and handles InterruptedExceptions
     *
     * @param t The time delay needed in milliseconds
     */
    public static void timeDelay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }
}
