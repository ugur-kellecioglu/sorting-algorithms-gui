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
    public static long start = 0;
    public static long end = 0;
    public static long THREAD_SLEEP = 100;
    public static long elapsedTime = 0;
    public static long minTime = 0;

    public Controller() {
        myFrame = new MyFrame();
        myPanel = new MyPanel();
        myFrame.add(myPanel);
        myFrame.setVisible(true);

    }

    public static void createSticks() {
        Random rnd = new Random();
        sticks = new ArrayList<>();
        for (int i = 0; i < number_of_stick; i++) {

            int h = rnd.nextInt(200) + 100;
            int w = 12;
            sticks.add(new Stick(w, h, Color.MAGENTA, i));

        }

        myFrame.repaint();

    }

    public static void printSticks() {

        for (Stick s : sticks) {

            System.out.println(s);
        }
    }

    public static void selectionSort() {
        start = System.currentTimeMillis();
        minTime = 0;
        elapsedTime = 0;
        Thread thread = new Thread("New Thread") {
            public void run() {
                for (int i = 0; i < number_of_stick; i++) {
                    Stick proccesed = sticks.get(i);
                    Stick min = minStick(i);
                    proccesed.setColor(Color.GREEN);
                    int a = proccesed.getHEIGHT();
                    proccesed.setHEIGHT(min.getHEIGHT());
                    min.setHEIGHT(a);

                    try {
                        Thread.sleep(THREAD_SLEEP);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    myFrame.repaint();
                }
                end = System.currentTimeMillis();

                elapsedTime = end - start - (THREAD_SLEEP * number_of_stick) - minTime;
                myFrame.getLabel_time().setText(String.valueOf(elapsedTime));
            }
        };
        thread.start();

    }

    public static Stick minStick(int i) {
        Stick minStick = sticks.get(i);
        for (int j = i + 1; j < number_of_stick; j++) {
            Stick tmpStick = sticks.get(j);
            tmpStick.setColor(Color.MAGENTA);
            if (minStick.getHEIGHT() > tmpStick.getHEIGHT()) {
                minStick = tmpStick;
            }

        }
        minStick.setColor(Color.yellow);
        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        minTime += THREAD_SLEEP;
        return minStick;
    }

    public static void bubbleSort() {
        start = System.currentTimeMillis();
        minTime = 0;
        elapsedTime = 0;
        Thread thread = new Thread("New Thread") {

            public void run() {
                int tmp = 0;

                for (int i = 0; i < number_of_stick; i++) {

                    for (int j = 0; j < number_of_stick - 1; j++) {
                        
                        Stick one = sticks.get(j);
                        Stick two = sticks.get(j+1);
                        
                        if (sticks.get(j).getHEIGHT() > sticks.get(j + 1).getHEIGHT()) {
                            one.setColor(Color.GREEN);
                            two.setColor(Color.GREEN);
                            tmp = one.getHEIGHT();
                            one.setHEIGHT(two.getHEIGHT());
                            two.setHEIGHT(tmp);
                            myFrame.repaint();
                            try {
                                Thread.sleep(THREAD_SLEEP);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            minTime += THREAD_SLEEP;
                        }
                        one.setColor(Color.MAGENTA);
                        two.setColor(Color.MAGENTA);

                    }
                        
                }
                end = System.currentTimeMillis();

                elapsedTime = end - start - minTime;
                myFrame.getLabel_time().setText(String.valueOf(elapsedTime));

            }

        };
        
        thread.start();
        
    }

    
    
    
    
    
}
