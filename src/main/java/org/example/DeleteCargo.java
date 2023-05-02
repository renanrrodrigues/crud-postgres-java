package org.example;

import br.com.sistema.dao.CargoDAO;
import br.com.sistema.model.Cargo;

public class DeleteCargo {
    public static void main(String[] args) {

        CargoDAO dao = new CargoDAO();
        Cargo cargo = new Cargo();

        cargo.setCargo_id(11);

        dao.delete(cargo);

    }
}
