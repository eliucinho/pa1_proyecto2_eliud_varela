/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.p1.datos;

import hn.uth.pa1.p1.objetos.Humano;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author uth
 */
public class svHumanos {
    private static List<Humano> datos=new ArrayList<>();
    private static Humano humanoSeleccionado=null;
    
    public static void setHumanoSeleccionado(Humano humano){
        humanoSeleccionado=humano;
    }
    
    public static Humano getHumanoSeleccionado(){
        return humanoSeleccionado;
    }
    
    public static void llenarTabla(){
        datos.add(new Humano(1,"Eliud", "Varela", 150, "M", "FM", "DC"));
        datos.add(new Humano(2,"Juian", "Varela", 150, "M", "FM", "DC"));
        datos.add(new Humano(3,"JUlian", "Varela", 150, "M", "FM", "DC"));
        datos.add(new Humano(4,"Carlos", "Varela", 150, "M", "FM", "DC"));
        datos.add(new Humano(5,"Manuel", "Varela", 150, "M", "FM", "DC"));
    }
    
    public static DefaultTableModel getModelHumano(){
        String[] columnas=new String[]{ "id", "nombre", "apellido", "peso", "sexo", "departamento", "municipio"};
        String[][] filas=new String[datos.size()][7];
        for (int i = 0; i < datos.size(); i++) {
            Humano tmp = datos.get(i);
            filas[i][0]=String.valueOf(tmp.getId());
            filas[i][1]=tmp.getNombre();
            filas[i][2]=tmp.getApellido();
            filas[i][3]=String.valueOf(tmp.getPeso());
            filas[i][4]=tmp.getSexo();
            filas[i][5]=tmp.getDepartamento();
            filas[i][6]=tmp.getMunicipio();
        }
        
        return new DefaultTableModel(filas,columnas);   
    }
    
    public static void guardar(Humano humano){
        //datos.add(humano);
        gestorDB.guardarHumano
        (humano.getId(), humano.getNombre()
                , humano.getApellido(), humano.getPeso()
                , humano.getSexo()
                , humano.getDepartamento()
                , humano.getMunicipio());
    }
    
    public static Humano buscar(int id){
        for (Humano dato : datos) {
            if (dato.getId()==id) {
                return dato;
            }
        }
        return null;
    }
    
    public static void eliminar(int id){
        eliminar(buscar(id));
    }
    
    public static void eliminar(Humano humano){
        datos.remove(humano);
    }
}
