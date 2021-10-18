package controller;


import connection.conectar;
import model.Pregunta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    public void resultados(){
        String sql = "select * from historico ";
        conectar cone = new conectar().conectar();

        Statement st;
        try {
            st = cone.getConexion().createStatement();
            ResultSet resultado= st.executeQuery(sql);
            while (resultado.next()){
                System.out.println(resultado.getString("nombre").trim()+" puntuación "+
                        resultado.getString("puntuacion")+" preguntas "+
                        resultado.getString("preguntas"));

            }

        } catch (Exception ex) {

            System.out.println("Fallo la base de datos");
        }finally {
            cone.desconectar();
        }
    }

    public Pregunta obtenerPregunta(int categoria){
        List<String> opciones=new ArrayList<>();

        String sql = "SELECT  categoria, pregunta, \"opcionA\", \"opcionB\", \"opcionC\", \"opcionD\", correcta\n" +
                "\tFROM public.preguntas\n" +
                "\twhere categoria = ?\n" +
                "\tORDER BY RANDOM()\n" +
                "LIMIT 1 ";
        conectar cone = new conectar().conectar();

        PreparedStatement st;
        try {
            st = cone.getConexion().prepareStatement(sql);
            st.setInt(1,categoria);
            ResultSet resultado= st.executeQuery();
            while (resultado.next()){
                opciones.add(resultado.getString("opcionA").trim());
                opciones.add(resultado.getString("opcionB").trim());
                opciones.add(resultado.getString("opcionC").trim());
                opciones.add(resultado.getString("opcionD").trim());

                return new Pregunta(resultado.getInt("categoria"),opciones,
                        resultado.getString("correcta").trim(),resultado.getString("pregunta").trim());
            }

        } catch (Exception ex) {

            System.out.println("Fallo en la base de datos");
            return null;
        }
        finally {
            cone.desconectar();
        }
        return null;
    }

    public void insertarResultadoJugador(String nombre,int puntaje,int preguntas){
        String sql = "INSERT INTO public.historico(\n" +
                "\t nombre, puntuacion, preguntas)\n" +
                "\tVALUES (?, ?, ?);";
        conectar cone = new conectar().conectar();

        PreparedStatement st;
        try {
            st = cone.getConexion().prepareStatement(sql);
            st.setString(1,nombre);
            st.setInt(2,puntaje);
            st.setInt(3,preguntas);
            st.execute();
            System.out.println("Se guardo el resultado.");

        } catch (Exception ex) {

            System.out.println("Fallo en la base de datos");
        }finally {
            cone.desconectar();
        }

    }


}
