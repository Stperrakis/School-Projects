/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model.ui;

import buzzquizworld.object.model.Game;
import buzzquizworld.object.model.Question;
import buzzquizworld.object.model.User;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworld.storrage.QuestionStorage;
import java.io.IOException;

/**
 *
 * @author Jackie
 */
public class UiStopTheClockGame extends Game{
    private long timer;
    private double bonus;
    public UiStopTheClockGame(){
        this.gameDescriptionEn = "Stop the clock game is active. Ready???";
        this.gameDescriptionGr = "Παιχνίδι με αντίπαλο το χρόνο ενεργό. Έτοιμοι???";
    }
    
    public UiStopTheClockGame(SupportedLanguage language) throws IOException {
        super();
        this.language = language;
        this.Qs = new QuestionStorage(language);
    }

    @Override
    public boolean EvaluateQuestion(Question question, User user, int answer, Integer bid) {
        this.QuestionsAsked++;
        long elapsedMilliseconds = System.currentTimeMillis() - timer;
        if(question.isAnswerRight(answer)){
            user.increaseCorrectAnswers();
            //Give user points regarding the remaining milliseconds
            if(elapsedMilliseconds < 5000){
                bonus = elapsedMilliseconds * 0.2;
                user.increasePointsBy(bonus);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public Question GetQuestion() throws IOException {
        if(this.Qs == null){
            this.Qs = new QuestionStorage(this.language);    
        }
        timer = System.currentTimeMillis();
        bonus = 0;
        return this.Qs.GetQuestion();
        
    }

    @Override
    public void BeforeAskQuestion(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getBonus() {
        return bonus;
    }
}
