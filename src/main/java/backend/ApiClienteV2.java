
package backend;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author juanp
 */
public class ApiClienteV2 {
    // Atributos
    private String dni;
    private String respuesta = "9999";
    private String nombre;
    private String paterno;
    private String materno;
    
    // Constructor
    public ApiClienteV2(String dni) {
        this.dni = dni;
        // Llamos al metodo apenas se crea la instancia
        try {
            buscarPorDNI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    // Metodo que establece los valores correspondientes a los atributos
    public void buscarPorDNI() throws IOException {
        try {
            URL url = new URL("http://app20.susalud.gob.pe/wb-casilla/data/consultaws.htm");
            Map<String, Object> payload = new LinkedHashMap<>();
            payload.put("txtDocumento", dni);
            payload.put("codigoDocumento", "01");
            
            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String, Object> payloads : payload.entrySet()){
                if (postData.length() != 0)
                    postData.append('&');
                postData.append(URLEncoder.encode(payloads.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(payloads.getValue()), "UTF-8"));
            }
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(postData.toString());
            writer.flush();
            
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            
            // Se recorre la respuesta de la api y con el metodo append vamos agregando linea la respuesta a la varaiable response
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            
            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject dataJson = jsonObject.getJSONObject("dataJson");
            JSONObject persona = dataJson.getJSONObject("persona");
           
            String resultado = persona.getString("resultado"); // Se busca la key coRespuesta y se obtiene el valor
            if (resultado.equals("OK")){ // Si la respuesta es "", es decir, es correcta, se obtiene los demas valores
                setRespuesta("0000");
                String apePaterno = persona.getString("apPaterno"); 
                setPaterno(apePaterno);
                String apeMaterno = persona.getString("apMaterno");
                setMaterno(apeMaterno);
                String preNombres = persona.getString("preNombres");
                preNombres = preNombres.replace(apePaterno, "");
                preNombres = preNombres.replace(apeMaterno, "");
                setNombre(preNombres);
            }
        } catch (IOException e) {
            throw e;
        } 
    }
}