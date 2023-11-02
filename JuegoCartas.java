/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.juegocartasbasico;

import java.util.*;

/**
 *
 * @author pl2023266
 */
public class JuegoCartas {
        
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = {1, 2, 3, 4, 5, 6,7, 8, 9, 0};
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo"};
        
        //SETEO ARRAY DE CARTAS BARAJA
        ArrayList<Carta> cartasBaraja = new ArrayList();
      
        //SETEO DE CARTAS NORMALES
        for(int dobleCarta = 0; dobleCarta < 2; dobleCarta++){
            for (String i : colores) {
                for (int j : numeros) {
                    CartaNormal cartaNormal = new CartaNormal(i, j);
                    cartasBaraja.add(cartaNormal);
                }
            }
        }
        
        //MEZCLA BARAJA
        Collections.shuffle(cartasBaraja);
        //INICIALIZAR OBJETO BARAJA CON LISTA CARTAS BARAJA
        Baraja Baraja = new Baraja(cartasBaraja);
        
        //PEDIR NUM JUGADORES
        System.out.println("Introduce el número de jugadores:");
        int n = sc.nextInt();
        
        //GENERACION DE JUGADORES
        ArrayList<Jugador> jugadores = new ArrayList();
        for (int i=0;i<n;i++){
            //GENERO JUGADOR, LE DOY MANO Y LO METO EN LA LISTA DE JUGADORES
            Jugador Jugador = new Jugador();
            Jugador.generaMano(Baraja);
            jugadores.add(Jugador);
        }
        
        //CREO LA PARTIDA
        Juego Partida = new Juego(Baraja, jugadores);
        
        //BUCLE DE JUGAR CARTAS HASTA QUE UN JUGADOR SE QUEDE SIN CARTAS
        Partida.buclePartida(jugadores, n);
    }
}
