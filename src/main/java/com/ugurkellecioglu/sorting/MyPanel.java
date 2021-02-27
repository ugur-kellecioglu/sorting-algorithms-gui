/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurkellecioglu.sorting;

import static com.ugurkellecioglu.sorting.Controller.number_of_stick;
import static com.ugurkellecioglu.sorting.Controller.sticks;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author ugur
 */
class MyPanel extends JPanel {



    public MyPanel() {

      setBorder(BorderFactory.createLineBorder(Color.black));

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        for(int i = 0; i < number_of_stick; i++){
            int h = sticks.get(i).getHEIGHT();
            int w = sticks.get(i).getWIDTH();
            g.setColor(sticks.get(i).getColor());
            g.fillRect(i*w, 0, w-4, h);
        
        }

    }  
     public Dimension getPreferredSize() {
        return new Dimension(1200,300);
    }
}