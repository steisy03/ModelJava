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
     */
    public String crud(String uri, Map map) throws IOException {
        Map responseMap = webService.sendRequest(uri, map);
        return responseMap.get("respuesta").toString();
    }

    /* para para una busqueda con parametros
    * uri: la ruta del servicio
    * map: el request
    * lista: nombre de la lista que trae el metodo como respuesta
     */
    public List<Map<String, Object>> buscar(String uri, String lista, Map map) throws IOException {
        Map responseMap = webService.sendRequest(uri, map);
        List<Map<String, Object>> list = (List<Map<String, Object>>) responseMap.get(lista);
        return list;
    }

    /* para una busqueda sin parametros
    * uri: la ruta del servicio
    * lista: nombre de la lista que trae el metodo como respuesta
     */
    public List<Map<String, Object>> buscar(String uri, String lista) throws IOException {
        Map responseMap = webService.sendRequest(uri);
        List<Map<String, Object>> list = (List<Map<String, Object>>) responseMap.get(lista);
        return list;
    }
}
