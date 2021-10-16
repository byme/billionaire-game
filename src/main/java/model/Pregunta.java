package model;

import java.util.List;

public class Pregunta {
    private int categoria;
    private List<String> opciones;
    private String opcionCorrecta;
    private boolean estado;

    public Pregunta(int categoria, List<String> opciones, String opcionCorrecta, boolean estado) {
        this.categoria = categoria;
        this.opciones = opciones;
        this.opcionCorrecta = opcionCorrecta;
        this.estado = estado;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
