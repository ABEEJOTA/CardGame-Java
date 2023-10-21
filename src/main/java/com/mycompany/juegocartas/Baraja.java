/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;
import java.util.ArrayList;

/**
 *
 * @author pl2023266
 */
public class Baraja {
    private ArrayList<Carta> m_cartas;
    final int CARTAS_BARAJA = 10;
    
    Baraja(ArrayList<Carta> cartas){
        m_cartas = cartas;
    }
    
    public ArrayList<Carta> getBaraja(){
        return m_cartas;
    }
    
    public void setBaraja(ArrayList<Carta> cartas){
        m_cartas = cartas;
    }
    
    public Carta getCartaBaraja(int i){
        return m_cartas.get(i);
    }
    
    public void borrarCartaBaraja(int i){
        m_cartas.remove(i);
    }
}
