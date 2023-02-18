package com.devJDA.FrontEnd;

import com.devJDA.BackEnd.Cpu;
import com.devJDA.BackEnd.JuegoPrincipal;
import com.devJDA.BackEnd.Jugador;
import com.devJDA.BackEnd.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class capaDePresentacion {
    public static void main(String[] args) throws IOException {
        //Instancia de las clases principales ////////////////////////////////////////////////
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Tablero tableroJuego = new Tablero();
        JuegoPrincipal tricky = new JuegoPrincipal(tableroJuego);
        //ciclo del menu principal ///////////////////////////////////////////////////////
        int opcionMenuPrincipal = 0;
        while (opcionMenuPrincipal < 3) {
            System.out.println("Bienvenido a tricky\n1.Jugador Vs Jugador\n2.Jugador vs Cpu\n3.Salir\n");
            opcionMenuPrincipal = Integer.parseInt(input.readLine());

            switch (opcionMenuPrincipal) {
                //Jugador vs Jugador ////////////////////////////////////////////////////////
                case 1: {
                    Jugador azul = new Jugador("Pj1");
                    Jugador rojo = new Jugador("Pj2");
                    tricky.setJugador1(azul);
                    tricky.setJugador2(rojo);
                    String decisionCambioOrden;
                    String decisionCambioSimbolos;
                    int decisionIncio,decisionComienzo,numeroDeCelda;
                    Character e;
                    char avatar;
                    //cambiar orden /////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    do {
                        System.out.println("Desea cambiar el orden actual?(si--no)\n" + "Jugador1:" + tricky.getJugador1().getNombre() + "\nJugador2:" + tricky.getJugador2().getNombre() + "\n");
                        decisionCambioOrden = input.readLine();
                        if(decisionCambioOrden.toLowerCase().equals("si")){
                            tricky.cambiarOrdenDeJugadores();
                        }
                    } while(decisionCambioOrden.toLowerCase().equals("si"));
                    tricky.definirSimbolosPorDefecto();
                    System.out.println("Estos son lo simbolos predeterminados\njugador1:"+ tricky.getJugador1().getSimbolo()+"\nJugador2:"+tricky.getJugador2().getSimbolo()+"\n");
                    //cambiar lo simbolos por defecto ///////////////////////////////////////////////////////////////////////////////////////
                    System.out.println("Jugador1 desea cambiar su avatar?\n");
                    decisionCambioSimbolos = input.readLine();
                    if(decisionCambioSimbolos.toLowerCase().equals("si")){
                        System.out.println("Jugador1 escoge tu avatar:\n"+ tricky.getSimbolosDisponibles());
                        avatar = input.readLine().toUpperCase().charAt(0);
                        if(tricky.verificarSimboloDisponible(avatar)){
                            tricky.getSimbolosDisponibles().remove(e = avatar);
                            tricky.definirSimbolos(avatar,1);
                        }
                    }
                    System.out.println("Jugador2 desea cambiar su avatar?\n");
                    decisionCambioSimbolos = input.readLine();
                    if(decisionCambioSimbolos.toLowerCase().equals("si")) {
                        System.out.println("Jugador2 escoge tu avatar:\n" + tricky.getSimbolosDisponibles());
                        avatar = input.readLine().toUpperCase().charAt(0);
                        if(tricky.verificarSimboloDisponible(avatar)){
                            tricky.getSimbolosDisponibles().remove(e = avatar);
                            tricky.definirSimbolos(avatar,2);
                        }
                    }
                    System.out.println("Jugador1: "+ tricky.getJugador1().getSimbolo()+"\nJugador2: "+tricky.getJugador2().getSimbolo());
                    System.out.println("Como iniciamos?\n1.Aleatorio\n2.Manual");
                    decisionIncio = Integer.parseInt(input.readLine());
                    //decidir quien tiene el primer turno ///////////////////////////////////////////////////////////////////////
                    switch (decisionIncio) {
                        case 1: {
                            tricky.definirInicioAleatorio();
                            break;
                        }
                        case 2: {
                            System.out.println("Quien comienza?\n1.Jugador1\n2.Jugador2");
                            decisionComienzo = Integer.parseInt(input.readLine());
                            tricky.definirIncioManual(decisionComienzo);
                            break;
                        }
                    }

                    //ejecucion del juego principal///////////////////////////////////////////////////////////////////////
                        while (tricky.isJuegoEnCurso()) {
                            if (tricky.isTurnoActua()) {
                                System.out.println(tricky.getTablero().dibujar());
                                do {
                                    System.out.println("Jugador1 ingrese numero de celda disponible(Codigo de reinicio= 777)\n");
                                    numeroDeCelda = Integer.parseInt(input.readLine());
                                } while (!tricky.marcarTablero(numeroDeCelda, tricky.getJugador1().getSimbolo()));
                                tricky.validarGanador(tricky.getJugador1());

                            } else {
                                System.out.println(tricky.getTablero().dibujar());
                                do {
                                    System.out.println("Jugador2 ingrese numero de celda disponible(Codigo de reinicio = 777)\n");
                                    numeroDeCelda = Integer.parseInt(input.readLine());
                                } while (!tricky.marcarTablero(numeroDeCelda, tricky.getJugador2().getSimbolo()));
                                tricky.validarGanador(tricky.getJugador2());
                            }
                            if (numeroDeCelda == 777) {
                                tricky.reiniciarTablero();
                            } else if (tricky.validarEmpate()) {
                                tricky.setJuegoEnCurso(false);
                            }
                            tricky.cambiarTurno();
                        }

                    if(tricky.getGanador() == null){
                       System.out.println((tricky.getTablero().dibujar()));
                        System.out.println("Empate");
                    }else if(tricky.getGanador() != null) {
                        System.out.println((tricky.getTablero().dibujar()));
                        System.out.println("Fin del juego\nGanador -> " + tricky.getGanador().getSimbolo() + " " + tricky.getGanador().getNombre());
                        tricky.valoresPorDefecto();
                    }
                    tricky.valoresPorDefecto();
                    break;
                }

                case 2: {//Jugador vs Cpu//////////////////////////////////////////////////////////////////////
                    Jugador humano = new Jugador("jugador");
                    Cpu maquinaNueva = new Cpu("Cpu");
                    tricky.setJugador1(humano);
                    tricky.setJugador2(maquinaNueva);
                    String decisionCambioOrden;
                    String decisionCambioSimbolos;
                    int decisionIncio, decisionComienzo, numeroDeCelda;
                    char avatar;
                    Character e;
                    do {
                        System.out.println("Desea cambiar el orden actual?(si--no)\n" + "Jugador1:" + tricky.getJugador1().getNombre() + "\nJugador2:" + tricky.getJugador2().getNombre() + "\n");
                        decisionCambioOrden = input.readLine();
                        if(decisionCambioOrden.toLowerCase().equals("si")){
                            tricky.cambiarOrdenDeJugadores();
                        }
                    } while(decisionCambioOrden.toLowerCase().equals("si"));

                    tricky.definirSimbolosPorDefecto();
                    System.out.println("Estos son lo simbolos predeterminados\njugador1:"+ tricky.getJugador1().getSimbolo()+"\nJugador2:"+tricky.getJugador2().getSimbolo()+"\n");
                    System.out.println("abrir menu de avatars disponibles?\n");
                    decisionCambioSimbolos = input.readLine();
                    //toma de decision de cambiar simbolos, segun el caso//////////////////////////////////////////////////////////////////
                    if(decisionCambioSimbolos.toLowerCase().equals("si") && tricky.getJugador1().getNombre().toLowerCase().equals("jugador")){//si el jugador1 es humano
                        System.out.println("Jugador1 escoge tu avatar:\n"+ tricky.getSimbolosDisponibles());
                        avatar = input.readLine().toUpperCase().charAt(0);
                        if(tricky.verificarSimboloDisponible(avatar)){
                            tricky.getSimbolosDisponibles().remove(e = avatar);
                            tricky.definirSimbolos(avatar,1);
                        }
                    }else if(decisionCambioSimbolos.toLowerCase().equals("si")){    //si el jugador2 es humano
                        System.out.println("Jugador2 escoge tu avatar:\n"+ tricky.getSimbolosDisponibles());
                        avatar = input.readLine().toUpperCase().charAt(0);
                        if(tricky.verificarSimboloDisponible(avatar)){
                            tricky.getSimbolosDisponibles().remove(e = avatar);
                            tricky.definirSimbolos(avatar,2);
                        }
                    } else if (tricky.getJugador1() instanceof Cpu && tricky.getJugador1().tomarDecision()) {//si el jugador1 es maquina
                        e = tricky.getJugador1().cambiarDeSimbolo(tricky.getSimbolosDisponibles());
                        tricky.getSimbolosDisponibles().remove(e);
                        tricky.definirSimbolos(e,1);
                    } else if(tricky.getJugador2().tomarDecision()){// si el jugador2 es maquina
                        e = tricky.getJugador2().cambiarDeSimbolo(tricky.getSimbolosDisponibles());
                        tricky.getSimbolosDisponibles().remove(e);
                        tricky.definirSimbolos(e,2);
                    }
                    System.out.println("Jugador1: "+ tricky.getJugador1().getSimbolo()+"\nJugador2: "+tricky.getJugador2().getSimbolo());
                    System.out.println("Como iniciamos?\n1.Aleatorio\n2.Manual");
                    decisionIncio = Integer.parseInt(input.readLine());

                    switch (decisionIncio) {
                        case 1: {
                            tricky.definirInicioAleatorio();
                            break;
                        }
                        case 2: {
                            System.out.println("Quien comienza?\n1.Jugador1\n2.Jugador2");
                            decisionComienzo = Integer.parseInt(input.readLine());
                            tricky.definirIncioManual(decisionComienzo);
                            break;
                        }
                    }
                    while (tricky.isJuegoEnCurso()) {
                        if (tricky.isTurnoActua()) {
                            if(tricky.getJugador1().getNombre().equals("Cpu")){
                                numeroDeCelda = tricky.getJugador1().tomarDecisionDeCelda(tricky.getTablero());
                                tricky.marcarTablero(numeroDeCelda,tricky.getJugador1().getSimbolo());
                            }else {
                                System.out.println(tricky.getTablero().dibujar());
                                do {
                                    System.out.println("Jugador1 ingrese numero de celda disponible(Codigo de reinicio= 777)\n");
                                    numeroDeCelda = Integer.parseInt(input.readLine());
                                } while (!tricky.marcarTablero(numeroDeCelda, tricky.getJugador1().getSimbolo()));
                            }
                            tricky.validarGanador(tricky.getJugador1());
                        } else {
                            if(tricky.getJugador2().getNombre().equals("Cpu")){
                                numeroDeCelda = tricky.getJugador2().tomarDecisionDeCelda(tricky.getTablero());
                                tricky.marcarTablero(numeroDeCelda,tricky.getJugador2().getSimbolo());
                            }else {
                                System.out.println(tricky.getTablero().dibujar());
                                do {
                                    System.out.println("Jugador2 ingrese numero de celda disponible(Codigo de reinicio= 777)\n");
                                    numeroDeCelda = Integer.parseInt(input.readLine());
                                } while (!tricky.marcarTablero(numeroDeCelda, tricky.getJugador2().getSimbolo()));
                            }
                            tricky.validarGanador(tricky.getJugador2());
                        }

                        if (numeroDeCelda == 777) {
                            tricky.reiniciarTablero();
                        }else if (tricky.validarEmpate()) {
                            tricky.setJuegoEnCurso(false);
                        }
                        tricky.cambiarTurno();
                    }
                    if(tricky.getGanador() == null){
                        System.out.println((tricky.getTablero().dibujar()));
                        System.out.println("Empate");
                    }else if(tricky.getGanador() != null) {
                        System.out.println((tricky.getTablero().dibujar()));
                        System.out.println("Fin del juego\nGanador -> " + tricky.getGanador().getSimbolo() + " " + tricky.getGanador().getNombre());
                        tricky.valoresPorDefecto();
                    }
                    tricky.valoresPorDefecto();
                    break;

                }

            }
        }
    }
}
