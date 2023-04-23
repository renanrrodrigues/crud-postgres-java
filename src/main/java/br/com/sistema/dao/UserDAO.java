package br.com.sistema.dao;

import br.com.sistema.factory.ConnectionFactory;
import br.com.sistema.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAO {
    public void save(Usuario usuario) {

        String sql = "INSERT INTO usuario (nome, nickname, senha, nivel) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getNickname());
            pstm.setString(3, usuario.getSenha());
            pstm.setString(4, usuario.getNivel());

            pstm.execute();

            System.out.println("Usuário salvo com sucesso! \uD83D\uDE80");

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

    public void delete(Usuario usuario){

        String sql = "DELETE FROM usuario WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, usuario.getId());

            pstm.execute();

            System.out.println("Usuário excluído com sucesso! \uD83D\uDE80");

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
