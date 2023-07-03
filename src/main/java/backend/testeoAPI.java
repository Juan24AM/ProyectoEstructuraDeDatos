
package backend;

import java.io.IOException;


public class testeoAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String dni = "44444444";
        
        // ApiClient apiClient = new ApiClient(dni);
        ApiClienteV2 apiClient = new ApiClienteV2(dni);
        
        String coRespuesta = apiClient.getRespuesta();
        if (coRespuesta.equals("0000")) {
            String nombre = apiClient.getNombre();
            String paterno = apiClient.getPaterno();
            String materno = apiClient.getMaterno();

            System.out.println("NOMBRE: " + nombre + " " + paterno + " " + materno + "\n");
        } else 
            System.out.println("Por favor verifique el DNI");
        
    }
    
}
