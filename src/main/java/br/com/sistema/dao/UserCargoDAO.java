package br.com.sistema.dao;

import br.com.sistema.factory.ConnectionFactory;
import br.com.sistema.model.UserCargo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserCargoDAO {

    public void save(UserCargo userCargo) {

        String sql = "INSERT INTO usuario_cargo (usuario_id, cargo_id) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, userCargo.getUsuario_id());
            pstm.setInt(2, userCargo.getCargo_id());

            pstm.execute();

            System.out.println("Usuário cadastrado no cargo com sucesso! \uD83D\uDE80");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
