package model;

import java.util.List;

public class Pregunta {
    private int categoria;
    private List<String> opciones;
    private String opcionCorrecta;
    private String pregunta;
    private boolean estado;

    public Pregunta(int categoria, List<String> opciones, String opcionCorrecta,String pregunta) {
        this.categoria = categoria;
        this.opciones = opciones;
        this.opcionCorrecta = opcionCorrecta;
        this.estado = false;
        this.pregunta=pregunta;
    }




    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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
