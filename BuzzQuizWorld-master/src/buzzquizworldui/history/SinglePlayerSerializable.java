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
public class SinglePlayerSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int points;
    private int correctAnswers;

    public SinglePlayerSerializable() {
    }

    
    public SinglePlayerSerializable(String name, int points, int correctAnswers) {
        this.name = name;
        this.points = points;
        this.correctAnswers = correctAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Player:" + name + ", points=" + points + ", correctAnswers=" + correctAnswers;
    }
    
}
