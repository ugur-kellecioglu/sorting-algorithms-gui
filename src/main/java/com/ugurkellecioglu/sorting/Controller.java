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
            sticks.add(new Stick(w, h, Color.MAGENTA, i));
            
        }
        
        myFrame.repaint();
    
    }
    public static void printSticks(){
    
        for(Stick s : sticks){
        
            System.out.println(s);
        }
    }
    
    public static boolean checkSelectionSort(){
    
        for(int i = 0 ; i < number_of_stick - 1;i++){
            
            if(sticks.get(i).getHEIGHT() > sticks.get(i+1).getWIDTH()) return false;
        
        }
    
        return true;
    
    }
    public static void selectionSort(){
        Thread thread = new Thread("New Thread") {
            public void run(){
              for(int i = 0 ; i < number_of_stick; i++){
                    
                    Stick min = sticks.get(i);
                    int minHeight = min.getHEIGHT();
                    min.setColor(Color.GREEN);
                    Stick tmp2 = min ;
                    for(int j = i +1 ; j < number_of_stick; j++ ){
                        Stick temp = sticks.get(j);

                        if(min.getHEIGHT() > temp.getHEIGHT()){
                             minHeight = temp.getHEIGHT();
                             tmp2 = temp;
                        }
                       
                        myFrame.repaint();
                        temp.setColor(Color.RED);
                        try {
                            //Thread.sleep(150);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    int tmp = min.getHEIGHT();
                    min.setHEIGHT(minHeight);
                    tmp2.setHEIGHT(tmp);
                    
                    myFrame.repaint();
                }
            }
        };
       thread.start();
       
       if(!checkSelectionSort()) selectionSort();
        
    }
}
