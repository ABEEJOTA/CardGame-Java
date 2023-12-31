/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

/**
 *
 * @author pl2023266
 */

public class CartaEspecial extends Carta {
    
    private String m_efecto;
    
    CartaEspecial(String color, String efecto){
        super(color);
        m_efecto = efecto;
    }
    
    //GETTERS
    public String getEfecto(){
        return m_efecto;
    }
    
    @Override public String getColor(){
        return m_color;
    }
    
    //SETTERS
    public void setEfecto(String efecto){
        m_efecto = efecto;
    }
    
   @Override public void setColor(String color){
        m_color = color;
    }
    
    @Override public String ensenaCarta(){
        return(m_color + " " + m_efecto);
    }
   
}