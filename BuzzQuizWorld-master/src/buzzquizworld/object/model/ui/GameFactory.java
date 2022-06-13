/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model.ui;

import buzzquizworld.object.model.Game;
import buzzquizworld.object.model.enums.GameType;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author Jackie
 */
public class GameFactory {
    
    public static Game SelectRandomGameMode(boolean multiplayerAcceptable){
        int randomTypeIndex = ThreadLocalRandom.current().nextInt(0,multiplayerAcceptable?5:3);
        GameType randomType = GameType.values()[randomTypeIndex];
        
        if(randomType == GameType.BETING_GAME){
            return new UiRightAnswerGameWithBid();
        } else if (randomType == GameType.STOP_THE_CLOCK){
            return new UiStopTheClockGame();
        } else if (randomType == GameType.RIGHT_ANSWER){
            return new UiRightAnswerGame();
        } else if (randomType == GameType.THERMOMETER){
            return new UiThermometerGame();
        }else if (randomType == GameType.QUICK_ANSWER){
            return new UiQuickAnswerGame();
        } 
        return new UiRightAnswerGame();
    }
}
