/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model;

import buzzquizworld.object.model.enums.QuestionCategory;
import java.util.HashMap;

/**
 *
 * @author Jackie
 */
public class Question {

    private String question;
    private HashMap<Integer, String> PossibleAnswer;
    private int CorrectAnswer;
    private String iconPath;
    private QuestionCategory type;

    /**
     *
     * @param question
     * @param CorrectAnswer
     * @param type Creating question
     */
    public Question(String question, int CorrectAnswer, QuestionCategory type) {
        this.question = question;
        this.CorrectAnswer = CorrectAnswer;
        this.type = type;
        this.PossibleAnswer = new HashMap<Integer, String>();
    }
    
    /**
     *
     * @param question
     * @param CorrectAnswer
     * @param type Creating question with icon path
     */
    public Question(String question, int CorrectAnswer, QuestionCategory type, String iconPath) {
        this.question = question;
        this.CorrectAnswer = CorrectAnswer;
        this.type = type;
        this.PossibleAnswer = new HashMap<Integer, String>();
        this.iconPath = iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * This HashMap has the possible answers of question each question
     *
     * @return
     */
    public HashMap<Integer, String> getPossibleAnswer() {
        return PossibleAnswer;
    }

    public void setPossibleAnswer(HashMap<Integer, String> PossibleAnswer) {
        this.PossibleAnswer = PossibleAnswer;
    }

    public int getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(int CorrectAnswer) {
        this.CorrectAnswer = CorrectAnswer;
    }

    public QuestionCategory getType() {
        return type;
    }

    public void setType(QuestionCategory type) {
        this.type = type;
    }

    public String getIconPath() {
        return iconPath;
    }
    
    public boolean isAnswerRight(int givenAnswer){
        return this.CorrectAnswer == givenAnswer;
    }
    
}
