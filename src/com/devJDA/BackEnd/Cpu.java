package com.devJDA.BackEnd;

import java.util.List;

public class Cpu extends Jugador{
    private char simbolo;


    public Cpu(String nombre, char simbolo) {
        super(nombre);
        this.simbolo = simbolo;
    }

    public int tomarDecisionDeCelda(Tablero tableroActual){
        return 1;
    }
    public void cambiarDeSimbolo(List<Character> disponibles){
        int seleccionarUnAvatar = (int) (Math.random()*(disponibles.size()-1) +1);
        simbolo = disponibles.remove(seleccionarUnAvatar);

    }
    public boolean decidirCambioDeSimbolo(){
        int randomBoolean = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (randomBoolean == 1) {
           return true;
        } else {
           return false;
        }
    }
    public boolean decidirQuienIncia(){
        return true;
    }

}
