package com.devJDA.BackEnd;

import java.util.ArrayList;
import java.util.List;

public class Cpu extends Jugador{



    public Cpu(String nombre) {
        super(nombre);
    }

    public int tomarDecisionDeCelda(Tablero tableroActual) {
        List<Integer> espaciosDisponibles = new ArrayList<>();
        espaciosDisponibles.clear();
        for (int i = 0; i <tableroActual.getCeldas().length ; i++) {
            if(tableroActual.getCeldas()[i] ==' '){
                espaciosDisponibles.add(i);
            }
        }
        if(espaciosDisponibles.size() == 1){
            return espaciosDisponibles.get(0);
        }
        return espaciosDisponibles.get((int)(Math.random() * (espaciosDisponibles.size() - 1) + 1));
    }

    public Character cambiarDeSimbolo(List<Character> disponibles){
        int seleccionarUnAvatar = (int) (Math.random()*(disponibles.size() - 1) +1);
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
