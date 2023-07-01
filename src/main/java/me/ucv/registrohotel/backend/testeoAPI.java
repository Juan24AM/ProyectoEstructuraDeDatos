
package me.ucv.registrohotel.backend;

import java.io.IOException;


public class testeoAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String dni = "73186544";

        ApiClient apiClient = new ApiClient();
        apiClient.buscarPorDNI(dni);
        String nombre = apiClient.getNombre();
        String paterno = apiClient.getPaterno();
        String materno = apiClient.getMaterno();
        int edad = apiClient.getNuEdad();
        
        System.out.println(nombre + " " + paterno + " " + materno + " " + edad);
    }
    
}
