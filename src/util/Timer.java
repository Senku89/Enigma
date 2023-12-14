package util;

import java.util.logging.Logger;

public class Timer {
    private int timeSeconds;
    private boolean enCours;
    Logger logger = Logger.getLogger(getClass().getName());

    public Timer(int initialTime) {
        this.timeSeconds = initialTime;
        this.enCours = false;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void startTimer() {
        enCours = true;

        Thread timerThread = new Thread(() -> {
            while (enCours && timeSeconds > 0) {
                try {
                    // Pause une seconde
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.severe("Thread Timer interrompu: " + e.getMessage());
                }
                timeSeconds--;
            }
        });

        timerThread.start();
    }

    public void stopTimer() {
        enCours = false;
    }

    public void resumeTimer() { }

    public void resetTimer(int initialTime) {
        stopTimer();
        timeSeconds = initialTime;
    }
}
