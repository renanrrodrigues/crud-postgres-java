package org.example;

import java.util.Collections;
import java.util.List;
import br.com.sistema.dao.UserCargoDAO;
import br.com.sistema.model.Cargo;
import br.com.sistema.model.UserCargo;
import br.com.sistema.model.Usuario;

public class ViewCargosUsers {

    public static void main(String[] args) {

        UserCargoDAO dao = new UserCargoDAO();

        List<Object> list = Collections.singletonList(dao.viewCargosUsers());

        for (Object object : list) {

                UserCargo userCargo = (UserCargo) object;

                System.out.println("ID do Usuário: " + userCargo.getUsuario_id());
                System.out.println("ID do Cargo: " + userCargo.getCargo_id());
                System.out.println("    ");
        }


    }


}
