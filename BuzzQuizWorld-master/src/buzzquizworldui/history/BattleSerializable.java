/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworldui.history;

import java.io.Serializable;

/**
 *
 * @author Jackie
 */
public class BattleSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String loserName;
    private String winnerName;
    private int points;
    private int correctAnswers;

    public BattleSerializable() {
    }

    public BattleSerializable(String loserName, String winnerName, int points, int correctAnswers) {
        this.loserName = loserName;
        this.winnerName = winnerName;
        this.points = points;
        this.correctAnswers = correctAnswers;
    }

    public String getLoserName() {
        return loserName;
    }

    public void setLoserName(String loserName) {
        this.loserName = loserName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    @Override
    public String toString() {
        return "loserName=" + loserName + ", winnerName=" + winnerName + ", points=" + points + ", correctAnswers=" + correctAnswers;
    }
}
