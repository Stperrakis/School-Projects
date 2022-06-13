/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model;

import buzzquizworld.object.model.enums.GameType;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworld.storrage.QuestionStorage;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Jackie
 */
public abstract class Game {

    private int Rounds = 2;
    private int QuestionsPerRound = 2;
    protected int QuestionsAsked = 0;
    protected QuestionStorage Qs;
    protected SupportedLanguage language;
    protected Question currentQuestion;
    protected GameType type;
    protected String gameDescriptionGr;
    protected String gameDescriptionEn;
    private User user1;
    private User user2;
    private User currentUser;

    public Game() {}

    public int getQuestionsAsked() {
        return QuestionsAsked;
    }

    public void setQuestionsAsked(int QuestionsAsked) {
        this.QuestionsAsked = QuestionsAsked;
    }

    public String getGameDescriptionGr() {
        return gameDescriptionGr;
    }

    public String getGameDescriptionEn() {
        return gameDescriptionEn;
    }
    
    public void switchCurrentUser(){
        if (this.getQuestionsAsked() % 2 == 0) {
            this.setCurrentUser(this.getUser1());
        } else if (this.getUser2() != null) {
            this.setCurrentUser(this.getUser2());
        }
    }
    
    
    /**
     * Get question from question storage
     */
    public void GetConsoleQuestion() {
        this.currentQuestion = this.Qs.GetQuestion();
    }
    
    public User getWinner(){
        return user1.getCorrAnswer()>user2.getCorrAnswer()?user1:user1.getCorrAnswer()<user2.getCorrAnswer()?user2:null;
    }
    
    public boolean isRoundEnd(){
        return this.user2==null?QuestionsAsked >= QuestionsPerRound:QuestionsAsked >= QuestionsPerRound*2;
    }
    
    public void setCurrentUser(User user){
        this.currentUser = user;
    }
    
    public User getCurrentUser(){
        return currentUser;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public int getRounds() {
        return Rounds;
    }

    public void setRounds(int Rounds) {
        this.Rounds = Rounds;
    }

    public int getQuestionsPerRound() {
        return QuestionsPerRound;
    }

    public void setQuestionsPerRound(int QuestionsPerRound) {
        this.QuestionsPerRound = QuestionsPerRound;
    }

    public SupportedLanguage getLanguage() {
        return language;
    }

    public void setLanguage(SupportedLanguage language) {
        this.language = language;
    }
    
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    /**
     * Get next question
     * @return
     * @throws IOException 
     */
    public abstract Question GetQuestion()throws IOException;
    
    /**
     * Get next question
     * @return
     * @throws IOException 
     */
    public abstract void BeforeAskQuestion();
    
    /**
     * Abstract method to evaluate question
     * @param question
     * @param user
     * @param answer
     * @param points 
     */
    public abstract boolean EvaluateQuestion(Question question, User user,int answer,Integer points);
}
