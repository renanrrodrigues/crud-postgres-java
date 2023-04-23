package br.com.sistema.dao;

import br.com.sistema.model.Cargo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.sistema.factory.ConnectionFactory;
public class CargoDAO {

    public void save(Cargo cargo) {
        String sql = "INSERT INTO cargo (nome, status) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cargo.getNome_cargo());
            pstm.setBoolean(2, cargo.getStatus());

            pstm.execute();

            System.out.println("Cargo salvo com sucesso! \uD83D\uDE80");

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

    public void delete(Cargo cargo){
        String sql = "DELETE FROM cargo WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, cargo.getCargo_id());

            pstm.execute();

            System.out.println("Cargo deletado com sucesso! \uD83D\uDE80");

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
