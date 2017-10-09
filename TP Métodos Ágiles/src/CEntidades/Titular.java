package CEntidades;

import java.sql.Date;

public class Titular {
    
    long ID;
    String Apellido;
    String Nombre;
    String TipoDocumento;
    long NumeroDocumento;
    Date FechaNacimiento;
    String Direccion;
    char ClaseLicencia;
    String GrupoSanguineo;
    boolean FactorRH;
    boolean Donante;
    Date FechaCreacion;
    Date FechaBaja;
    long IdUsuario;
    
    public Titular(){
        
    }
    
    public Titular(long id, String ape, String nom, String tipodoc, long nrodoc, Date fechanac, String direc, char claselic, String gruposang, boolean factrh, boolean dona, Date fechacre, Date fechabaj, long idusu){
        ID = id;
        Apellido = ape;
        Nombre = nom;
        TipoDocumento = tipodoc;
        NumeroDocumento = nrodoc;
        FechaNacimiento = fechanac;
        Direccion = direc;
        ClaseLicencia = claselic;
        GrupoSanguineo = gruposang;
        FactorRH = factrh;
        Donante = dona;
        FechaCreacion = fechacre;
        FechaBaja = fechabaj;
        IdUsuario = idusu;
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
        ClaseLicencia = (atributos[7]).charAt(0);
        GrupoSanguineo = atributos[8];
        FactorRH = atributos[9].equals("1");
        Donante = atributos[10].equals("1");
        FechaCreacion = Date.valueOf(atributos[11]);
        if(!atributos[12].equals("null")){
            FechaBaja = Date.valueOf(atributos[12]);
        }
        else{
            FechaBaja = null;
        }
        IdUsuario = Long.parseLong(atributos[13]);
    }
    
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
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

    public long getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(long NumeroDocumento) {
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

    public char getClaseLicencia() {
        return ClaseLicencia;
    }

    public void setClaseLicencia(char ClaseLicencia) {
        this.ClaseLicencia = ClaseLicencia;
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

    public long getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
}
