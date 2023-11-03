/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

/**
 *
 * @author pl2023266
 */
public class CartaNormal extends Carta {
    protected int m_numero;
    
    CartaNormal(String color, int numero){
        super(color);
        m_numero = numero; 
    }
    
    //GETTERS
   public int getNumero(){
        return m_numero;
    }
   
   @Override public String getColor(){
       return m_color;
   }
    
    //SETTERS
    public void setNumero(int numero){
        m_numero = numero;
    }
    
    @Override public void setColor(String color){
        m_color =  color;
    }
    
    //ENSEÑAR CARTA
    @Override public String ensenaCarta (){
        return (m_color + " " + m_numero);
    }
}