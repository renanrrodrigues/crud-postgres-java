package org.example;

import java.util.Collections;
import java.util.List;
import br.com.sistema.dao.UserCargoDAO;
import br.com.sistema.model.UserCargo;


public class ViewCargosUsers {

    public static void main(String[] args) {

        UserCargoDAO dao = new UserCargoDAO();

        //List<Object> list = Collections.singletonList(dao.viewCargosUsers());
        List<UserCargo> list = dao.viewCargosUsers();

        System.out.println(" | id usuário | id cargo | nome | cargo |\n");
        for (UserCargo userCargo : list) {
            System.out.println(
                    " | id usuário: "+userCargo.getUsuario_id()+
                    " | id cargo: "+userCargo.getCargo_id()+
                    " | nome: "+userCargo.getNome()+
                    " | cargo: "+userCargo.getCargo()
            );
        }


    }


}
