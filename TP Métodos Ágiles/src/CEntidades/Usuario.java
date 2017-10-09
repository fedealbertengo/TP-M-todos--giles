package CEntidades;

public class Usuario {
    
    public long ID;
    public String Apellido;
    public String Nombre;
    public String TipoDocumento;
    public long NumeroDocumento;
    public String NombreUsuario;
    public String Contrasenia;
    public boolean EsAdministrador;
    public boolean EsSuperusuario;
    
    public Usuario(){
        
    }
    
    public Usuario(long ID, String Apellido, String Nombre, String TipoDocumento, long NumeroDocumento, String NombreUsuario, String Contrasenia, boolean EsAdministrador, boolean EsSuperusuario) {
        this.ID = ID;
        this.Apellido = Apellido;
        this.Nombre = Nombre;
        this.TipoDocumento = TipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.NombreUsuario = NombreUsuario;
        this.Contrasenia = Contrasenia;
        this.EsAdministrador = EsAdministrador;
        this.EsSuperusuario = EsSuperusuario;
    }
    
    public Usuario(String obj) {
        String[] atributos = obj.split("\t");
        this.ID = Long.parseLong(atributos[0]);
        this.Apellido = atributos[1];
        this.Nombre = atributos[2];
        this.TipoDocumento = atributos[3];
        this.NumeroDocumento = Long.parseLong(atributos[4]);
        this.NombreUsuario = atributos[5];
        this.Contrasenia = atributos[6];
        this.EsAdministrador = atributos[7].equals("1");
        this.EsSuperusuario = atributos[8].equals("1");
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

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public boolean isEsAdministrador() {
        return EsAdministrador;
    }

    public void setEsAdministrador(boolean EsAdministrador) {
        this.EsAdministrador = EsAdministrador;
    }

    public boolean isEsSuperusuario() {
        return EsSuperusuario;
    }

    public void setEsSuperusuario(boolean EsSuperusuario) {
        this.EsSuperusuario = EsSuperusuario;
    }
}
