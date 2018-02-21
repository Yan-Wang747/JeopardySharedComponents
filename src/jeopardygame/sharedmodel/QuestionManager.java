/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardygame.sharedmodel;

import java.util.*;
import java.io.*;
/**
 *
 * @author student
 */
public class QuestionManager extends Observable implements Serializable{
    public final ArrayList<Category> categories;
    private int doubleCategoryIndex, doubleQuestionIndex;
    
    public QuestionManager(){
        categories = new ArrayList();
    }
    
    public void start(){
        Random rnd = new Random();
        doubleCategoryIndex = rnd.nextInt(categories.size());
        doubleQuestionIndex = rnd.nextInt(categories.get(doubleCategoryIndex).questions.size());
    }
    
    public void addQuestion(Question newQuestion){
        categories.get(newQuestion.categoryIndex).addQuestion(newQuestion.questionIndex, newQuestion);
        this.setChanged();
        this.notifyObservers(newQuestion);
    }
    
    public void addNewCategory(Category newCategory){
        categories.add(newCategory);
    }
    
    public int getNumOfQuestions(int categoryIndex){
        return categories.get(categoryIndex).questions.size();
    }
    
    public int getNumOfCategories(){
        return categories.size();
    }
    
    public Category getCategory(int categoryIndex){
        return categories.get(categoryIndex);
    }
    
    public Question getQuestion(int categoryIndex, int questionIndex){
        return categories.get(categoryIndex).questions.get(questionIndex);
    }
    
    public boolean isDoubleJeopardy(int categoryIndex, int questionIndex){
        return categoryIndex == this.doubleCategoryIndex && questionIndex == this.doubleQuestionIndex;
    }
    
    public void setCredits(int categoryIndex, int questionIndex, int newCredits){
        this.categories.get(categoryIndex).questions.get(questionIndex).setCredits(newCredits);
    }
}
