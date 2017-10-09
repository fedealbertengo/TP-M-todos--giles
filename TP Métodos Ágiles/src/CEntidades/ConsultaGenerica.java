package CEntidades;

import java.util.HashMap;
import java.util.Map;

public class ConsultaGenerica {
    Map<String, String> respuestas;
    
    public ConsultaGenerica(String rta){
        String[] rtas = rta.split("\t");
        respuestas = new HashMap<String, String>();
        for(String str: rtas){
            respuestas.put((str.split("-")[0]).trim(), (str.split("-")[1]).trim());
        }
    }
    
    public Map<String, String> getRespuestas(){
        return respuestas;
    }
}
