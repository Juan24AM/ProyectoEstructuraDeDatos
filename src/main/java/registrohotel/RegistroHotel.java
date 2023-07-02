/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package registrohotel;

import Interfaces.Acceder;
import backend.SQL;

/**
 *
 * @author yo
 */
public class RegistroHotel {

    public static void main(String[] args) {
        SQL login = new SQL();
        login.setVisible(true);
        login.setLocationRelativeTo(null);  //test
    }
}
