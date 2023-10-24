/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;

/**
 *
 * @author pl2023266
 */
public class CartaNormal implements Carta {
    protected int m_numero;
    protected String m_color;
    
    CartaNormal(String color, int numero){
        m_color = color;
        m_numero = numero; 
    }
    
    //GETTERS
   @Override public int getNumero(){
        return m_numero;
    }
   
   @Override public String getColor(){
       return m_color;
   }
    
    //SETTERS
    @Override public void setNumero(int numero){
        m_numero = numero;
    }
    
    @Override public void setColor(String color){
        m_color =  color;
    }
    
    //ENSEÑAR CARTA
    @Override public String ensenaCarta (){
        String color =  getColor();
        int numero = getNumero();
        return (color + " " + numero);
    }
}
