package br.com.sistema.dao;

import br.com.sistema.factory.ConnectionFactory;
import br.com.sistema.model.Cargo;
import br.com.sistema.model.UserCargo;
import br.com.sistema.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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

    public List<UserCargo> viewCargosUsers() {

        //String sql = "SELECT * FROM usuario_cargo";

        String sql = "SELECT usuario.nome, cargo.nome, usuario_cargo.usuario_id, usuario_cargo.cargo_id FROM usuario_cargo INNER JOIN usuario ON usuario_cargo.usuario_id = usuario.id INNER JOIN cargo ON usuario_cargo.cargo_id = cargo.id";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        List<UserCargo> userCargos = new java.util.ArrayList<UserCargo>();

        try {
            conn = ConnectionFactory.createConnectionToPostgreSQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                UserCargo userCargo = new UserCargo();
                Cargo cargo = new Cargo();
                Usuario usuario = new Usuario();

                usuario.setNome(rset.getString("nome"));
                cargo.setNome_cargo(rset.getString("nome"));
                userCargo.setUsuario_id(rset.getInt("usuario_id"));
                userCargo.setCargo_id(rset.getInt("cargo_id"));

                userCargos.add(userCargo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
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

        return userCargos;

    }
}
