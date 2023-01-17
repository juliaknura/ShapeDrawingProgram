package main;
import gui.MainMenu;
import scene.*;

public class Main {
    public static void main(String[] args) {

        Scene scene = new Scene();

        MainMenu gui = new MainMenu(scene);
        gui.start();


    }
}