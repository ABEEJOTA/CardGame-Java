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
public class Juego {

    private Baraja m_baraja;
    private ArrayList<Carta> m_pila;
    private int m_turno;

   Juego(Baraja baraja, ArrayList<Carta> pila, int turno) {
        m_baraja = baraja;
        m_pila = pila;
        m_turno = turno;
    }

   public ArrayList<Carta> getPila(){
       return m_pila;
   }
   
    public void juegaCarta(Carta cartaNueva) {
        //NO ES TURNO 1
        if (m_pila.size() != 0) {
            if ((m_pila.get(m_turno-1).getColor() == cartaNueva.getColor()) || (m_pila.get(m_turno-1).getNumero() == cartaNueva.getNumero()))  {
                m_pila.add(cartaNueva);
            }
            //NO ES UNA CARTA ACEPTABLE
            else{
                System.out.println("No comparten ni color ni numero");
            }
        }
        //ES PRIMER TURNO
        else {
                m_pila.add(cartaNueva);
        }
    }
    
    public void ensenaPila(){
        int i;
        for(i=0;i<m_pila.size();i++){
        System.out.println(m_pila.get(i).ensenaCarta());
        }
    }
}
