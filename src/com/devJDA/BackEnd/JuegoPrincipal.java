package com.devJDA.BackEnd;

import jdk.dynalink.beans.BeansLinker;

import java.util.ArrayList;
import java.util.List;
 public class JuegoPrincipal {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    private List<Character> simbolosDisponibles;
    private boolean turnoActual;// true si es el jugador1 y false si es el jugador2
    private boolean juegoEnCurso;
    private Jugador ganador;


    public JuegoPrincipal(Tablero tablero) {
        this.tablero = tablero;
        this.simbolosDisponibles = simbolosDisponibles;
        this.juegoEnCurso = true;
        this.simbolosDisponibles = new ArrayList<>();
        simbolosDisponibles.add('@');
        simbolosDisponibles.add('#');
        simbolosDisponibles.add('Y');
        simbolosDisponibles.add('*');
        simbolosDisponibles.add('&');
        simbolosDisponibles.add('Z');
    }

    public void definirSimbolos(char c, int codigoJugador) {
        if (!verificarSimboloDisponible(c)) {
            if (codigoJugador == 1) {
                jugador1.setSimbolo(c);
            } else {
                jugador2.setSimbolo(c);
            }
        }
    }

    public void cambiarOrdenDeJugadores() {
            Jugador aux = jugador1;
            jugador1 = jugador2;
            jugador2 = aux;
    }


    public void definirSimbolosPorDefecto() {
        jugador1.setSimbolo('X');
        jugador2.setSimbolo('O');
    }

    public void cambiarTurno() {
        if (turnoActual) {
            turnoActual = false;
        } else {
            turnoActual = true;
        }
    }

    public void reiniciarTablero() {
        juegoEnCurso = false;
    }
    public void valoresPorDefecto(){
        juegoEnCurso = true;
        jugador1 = null;
        jugador2 = null;
        tablero.llenarCeldas();
        simbolosDisponibles.clear();
        simbolosDisponibles.add('@');
        simbolosDisponibles.add('#');
        simbolosDisponibles.add('Y');
        simbolosDisponibles.add('*');
        simbolosDisponibles.add('&');
        simbolosDisponibles.add('Z');

    }
    public void definirInicioAleatorio() {
        int randomBooleano = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (randomBooleano == 1) {
            turnoActual = true;
        } else {
            turnoActual = false;
        }
    }
    public void definirIncioManual(int decision){
        if(decision == 1){
            turnoActual = true;
        }else {
            turnoActual = false;
        }
    }
    public boolean marcarTablero(int celda,char avatar){
        if(celda <=tablero.getCeldas().length) {
            char celda1 = tablero.getCeldas()[celda - 1];
            if (celda1 == ' ') {
                tablero.setCantidadCeldasllenas(tablero.getCantidadCeldasllenas() + 1);
                tablero.getCeldas()[celda - 1] = avatar;
                return true;
            }
            return false;
        }
        return true;
    }
    public boolean validarEmpate(){
        if(tablero.getCantidadCeldasllenas() == 9 && ganador == null) {
            return true;
        }else {
            return false;
        }
    }

    public boolean validarGanador(Jugador jugadorActual){
        //jugador1
        for (int i = 0; i <9 ; i += 3){ // filas
            if(tablero.getCeldas()[i] == jugadorActual.getSimbolo() && tablero.getCeldas()[i + 1] == jugadorActual.getSimbolo() && tablero.getCeldas()[i +2] == jugadorActual.getSimbolo()){
                ganador = jugadorActual;
                return true;
            }
        }
        for (int i = 0; i <3 ; i++) {// columnas
            if(tablero.getCeldas()[i] == jugadorActual.getSimbolo() && tablero.getCeldas()[i +3] == jugadorActual.getSimbolo() && tablero.getCeldas()[i + 6] == jugadorActual.getSimbolo()){
                ganador = jugadorActual;
                return true;
            }
        }
        // diagonales
        if(tablero.getCeldas()[0] == jugadorActual.getSimbolo() && tablero.getCeldas()[4] == jugadorActual.getSimbolo()  && tablero.getCeldas()[8] == jugadorActual.getSimbolo()){
            ganador = jugadorActual;
            return true;
        }
        if (tablero.getCeldas()[2] == jugadorActual.getSimbolo()  && tablero.getCeldas()[4] == jugadorActual.getSimbolo()  && tablero.getCeldas()[6] == jugadorActual.getSimbolo()){
            ganador = jugadorActual;
            return true;
        }
        return false;
    }

    public boolean verificarSimboloDisponible(char c){
        return simbolosDisponibles.contains(c);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public List<Character> getSimbolosDisponibles() {
        return simbolosDisponibles;
    }

    public boolean isTurnoActua() {
        return turnoActual;
    }

    public boolean isJuegoEnCurso() {
        return juegoEnCurso;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setTurnoActua(boolean turnoActual) {
        this.turnoActual = turnoActual;
    }

    public void setJuegoEnCurso(boolean juegoEnCurso) {
        this.juegoEnCurso = juegoEnCurso;
    }

    public Jugador getGanador() {
        return ganador;
    }

}
