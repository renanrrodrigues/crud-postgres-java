package org.example;

import br.com.sistema.dao.UserCargoDAO;
import br.com.sistema.model.UserCargo;

public class InsertRelacioCargoUser {

    public static void main(String[] args) {

        UserCargoDAO dao = new UserCargoDAO();
        UserCargo userCargo = new UserCargo();


        userCargo.setUsuario_id(23);
        userCargo.setCargo_id(15);

        dao.save(userCargo);

    }
}
