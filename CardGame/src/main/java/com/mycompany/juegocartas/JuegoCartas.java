/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.juegocartas;

import java.util.*;

/**
 *
 * @author pl2023266
 */
public class JuegoCartas {

    public static void main(String[] args) {
        
        int[] numeros = {1, 2, 3, 4, 5, 6,7, 8, 9, 0};
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        String[] efectosEspeciales = {"Mas4", "CambioColor"};
        String[] efectos = {"Salto", "Roba", "Giro"};
        
        //SETEO BARAJA
        ArrayList<Carta> cartasBaraja = new ArrayList();
        
        //SETEO DE CARTAS NORMALES Y ESPECIALES COLORIDAS
        for(int dobleCarta = 0; dobleCarta < 2; dobleCarta++){
            for (String i : colores) {
                for (int j : numeros) {
                    CartaNormal cartaNormal = new CartaNormal(i, j);
                    cartasBaraja.add(cartaNormal);
                }
                for (String k: efectos){
                    CartaEspecial cartaEspecial = new CartaEspecial(i, k);
                    cartasBaraja.add(cartaEspecial);
                }
            }
        }
        
        //SETEO DE CARTAS UNICAS
        for(int cuadrupleCartas = 0; cuadrupleCartas<4;cuadrupleCartas++){
            for(String l:efectosEspeciales){
                CartaEspecial cartaEspecialUnica = new CartaEspecial("Especial",l);
                cartasBaraja.add(cartaEspecialUnica);
            }
        }
        //MEZCLA BARAJA
        Collections.shuffle(cartasBaraja);
        //DECLARACION BARAJA
        Baraja Baraja = new Baraja(cartasBaraja);

        //POSIBLE BUCLE PARA NUMERO DE JUGADORES DINAMICO
        //TEST GENERAR MANO JUGADOR 1
        Jugador Jugador1 = new Jugador();
        //GENERAR MANO
        Jugador1.generaMano(Baraja);

        //TEST GENERAR MANO JUGADOR 2
        Jugador Jugador2 = new Jugador();
        //GENERAR MANO
        Jugador2.generaMano(Baraja);

        //TEST JUGAR CARTA
        Juego Partida = new Juego(Baraja);
        
        //BUCLE DE JUGAR CARTAS HASTA QUE UN JUGADOR SE QUEDE SIN CARTAS
        Partida.buclePartida(Jugador1,Jugador2);

    }
}
