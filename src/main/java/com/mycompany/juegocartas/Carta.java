/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;

/**
 *
 * @author pl2023266
 */
interface Carta {
    
    //GETTERS
    public abstract String getColor();
    
   public abstract int getNumero();
    
    //SETTERS
    public abstract void setColor(String color);
    
    public abstract void setNumero(int numero);
    
    
    //ENSEÑAR CARTA
    public abstract String ensenaCarta();
}
