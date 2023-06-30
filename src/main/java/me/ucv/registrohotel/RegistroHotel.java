/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package me.ucv.registrohotel;

import me.ucv.registrohotel.interfaz.Acceder;

/**
 *
 * @author Daysuke
 */
public class RegistroHotel {

    public static void main(String[] args) {
        Acceder login = new Acceder();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
