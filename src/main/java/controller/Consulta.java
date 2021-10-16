package controller;


import connection.conectar;

import java.sql.ResultSet;
import java.sql.Statement;

public class Consulta {
    public void usuarios(){
        String sql = "select * from usuarios ";
        conectar cone = new conectar().conectar();

        Statement st;
        try {
            st = cone.getConexion().createStatement();
            ResultSet resultado= st.executeQuery(sql);
            while (resultado.next()){
                System.out.println(resultado.getString("nombre"));
            }

        } catch (Exception ex) {

            System.out.println("fallo");
        }
    }
}
