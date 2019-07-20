/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.p1.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author uth
 */
public class gestorDB {

    /**
     * Retorna una conexion a la base de datos derby local
     *
     * @return objeto conexion
     */
    public static Connection getConexion() {
        try {
            String usuario = "uth";
            String contrasenia = "uth";
            String url = "jdbc:derby://localhost:1527/uth";

            return DriverManager.getConnection(url, usuario, contrasenia);
        } catch (Exception e) {
            System.out.println("Error getConexion: " + e.toString());
        }
        return null;
    }

    public static void guardarHumano(
            int id,
            String nombre,
            String apellido,
            double peso,
            String sexo,
            String departamento,
            String municipio
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de insert
            String sql = "insert into uth.humanos "
                    + "(ID, NOMBRE, APELLIDO, PESO, SEXO, DEPARTAMENTO, MUNICIPIO)  "
                    + "values "
                    + "(?,?,?,?,?,?,?)";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setDouble(4, peso);
            ps.setString(5, sexo);
            ps.setString(6, departamento);
            ps.setString(7, municipio);

            //5. Ejecutar el query
            ps.execute();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardarHumano: " + e.toString());
        }
    }

    public static void actualizarHumano(
            int id,
            String nombre,
            String apellido,
            double peso,
            String sexo,
            String departamento,
            String municipio
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = "UPDATE HUMANOS "
                    + "SET NOMBRE=?, "
                    + "    APELLIDO=?, "
                    + "    PESO=?, "
                    + "    SEXO=?, "
                    + "    DEPARTAMENTO=?, "
                    + "    MUNICIPIO=? "
                    + "WHERE ID=? ";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(7, id);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setDouble(3, peso);
            ps.setString(4, sexo);
            ps.setString(5, departamento);
            ps.setString(6, municipio);

            //5. Ejecutar el query
            ps.executeUpdate();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error actualizarHumano: " + e.toString());
        }
    }

    public static void eliminarHumano(
            int id
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "DELETE FROM HUMANOS " +
                    "WHERE ID=?";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(1, id);

            //5. Ejecutar el query
            ps.executeUpdate();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error eliminarHumano: " + e.toString());
        }
    }
    
    public static void getHumanos() {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "SELECT * " +
                    "FROM HUMANOS";

            //3. Preparar el query
            Statement st = con.createStatement();

            //4. Ejecutar el query
            ResultSet rs=st.executeQuery(sql);

            //5. Leer el resultado
            while(rs.next()){
                System.out.print(rs.getInt("ID"));
                System.out.print(rs.getString("NOMBRE"));
                System.out.print(rs.getString("APELLIDO"));
            }
            
            //6. Cerrar la conexion
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error getHumanos: " + e.toString());
        }
    }
    
    public static void getHumanos(
            int id
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "SELECT * " +
                    "FROM HUMANOS " +
                    "WHERE ID = ? ";

            //3. Preparar el query
            PreparedStatement ps = 
                    con.prepareStatement(sql);
            ps.setInt(1, id);
            
            //4. Ejecutar el query
            ResultSet rs=ps.executeQuery();

            //5. Leer el resultado
            while(rs.next()){
                System.out.print(rs.getInt("ID"));
                System.out.print(rs.getString("NOMBRE"));
                System.out.print(rs.getString("APELLIDO"));
            }
            
            //6. Cerrar la conexion
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error getHumanos: " + e.toString());
        }
    }    
}
