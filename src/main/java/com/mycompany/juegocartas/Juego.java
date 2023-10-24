/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pl2023266
 */
public class Juego {

    Scanner sc = new Scanner(System.in);
    
    private Baraja m_baraja;
    private ArrayList<Carta> m_pila;
    private int m_turno;

    Juego(Baraja baraja, ArrayList<Carta> pila, int turno) {
        m_baraja = baraja;
        m_pila = pila;
        m_turno = turno;
    }

    public ArrayList<Carta> getPila() {
        return m_pila;
    }
    
    public void setTurno(int turno){
        m_turno = turno;
    }

    
    //COMPROBAR SI ROBA
    public boolean comprobarSiRoba(Jugador jugador){
        //VARIABLE PARA SABER SI TIENE MOVIMIENTO POSIBLE
        boolean hayPosible = false;
        //PARA CADA CARTA DE SU MANO HACEMOS COMPROBACION CON LA ULTIMA CARTA DE LA PILA
         if (m_pila.size() != 0) {
            for (int i = 0; i < jugador.getNumCartas(); i++) {
                if ((m_pila.get(m_turno - 1).getColor() == jugador.getCartaMano(i).getColor()) || (m_pila.get(m_turno - 1).getNumero() == jugador.getCartaMano(i).getNumero())) {
                    hayPosible = true;
                }
            }
            //SI NO HAY POSIBLE MOVIMIENTO ROBA Y SE ENSEÑA NUEVA MANO
            if (hayPosible == false) {
                jugador.robaCarta(m_baraja, 0);
                System.out.println("No tienes cartas posibles, robas carta");
                System.out.println("Nueva mano:");
                jugador.ensenaMano();
            }
        }else{
             hayPosible=true;
         }
         return hayPosible;
    }
    
    //JUGAR CARTA
    public void juegaCarta(Jugador jugador, Carta cartaNueva) {
        //NO ES TURNO 1
        if (m_pila.size() != 0) {
            //COMPRUEBA SI LA CARTA ES VALIDA PARA JUGARLA COMPARANDO VALORES CON PILA
            if ((m_pila.get(m_turno - 1).getColor() == cartaNueva.getColor()) || (m_pila.get(m_turno - 1).getNumero() == cartaNueva.getNumero())) {
                //LA AÑADO A LA PILA
                m_pila.add(cartaNueva);
                //BORRO CARTA DE LA MANO JUGADA
                jugador.borraCartaMano(cartaNueva);
                //AUMENTO EL TURNO
                m_turno++;
        
            } //NO ES UNA CARTA ACEPTABLE
            else {
                System.out.println("No comparten ni color ni numero");
                System.out.println("Vuelve a elegir el numero:");
                int carta_jugada = sc.nextInt();
                juegaCarta(jugador, jugador.getCartaMano(carta_jugada));
            }
        } //ES PRIMER TURNO
        else {
            m_pila.add(cartaNueva);
            //BORRO CARTA DE LA MANO JUGADA
            jugador.borraCartaMano(cartaNueva);
             //AUMENTO EL TURNO
            m_turno++;
        }
    }

    public void ensenaPila() {
        int i;
        for (i = 0; i < m_pila.size(); i++) {
            System.out.println(m_pila.get(i).ensenaCarta());
        }
    }
}
