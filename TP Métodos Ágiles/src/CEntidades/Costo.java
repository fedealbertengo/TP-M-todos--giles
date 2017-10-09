package CEntidades;

public class Costo {
    public long ID;
    public char Clase;
    public int Vigencia;
    public double Costo;
    
    public Costo(){
        
    }

    public Costo(long ID, char Clase, int Vigencia, double Costo) {
        this.ID = ID;
        this.Clase = Clase;
        this.Vigencia = Vigencia;
        this.Costo = Costo;
    }
    
    public Costo(String obj){
        String[] atributos = obj.split("\t");
        this.ID = Long.parseLong(atributos[0]);
        this.Clase = atributos[1].charAt(0);
        this.Vigencia = Integer.parseInt(atributos[2]);
        this.Costo = Double.parseDouble(atributos[3]);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public char getClase() {
        return Clase;
    }

    public void setClase(char Clase) {
        this.Clase = Clase;
    }

    public int getVigencia() {
        return Vigencia;
    }

    public void setVigencia(int Vigencia) {
        this.Vigencia = Vigencia;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }
}
