package com.devJDA.BackEnd;

import java.util.ArrayList;
import java.util.List;

public class JuegoPrincipal {
    private Cpu maquina;
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

    public void cambiarOrdenDeJugadores(int caso) {
        if (caso == 1) {
            Jugador aux = jugador1;
            jugador1 = jugador2;
            jugador2 = aux;
        } else if (caso == 2) {
            Jugador aux = jugador1;
            jugador1 = maquina;
            jugador2 = aux;
        }
    }


    public void definirSimbolosPorDefecto() {
        jugador1.setSimbolo('X');
        jugador2.setSimbolo('O');
    }

    public void cambiarTurno() {
        if (turnoActual) {
            turnoActual = !turnoActual;
        } else {
            turnoActual = !turnoActual;
        }
    }

    public void reiniciarTablero() {
        juegoEnCurso = false;
    }
    public void valoresPorDefecto(){
        juegoEnCurso = true;
        jugador1 = null;
        jugador2 = null;
        maquina = null;
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
        int randomBoolean = (int) (Math.random() * (2 - 1 + 1) + 1);
        if (randomBoolean == 1) {
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
        if(tablero.getCantidadCeldasllenas() == 9 && !validarGanador()) {
            return true;
        }else {
            return false;
        }
    }

    public boolean validarGanador(){
        //jugador1
        char jugador1_pos1 = tablero.getCeldas()[0];
        char jugador1_pos2 = tablero.getCeldas()[1];
        char jugador1_pos3 = tablero.getCeldas()[2];
        char jugador1_pos4 = tablero.getCeldas()[3];
        char jugador1_pos5 = tablero.getCeldas()[4];
        char jugador1_pos6 = tablero.getCeldas()[5];
        char jugador1_pos7 = tablero.getCeldas()[6];
        char jugador1_pos8 = tablero.getCeldas()[7];
        char jugador1_pos9 = tablero.getCeldas()[8];
        if(jugador1_pos1 == jugador1.getSimbolo()){
            if(jugador1_pos2 == jugador1.getSimbolo() && jugador1_pos3 == jugador1.getSimbolo()){
                ganador = jugador1;
                return true;
            } else if (jugador1_pos4 == jugador1.getSimbolo() && jugador1_pos7 == jugador1.getSimbolo()) {
                ganador = jugador1;
                return true;
            } else if (jugador1_pos5 == jugador1.getSimbolo() && jugador1_pos9 == jugador1.getSimbolo()) {
                ganador = jugador1;
                return true;
            }
        } else if (jugador1_pos5 == jugador1.getSimbolo()) {
            if(jugador1_pos4 == jugador1.getSimbolo() && jugador1_pos6 == jugador1.getSimbolo()){
                ganador = jugador1;
                return true;
            } else if (jugador1_pos2 == jugador1.getSimbolo() && jugador1_pos8 == jugador1.getSimbolo()) {
                ganador = jugador1;
                return true;
            } else if (jugador1_pos7 == jugador1.getSimbolo() && jugador1_pos3 == jugador1.getSimbolo()) {
                ganador = jugador1;
                return true;
            }
        } else if (jugador1_pos9 == jugador1.getSimbolo()) {
            if(jugador1_pos3 == jugador1.getSimbolo() && jugador1_pos6 == jugador1.getSimbolo()){
                ganador = jugador1;
                return true;
            } else if (jugador1_pos7 == jugador1.getSimbolo() && jugador1_pos8 == jugador1.getSimbolo()) {
                ganador = jugador1;
                return true;
            }

        }
        //jugador2
        char jugador2_pos1 = tablero.getCeldas()[0];
        char jugador2_pos2 = tablero.getCeldas()[1];
        char jugador2_pos3 = tablero.getCeldas()[2];
        char jugador2_pos4 = tablero.getCeldas()[3];
        char jugador2_pos5 = tablero.getCeldas()[4];
        char jugador2_pos6 = tablero.getCeldas()[5];
        char jugador2_pos7 = tablero.getCeldas()[6];
        char jugador2_pos8 = tablero.getCeldas()[7];
        char jugador2_pos9 = tablero.getCeldas()[8];
        if(jugador2_pos1 == jugador2.getSimbolo()){
            if(jugador2_pos2 == jugador2.getSimbolo() && jugador2_pos3 == jugador2.getSimbolo()){
                ganador = jugador2;
                return true;
            } else if (jugador2_pos4 == jugador2.getSimbolo() && jugador2_pos7 == jugador2.getSimbolo()) {
                ganador = jugador2;
                return true;
            } else if (jugador2_pos5 == jugador2.getSimbolo() && jugador2_pos9 == jugador2.getSimbolo()) {
                ganador = jugador2;
                return true;
            }
        } else if (jugador2_pos5 == jugador2.getSimbolo()) {
            if(jugador2_pos4 == jugador2.getSimbolo() && jugador2_pos6 == jugador2.getSimbolo()){
                ganador = jugador2;
                return true;
            } else if (jugador2_pos2 == jugador2.getSimbolo() && jugador2_pos8 == jugador2.getSimbolo()) {
                ganador = jugador2;
                return true;
            } else if (jugador2_pos3 == jugador2.getSimbolo() && jugador2_pos7 == jugador2.getSimbolo()) {
                ganador = jugador2;
                return true;
            }
        } else if (jugador2_pos9 == jugador2.getSimbolo()) {
            if(jugador2_pos3 == jugador2.getSimbolo() && jugador2_pos6 == jugador2.getSimbolo()){
                ganador = jugador2;
                return true;
            } else if (jugador2_pos7 == jugador2.getSimbolo() && jugador2_pos8 == jugador2.getSimbolo()) {
                ganador = jugador2;
                return true;
            }

        }
        return false;
    }

    private boolean verificarSimboloDisponible(char c){
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

    public Cpu getMaquina() {
        return maquina;
    }

    public void setMaquina(Cpu maquina) {
        this.maquina = maquina;
    }
}
