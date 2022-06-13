/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buzzquizworldui.utilities;

import buzzquizworld.object.model.Question;
import buzzquizworld.object.model.enums.QuestionCategory;
import buzzquizworld.object.model.enums.SupportedLanguage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Jackie
 */
public class CsvQuestionParser {

    public CsvQuestionParser() {
    }
    
    /**
     * Read Questions
     * @param language 
     */
    public List<Question> ReadQuestions(SupportedLanguage language) throws IOException{
        List<Question> readenQuestions = new ArrayList<Question>();
        
        //Find csv relative path based to given language
        String languageVersion = language==SupportedLanguage.ENGLISH?"EN.csv":"GR.csv";
        String relativeFilePath = "buzzquizworldui/csv/QuestionStorrage"+ languageVersion;
        InputStream fileStream = CsvQuestionParser.class.getClassLoader().getResourceAsStream(relativeFilePath);
        
        final Reader reader = new InputStreamReader(fileStream, "UTF-8");
        CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
        for (CSVRecord csvRecord : parser) {
            String question = csvRecord.get("Ερώτηση");
            String possibleAnswer1 = csvRecord.get("Πιθανή Απάντηση 1");
            String possibleAnswer2 = csvRecord.get("Πιθανή Απάντηση 2");
            String possibleAnswer3 = csvRecord.get("Πιθανή Απάντηση 3");
            String possibleAnswer4 = csvRecord.get("Πιθανή Απάντηση 4");
            Integer rightAnswer = Integer.parseInt(csvRecord.get("Σωστή Απάντηση"));
            QuestionCategory category = QuestionCategory.valueOf(csvRecord.get("Κατηγορία"));
            String iconPath = csvRecord.get("Path εικόνας");
            
            Question newQuestion = new Question(question, rightAnswer, category);
            HashMap<Integer, String> newPossibleAnswers = new HashMap<Integer, String>();
            newPossibleAnswers.put(1, possibleAnswer1);
            newPossibleAnswers.put(2, possibleAnswer2);
            newPossibleAnswers.put(3, possibleAnswer3);
            newPossibleAnswers.put(4, possibleAnswer4);
            newQuestion.setPossibleAnswer(newPossibleAnswers);
            newQuestion.setIconPath("buzzquizworldui/icons/"+iconPath);
            readenQuestions.add(newQuestion);
        }
        
        return readenQuestions;
    }
}
