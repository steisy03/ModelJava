/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modulos.Utilidades;

/**
 *
 * @author steisy crisostomo
 */
public class WebService {

    private javax.ws.rs.client.WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:4567/";

    public WebService() {
      
    }

    
    public Map sendRequest(String uri, Map jsonData) throws IOException {
        
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI+uri);
        Form frm = new Form();
        frm.param("json", Utilidades.jsonConvertMapToJson(jsonData));
        
        Response response = null;

        try {
            response = webTarget.request(MediaType.TEXT_PLAIN).post(Entity.form(frm));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor: \n" + e.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }
        String respuesta = response.readEntity(String.class);
        if (respuesta.equals("")) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor \n", "Informacion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return Utilidades.jsonConvertJsonToMap(respuesta);
    }
    
    public Map sendRequest(String uri) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI+uri);
        String respuesta = null;
        try {
            respuesta = webTarget.request(MediaType.TEXT_PLAIN).get(String.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Conectando al servidor: \n" + e.getMessage(), "Informacion", JOptionPane.ERROR_MESSAGE);
        }

        if (respuesta.equals("")) {
            JOptionPane.showMessageDialog(null, "2 Error Conectando al servidor \n", "Informacion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return Utilidades.jsonConvertJsonToMap(respuesta);
    }
    

    public void close() {
        client.close();
    }
    
}
