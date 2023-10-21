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
        
        //SETEO DE CARTAS
        CartaNormal Rojo1 = new CartaNormal(Carta.Color.Rojo, 1);
        CartaNormal Verde1 = new CartaNormal(Carta.Color.Verde, 1);
        CartaNormal Amarillo1 = new CartaNormal(Carta.Color.Amarillo, 1);
        CartaNormal Azul1 = new CartaNormal(Carta.Color.Azul, 1);
        CartaNormal Rojo2 = new CartaNormal(Carta.Color.Rojo, 2);
        CartaNormal Verde2 = new CartaNormal(Carta.Color.Verde, 2);
        CartaNormal Amarillo2 = new CartaNormal(Carta.Color.Amarillo, 2);
        CartaNormal Azul2 = new CartaNormal(Carta.Color.Azul, 2);
        
        //SETEO BARAJA
        ArrayList<Carta> cartasBaraja = new ArrayList();
        cartasBaraja.add(Rojo1);
        cartasBaraja.add(Rojo2);
        cartasBaraja.add(Amarillo1);
        cartasBaraja.add(Amarillo2);
        cartasBaraja.add(Azul1);
        cartasBaraja.add(Azul2);
        cartasBaraja.add(Verde1);
        cartasBaraja.add(Verde2);
        Baraja Baraja = new Baraja(cartasBaraja);
        
        //INICIALIZAR MANO JUGADOR
        
        
        //TEST VER CARTA JUGADOR
        ArrayList<Carta> ManoJugador1 = new ArrayList();
        /*
        ManoJugador1.add(Rojo1);
        ManoJugador1.add(Verde2);
        */
        Jugador Jugador1 = new Jugador(ManoJugador1);
        Jugador1.generaMano(Baraja);
        System.out.println(Jugador1.ensenaCartaMano(1));
        
        //TEST JUGAR CARTA
            //INICIALIZO PILA
        ArrayList<Carta> pila = new ArrayList();
            //INICIALIZO TURNO
        final int TURNO_INICIAL = 0;
            //CREO EL JUEGO CON UNA BARAJA LLENA, UNA PILA VACIA Y UN TURNO 0
        Juego Partida = new Juego(Baraja, pila,TURNO_INICIAL);
            //JUEGO UNA CARTA DE LA MANO DE UN JUGADOR
        Partida.juegaCarta(Jugador1.getMano().get(0));
            //ENSEÑO LA PILA
        Partida.ensenaPila();
        
        
    }
}
