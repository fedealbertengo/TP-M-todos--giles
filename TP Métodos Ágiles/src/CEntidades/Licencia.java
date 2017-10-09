package CEntidades;

import CLogica.GestorLicencia;
import CLogica.GestorTitular;
import CLogica.GestorUsuario;
import java.sql.Date;

public class Licencia {
    long ID;
    long IdTitular;
    Date FechaEmision;
    Date FechaExpiracion;
    long IdUsuario;
    Long IdOriginal;
    boolean EsRenovacion;

    public Licencia(){
        
    }
    
    public Licencia(long ID, long IdTitular, Date FechaEmision, Date FechaExpiracion, long IdUsuario, long IdOriginal, boolean EsRenovacion) {
        this.ID = ID;
        this.IdTitular = IdTitular;
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
        this.FechaEmision = Date.valueOf(atributos[2]);
        this.FechaExpiracion = Date.valueOf(atributos[3]);
        this.IdUsuario = Long.parseLong(atributos[4]);
        if(!atributos[5].equals("null")){
            this.IdOriginal = IdOriginal;
        }
        else{
            this.IdOriginal = null;
        }
        this.EsRenovacion = (this.IdOriginal != null);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getIdTitular() {
        return IdTitular;
    }

    public void setIdTitular(long IdTitular) {
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

    public long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(long IdUsuario) {
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
}
