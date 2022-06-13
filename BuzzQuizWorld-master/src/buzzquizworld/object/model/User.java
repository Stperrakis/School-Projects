/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model;

import java.io.Serializable;

/**
 *
 * @author Jackie
 */
public class User {

    private String name;
    private int points=0, corrAnswer=0, totalAnswer=0, currentBet=0;

    public User(String name, int points, int corrAnswer, int totalAnswer) {
        this.name = name;
        this.points = points;
        this.corrAnswer = corrAnswer;
        this.totalAnswer = totalAnswer;
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

    public void increasePointsBy(double pointsToAdd) {
        this.points += pointsToAdd;
    }

    public void decreasePointsBy(int pointsToAdd) {
        this.points -= pointsToAdd;
    }

    public int getCorrAnswer() {
        return corrAnswer;
    }

    public void increaseCorrectAnswers() {
        this.corrAnswer++;
    }

    public void setCorrAnswer(int corrAnswer) {
        this.corrAnswer = corrAnswer;
    }

    public int getTotalAnswer() {
        return totalAnswer;
    }

    public void setTotalAnswer(int totalAnswer) {
        this.totalAnswer = totalAnswer;
    }

    public void increaseTotalAnswers() {
        this.totalAnswer++;

    }

    public int getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(int currentBet) {
        this.currentBet = currentBet;
    }

    @Override
    public boolean equals(Object userObj){
     User user = (User) userObj;
     return this.name == user.getName() && this.totalAnswer == user.getTotalAnswer() && this.points == user.getPoints() && this.corrAnswer == user.getCorrAnswer();
    }
}
