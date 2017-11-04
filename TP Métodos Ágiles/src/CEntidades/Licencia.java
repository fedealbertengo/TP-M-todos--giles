package CEntidades;

import CLogica.GestorLicencia;
import CLogica.GestorTitular;
import CLogica.GestorUsuario;
import java.sql.Date;
import java.util.ArrayList;

public class Licencia {
    public Long ID;
    public Long IdTitular;
    public char Clase;
    public Date FechaEmision;
    public Date FechaExpiracion;
    public Long IdUsuario;
    public Long IdOriginal;
    public boolean EsRenovacion;

    public Licencia(){
        
    }
    
    public Licencia(Long ID, Long IdTitular, char cla, Date FechaEmision, Date FechaExpiracion, Long IdUsuario, Long IdOriginal, boolean EsRenovacion) {
        this.ID = ID;
        this.IdTitular = IdTitular;
        this.Clase = cla;
        this.FechaEmision = FechaEmision;
        this.FechaExpiracion = FechaExpiracion;
        this.IdUsuario = IdUsuario;
        this.IdOriginal = IdOriginal;
        this.EsRenovacion = EsRenovacion;
    }
    
    public Licencia(String obj){
        String[] atributos = obj.split("\t");
        this.ID = Long.parseLong(atributos[0]);
        this.IdTitular = Long.parseLong(atributos[1]);
        this.Clase = atributos[2].charAt(0);
        this.FechaEmision = Date.valueOf(atributos[3]);
        this.FechaExpiracion = Date.valueOf(atributos[4]);
        this.IdUsuario = Long.parseLong(atributos[5]);
        this.IdOriginal = (!atributos[6].equals("null")) ? IdOriginal : null;
        this.EsRenovacion = (this.IdOriginal != null);
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getIdTitular() {
        return IdTitular;
    }

    public void setIdTitular(Long IdTitular) {
        this.IdTitular = IdTitular;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public Date getFechaExpiracion() {
        return FechaExpiracion;
    }

    public void setFechaExpiracion(Date FechaExpiracion) {
        this.FechaExpiracion = FechaExpiracion;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public Long getIdOriginal() {
        return IdOriginal;
    }

    public void setIdOriginal(Long IdOriginal) {
        this.IdOriginal = IdOriginal;
    }

    public boolean isEsRenovacion() {
        return EsRenovacion;
    }

    public void setEsRenovacion(boolean EsRenovacion) {
        this.EsRenovacion = EsRenovacion;
    }
    
    public Usuario getUsuario() throws Exception{
        try{
            return GestorUsuario.getUsuario(this.IdUsuario);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public Titular getTitular() throws Exception{
        try{
            return GestorTitular.getTitular(this.IdTitular);
        }
        catch(Exception ex){
            throw ex;
        }
    }
        
    public Licencia getLicenciaOriginal() throws Exception{
        try{
            return GestorLicencia.getLicencia(this.IdOriginal);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public ArrayList<Licencia> getRenovaciones() throws Exception{
        try{
            return GestorLicencia.getRenovaciones(this.ID);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public Character getClase() {
        return Clase;
    }

    public void setClase(char Clase) {
        this.Clase = Clase;
    }
    
    
}
