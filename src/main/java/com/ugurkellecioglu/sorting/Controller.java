/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurkellecioglu.sorting;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ugur
 */
public class Controller {
    public static MyFrame myFrame;
    public static MyPanel myPanel;
    public static int number_of_stick = 0;
    public static ArrayList<Stick> sticks;
 
    public Controller() {
        myFrame = new MyFrame();
        myPanel = new MyPanel();
        myFrame.add(myPanel);
        myFrame.setVisible(true);
        sticks = new ArrayList<>();
        
        
    }
    public static void createSticks(){
        Random rnd = new Random();
        for(int i = 0; i < number_of_stick; i++){
        
            int h = rnd.nextInt(200)+100;
            int w = 10;
            sticks.add(new Stick(w, h, Color.yellow, i));
            
        }
        
        myFrame.repaint();
    
    }
    public static void printSticks(){
    
        for(Stick s : sticks){
        
            System.out.println(s);
        }
    }
    
    public static void selectionSort(){
        
        Thread thread = new Thread("New Thread") {
            public void run(){
              for(int i = 0 ; i < number_of_stick; i++){
                    
                    Stick the_one = sticks.get(i);
                    the_one.setColor(Color.CYAN);
                    Stick min = sticks.get(i);
                    for(int j = i +1 ; j < number_of_stick; j++ ){
                       Stick tmp = sticks.get(j);
                       tmp.setColor(Color.RED);
                       if(tmp.getHEIGHT() < min.getHEIGHT()) min = tmp;
                        
                       
                        myFrame.repaint();
                    }
                    
                    Stick x = the_one;
                    the_one = min;
                    min = x;
                    myFrame.repaint();
                }
            }
        };
       thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
