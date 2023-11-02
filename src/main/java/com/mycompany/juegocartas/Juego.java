/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.juegocartasbasico;

import java.util.*;

/**
 *
 * @author pl2023266
 */
public class Juego {
    
    Scanner sc = new Scanner(System.in);
    
    private final Baraja m_baraja;
    private final ArrayList<Carta> m_pila;
    private int m_turno;
    private ArrayList<Jugador> m_jugadores;

    public Juego(Baraja baraja, ArrayList<Jugador> jugadores) {
        m_baraja = baraja;
        m_pila = new ArrayList();
        m_turno = 0;
        m_jugadores = jugadores;
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
    public boolean juegaCarta(Jugador jugador, Carta cartaNueva) {
        boolean noValida = false;
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
                noValida = true;
            }
        } //ES PRIMER TURNO
        else {
            m_pila.add(cartaNueva);
            //BORRO CARTA DE LA MANO JUGADA
            jugador.borraCartaMano(cartaNueva);
             //AUMENTO EL TURNO
            m_turno++;
        }
        return noValida;
    }

    //QUIZAS ENSEÑAR LA ULTIMA CARTA Y AL FINAL ENSEÑARLA TODA
    public void ensenaPila() {
        int i;
        for (i = 0; i < m_pila.size(); i++) {
            System.out.println(m_pila.get(i).ensenaCarta());
        }
    }
    
    //COMPROBAR SI ALGUIEN TIENE 0 CARTAS
    public static boolean alguienNoGana(ArrayList<Jugador> jugadores){
        //SI EL BOOLEANO ES CIERTO ES QUE LA PARTIDA SIGUE
        boolean hayPartida = true;
        //POR CADA JUGADOR COMPRUEBO SU NUMERO DE CARTAS
        for(int i = 0; i < jugadores.size(); i++){
            if (jugadores.get(i).getNumCartas() == 0){
                hayPartida = false;
            }
        }
        return hayPartida;
    }
    
    public void buclePartida(ArrayList<Jugador> jugadores, int nJugadores) {
        //SERA EL VALOR QUE GUARDARA LA CARTA JUGADA POR EL USUARIO
        int carta_jugada;
        //VARIABLE QUE MIRA QUE LA CARTA INTRODUCIDA SEA VALIDA
        boolean noValida = true;
        
        //SI TIENEN CARTAS EN MANO HAY BUCLE 
        while (alguienNoGana(jugadores)) {
            for (int i = 0; i < nJugadores; i++) {
                
                //ENSEÑAR MANO JUGADOR 
                System.out.println("Esta es la mano del jugador " + (i+1) + " :");
                jugadores.get(i).ensenaMano();

                //COMPRUEBO SI EL JUGADOR PUEDE JUGAR O ROBA
                boolean noRoba = this.comprobarSiRoba(jugadores.get(i));
                //LE PIDO AL JUGADOR QUE INTRODUZCA SU CARTA PARA JUGAR SI NO HA ROBADO
                if (noRoba) {
                    System.out.println("JUGADOR " + (i+1) + " - Introduce el numero de la carta que quieres jugar:");
                    
                    do {
                        //BUCLE HASTA QUE EL NUMERO INTRODUCIDO SEA UNA CARTA VALIDA
                        do {
                            carta_jugada = sc.nextInt();
                            if (carta_jugada > jugadores.get(i).getNumCartas() - 1 || carta_jugada <0) {
                                System.out.println("Carta incorrecta, introduce una carta válida:");
                            }
                        } while (carta_jugada > jugadores.get(i).getNumCartas() - 1 || carta_jugada <0);
                        //JUEGA LA CARTA ELEGIDA O DICE SI LA CARTA JUGADA ES VALIDA
                        noValida = this.juegaCarta(jugadores.get(i), jugadores.get(i).getCartaMano(carta_jugada));
                    //VUELVO A PREGUNTAR MIENTRAS LA CARTA NO SEA VALIDA
                    } while (noValida);

                    //ENSEÑO LA PILA
                    System.out.println("--------------------------Esta es la pila de cartas:");
                    this.ensenaPila();
                    System.out.println("----------------------------------------------------------");
                }
            }
        }
        //QUIEN GANA
        for (int i = 0; i < nJugadores; i++) {
            if (jugadores.get(i).getNumCartas() == 0) {
                System.out.println("El Jugador " + (i+1) + " gana!!!");
            }
        }
    }
}


