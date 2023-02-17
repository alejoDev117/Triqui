package com.devJDA.BackEnd;

import java.util.List;

public class Cpu extends Jugador{
    private char simbolo;


    public Cpu(String nombre) {
        super(nombre);
    }

    public int tomarDecisionDeCelda(Tablero tableroActual){
        return 1;
    }

    public Character cambiarDeSimbolo(List<Character> disponibles){
        int seleccionarUnAvatar = (int) (Math.random()*(disponibles.size()-1) +1);
        simbolo = disponibles.get(seleccionarUnAvatar);
        Character e = simbolo;
        return e;

    }
    public boolean tomarDecision(){
        int randomBoolean = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (randomBoolean == 1) {
           return true;
        } else {
           return false;
        }
    }


}
