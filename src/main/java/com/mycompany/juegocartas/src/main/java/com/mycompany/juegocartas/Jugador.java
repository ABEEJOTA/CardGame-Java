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
    
    public Carta getCartaMano(int i){
        return m_mano.get(i);
    }
    
    //SETTERS
    public void setMano(ArrayList<Carta> mano){
        m_mano = mano;
    }
    
    //VALOR RANDOM
    //GENERAR UNA MANO INICIAL
    public void generaMano(Baraja baraja){
        for(int i = 0; i<7 ; i++){
            //SI EL INDICE DEL NUMERO DE CARTA DE LA BARAJA SUBE ESTOY SALTANDOME CARTAS
            //PORQUE AL BORRAR LA CARTA Y ACCEDER AL SIGUIENTE ESTOY ACCEDIENDO AL INDICE+2
            robaCarta(baraja, 0);
        }
    }
    
    //ENSEÑAR LA MANO
    public void ensenaMano (){
        for(int i=0;i<m_mano.size();i++){
            System.out.println(m_mano.get(i).ensenaCarta());
        }
    }
    
    //ENSEÑAR UNA CARTA DE LA MANO
    public void ensenaCartaMano (int i){
        System.out.println(m_mano.get(i).ensenaCarta());
    }
    
    //VALOR RANDOM
    //ROBAR UNA CARTA
    public void robaCarta(Baraja baraja, int i){
        //m_mano.add(baraja.getCartas().get(i));
        m_mano.add(baraja.getCartaBaraja(i));
        baraja.borrarCartaBaraja(i);
    }
}
