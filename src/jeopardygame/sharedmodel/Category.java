/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardygame.sharedmodel;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author iqapp
 */
public class Category implements Serializable{
    private String categoryText;
    public final int categoryIndex;
    public final ArrayList<Question> questions;
    
    public Category(String categoryText, int categoryIndex){
        questions = new ArrayList();
        this.categoryText = categoryText;
        this.categoryIndex = categoryIndex;
    }
    
    public void addQuestion(int questionIndex, Question newQuestion){
        if(questionIndex < questions.size())
            questions.set(questionIndex, newQuestion);
        else
            questions.add(newQuestion);
    }
    
    public void setCategoryText(String text){
        this.categoryText = text;
    }
    
    public String getCategoryText(){
        return this.categoryText;
    }
}
