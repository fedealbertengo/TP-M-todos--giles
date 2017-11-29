/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLogica;

import CDatos.Conexion;
import CEntidades.ConsultaGenerica;
import CEntidades.Licencia;
import java.awt.Component;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.naming.Context;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fede_
 */
public class GestorUtilidades {
    public static void generarReporte(Component ctx, String nombreArchivo, String urlSalida, Map<String, Object> parametros) throws Exception{
        try{    
            JasperReport reporte = JasperCompileManager.compileReport(ctx.getClass().getResourceAsStream("/Recursos/" + nombreArchivo));
            
            JRDataSource dataSource = new JREmptyDataSource();

            JasperPrint impresion = (JasperPrint) JasperFillManager.fillReport(reporte, parametros, dataSource);

            JasperExportManager.exportReportToPdfFile(impresion, urlSalida);

            JasperViewer.viewReport(impresion, false);
        }catch(Exception ex){
            throw new Exception("No pudo generarse el reporte");
        }
    }
            
    public static void llenarTabla(JTable tabla, ArrayList<Object> list) throws Exception{
        try{
            DefaultTableModel tableModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                 }
             };
            if(list.get(0).getClass() == ConsultaGenerica.class){
                ArrayList<ConsultaGenerica> ls = (ArrayList<ConsultaGenerica>)(Object)list;
                tabla.setModel(tableModel);
                if(ls.size() > 0){
                    for(String campo: ls.get(0).getParametros()){
                        tableModel.addColumn(campo);
                    }
                    for(ConsultaGenerica t: ls){
                        Vector<String> rowData = new Vector<String>();
                        for(int i=0; i< tableModel.getColumnCount(); i++){
                            rowData.add(t.getValor(tableModel.getColumnName(i)));
                        }
                        tableModel.addRow(rowData);
                    }
                }
            }
            else{
                Class cl = list.get(0).getClass();
                tabla.setModel(tableModel);
                if(list.size() > 0){
                    for(Field campo: cl.getDeclaredFields()){
                        tableModel.addColumn(campo.getName());
                    }
                    for(int i=0; i<list.size(); i++){
                        Vector<Object> rowData = new Vector<Object>();
                        for(int j=0; j< tableModel.getColumnCount(); j++){
                            rowData.add((cl.getDeclaredFields()[j]).get(list.get(i)));
                        }
                        tableModel.addRow(rowData);
                    }
                }
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static void llenarTablaLicenciasExpiradas(JTable tabla, List<Licencia> list) throws Exception{
        try{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DefaultTableModel tableModel = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                 }
            };
            tabla.setModel(tableModel);
            if(list.size() > 0){
                tableModel.addColumn("Nro");
                tableModel.addColumn("Nombre");
                tableModel.addColumn("Apellido");
                tableModel.addColumn("Clase");
                tableModel.addColumn("Fecha de Emision");
                tableModel.addColumn("Fecha de Expiracion");
                tableModel.addColumn("Original");
                for(Licencia lic: list){
                    Vector<Object> rowData = new Vector<Object>();
                    rowData.add(lic.getID());
                    rowData.add(lic.getTitular().getNombre());
                    rowData.add(lic.getTitular().getApellido());
                    rowData.add(lic.getClase());
                    rowData.add(dateFormat.format(lic.getFechaEmision()));
                    rowData.add(dateFormat.format(lic.getFechaExpiracion()));
                    rowData.add(!lic.isEsRenovacion());
                    tableModel.addRow(rowData);
                }
            }
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    
    public static Long getAge(Date dateOfBirth) {

    Calendar today = Calendar.getInstance();
    Calendar birthDate = Calendar.getInstance();

    int age = 0;

    birthDate.setTime(dateOfBirth);
    if (birthDate.after(today)) {
        throw new IllegalArgumentException("Can't be born in the future");
    }

    age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year   
    if ( (birthDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR) > 3) ||
            (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH ))){
        age--;

     // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
    }else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH )) &&
              (birthDate.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH ))){
        age--;
    }

    return new Long(age);
}
    
}
