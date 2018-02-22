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

/**
 *
 * @author student
 */
public class CategoryPanel extends Panel{
    public final JTextField categoryTextField;
    public final ArrayList<QuestionButton> questionButtons;
    public final int categoryIndex;
    public final int gap;
    
    public CategoryPanel(String categoryText, int categoryIndex, int gap, Dimension panelSize, Dimension textFieldSize){
        super();
        questionButtons = new ArrayList();
        categoryTextField = new JTextField();
        this.categoryIndex = categoryIndex;
        this.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER, gap, gap));
        this.gap = gap;
        this.setPreferredSize(panelSize);
        categoryTextField.setText(categoryText);
        categoryTextField.setPreferredSize(textFieldSize);
        categoryTextField.setHorizontalAlignment(JTextField.CENTER);
        this.add(categoryTextField);
    }
    
    public QuestionButton addNewQuestionButton(String text, ActionListener lisener, Dimension size){
        QuestionButton newQuestionButton = new QuestionButton(questionButtons.size(), size);
        newQuestionButton.setText(text);
        newQuestionButton.addActionListener(lisener);
  
        questionButtons.add(newQuestionButton);
        this.add(newQuestionButton);
        Dimension newSize = this.getPreferredSize();
        newSize.height += size.height + this.gap;
        this.setPreferredSize(newSize);
        return newQuestionButton;
    }
    
    @Override
    public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
        return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
    }
    @Override
    public int getBaseline(int width, int height) {
        return 0;
    }
}
