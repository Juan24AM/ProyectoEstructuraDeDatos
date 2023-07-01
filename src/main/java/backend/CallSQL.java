/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daysuke
 */
public class CallSQL {
    private Connection connection;
    private String url = "jdbc:mysql://gcp.connect.psdb.cloud/hotel?sslMode=VERIFY_IDENTITY";
    private String username = "10jhxx0k9gfveprtyapz";
    final String driver = "com.mysql.cj.jdbc.Driver";
    private String password = "pscale_pw_FVDB7wiRPNdYxRAeRdkXBkIvOt3yhsZNFKko6uWYScE";

    public CallSQL() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarRegistro(String nombre, String apellidos, String dni, String ingreso, String salida, double pago, String descripcion) {
        String query = "INSERT INTO registros_hotel (nombre, apellidos, dni, ingreso, salida, pago, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, dni);
            statement.setString(4, ingreso);
            statement.setString(5, salida);
            statement.setDouble(6, pago);
            statement.setString(7, descripcion);
            statement.executeUpdate();
            System.out.println("Registro agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarRegistro(int id, String nombre, String apellidos, String dni, String ingreso, String salida, double pago, String descripcion) {
        String query = "UPDATE registros_hotel SET nombre = ?, apellidos = ?, dni = ?, ingreso = ?, salida = ?, pago = ?, descripcion = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, dni);
            statement.setString(4, ingreso);
            statement.setString(5, salida);
            statement.setDouble(6, pago);
            statement.setString(7, descripcion);
            statement.setInt(8, id);
            statement.executeUpdate();
            System.out.println("Registro actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarRegistro(int id) {
        String query = "DELETE FROM registros_hotel WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Registro eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Registro> obtenerRegistros() {
        List<Registro> registros = new ArrayList<>();
        String query = "SELECT * FROM registros_hotel";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String dni = resultSet.getString("dni");
                String ingreso = resultSet.getString("ingreso");
                String salida = resultSet.getString("salida");
                double pago = resultSet.getDouble("pago");
                String descripcion = resultSet.getString("descripcion");

                Registro registro = new Registro(id, nombre, apellidos, dni, ingreso, salida, pago, descripcion);
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public void eliminarRegistroPorDNI(String dni) {
        String sql = "DELETE FROM registros_hotel WHERE dni = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://gcp.connect.psdb.cloud/hotel?sslMode=VERIFY_IDENTITY", "10jhxx0k9gfveprtyapz", "pscale_pw_FVDB7wiRPNdYxRAeRdkXBkIvOt3yhsZNFKko6uWYScE");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            stmt.executeUpdate();

            System.out.println("Registro eliminado exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
        }
    }


    public class Registro {
        private int id;
        private String nombre;
        private String apellidos;
        private String dni;
        private String ingreso;
        private String salida;
        private double pago;
        private String descripcion;

        public Registro(int id, String nombre, String apellidos, String dni, String ingreso, String salida, double pago, String descripcion) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.dni = dni;
            this.ingreso = ingreso;
            this.salida = salida;
            this.pago = pago;
            this.descripcion = descripcion;
        }

        // Getters y setters

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getIngreso() {
            return ingreso;
        }

        public void setIngreso(String ingreso) {
            this.ingreso = ingreso;
        }

        public String getSalida() {
            return salida;
        }

        public void setSalida(String salida) {
            this.salida = salida;
        }

        public double getPago() {
            return pago;
        }

        public void setPago(double pago) {
            this.pago = pago;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
    
}
