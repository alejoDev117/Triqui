package com.devJDA.BackEnd;

import java.util.List;

public class Jugador {
    private char simbolo;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }


    public int tomarDecisionDeCelda(Tablero tableroActual){
        return 1;
    }
    public Character cambiarDeSimbolo(List<Character> disponibles){
        return 'a';
    }
    public boolean decidirCambioDeSimbolo(){
        return true;
    }
    public boolean decidirQuienIncia(){
        return true;
    }
    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public String getNombre() {
        return nombre;
    }
}
