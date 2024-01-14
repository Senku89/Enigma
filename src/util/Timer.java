package util;

import java.util.logging.Logger;
import general.MainController;
public class Timer {
    private MainController mainController;
    private int timeSeconds;
    private boolean enCours;
    private Logger logger = Logger.getLogger(getClass().getName());
    private Thread timerThread;

    public Timer(MainController mainController, int initialTime) {
        this.mainController = mainController;
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
                    try{
                        mainController.timerIsUpdated(timeSeconds);
                    }catch(NullPointerException npe){
                        // Exception causée mais non bloquante
                    }
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
        mainController.outOfTime();
        // Actions supplémentaires à effectuer lorsque le temps est écoulé
    }
}