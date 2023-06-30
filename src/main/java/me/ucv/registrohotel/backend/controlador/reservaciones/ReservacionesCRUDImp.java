/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ucv.registrohotel.backend.controlador.reservaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import me.ucv.registrohotel.backend.CallDb;
import me.ucv.registrohotel.ventanas.model.Reservaciones;

/**
 *
 * @author Daysuke
 */
public class ReservacionesCRUDImp implements ReservacionesCRUD{
    @Override
    public void guardar(Reservaciones reservaciones){
        try {
            Connection con = new CallDb().getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Reservaciones(Reservaciones_nombre,Reservaciones_descripcion, Reservaciones_precio_compra, Categoria_id, Reservaciones_stock_actual, Reservaciones_unidad_medida, Reservaciones_cantidad_unidades) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, reservaciones.getNombre());
            pstmt.setString(2, reservaciones.getDescripcion());
            pstmt.setFloat(3, reservaciones.getPrecioCompra());
            pstmt.setInt(4, reservaciones.getCategoriaId());
            pstmt.setInt(5, reservaciones.getStockActual());
            pstmt.setString(6, reservaciones.getUnidadMedida());
            pstmt.setInt(7, reservaciones.getCantidadMedida());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void actualizar(Reservaciones reservaciones){
        try {
            Connection con = new CallDb().getConnection();      
        PreparedStatement pstmt = con.prepareStatement("UPDATE Reservaciones SET Reservaciones_nombre=?, Reservaciones_descripcion=?,  Reservaciones_precio_compra=?, Categoria_id=?, Reservaciones_stock_actual=?, Reservaciones_unidad_medida=?, Reservaciones_cantidad_unidades=? WHERE Reservaciones_id = ?");
            pstmt.setString(1,reservaciones.getNombre());       
            pstmt.setString(2, reservaciones.getDescripcion());
            pstmt.setFloat(3, reservaciones.getPrecioCompra());
            pstmt.setInt(4, reservaciones.getCategoriaId());
            pstmt.setInt(5, reservaciones.getStockActual());
            pstmt.setString(6, reservaciones.getUnidadMedida());
            pstmt.setInt(7, reservaciones.getCantidadMedida());
            pstmt.setInt(8, reservaciones.getId());
            pstmt.executeUpdate();
            
            }
        catch (Exception e) {
            System.out.println("ID: "+reservaciones.getId());
            System.out.println("NOMBRE: "+reservaciones.getNombre());
            System.out.println("DESCR: "+reservaciones.getDescripcion());
            System.out.println("PRECIO: "+reservaciones.getPrecioCompra());
            System.out.println("CATEG ID: "+reservaciones.getCategoriaId());
            System.out.println("STOCK: "+reservaciones.getStockActual());
            System.out.println("U.MEDIDA: "+reservaciones.getUnidadMedida());
            System.out.println("CANT MEDIDA: "+reservaciones.getCantidadMedida());
            e.printStackTrace();
        }        
    }
    
    @Override
    public void eliminar(Reservaciones reservaciones){
        try {
            Connection con = new CallDb().getConnection();
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Reservaciones WHERE Reservaciones_id=?");
            pstmt.setInt(1, reservaciones.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public List<String[]> getListaPares(){
        // TODO: sort alphabetically
        List<String[]> pairs = new ArrayList<>();
        try {
            Connection con = new CallDb().getConnection();           
            PreparedStatement ps = con.prepareStatement("select Reservaciones_id, Reservaciones_nombre FROM Reservaciones");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String[] pair = {rs.getString("Reservaciones_id"),rs.getString("Reservaciones_nombre")};
                pairs.add(pair);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pairs;
    }
    
    @Override
    public Reservaciones get(int id) {
        Reservaciones prod = new Reservaciones();
        try {
            Connection con = new CallDb().getConnection();           
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Reservaciones WHERE Reservaciones_id=?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                prod.setId(rs.getInt("Reservaciones_id"));
                prod.setNombre(rs.getString("Reservaciones_nombre"));
                prod.setDescripcion(rs.getString    ("Reservaciones_descripcion"));
                prod.setPrecioCompra(rs.getFloat("Reservaciones_precio_compra"));
                prod.setCategoriaId(rs.getInt("Categoria_id"));
                prod.setStockActual(rs.getInt("Reservaciones_stock_actual"));
                prod.setUnidadMedida(rs.getString("Reservaciones_unidad_medida"));
                prod.setCantidadMedida(rs.getInt("Reservaciones_cantidad_unidades"));
                prod.setIsActive(rs.getBoolean("Reservaciones_activo"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();            
        }
        return prod;
    }

    @Override
    public List<Reservaciones> list() {
        List<Reservaciones> list = new ArrayList<>();
        try {
            Connection con = new CallDb().getConnection();                       
            String sql = "SELECT * FROM Reservacione ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Reservaciones reser = new Reservaciones();

                reser.setId(rs.getInt("Reservaciones_id"));
                reser.setNombre(rs.getString("Reservaciones_nombre"));
                reser.setDescripcion(rs.getString    ("Reservaciones_descripcion"));
                reser.setPrecioCompra(rs.getFloat("Reservaciones_precio_compra"));
                reser.setCategoriaId(rs.getInt("Categoria_id"));
                reser.setStockActual(rs.getInt("Reservaciones_stock_actual"));
                reser.setUnidadMedida(rs.getString("Reservaciones_unidad_medida"));
                reser.setCantidadMedida(rs.getInt("Reservaciones_cantidad_unidades"));
                reser.setIsActive(rs.getBoolean("Reservaciones_activo"));                
 
                list.add(reser);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
