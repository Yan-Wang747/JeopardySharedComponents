/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardygame.sharedmodel;

import java.io.Serializable;
/**
 *
 * @author iqapp
 */
public class Question implements Serializable{
    public final String questionText;
    public final String answerText;
    public final int categoryIndex, questionIndex;
    private int credits;
    
    public Question(String questionText, String answerText, int credits, int categoryIndex, int questionIndex){
        this.questionText = questionText;
        this.answerText = answerText;
        this.credits = credits;
        this.categoryIndex = categoryIndex;
        this.questionIndex = questionIndex;
    }
    
    public int getCredits(){
        return this.credits;
    }
    
    public void setCredits(int newCredits){
        this.credits = newCredits;
    }
}
