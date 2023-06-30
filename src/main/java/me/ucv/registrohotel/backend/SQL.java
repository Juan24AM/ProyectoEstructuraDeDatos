/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ucv.registrohotel.backend;

import java.util.Random;
import me.ucv.registrohotel.backend.controlador.reservaciones.ReservacionesCRUDImp;
import me.ucv.registrohotel.ventanas.model.Reservaciones;

/**
 *
 * @author Daysuke
 */
public class SQL {
    public static void main(String[] args) {
        ReservacionesCRUDImp dao = new ReservacionesCRUDImp();        
        
        Reservaciones res = new Reservaciones();
        Random rand = new Random();
        int rand_int = rand.nextInt(9000);
        String randomNombre = "Prueba"+rand_int;
        res.setNombre(randomNombre);        
        res.setDescripcion("Probando reservacion");
        res.setPrecioCompra(99);
        res.setCategoriaId(100);
        res.setStockActual(66);
        res.setUnidadMedida("unidades");
        res.setCantidadMedida(4);
        
        // dao significa Data Access Object
//        dao.save(prod);
        
        // UPDATE
        Reservaciones res2 = new Reservaciones();
        res2.setId(1006);
        res2.setNombre("PruebaCustomName");        
        res2.setDescripcion("Probando reservacion");
        res2.setPrecioCompra(99);
        res2.setCategoriaId(100);
        res2.setStockActual(66);
        res2.setUnidadMedida("unidades");
        res2.setCantidadMedida(4);         
        
//        dao.update(prod2);

        // DELETE
        Reservaciones res3 = new Reservaciones();
        res3.setId(1010);
//        dao.delete(prod3);

        // GET SINGLE PRODUCT
        Reservaciones res4 = dao.get(1002);
        System.out.println(res4.getId()+"\t"+res4.getNombre()+"\t"+res4.getPrecioCompra()+"\t"+res4.getStockActual());
        
    }
}
