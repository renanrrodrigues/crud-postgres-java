package org.example;

import br.com.sistema.dao.UserDAO;
import br.com.sistema.model.Usuario;
import net.datafaker.Faker;

public class InsertUser {
    public static void main(String[] args) {

        Faker faker = new Faker();

        UserDAO dao = new UserDAO();

        Usuario usuario = new Usuario();

        usuario.setNome("Renan");
        usuario.setNickname("renan88");
        usuario.setSenha(faker.internet().password());
        usuario.setNivel(String.valueOf(faker.random().nextInt(1, 3)));

        dao.save(usuario);

       /* for (int i = 0; i < 20; i++) {
            usuario = new Usuario();

            usuario.setNome(faker.name().fullName());
            usuario.setNickname(faker.name().firstName());
            usuario.setSenha(faker.internet().password());
            usuario.setNivel(String.valueOf(faker.random().nextInt(1, 3)));

            dao.save(usuario);

            if (i % 5 == 0) {
                System.out.println("Salvando usuario " + i);
            }
        }*/


    }
}