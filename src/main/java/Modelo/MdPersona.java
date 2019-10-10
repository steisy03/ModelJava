
package Modelo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import service.WebService;

/**
 *
 * @author steisy crisostomo
 */
public class MdPersona {
    WebService webService;

    public MdPersona() {
        webService = new WebService();
    }

    public String crearPersona(Map map) throws IOException {
        Map responseMap = webService.sendRequest("crear_persona", map);
        return responseMap.get("respuesta").toString();
    }

    public String modificarPersona(Map map) throws IOException {
        Map responseMap = webService.sendRequest("modificar_persona", map);
        return responseMap.get("respuesta").toString();
    }

    public DefaultTableModel buscarPersona() throws IOException {
        Map responseMap = webService.sendRequest("get_persona", new HashMap());
        Object[] fila = new Object[4];
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("#");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Estado");
        List<Map<String, Object>> list = (List<Map<String, Object>>) responseMap.get("f_persona");
        list.stream().forEach(mapsData -> {
            fila[0] = mapsData.get("id");
            fila[1] = mapsData.get("nombre");
            fila[2] = mapsData.get("apellido");
            fila[3] = mapsData.get("estado");
            modelo.addRow(fila);
        });
        return modelo;
    }

    public List<Map<String, Object>> persona() throws IOException {
        Map responseMap = webService.sendRequest("get_persona", new HashMap());
        List<Map<String, Object>> list = (List<Map<String, Object>>) responseMap.get("f_persona");
        return list;
    }

    public String eliminarPersona(Map map) throws IOException {
        Map responseMap = webService.sendRequest("eliminar_persona", map);
        return responseMap.get("respuesta").toString();
    }
}
