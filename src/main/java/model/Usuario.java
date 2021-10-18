package model;

public class Usuario {
    private String nombre;
    private int puntaje;
    private int preguntas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.preguntas = 0;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(int preguntas) {
        this.preguntas = preguntas;
    }
}
