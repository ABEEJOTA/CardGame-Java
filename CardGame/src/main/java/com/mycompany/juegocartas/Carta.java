/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

/**
 *
 * @author pl2023266
 */
    public class Carta {
    String m_color;
    
    Carta(String color){
        m_color = color;
    }
    
    //GETTERS
    public String getColor(){
        return m_color;
    }
    
    //SETTERS
    public void setColor(String color){
        m_color = color;
    }
    
    //ENSEÑAR CARTA
    public String ensenaCarta(){
        return m_color;
    }
}