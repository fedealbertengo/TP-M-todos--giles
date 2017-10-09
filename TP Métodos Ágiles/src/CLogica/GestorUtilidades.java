/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLogica;

import CEntidades.ConsultaGenerica;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fede_
 */
public class GestorUtilidades {
    
    public static void llenarTabla(JTable tabla, ArrayList<Object> list) throws Exception{
        try{
            if(list.get(0).getClass() == ConsultaGenerica.class){
                ArrayList<ConsultaGenerica> ls = (ArrayList<ConsultaGenerica>)(Object)list;
                DefaultTableModel tableModel = new DefaultTableModel();
                for(String campo: ls.get(0).getParametros()){
                    tableModel.addColumn(campo);
                }
                tabla.setModel(tableModel);
                for(ConsultaGenerica t: ls){
                    Vector<String> rowData = new Vector<String>();
                    for(int i=0; i< tableModel.getColumnCount(); i++){
                        rowData.add(t.getValor(tableModel.getColumnName(i)));
                    }
                    tableModel.addRow(rowData);
                }
            }
            else{
                Class cl = list.get(0).getClass();
                DefaultTableModel tableModel = new DefaultTableModel();
                for(Field campo: cl.getDeclaredFields()){
                    tableModel.addColumn(campo.getName());
                }
                tabla.setModel(tableModel);
                for(int i=0; i<list.size(); i++){
                    Vector<Object> rowData = new Vector<Object>();
                    for(int j=0; j< tableModel.getColumnCount(); j++){
                        rowData.add((cl.getDeclaredFields()[j]).get(list.get(i)));
                    }
                    tableModel.addRow(rowData);
                }
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
