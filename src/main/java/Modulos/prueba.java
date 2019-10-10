package Modulos;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author steisy crisostomo
 */
public class prueba {

    private int id;
    private boolean estado;
    private Date fecha;
    private String nombre;
    private String pass;
    private String email;
    private String telefono;
    private String username;

    public prueba() {
        
    }
    
    //aqui irian los getter y setter, en todo caso
    
    public Map<String, Object> generarMapa() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", this.id);
        map.put("estado", this.estado);
        map.put("fecha", this.fecha);
        map.put("nombre", this.nombre);
        map.put("pass", this.pass);
        map.put("email", this.email);
        map.put("telefono", this.telefono);
        map.put("username", this.username);
        return map;
    }

}
