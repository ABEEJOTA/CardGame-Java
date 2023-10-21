/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;

/**
 *
 * @author pl2023266
 */
public class CartaNormal extends Carta {
    private int m_numero;
    
    
    
    CartaNormal(Color color, int numero){
        super(color);
        m_numero = numero; 
    }
    
    //GETTERS
    @Override public int getNumero(){
        return m_numero;
    }
    
    @Override public Color getColor(){
        return m_color;
    }
    
    //SETTERS
    public void setNumero(int numero){
        m_numero = numero;
    }
    
    @Override public void setColor(Color color){
        m_color = color;
    }
    
    
    @Override public String ensenaCarta (){
        Color color =  getColor();
        int numero = getNumero();
        return (color + " " + numero);
    }
}
