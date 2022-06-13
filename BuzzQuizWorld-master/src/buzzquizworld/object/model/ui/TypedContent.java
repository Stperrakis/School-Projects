/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.object.model.ui;

import buzzquizworld.object.model.enums.ComponentType;
import buzzquizworld.object.model.enums.SupportedLanguage;

/**
 *
 * @author Jackie
 */
public class TypedContent {

    public ComponentType type;
    public String greekTranslation;
    public String englishTranslation;

    public TypedContent(ComponentType type, String greekValue, String englishValue) {
        this.type = type;
        this.greekTranslation = greekValue;
        this.englishTranslation = englishValue;
    }
    
    public String GetTranslation(SupportedLanguage language){
        if(language == SupportedLanguage.ENGLISH){
            return englishTranslation;
        } else if (language == SupportedLanguage.GREEK){
            return greekTranslation;
        }
        return null;
    }
}
