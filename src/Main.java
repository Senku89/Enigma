import general.MainController;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        MainController jeuEnigma = new MainController();
        jeuEnigma.startMenuPrincipal();
    }
}