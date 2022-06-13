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
import javax.swing.JOptionPane;

/**
 *
 * @author Jackie
 */
public class UiRightAnswerGameWithBid extends Game {

    public UiRightAnswerGameWithBid() {
        this.gameDescriptionEn = "Right answer game with bids is active. Ready???";
        this.gameDescriptionGr = "Παιχνίδι σωστής απάντησης με ποντάρισμα ενεργό. Έτοιμοι???";
    }

    public UiRightAnswerGameWithBid(SupportedLanguage language) throws IOException {
        super();
        this.language = language;
        this.Qs = new QuestionStorage(language);
        this.gameDescriptionEn = "Right answer game is active. Ready???";
        this.gameDescriptionGr = "Παιχνίδι σωστής απάντησης ενεργό. Έτοιμοι???";
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
        
        if (question.isAnswerRight(answer)) {
            user.increaseCorrectAnswers();
            user.increasePointsBy(bid); //increase by 1000 points
            return true;
        }

        user.decreasePointsBy(bid);
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
}
