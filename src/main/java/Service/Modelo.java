package Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import service.WebService;

/**
 *
 * @author steisy crisostomo
 */
public class Modelo {

    WebService webService;

    public Modelo() {
        webService = new WebService();
    }

    /* para crear, modificar o eliminar
    * uri: la ruta del servicio
    * map: el request
    * respuesta: es la respuesta del servicio... 1 para exitoso o un string con la Excepcion
     */
    public String crud(String uri, Map map) throws IOException {
        Map responseMap = webService.sendRequest(uri, map);
        return responseMap.get("respuesta").toString();
    }

    /* para una busqueda con parametros o sin ellos (new HashMap<>())
    * uri: la ruta del servicio
    * map: el request
    * lista: nombre de la lista que trae el metodo como respuesta
     */
    public List<Map<String, Object>> buscar(String uri, String lista, Map map) throws IOException {
        Map responseMap = webService.sendRequest(uri, map);
        List<Map<String, Object>> list = (List<Map<String, Object>>) responseMap.get(lista);
        return list;
    }
    
    /* para una busqueda de un solo parametros en modo validacion
    * uri: la ruta del servicio
    * params: descripcion del objeto que se va a validar
    *respuesta: 1 si existe o 0 si no existe
     */
    public String buscar(String uri, String param) throws IOException {
        Map responseMap = webService.sendRequest(uri, param);
        return responseMap.get("respuesta").toString();
    }
}
