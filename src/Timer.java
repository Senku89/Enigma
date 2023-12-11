public class Timer {
    private int timeSeconds;
    private boolean isRunning;

    public Timer(int initialTime) {
        this.timeSeconds = initialTime;
        this.isRunning = false;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void startTimer() {
        isRunning = true;

        Thread timerThread = new Thread(() -> {
            while (isRunning && timeSeconds > 0) {
                try {
                    // Pause une seconde
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("Timer thread interrupted: " + e.getMessage());
                }
                timeSeconds--;
            }
        });

        timerThread.start();
    }

    public void stopTimer() {
        isRunning = false;
    }

    public void resetTimer(int initialTime) {
        stopTimer();
        timeSeconds = initialTime;
    }
}
