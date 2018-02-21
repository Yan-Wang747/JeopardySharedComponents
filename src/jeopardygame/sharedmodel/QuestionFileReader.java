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
public class QuestionFileReader {
    private final File questionFile;
    
    public QuestionFileReader(File questionFile){
        this.questionFile = questionFile;
    }
    
    public QuestionManager read() throws ClassNotFoundException, IOException{
        QuestionManager res;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(questionFile))) {
            res = (QuestionManager)inputStream.readObject();
            inputStream.close();
        }
        
        return res;
    }
}
