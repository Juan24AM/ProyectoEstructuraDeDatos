package me.ucv.registrohotel.backend;

import java.io.IOException; // Libreria para controlar excepciones
import java.net.HttpURLConnection; // Libreria para controlar realizar peticiones
import java.net.URL; // Libreria para controlar darle formato a la url
import java.util.Scanner;
import org.json.JSONObject; // Libreria para manejar la respuesta de la API (json)

public class ApiClient {
    // Atributos
    private String respuesta;
    private String nombre;
    private String paterno;
    private String materno;
    private String sexo;
    private int nuEdad;

    // Constructor
    public ApiClient() {
        respuesta = "9999";
        nombre = null;
        paterno = null;
        materno = null;
        sexo = null;
        nuEdad = 0;
    }

    // Métodos
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNuEdad() {
        return nuEdad;
    }

    public void setNuEdad(int nuEdad) {
        this.nuEdad = nuEdad;
    }
    
    // Metodo que establece los valores correspondientes a los atributos
    public void buscarPorDNI(String dni) throws IOException {
        String url = "https://hotelconsulta.azurewebsites.net/buscar/" + dni; // Contenamos el numero de DNI con la API

        HttpURLConnection conn = null; // Se inicializa una variables para realizar la conexion en null
        Scanner scanner = null; // Se inicializa variables para leer datos en null

        try {
            /* Se crea el objeto url, 
            y se crea una conexión con el metodo openConnection,
            el cual es asignado a la variable  conn */
            conn = (HttpURLConnection) new URL(url).openConnection();
            // Se indica que la conexión sera de pito GET
            conn.setRequestMethod("GET");
            
            scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();
            
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
          
            JSONObject jsonObject = new JSONObject(response.toString());
            String coRespuesta = jsonObject.getString("coRespuesta");
            setRespuesta(coRespuesta);
            String apePaterno = jsonObject.getString("apePaterno"); 
            setPaterno(apePaterno);
            String apeMaterno = jsonObject.getString("apeMaterno");
            setMaterno(apeMaterno);
            String preNombres = jsonObject.getString("preNombres");
            setNombre(preNombres);
            String Sexo = jsonObject.getString("sexo");
            setSexo(Sexo);
            int edad = jsonObject.getInt("nuEdad");
            setNuEdad(edad);
            
        } catch (IOException e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
