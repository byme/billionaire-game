package model;

import java.util.List;

public class Juego {
    private int nivel;
    private Usuario jugador;
    private Pregunta pregunta;
    private boolean estadoJuego;
    private List<Integer> premios;

    public Juego(){

    }
    public Juego( Usuario jugador,List<Integer> premios) {
        this.nivel = 1;
        this.jugador = jugador;
        this.estadoJuego = false;
        this.premios = premios;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isEstadoJuego() {
        return estadoJuego;
    }

    public void setEstadoJuego(boolean estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public List<Integer> getPremios() {
        return premios;
    }

    public void setPremios(List<Integer> premios) {
        this.premios = premios;
    }
}
