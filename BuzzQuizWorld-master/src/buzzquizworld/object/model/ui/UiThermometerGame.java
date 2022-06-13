/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model.ui;

import buzzquizworld.object.model.Game;
import buzzquizworld.object.model.Question;
import buzzquizworld.object.model.User;
import buzzquizworld.object.model.enums.GameType;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworld.storrage.QuestionStorage;
import java.io.IOException;

/**
 *
 * @author Jackie
 */
public class UiThermometerGame extends Game {
    private User userThatWonBonus = null;
    private static int CORRECT_ANSWERS_TO_WIN_BONUS = 5;
    public UiThermometerGame() {
        this.gameDescriptionEn = "Thermometer game is active. Ready???";
        this.gameDescriptionGr = "Παιχνίδι θερμομέτρου ενεργό. Έτοιμοι???";
    }

    public UiThermometerGame(SupportedLanguage language) throws IOException {
        super();
        this.language = language;
        this.Qs = new QuestionStorage(language);

    }

    /**
     * Return false when round is finished
     *
     * @param question asked to user
     * @param user that answered the question
     * @param answer given
     * @param bid given
     * @return true when question is true
     */
    @Override
    public boolean EvaluateQuestion(Question question, User user, int answer, Integer bid) {
        this.QuestionsAsked++;
        user.increaseTotalAnswers();
        
        if(this.getUser1().getCorrAnswer()>=CORRECT_ANSWERS_TO_WIN_BONUS && this.getUser2().getTotalAnswer()>=CORRECT_ANSWERS_TO_WIN_BONUS && userThatWonBonus == null){
            this.getUser1().increasePointsBy(5000);
            userThatWonBonus = this.getUser1();
        } else if(this.getUser2().getCorrAnswer()>=CORRECT_ANSWERS_TO_WIN_BONUS && this.getUser1().getTotalAnswer()>=CORRECT_ANSWERS_TO_WIN_BONUS && userThatWonBonus == null) {
            this.getUser2().increasePointsBy(5000);
            userThatWonBonus = this.getUser1();
        }
        
        if (question.isAnswerRight(answer)) {
            user.increaseCorrectAnswers();
            return true;
        }
        switchCurrentUser();
        return false;
    }

    @Override
    public Question GetQuestion() throws IOException {
        if (this.Qs == null) {
            this.Qs = new QuestionStorage(this.language);
        }
        return this.Qs.GetQuestion();
    }

    @Override
    public void BeforeAskQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getUserThatWonBonus() {
        return userThatWonBonus;
    }
    
}
