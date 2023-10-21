/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.juegocartas;

import java.util.ArrayList;

/**
 *
 * @author pl2023266
 */
public class JuegoCartas {

    public static void main(String[] args) {
        /*
        CartaNormal cartaEj = new CartaNormal("Roja" , 2);
        System.out.println(cartaEj.getNumero() + ", " + cartaEj.getColor());
         */
        
        
        //MIRAR ENUM PARA COLORES
        
        //SETEO DE CARTAS
        CartaNormal Rojo1 = new CartaNormal("Rojo", 1);
        CartaNormal Verde1 = new CartaNormal("Verde", 1);
        CartaNormal Amarillo1 = new CartaNormal("Amarillo", 1);
        CartaNormal Azul1 = new CartaNormal("Azul", 1);
        CartaNormal Rojo2 = new CartaNormal("Rojo", 2);
        CartaNormal Verde2 = new CartaNormal("Verde", 2);
        CartaNormal Amarillo2 = new CartaNormal("Amarillo", 2);
        CartaNormal Azul2 = new CartaNormal("Azul", 2);
        CartaNormal Rojo3 = new CartaNormal("Rojo", 3);
        CartaNormal Verde3 = new CartaNormal("Verde", 3);
        CartaNormal Amarillo3 = new CartaNormal("Amarillo", 3);
        CartaNormal Azul3 = new CartaNormal("Azul", 3);
        
        //SETEO BARAJA
        ArrayList<Carta> cartasBaraja = new ArrayList<Carta>();
        cartasBaraja.add(Rojo1);
        cartasBaraja.add(Rojo2);
        cartasBaraja.add(Rojo3);
        cartasBaraja.add(Amarillo1);
        cartasBaraja.add(Amarillo2);
        cartasBaraja.add(Amarillo3);
        cartasBaraja.add(Azul1);
        cartasBaraja.add(Azul2);
        cartasBaraja.add(Azul3);
        cartasBaraja.add(Verde1);
        cartasBaraja.add(Verde2);
        cartasBaraja.add(Verde3);
        Baraja Baraja = new Baraja(cartasBaraja);
        
        
        //TEST VER CARTA JUGADOR
        ArrayList<Carta> ManoJugador1 = new ArrayList<Carta>();
        Jugador Jugador1 = new Jugador(ManoJugador1);
        Jugador1.generaMano(Baraja);
        //Jugador1.ensenaCartaMano(5));
        Jugador1.ensenaMano();
        
        //TEST JUGAR CARTA
            //INICIALIZO PILA
        ArrayList<Carta> pila = new ArrayList<Carta>();
            //INICIALIZO TURNO
        final int TURNO_INICIAL = 0;
            //CREO EL JUEGO CON UNA BARAJA LLENA, UNA PILA VACIA Y UN TURNO 0
        Juego Partida = new Juego(Baraja, pila,TURNO_INICIAL);
            //JUEGO UNA CARTA DE LA MANO DE UN JUGADOR
        Partida.juegaCarta(Jugador1.getCartaMano(1));
            //ENSEÑO LA PILA
        Partida.ensenaPila();
    }
}
