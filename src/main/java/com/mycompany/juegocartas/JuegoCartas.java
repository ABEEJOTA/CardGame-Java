/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.juegocartas;

import java.util.ArrayList;
import java.util.Scanner;

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

        Scanner sc = new Scanner(System.in);

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
        CartaNormal Rojo4 = new CartaNormal("Rojo", 4);
        CartaNormal Verde4 = new CartaNormal("Verde", 4);
        CartaNormal Amarillo4 = new CartaNormal("Amarillo", 4);
        CartaNormal Azul4 = new CartaNormal("Azul", 4);
        CartaNormal Rojo5 = new CartaNormal("Rojo", 5);
        CartaNormal Verde5 = new CartaNormal("Verde", 5);
        CartaNormal Amarillo5 = new CartaNormal("Amarillo", 5);
        CartaNormal Azul5 = new CartaNormal("Azul", 5);
        CartaNormal Rojo6 = new CartaNormal("Rojo", 6);
        CartaNormal Verde6 = new CartaNormal("Verde", 6);
        CartaNormal Amarillo6 = new CartaNormal("Amarillo", 6);
        CartaNormal Azul6 = new CartaNormal("Azul", 6);

        //SETEO BARAJA
        ArrayList<Carta> cartasBaraja = new ArrayList();
        cartasBaraja.add(Rojo1);
        cartasBaraja.add(Rojo2);
        cartasBaraja.add(Rojo3);
        cartasBaraja.add(Rojo4);
        cartasBaraja.add(Rojo5);
        cartasBaraja.add(Rojo6);
        cartasBaraja.add(Amarillo1);
        cartasBaraja.add(Amarillo2);
        cartasBaraja.add(Amarillo3);
        cartasBaraja.add(Amarillo4);
        cartasBaraja.add(Amarillo5);
        cartasBaraja.add(Amarillo6);
        cartasBaraja.add(Azul1);
        cartasBaraja.add(Azul2);
        cartasBaraja.add(Azul3);
        cartasBaraja.add(Azul4);
        cartasBaraja.add(Azul5);
        cartasBaraja.add(Azul6);
        cartasBaraja.add(Verde1);
        cartasBaraja.add(Verde2);
        cartasBaraja.add(Verde3);
        cartasBaraja.add(Verde4);
        cartasBaraja.add(Verde5);
        cartasBaraja.add(Verde6);
        Baraja Baraja = new Baraja(cartasBaraja);

        //TEST GENERAR MANO JUGADOR 1
        ArrayList<Carta> ManoJugador1 = new ArrayList();
        Jugador Jugador1 = new Jugador(ManoJugador1);
        //GENERAR MANO
        Jugador1.generaMano(Baraja);

        //TEST GENERAR MANO JUGADOR 2
        ArrayList<Carta> ManoJugador2 = new ArrayList();
        Jugador Jugador2 = new Jugador(ManoJugador2);
        //GENERAR MANO
        Jugador2.generaMano(Baraja);

        //TEST JUGAR CARTA
        //INICIALIZO PILA
        ArrayList<Carta> pila = new ArrayList();
        //INICIALIZO TURNO
        final int TURNO_INICIAL = 0;
        //CREO EL JUEGO CON UNA BARAJA LLENA, UNA PILA VACIA Y UN TURNO 0
        Juego Partida = new Juego(Baraja, pila, TURNO_INICIAL);

        
        
        //CONVERTIRLO EN FUNCION PUBLIC STATIC VOID BUCLEJUEGO(JUEGO PARTIDA, JUGADOR JUGADOR1, JUGADOR JUGADOR2)
        //BUCLE DE JUGAR CARTAS HASTA QUE UN JUGADOR SE QUEDE SIN CARTAS
        while (Jugador1.getNumCartas() != 0 && Jugador2.getNumCartas() != 0) {

            //ENSEÑAR MANO JUGADOR 1
            System.out.println("Esta es la mano inicial del jugador 1:");
            Jugador1.ensenaMano();
            
            //COMPRUEBO SI EL JUGADOR 1 PUEDE JUGAR O ROBA
            boolean noRoba1 = Partida.comprobarSiRoba(Jugador1);
            //LE PIDO AL JUGADOR 1 QUE INTRODUZCA SU CARTA PARA JUGAR SI NO HA ROBADO
            if (noRoba1){
                System.out.println("JUGADOR 1 - Introduce el numero de la carta que quieres jugar:");
                int carta_jugada = sc.nextInt();
                //JUEGO LA CARTA DE LA MANO DEL JUGADOR 1
                Partida.juegaCarta(Jugador1, Jugador1.getCartaMano(carta_jugada));
                
                //ENSEÑO LA PILA
                System.out.println("--------------------------Esta es la pila de cartas:");
                Partida.ensenaPila();
                System.out.println("----------------------------------------------------------");
            }

            
            
            //ENSEÑAR MANO JUGADOR 2
            System.out.println("Esta es la mano inicial del jugador 2:");
            Jugador2.ensenaMano();
            
            //COMPRUEBO SI EL JUGADOR 2 PUEDE JUGAR O ROBA
            boolean noRoba2 = Partida.comprobarSiRoba(Jugador2);
            //LE PIDO AL JUGADOR 2 QUE INTRODUZCA SU CARTA PARA JUGAR SI NO HA ROBADO
            if(noRoba2){
                System.out.println("JUGADOR 2 - Introduce el numero de la carta que quieres jugar:");
                int carta_jugada2 = sc.nextInt();
                //JUEGO LA CARTA DE LA MANO DEL JUGADOR 2
                Partida.juegaCarta(Jugador2, Jugador2.getCartaMano(carta_jugada2));        
                
                //ENSEÑO LA PILA
                System.out.println("----------------------------Esta es la pila de cartas:");
                Partida.ensenaPila();
                System.out.println("----------------------------------------------------------");
            }
        }
        
        //QUIEN GANA
        if (Jugador1.getNumCartas()==0){
            System.out.println("El Jugador1 gana!!!");
        }else{
            System.out.println("El Jugador2 gana!!!");
        }
        

    }
}
