package org.example;

import br.com.sistema.dao.CargoDAO;
import br.com.sistema.model.Cargo;
import net.datafaker.Faker;

public class InsertCargo {

    public static void main(String[] args) {

        //Faker faker = new Faker();

        CargoDAO dao = new CargoDAO();

        Cargo cargo = new Cargo();

        cargo.setNome_cargo("Jardinagem");
        cargo.setStatus(false);

        dao.save(cargo);



    }

}
