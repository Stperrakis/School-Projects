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
public class UiQuickAnswerGame extends Game {

    public enum BATTLE_RESULT {
        PENDING,
        USER1_FASTER_THAN_USER2,
        USER2_FASTER_THAN_USER1,
        USER1_ANSWER_IS_WRONG,
        USER2_ANSWER_IS_WRONG
    }

    private long user1Timer;
    private long user2Timer;
    private BATTLE_RESULT battleResult;

    public UiQuickAnswerGame() {
        this.gameDescriptionEn = "Quick answer game is active. Ready???";
        this.gameDescriptionGr = "Παιχνίδι γρήγορης απάντησης ενεργό. Έτοιμοι???";
    }

    public UiQuickAnswerGame(SupportedLanguage language) throws IOException {
        super();
        this.language = language;
        this.Qs = new QuestionStorage(language);

    }

    public void setUser1Timer(long user1Timer) {
        this.user1Timer = user1Timer;
    }

    public void setUser2Timer(long user2Timer) {
        this.user2Timer = user2Timer;
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
        boolean answerIsRight = false;
        if (question.isAnswerRight(answer)) {
            user.increaseCorrectAnswers();
            answerIsRight = true;
        }
        if (this.getQuestionsAsked() % 2 == 0) { // given asnwer belongs to user 2
            user2Timer = System.currentTimeMillis() - user2Timer;

            if (!answerIsRight) { //user 2 answer is wrong - give 1000 points to user 1
                this.getUser1().increasePointsBy(1000);
                battleResult = BATTLE_RESULT.USER2_ANSWER_IS_WRONG;
            }
            if (user1Timer < user2Timer && user1Timer != -1) { // user 1 is faster
                this.getUser1().increasePointsBy(1000);
                this.getUser2().increasePointsBy(500);
                battleResult = BATTLE_RESULT.USER1_FASTER_THAN_USER2;
            } else if (user1Timer > user2Timer) { // user 2 is faster
                this.getUser1().increasePointsBy(500);
                this.getUser2().increasePointsBy(1000);
                battleResult = BATTLE_RESULT.USER2_FASTER_THAN_USER1;
            } else if (user1Timer == -1) { //user 1 answer is wrong - give 1000 points to user 2
                this.getUser2().increasePointsBy(1000);
                battleResult = BATTLE_RESULT.USER1_ANSWER_IS_WRONG;
            }
        } else { // given asnwer belongs to user 1
            //-1 stands for wrong answer (allows us to recall whether user 1 answer is wrong or right
            this.user1Timer = answerIsRight ? System.currentTimeMillis() - user1Timer : -1;
        }

        return answerIsRight;
    }

    @Override
    public Question GetQuestion() throws IOException {
        if (this.Qs == null) {
            this.Qs = new QuestionStorage(this.language);
        }
        long curTime = System.currentTimeMillis();
        if (this.getCurrentUser().equals(this.getUser1())) { // this question requested for user 1
            this.user1Timer = curTime;
        } else { // this question requested for user 2
            this.user2Timer = curTime;
        }

        return this.Qs.GetQuestion();

    }

    public BATTLE_RESULT getBattleResult() {
        return battleResult;
    }

    public String getMessageForResult(SupportedLanguage language, BATTLE_RESULT result) {
        if (language == SupportedLanguage.ENGLISH) {
            switch (result) {
                case USER1_ANSWER_IS_WRONG:
                    return this.getUser1().getName() + " answer is wrong";
                case USER1_FASTER_THAN_USER2:
                    return this.getUser1().getName() + " is faster than " + this.getUser2().getName();
                case USER2_ANSWER_IS_WRONG:
                    return this.getUser2().getName() + " answer is wrong";
                case USER2_FASTER_THAN_USER1:
                    return this.getUser2().getName() + " is faster than" + this.getUser1().getName();
            }
        }
        switch (result) {
            case USER1_ANSWER_IS_WRONG:
                return "Ο χρήστης "+this.getUser1().getName() + " έκανε λάθος";
            case USER1_FASTER_THAN_USER2:
                return "Ο χρήστης "+this.getUser1().getName() + " είναι γρηγορότερος από τον " + this.getUser2().getName();
            case USER2_ANSWER_IS_WRONG:
                return "Ο χρήστης "+this.getUser2().getName() + " έκανε λάθος";
            case USER2_FASTER_THAN_USER1:
                return "Ο χρήστης "+this.getUser2().getName() + " είναι γρηγορότερος από τον " + this.getUser1().getName();
        }
        return "";
    }

    @Override
    public void BeforeAskQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
