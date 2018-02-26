/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardygame.sharedview;

import java.awt.Panel;
import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Font;
/**
 *
 * @author student
 */
public class CategoryPanel extends Panel{
    public final JTextField categoryTextField;
    public final ArrayList<QuestionButton> questionButtons;
    public final int categoryIndex;
    public final int gap;
    
    public CategoryPanel(String categoryText, int categoryIndex, int gap, Dimension panelSize){
        super();
        questionButtons = new ArrayList();
        categoryTextField = new JTextField();
        categoryTextField.setBorder(BorderFactory.createEtchedBorder());
        this.categoryIndex = categoryIndex;
        this.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, gap, gap));
        this.gap = gap;
        this.setPreferredSize(panelSize);
        categoryTextField.setText(categoryText);
        Dimension textFieldSize = new Dimension(panelSize.width - gap, panelSize.height - 2*gap);
        categoryTextField.setPreferredSize(textFieldSize);
        categoryTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(categoryTextField);
    }
    
    public QuestionButton addNewQuestionButton(String text, ActionListener lisener, Dimension size){
        QuestionButton newQuestionButton = new QuestionButton(questionButtons.size());
        newQuestionButton.setText(text);
        newQuestionButton.addActionListener(lisener);
        newQuestionButton.setPreferredSize(size);
 
        questionButtons.add(newQuestionButton);
        this.add(newQuestionButton);
        Dimension newSize = this.getPreferredSize();
        newSize.height += size.height + this.gap;
        this.setPreferredSize(newSize);
        return newQuestionButton;
    }
    
    public void setCategoryTextFieldFont(Font font){
        this.categoryTextField.setFont(font);
    }
    
    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
        return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
    }
    @Override
    public int getBaseline(int width, int height) {
        return 0;
    }
    
    public void disableTextField(){
        this.categoryTextField.setEditable(false);
    }
}
