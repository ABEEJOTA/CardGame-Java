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
public class Jugador {
    private ArrayList<Carta> m_mano;
    
   Jugador(ArrayList<Carta> mano){
        m_mano = mano;
    }
    
    //GETTERS
    public ArrayList<Carta> getMano(){
        return m_mano;
    }
    
    public int getNumCartas(){
        return m_mano.size();
    }
    
    //SETTERS
    public void setMano(ArrayList<Carta> mano){
        m_mano = mano;
    }
    
    //VALOR RANDOM
    public void generaMano(Baraja baraja){
        for(int i = 0; i<7 ; i++){
            robaCarta(baraja, i);
        }
    }
    
    public String ensenaCartaMano (int i){
        return m_mano.get(i).ensenaCarta();
    }
    
    //VALOR RANDOM
    public void robaCarta(Baraja baraja, int i){
        //m_mano.add(baraja.getCartas().get(i));
        m_mano.add(baraja.getCartaBaraja(i));
        baraja.borrarCartaBaraja(i);
    }
}
