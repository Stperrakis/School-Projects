/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworldui.translations;

import buzzquizworld.object.model.enums.ComponentType;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworld.object.model.ui.TypedContent;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jackie
 */
public class UiTranslator {
    private HashMap<String,TypedContent> uiTranslates = new HashMap<String,TypedContent>();
    
    public UiTranslator(){
    
        //=============Translations for NewGamePanel =================================================//
        uiTranslates.put("user1Label", new TypedContent(ComponentType.LABEL,"Παίκτης 1:","User 1"));
        uiTranslates.put("user2Label", new TypedContent(ComponentType.LABEL,"Παίκτης 2:","User 2"));
        uiTranslates.put("userLabel", new TypedContent(ComponentType.LABEL,"Ένας Παίκτης:","Single player"));
        uiTranslates.put("UserLabel", new TypedContent(ComponentType.LABEL,"Όνομα παίκτη:","Username:"));
        uiTranslates.put("PointLabel", new TypedContent(ComponentType.LABEL,"Πόντοι:","Points:"));
        uiTranslates.put("MultiPlayerRadioButton", new TypedContent(ComponentType.RADIO_BUTTON,"2 παίκτες","2 players"));
        uiTranslates.put("SinglePlayerRadioButton", new TypedContent(ComponentType.RADIO_BUTTON,"1 παίκτης","1 player"));
        uiTranslates.put("StartGameButton", new TypedContent(ComponentType.BUTTON,"Εκκίνηση!","Start!"));
        uiTranslates.put("WelcomeLabel", new TypedContent(ComponentType.LABEL,"Καλώς ορίσατε στο Buzz quiz world","Welcome to buzz quiz wolrd"));
        uiTranslates.put("closeButton", new TypedContent(ComponentType.BUTTON,"Κλείσιμο","Close"));
        uiTranslates.put("multiPlayerLabel", new TypedContent(ComponentType.LABEL,"Στατιστικά πολλαπλών παιχτών:","Multi player statistics:"));
        uiTranslates.put("singlePlayerLabel", new TypedContent(ComponentType.LABEL,"Στατιστικά μονού παιχνιδιού:","Single player statistics:"));
        //TODO add the rest components here for each language (
    }
    
    
    public void TranslatePanelElements(JPanel containerPanel, SupportedLanguage language) throws IllegalArgumentException, IllegalAccessException {
        Field panelFields [] = containerPanel.getClass().getDeclaredFields();
        
        for(Field panelField: panelFields){
            
            String variableName = panelField.getName();
            TypedContent content = this.uiTranslates.get(variableName);
            
            if(content == null){
                continue;
            }
            
            panelField.setAccessible(true);
            
            if(JButton.class.isAssignableFrom(panelField.getType())){ //if current field is JButton
               JButton button = (JButton)panelField.get(containerPanel);
               button.setText(content.GetTranslation(language));
            }
            else if(JLabel.class.isAssignableFrom(panelField.getType())){ //if current field is JLabel
               JLabel label = (JLabel)panelField.get(containerPanel);
               label.setText(content.GetTranslation(language));
            }
            else if (JRadioButton.class.isAssignableFrom(panelField.getType()))
            {
                JRadioButton button = (JRadioButton) panelField.get(containerPanel);
                button.setText(content.GetTranslation(language));
            }
        }
    }
    
    
}
