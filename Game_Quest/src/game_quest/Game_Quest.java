/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package game_quest;

import Controller.KnightsTourProblemController;
import Model.KnightsTourProblemModel;
import View.KnightsTourProblemUI;

/**
 *
 * @author ndila
 */
public class Game_Quest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KnightsTourProblemController controller = new KnightsTourProblemController(8); // Initialize with the desired chessboard size
        KnightsTourProblemUI view = new KnightsTourProblemUI(controller);
        KnightsTourProblemModel model = new KnightsTourProblemModel(controller, view);
        MainMenu menu = new MainMenu();
        
        menu.setVisible(true);
    }
    
}
