/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cardgame;

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
    private boolean sentidoHorario;

    public Juego(Baraja baraja, ArrayList<Jugador> jugadores) {
        m_baraja = baraja;
        m_pila = new ArrayList();
        m_turno = 0;
        m_jugadores = jugadores;
        sentidoHorario = true;
    }

    public ArrayList<Carta> getPila() {
        return m_pila;
    }
    
    public Carta ultimaCartaPila(ArrayList<Carta> pila){
        return m_pila.get(m_pila.size()-1);
    }

    //SERA LO QUE COMPROBARA LAS JUGADAS EN LA FUNCION JUEGACARTA
    public boolean comprobarCartaValida(Carta carta) {
        boolean valida = false;
        
        if (carta instanceof CartaNormal) {//CARTA NORMAL JUGADA------------------------------------------------------------
            CartaNormal cartaNormal = (CartaNormal) carta;
            if (this.ultimaCartaPila(m_pila) instanceof CartaNormal) {//CARTA NORMAL PILA--------------------
                CartaNormal cartaPilaNormal = (CartaNormal) this.ultimaCartaPila(m_pila);
                if((cartaPilaNormal.getColor().equals(cartaNormal.getColor())) || (cartaPilaNormal.getNumero()==cartaNormal.getNumero())){
                    valida = true;
                }
            }//-------------------------------------------------------------------------------------------------------------------
            else if(this.ultimaCartaPila(m_pila) instanceof CartaEspecial){//CARTA ESPECIAL PILA------------------------------------------------------------------------------
                CartaEspecial cartaPilaEspecial = (CartaEspecial) this.ultimaCartaPila(m_pila);
                if(cartaPilaEspecial.getEfecto().equals("Mas4")){
                    valida=true;
                }
                if (cartaPilaEspecial.getColor().equals(cartaNormal.getColor())) {
                    valida = true;
                }
            }//-------------------------------------------------------------------------------------------------------------------
        }//---------------------------------------------------------------------------------------------------------------------------------------
        
        
        else if (carta instanceof CartaEspecial) {//CARTA ESPECIAL JUGADA--------------------------------------------------------
            CartaEspecial cartaEspecial = (CartaEspecial) carta;
            //SIEMPRE PUEDES TIRAR UN +4, NO HAY EXCEPCION
            if(cartaEspecial.getEfecto().equals("Mas4")){
                valida=true;
            }
            if (this.ultimaCartaPila(m_pila) instanceof CartaNormal) {//CARTA NORMAL PILA---------------------
                CartaNormal cartaPilaNormal = (CartaNormal) this.ultimaCartaPila(m_pila);
                if(cartaEspecial.getColor().equals("Especial")){
                    valida=true;
                }
                else{
                    if(cartaEspecial.getColor().equals(cartaPilaNormal.getColor())){
                        valida=true;
                    }
                }
            }//-----------------------------------------------------------------------------------------------------------------------
            
            else if(this.ultimaCartaPila(m_pila) instanceof CartaEspecial){//CARTA ESPECIAL PILA----------------------
                CartaEspecial cartaPilaEspecial = (CartaEspecial) this.ultimaCartaPila(m_pila);
                if(cartaPilaEspecial.getEfecto().equals("Mas4")){
                    valida=true;
                }
                if((cartaEspecial.getColor().equals("Especial")) && (cartaPilaEspecial.getEfecto().equals("CambioColor"))){
                    valida=true;
                }
                if((!cartaEspecial.getColor().equals("Especial")) && (cartaEspecial.getColor().equals(cartaPilaEspecial.getColor()))){
                    valida = true;
                }
            }//-----------------------------------------------------------------------------------------------------------------------
        }//---------------------------------------------------------------------------------------------------------------------------------------

        return valida;
    }

    //COMPROBAR SI ROBA
    public boolean comprobarSiRoba(Jugador jugador){
        //VARIABLE PARA SABER SI TIENE MOVIMIENTO POSIBLE
        boolean hayPosible = false;
        //PARA CADA CARTA DE SU MANO HACEMOS COMPROBACION CON LA ULTIMA CARTA DE LA PILA
         if (!m_pila.isEmpty()) {
            for (int i = 0; i < jugador.getNumCartas(); i++) {
                if (comprobarCartaValida(jugador.getCartaMano(i))) {
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
        if (!m_pila.isEmpty()) {
            //COMPRUEBA SI LA CARTA ES VALIDA PARA JUGARLA COMPARANDO VALORES CON PILA
            if (comprobarCartaValida(cartaNueva)) {
                //LA AÑADO A LA PILA
                m_pila.add(cartaNueva);
                
                //SI ES CARTA ESPECIAL METER CODIGO DEPENDIENDO DE LA CARTA JUGADA
                if(cartaNueva instanceof CartaEspecial){
                    CartaEspecial cartaEspecial = (CartaEspecial) cartaNueva;
                    aplicarEfectoCartaEspecial(cartaEspecial);
                }
                
                //BORRO CARTA JUGADA DE LA MANO
                jugador.borraCartaMano(cartaNueva);
                //JUGADOR SIGUIENTE
                if (sentidoHorario) {
                    m_turno++;
                    if(m_turno==m_jugadores.size()){
                        m_turno=0;
                    }
                }else{
                    m_turno--;
                    if(m_turno<0){
                        m_turno=m_jugadores.size()-1;
                    }
                }

            } //NO ES UNA CARTA ACEPTABLE
            else {
                System.out.println("No es una carta jugable");
                System.out.println("Vuelve a elegir el numero:");
                noValida = true;
            }
        } else {//ES PRIMER TURNO
            m_pila.add(cartaNueva);
            //SI ES CARTA ESPECIAL HAY QUE APLICAR EL EFECTO
            if (cartaNueva instanceof CartaEspecial) {
                CartaEspecial cartaEspecial = (CartaEspecial) cartaNueva;
                aplicarEfectoCartaEspecial(cartaEspecial);
            }
            //BORRO CARTA DE LA MANO JUGADA
            jugador.borraCartaMano(cartaNueva);
            //JUGADOR SIGUIENTE
                if (sentidoHorario) {
                    m_turno++;
                    if(m_turno==m_jugadores.size()){
                        m_turno=0;
                    }
                }else{
                    m_turno--;
                    if(m_turno<0){
                        m_turno=m_jugadores.size()-1;
                    }
                }
        }
        return noValida;
    }
    
    //FUNCION QUE APLICA EL EFECTO DE LAS CARTAS ESPECIALES
    public void aplicarEfectoCartaEspecial(CartaEspecial cartaEspecial){
        
        int siguienteJugador;
        
        //CASO DEPENDIENDO DEL EFECTO DE LA CARTA ESPECIAL
        switch (cartaEspecial.getEfecto()){
            
            //CASO DE CAMBIO DE COLOR
            case "CambioColor":
                String colorElegido=null;
                int colorNumero;
                String[] colores = {"Rojo", "Verde", "Azul", "Amarillo"};
                boolean numeroInvalido = false;
                do {
                    System.out.println("Qué color quieres poner?");
                    System.out.println("[1]Rojo, [2]Verde, [3]Azul, [4]Amarillo:");
                    colorNumero = sc.nextInt();
                    if (colorNumero >= 1 && colorNumero <= 4){
                        colorElegido = colores[colorNumero-1];
                    }else{
                        System.out.println("Numero incorrecto, introdúcelo otra vez:");
                        numeroInvalido=true;
                    }
                } while (numeroInvalido);
                //CAMBIO EL COLOR DE LA MISMA CARTA COMODIN JUGADA POR EL COLOR ELEGIDO
                m_pila.get(m_pila.size()-1).setColor(colorElegido);
                break;
                
            //CASO DE ROBA 4
            case "Mas4":
                if (sentidoHorario) {
                    siguienteJugador = (m_turno + 1) % m_jugadores.size();
                } else {
                    siguienteJugador = (m_turno - 1) % m_jugadores.size();
                }
                for (int i = 0; i < 4; i++) {
                    m_jugadores.get(siguienteJugador).robaCarta(m_baraja, 0);
                }
                System.out.println("------------------------------------------------------------");
                System.out.println("El Jugador siguiente roba 4 cartas!!");
                System.out.println("------------------------------------------------------------");
                break;
                
            //CASO DE SALTAR JUGADOR
            case "Salto":
                System.out.println("------------------------------------------------------------");
                System.out.println("El siguiente Jugador pierde su turno!!");
                System.out.println("------------------------------------------------------------");
                if(sentidoHorario){
                    m_turno = (m_turno + 1) % m_jugadores.size();
                }else{
                    m_turno = (m_turno - 1 + m_jugadores.size()) % m_jugadores.size();
                }
                break;
                
            //CASO DE ROBAR CARTAS
            case "Roba":
                if(sentidoHorario){
                    siguienteJugador = (m_turno + 1) % m_jugadores.size();
                }else{
                    siguienteJugador = (m_turno - 1 + m_jugadores.size()) % m_jugadores.size();
                }
                for(int i = 0; i<2;i++){
                    m_jugadores.get(siguienteJugador).robaCarta(m_baraja, 0);
                }
                System.out.println("------------------------------------------------------------");
                System.out.println("El Jugador siguiente roba 2 cartas!!");
                System.out.println("------------------------------------------------------------");
                break;
                
            //CASO DE GIRAR SENTIDO
            case "Giro":
                sentidoHorario = !sentidoHorario;
                System.out.println("------------------------------------------------------------");
                System.out.println("CAMBIO DE SENTIDO!!");
                System.out.println("------------------------------------------------------------");
                break;
        }
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
                //ENSEÑAR MANO JUGADOR 
                System.out.println("Esta es la mano del JUGADOR " + (m_turno+1) + " :");
                jugadores.get(m_turno).ensenaMano();

                //COMPRUEBO SI EL JUGADOR PUEDE JUGAR O ROBA
                boolean noRoba = this.comprobarSiRoba(jugadores.get(m_turno));
                //LE PIDO AL JUGADOR QUE INTRODUZCA SU CARTA PARA JUGAR SI NO HA ROBADO
                if (noRoba) {
                    System.out.println("JUGADOR " + (m_turno+1) + " - Introduce el numero de la carta que quieres jugar:");
                    
                    do {
                        //BUCLE HASTA QUE EL NUMERO INTRODUCIDO SEA UNA CARTA VALIDA
                        do {
                            carta_jugada = sc.nextInt();
                            if (carta_jugada > jugadores.get(m_turno).getNumCartas() - 1 || carta_jugada <0) {
                                System.out.println("Carta incorrecta, introduce una carta válida:");
                            }
                        } while (carta_jugada > jugadores.get(m_turno).getNumCartas() - 1 || carta_jugada <0);
                        //JUEGA LA CARTA ELEGIDA O DICE SI LA CARTA JUGADA ES VALIDA
                        noValida = this.juegaCarta(jugadores.get(m_turno), jugadores.get(m_turno).getCartaMano(carta_jugada));
                    //VUELVO A PREGUNTAR MIENTRAS LA CARTA NO SEA VALIDA
                    } while (noValida);

                    //ENSEÑO LA PILA
                    System.out.println("--------------------------Esta es la pila de cartas:");
                    this.ensenaPila();
                    System.out.println("----------------------------------------------------------");
                }
        }
        //QUIEN GANA
        for (int i = 0; i < nJugadores; i++) {
            if (jugadores.get(i).getNumCartas() == 0) {
                System.out.println("El JUGADOR " + (i+1) + " gana!!!");
            }
        }
    }
}
