/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ucv.registrohotel.backend.controlador.reservaciones;

import java.util.List;
import me.ucv.registrohotel.ventanas.model.Reservaciones;

/**
 *
 * @author Daysuke
 */
public interface ReservacionesCRUD {
    public void guardar(Reservaciones reservaciones);
    public void actualizar(Reservaciones reservaciones);
    public void eliminar(Reservaciones reservaciones);
    public Reservaciones get(int id);
    public List<Reservaciones> list();    
}
