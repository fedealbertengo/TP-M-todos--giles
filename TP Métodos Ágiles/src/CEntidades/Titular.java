package CEntidades;

import CLogica.GestorLicencia;
import java.sql.Date;
import CLogica.GestorUsuario;
import java.util.ArrayList;

public class Titular {
    
    public Long ID;
    public String Apellido;
    public String Nombre;
    public String TipoDocumento;
    public Long NumeroDocumento;
    public Date FechaNacimiento;
    public String Direccion;
    public String GrupoSanguineo;
    public boolean FactorRH;
    public boolean Donante;
    public Date FechaCreacion;
    public Date FechaBaja;
    public Long IdUsuario;
    public String Nacionalidad;
    public char Sexo;
    
    public Titular(){
        
    }
    
    public Titular(String nom, String ape, String tipodoc, Long nrodoc, Date fechanac, String direc, String gruposang, boolean factrh, boolean dona, Date fechacre, Date fechabaj, Long idusu, String nacional, char sex){
        Apellido = ape;
        Nombre = nom;
        TipoDocumento = tipodoc;
        NumeroDocumento = nrodoc;
        FechaNacimiento = fechanac;
        Direccion = direc;
        GrupoSanguineo = gruposang;
        FactorRH = factrh;
        Donante = dona;
        FechaCreacion = fechacre;
        FechaBaja = fechabaj;
        IdUsuario = idusu;
        Nacionalidad = nacional;
        Sexo = sex;
    }
    
    public Titular(String obj){
        String[] atributos = obj.split("\t");
        ID = Long.parseLong(atributos[0]);
        Apellido = atributos[1];
        Nombre = atributos[2];
        TipoDocumento = atributos[3];
        NumeroDocumento = Long.parseLong(atributos[4]);
        FechaNacimiento = Date.valueOf(atributos[5]);
        Direccion = atributos[6];
        GrupoSanguineo = atributos[7];
        FactorRH = atributos[8].equals("1");
        Donante = atributos[9].equals("1");
        FechaCreacion = Date.valueOf(atributos[10]);
        FechaBaja = (!atributos[11].equals("null")) ? Date.valueOf(atributos[11]) : null;
        IdUsuario = Long.parseLong(atributos[12]);
        Nacionalidad = atributos[13];
        Sexo = atributos[14].charAt(0);
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public Long getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(Long NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getGrupoSanguineo() {
        return GrupoSanguineo;
    }

    public void setGrupoSanguineo(String GrupoSanguineo) {
        this.GrupoSanguineo = GrupoSanguineo;
    }

    public boolean isFactorRH() {
        return FactorRH;
    }

    public void setFactorRH(boolean FactorRH) {
        this.FactorRH = FactorRH;
    }

    public boolean isDonante() {
        return Donante;
    }

    public void setDonante(boolean Donante) {
        this.Donante = Donante;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public Date getFechaBaja() {
        return FechaBaja;
    }

    public void setFechaBaja(Date FechaBaja) {
        this.FechaBaja = FechaBaja;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    public Usuario getUsuario() throws Exception{
        try{
            return GestorUsuario.getUsuario(this.IdUsuario);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public ArrayList<Licencia> getLicencias() throws Exception{
        try{
            return GestorLicencia.getLicenciasTitular(this.IdUsuario);
        }
        catch(Exception ex){
            throw ex;
        }
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public Character getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }
    
    
}
