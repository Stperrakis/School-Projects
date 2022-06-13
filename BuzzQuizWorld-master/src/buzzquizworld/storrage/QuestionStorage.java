/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworld.storrage;

import buzzquizworld.object.model.Question;
import buzzquizworld.object.model.enums.QuestionCategory;
import buzzquizworld.object.model.enums.SupportedLanguage;
import buzzquizworldui.utilities.CsvQuestionParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This is our question storage here you will find all the possible questions
 * creating the array for the question including the right answer and the type
 * of each one.Also each question includes a HashMap with the possible answer
 */
public class QuestionStorage {

    private List<Question> Questions;
    private List<Integer> SelectedIndexes = new ArrayList<Integer>();

    public QuestionStorage(SupportedLanguage language) throws IOException {
        CsvQuestionParser parser = new CsvQuestionParser();
        this.Questions = parser.ReadQuestions(language);
    }
    
    /**
     * Get next question
     */
    public Question GetQuestion() {
        Integer randomIndex;
        do{
            if(this.SelectedIndexes.size() == this.Questions.size()){
                this.SelectedIndexes = new ArrayList<Integer>();
            }
            randomIndex = ThreadLocalRandom.current().nextInt(0,this.Questions.size());
        } while (this.SelectedIndexes.contains(randomIndex));
        
        this.SelectedIndexes.add(randomIndex);
        
        return this.Questions.get(randomIndex);

    }

}
