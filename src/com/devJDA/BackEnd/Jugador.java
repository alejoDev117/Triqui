package com.devJDA.BackEnd;

public class Jugador {
    private char simbolo;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public  int seleccionarCelda(int celda){
        return celda;
    }


    public int decidirQuienComienza(int codigoJugador){
        return codigoJugador;
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
