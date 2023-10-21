/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;

/**
 *
 * @author pl2023266
 */
abstract class Carta {
    
    public enum Color{
        Rojo,
        Azul,
        Amarillo,
        Verde
    }
    
    protected Color m_color;
    
    Carta(Color color){
        m_color = color;
    }
    
    //GETTERS
    public abstract Color getColor();
    public abstract int getNumero();
    
    //SETTERS
    public abstract void setColor(Color color);
    
    public abstract String ensenaCarta();
}
