/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ugurkellecioglu.sorting;

import java.awt.Color;

/**
 *
 * @author ugur
 */
public class Stick {
    private int WIDTH;
    private int HEIGHT;
    private Color color;
    private int index;

    public Stick(int WIDTH, int HEIGHT, Color color, int index) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.color = color;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Stick{" + "WIDTH=" + WIDTH + ", HEIGHT=" + HEIGHT + ", color=" + color + ", index=" + index + '}';
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Color getColor() {
        return color;
    }

    public int getIndex() {
        return index;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
