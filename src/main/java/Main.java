
import connection.conectar;
import controller.Consulta;
import model.Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        String respuesta,aux="";
        Juego game=new Juego();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        game.mensajeIngresoNombre();
        respuesta= reader.readLine();
        game.asignarUsuario(respuesta);


        do{
            game.asignarPregunta();
            game.mostrarPregunta();
            respuesta= reader.readLine();
            while (!game.validarSintaxisRespuesta(respuesta)){
                game.mensajeDeReingresoDato();
                respuesta= reader.readLine();
            }
            aux=game.validarRespuesta(respuesta);
            game.actualizarEstadoJuego(aux);
        }while(!game.getEstadoJuego());
        if (game.isJuegoGanado())
            game.ganador();

        System.out.println("Fin del juego");


    }
}
