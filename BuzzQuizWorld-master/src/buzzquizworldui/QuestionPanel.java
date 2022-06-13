/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworldui;

import buzzquizworld.object.model.Game;
import buzzquizworld.object.model.Question;
import buzzquizworld.object.model.User;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworld.object.model.ui.UiQuickAnswerGame;
import buzzquizworld.object.model.ui.UiQuickAnswerGame.BATTLE_RESULT;
import buzzquizworld.object.model.ui.UiRightAnswerGame;
import buzzquizworld.object.model.ui.UiRightAnswerGameWithBid;
import buzzquizworld.object.model.ui.UiStopTheClockGame;
import buzzquizworld.object.model.ui.UiThermometerGame;
import buzzquizworldui.translations.UiTranslator;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jackie
 */
public class QuestionPanel extends javax.swing.JPanel {

    private Question currentQuestion;
    private MainFrame frame;
    private int SelectedAnswer = 0;
    private Integer currentBid = null;
    private UserPanel userPanel1;
    private UserPanel userPanel2;

    /**
     * Creates new form RightAnswer
     */
    public QuestionPanel(MainFrame frame) throws IOException {
        try {
            initComponents();
            this.frame = frame;
            initPlayersPanel();

            this.GetNextQuestion();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initPlayersPanel() throws IllegalArgumentException, IllegalAccessException {
        this.PlayersPanel.setLayout(new BoxLayout(this.PlayersPanel, BoxLayout.Y_AXIS));
        Game game = this.frame.getGame();
        userPanel1 = new UserPanel(game.getUser1());
        UiTranslator translator = new UiTranslator();
        translator.TranslatePanelElements(userPanel1, game.getLanguage());
        this.PlayersPanel.add(userPanel1);
        game.setCurrentUser(game.getUser1());

        if (game.getUser2() != null) {
            userPanel2 = new UserPanel(game.getUser2());
            translator.TranslatePanelElements(userPanel2, game.getLanguage());
            this.PlayersPanel.add(userPanel2);
        }
        totalProgress.setMinimum(0);
        totalProgress.setMaximum(game.getQuestionsPerRound());
        totalProgress.setStringPainted(true);
    }

    /**
     * Show bid dialog
     */
    public void showBidDialog(String type) {
        Object[] possibilities = {"250", "500", "750", "1000"};
        String givenBid = (String) JOptionPane.showInputDialog(
                this.frame,
                this.frame.getGame().getLanguage() == SupportedLanguage.ENGLISH ? "Category of next question: " + type + ". Select one of the following bids" : "Κατηγορία επόμενης ερώτησης: " + type + ". Επιλογή πόντων ",
                "Bid",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities, "250");
        if (givenBid != null) {
            currentBid = Integer.parseInt(givenBid);
            return;
        }
        currentBid = 250;

    }

    public void GetNextQuestion() throws IOException {
        Game game = this.frame.getGame();
        this.currentQuestion = game.GetQuestion();

        //If bid is needed show proper message
        if (game.getClass().isAssignableFrom(UiRightAnswerGameWithBid.class)) {
            showBidDialog(this.currentQuestion.getType().toString());
        }

        //Set user panel activeness
        if (game.getUser2() != null) {
            if (game.getCurrentUser() == game.getUser1()) {
                userPanel1.isActive(true);
                userPanel2.isActive(false);
            } else {
                userPanel1.isActive(false);
                userPanel2.isActive(true);
            }
        }

        this.questionLabel.setText(this.currentQuestion.getQuestion());
        this.possibleAnswer1Radio.setText(this.currentQuestion.getPossibleAnswer().get(1));
        this.possibleAnswer2Radio.setText(this.currentQuestion.getPossibleAnswer().get(2));
        this.possibleAnswer3Radio.setText(this.currentQuestion.getPossibleAnswer().get(3));
        this.possibleAnswer4Radio.setText(this.currentQuestion.getPossibleAnswer().get(4));

        if (this.currentQuestion.getIconPath() != null) {
            URL url = QuestionPanel.class.getClassLoader().getResource(this.currentQuestion.getIconPath());
            if (url == null) {
                return;
            }
            ImageIcon icon = new ImageIcon(url);
            this.imageLabel.setIcon(icon);
            this.imageLabel.setText("");
        }

        this.revalidate();
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        totalProgress = new javax.swing.JProgressBar();
        questionLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        possibleAnswer1Radio = new javax.swing.JRadioButton();
        possibleAnswer2Radio = new javax.swing.JRadioButton();
        possibleAnswer3Radio = new javax.swing.JRadioButton();
        possibleAnswer4Radio = new javax.swing.JRadioButton();
        nextQuestionButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        PlayersPanel = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalProgress.setToolTipText("");
        add(totalProgress, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 291, 416, -1));
        add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 11, 511, 124));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 140, 511, 15));

        buttonGroup1.add(possibleAnswer1Radio);
        possibleAnswer1Radio.setText("Possibleans1");
        possibleAnswer1Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                possibleAnswer1RadioActionPerformed(evt);
            }
        });
        add(possibleAnswer1Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 187, -1, -1));

        buttonGroup1.add(possibleAnswer2Radio);
        possibleAnswer2Radio.setText("Possibleans2");
        possibleAnswer2Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                possibleAnswer2RadioActionPerformed(evt);
            }
        });
        add(possibleAnswer2Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 210, -1, -1));

        buttonGroup1.add(possibleAnswer3Radio);
        possibleAnswer3Radio.setText("Possibleans3");
        possibleAnswer3Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                possibleAnswer3RadioActionPerformed(evt);
            }
        });
        add(possibleAnswer3Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 233, -1, -1));

        buttonGroup1.add(possibleAnswer4Radio);
        possibleAnswer4Radio.setText("Possibleans4");
        possibleAnswer4Radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                possibleAnswer4RadioActionPerformed(evt);
            }
        });
        add(possibleAnswer4Radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 256, -1, -1));

        nextQuestionButton.setText("Next");
        nextQuestionButton.setEnabled(false);
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionButtonActionPerformed(evt);
            }
        });
        add(nextQuestionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 291, 89, -1));
        add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 161, 353, 123));

        javax.swing.GroupLayout PlayersPanelLayout = new javax.swing.GroupLayout(PlayersPanel);
        PlayersPanel.setLayout(PlayersPanelLayout);
        PlayersPanelLayout.setHorizontalGroup(
            PlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        PlayersPanelLayout.setVerticalGroup(
            PlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        add(PlayersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void possibleAnswer1RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_possibleAnswer1RadioActionPerformed
        SelectedAnswer = 1;
        nextQuestionButton.setEnabled(true);

    }//GEN-LAST:event_possibleAnswer1RadioActionPerformed

    private void possibleAnswer4RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_possibleAnswer4RadioActionPerformed
        SelectedAnswer = 4;
        nextQuestionButton.setEnabled(true);
    }//GEN-LAST:event_possibleAnswer4RadioActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        try {
            Game game = this.frame.getGame();
            boolean isRight = game.EvaluateQuestion(currentQuestion, game.getCurrentUser(), SelectedAnswer, currentBid);

           
            if (game.getClass().isAssignableFrom(UiQuickAnswerGame.class)) {
                UiQuickAnswerGame quickAnswerGame = (UiQuickAnswerGame) game;
                BATTLE_RESULT result = quickAnswerGame.getBattleResult();
    
                if(result != null){
                    String messageToPrint = quickAnswerGame.getMessageForResult(game.getLanguage(), result);    
                    JOptionPane.showMessageDialog(this.frame, messageToPrint);
                }
            }

            if (isRight) {
                String possibleBonus = "";
                //If bid is needed show proper message
                if (game.getClass().isAssignableFrom(UiStopTheClockGame.class)) {
                    UiStopTheClockGame clockGame = (UiStopTheClockGame) game;
                    possibleBonus = " Bonus: " + clockGame.getBonus();
                }
                String message = game.getLanguage() == SupportedLanguage.ENGLISH ? "Answer is right!" : "Σωστή απάντηση!";
                JOptionPane.showMessageDialog(frame, message + possibleBonus);
            } else {
                JOptionPane.showMessageDialog(frame, game.getLanguage() == SupportedLanguage.ENGLISH ? "Answer is wrong!" : "Λάθος απάντηση!");
            }

            if (game.isRoundEnd()) {
                String winnerMessage = "";
                if (game.getUser2() != null) {
                    User winner = game.getWinner();

                    if (winner == null) {
                        winnerMessage = game.getLanguage() == SupportedLanguage.ENGLISH ? "users have equal points" : "ισοβαθμία";
                    } else {
                        winnerMessage = game.getLanguage() == SupportedLanguage.GREEK ? "Ο χρήστης " + winner.getName() + " νίκησε σε αυτό τον γύρο με " + winner.getPoints() + " πόντους!" : winner.getName() + " won the round with " + winner.getPoints() + " points!";
                    }
                } else {
                    winnerMessage = game.getLanguage() == SupportedLanguage.ENGLISH ? "Total points: " : "Συνολικοί πόντοι:" + game.getUser1().getPoints();
                }

                JOptionPane.showMessageDialog(frame, game.getLanguage() == SupportedLanguage.ENGLISH ? "Round ended. " : "Τέλος γύρου. " + winnerMessage);
                this.removeAll();
                this.frame.EndRound();
            }
            
             //If bid is needed show proper message
            if (game.getClass().isAssignableFrom(UiThermometerGame.class)) {
                UiThermometerGame thermometerGame = (UiThermometerGame) game;
                User userWithBonus = thermometerGame.getUserThatWonBonus();
                if(userWithBonus != null){
                    JOptionPane.showMessageDialog(this.frame,game.getLanguage() == SupportedLanguage.ENGLISH?"User "+userWithBonus.getName()+" won bonus of 5000points":"Ο χρήστης "+userWithBonus.getName()+" κέρδισε τοbonus των 5000 πόντων");
                }
            }
            

            game.switchCurrentUser();
            //Update user details
            userPanel1.ShowUserDetails();
            if (userPanel2 != null) {
                userPanel2.ShowUserDetails();
                totalProgress.setValue(game.getQuestionsAsked() / 2);
            } else {
                totalProgress.setValue(game.getQuestionsAsked());
            }

            GetNextQuestion();
            this.buttonGroup1.clearSelection();
            nextQuestionButton.setEnabled(false);

        } catch (IOException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void possibleAnswer2RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_possibleAnswer2RadioActionPerformed
        SelectedAnswer = 2;
        nextQuestionButton.setEnabled(true);
    }//GEN-LAST:event_possibleAnswer2RadioActionPerformed

    private void possibleAnswer3RadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_possibleAnswer3RadioActionPerformed
        SelectedAnswer = 3;
        nextQuestionButton.setEnabled(true);
    }//GEN-LAST:event_possibleAnswer3RadioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PlayersPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JRadioButton possibleAnswer1Radio;
    private javax.swing.JRadioButton possibleAnswer2Radio;
    private javax.swing.JRadioButton possibleAnswer3Radio;
    private javax.swing.JRadioButton possibleAnswer4Radio;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JProgressBar totalProgress;
    // End of variables declaration//GEN-END:variables
}
