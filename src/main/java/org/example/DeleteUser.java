package org.example;

import br.com.sistema.dao.UserDAO;
import br.com.sistema.model.Usuario;

public class DeleteUser {
    public static void main(String[] args) {

        UserDAO dao = new UserDAO();
        Usuario user = new Usuario();

        user.setId(5);

        dao.delete(user);
    }
}
