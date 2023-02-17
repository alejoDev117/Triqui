package com.devJDA.BackEnd;

public class Tablero {
    private char[] celdas;
    private int cantidadCeldasllenas;

    public Tablero() {
        this.celdas = new char[9];
        llenarCeldas();
    }

    public String dibujar(){
        String pantalla = "";
        //pantalla += " ";
        for (int i = 0; i < celdas.length ; i+=3) {
            pantalla += celdas[i] + "|" + celdas[i + 1] + "|" + celdas[i + 2]+"\n";
            pantalla += "-----\n";

        }
        return pantalla;
    }

    protected void llenarCeldas(){
        cantidadCeldasllenas = 0;
        for(int i=0;i<celdas.length;i++){
            celdas[i]= ' ';
        }
    }

    public char[] getCeldas() {
        return celdas;
    }

    public void setCeldas(char[] celdas) {
        this.celdas = celdas;
    }

    public int getCantidadCeldasllenas() {
        return cantidadCeldasllenas;
    }

    public void setCantidadCeldasllenas(int cantidadCeldasllenas) {

        this.cantidadCeldasllenas = cantidadCeldasllenas;
    }
}
