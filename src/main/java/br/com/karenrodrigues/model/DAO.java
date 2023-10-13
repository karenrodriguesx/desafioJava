package br.com.karenrodrigues.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    /*Conexão com o banco*/
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/desafiojava";
    private String user = "postgres";
    private String password = "root";

    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println (e);
            return null;
        }
    }

    //Inserindo dados no banco
    public void insert (JavaBeans usuario) {
        String create = "insert into dbusuarios (nome,profissao, idade) values (?,?,?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getProfissao());
            pst.setInt(3, usuario.getIdade());

            pst.executeUpdate();

            //encerrando a conexão com o banco

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete (JavaBeans usuario) {
        String delete = "delete from dbusuarios where id=?";

        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, Integer.parseInt(usuario.getId()));
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Lendo os dados do banco

    public ArrayList<JavaBeans> listaUsuarios () {
        ArrayList<JavaBeans> usuarios = new ArrayList<>();
        String read = "select * from dbusuarios order by nome";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                // variaveis para receber os dados
                String id = rs.getString(1);
                String nome = rs.getString(2);
                String profissao = rs.getString(3);
                int idade = rs.getInt(4);

                //Alimentando o vetor
                usuarios.add(new JavaBeans(id,nome,profissao,idade));
            }
            con.close();
            return usuarios;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
