package util;

import java.util.logging.Logger;

public class Timer {
    private int timeSeconds;
    private boolean enCours;
    private Logger logger = Logger.getLogger(getClass().getName());
    private Thread timerThread;

    public Timer(int initialTime) {
        this.timeSeconds = initialTime;
        this.enCours = false;
    }

    public int getTimeSeconds() {
        return timeSeconds;
    }

    public void startTimer() {
        if (!enCours) {
            enCours = true;

            timerThread = new Thread(() -> {
                while (enCours && timeSeconds > 0) {
                    try {
                        // Pause une seconde
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        logger.severe("Thread Timer interrompu: " + e.getMessage());
                    }
                    timeSeconds--;
                }

                // Ajouter une action à effectuer lorsque le temps est écoulé
                if (timeSeconds == 0) {
                    timerExpired();
                }
            });

            timerThread.start();
        }
    }

    public void stopTimer() {
        enCours = false;
        if (timerThread != null && timerThread.isAlive()) {
            timerThread.interrupt();
        }
    }

    public void resumeTimer() {
        if (!enCours) {
            startTimer();
        }
    }

    public void resetTimer(int initialTime) {
        stopTimer();
        timeSeconds = initialTime;
    }

    // Ajouter une méthode à appeler lorsque le temps est écoulé
    private void timerExpired() {
        logger.info("Temps écoulé!");
        // Actions supplémentaires à effectuer lorsque le temps est écoulé
    }
}