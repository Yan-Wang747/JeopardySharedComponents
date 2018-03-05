/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardygame.sharedmodel;

import java.io.*;
/**
 *
 * @author iqapp
 */
public class QuestionFileWriter {
    private final File questionFile;
    
    public QuestionFileWriter(File questionFile) {
        this.questionFile = questionFile;
    }
    
    public void write(QuestionManager theQuestionManager) throws IOException{
        if(theQuestionManager.getNumOfCategories() != 0)
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(questionFile))) {
                outputStream.writeObject(theQuestionManager);
                outputStream.close();
            }
    }
}
