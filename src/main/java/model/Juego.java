package model;

import controller.Consulta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Juego extends Consulta {
    private int nivel;
    private Usuario jugador;
    private Pregunta pregunta;
    private boolean estadoJuego;
    private List<Integer> premios;
    private boolean juegoGanado=false;


    public Juego( ) {
        this.nivel = 1;
        this.jugador = jugador;
        this.estadoJuego = false;
        this.premios = Arrays.asList(1000,2000,3000,4000,10000);
    }



    public void actualizarEstadoJuego(String respuestaValidadaUsuario){
        if ( respuestaValidadaUsuario.contains("retirado")){
            System.out.println("Su puntaje fue:"+this.jugador.getPuntaje());
            insertarResultadoJugador(this.jugador.getNombre(),this.jugador.getPuntaje(),
                    this.jugador.getPreguntas());
            this.estadoJuego=true;

        }else if(respuestaValidadaUsuario.contains("continua")){
            if (this.nivel!=5){
            this.actualizarDatoJugador();
            this.aumentarNivel();
            }else{
                this.actualizarDatoJugador();
                this.juegoGanado=true;
                this.estadoJuego=true;
            }
        }else{
            //obción en la que pierde y no se lleva nada
            System.out.println("No se lleva premio");
            this.estadoJuego=true;
            insertarResultadoJugador(this.jugador.getNombre(),0,
            this.jugador.getPreguntas());
        }
    }

    public void ganador(){
        System.out.println("Felicidades ha ganadoooo");
        System.out.println("Su puntaje fue:"+this.jugador.getPuntaje());
        this.estadoJuego=true;
        insertarResultadoJugador(this.jugador.getNombre(),this.jugador.getPuntaje(),
                this.jugador.getPreguntas());
    }


    public String validarRespuesta(String respuesta){
        if (respuesta.toLowerCase().contains("e")){
           return "retirado";
        }else if(respuesta.toLowerCase().contains(this.pregunta.getOpcionCorrecta())){
            return "continua";
        }else {
            return "fail";
        }
    }

    public boolean validarSintaxisRespuesta(String respuesta){
            if (respuesta.toLowerCase().matches("a|b|c|d|e")){
                return true;
            }else{
                return false;
            }
    }


    public void actualizarDatoJugador(){
        this.jugador.setPreguntas(this.nivel);
        this.jugador.setPuntaje(jugador.getPuntaje()+this.premios.get(this.nivel-1));
    }

    //mensajes
    public void mensajeDeReingresoDato(){
        System.out.print("Ingreso una obción que no exite, ingrese de nuevo la obción:");
    }

    public void mensajeIngresoNombre(){
        System.out.println("Por favor escriba su nombre:");
        System.out.print(">");
    }

    public void mensajeAdios(){System.out.println("Ha terminado el juego");}

    public void mostrarPregunta(){
        System.out.println(this.pregunta.getPregunta());
        System.out.println("a)"+this.pregunta.getOpciones().get(0));
        System.out.println("b)"+this.pregunta.getOpciones().get(1));
        System.out.println("c)"+this.pregunta.getOpciones().get(2));
        System.out.println("d)"+this.pregunta.getOpciones().get(3));
        System.out.println("e)"+"Con esta opción se retira y se lleva lo que acomule");
        System.out.print("Indique su respuesta a,b,c,d o e: ");

    }

    public void asignarPregunta(){this.pregunta=obtenerPregunta(this.nivel);}

    public void asignarUsuario(String nombre){this.jugador=new Usuario(nombre);}

    public void aumentarNivel() {this.nivel++;}

    public int getNivel() {return nivel;}

    public void setNivel(int nivel) {this.nivel = nivel;}

    public Usuario getJugador() {return jugador;}

    public void setJugador(Usuario jugador) {this.jugador = jugador;}

    public Pregunta getPregunta() {return pregunta;}

    public void setPregunta(Pregunta pregunta) {this.pregunta = pregunta;}

    public boolean getEstadoJuego() {return this.estadoJuego;}

    public void setEstadoJuego(boolean estadoJuego) {this.estadoJuego = estadoJuego;}

    public List<Integer> getPremios() {return premios;}

    public void setPremios(List<Integer> premios) {this.premios = premios;}

    public boolean isJuegoGanado() {return juegoGanado;}

    public void setJuegoGanado(boolean juegoGanado) {this.juegoGanado = juegoGanado;}
}
