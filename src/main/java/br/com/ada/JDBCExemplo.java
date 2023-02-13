package br.com.ada;

import br.com.ada.entities.Gato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCExemplo {

    private static final String DATA_BASE_URL = "jdbc:mysql://127.0.0.1:3308/PET";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    private static final String SELECT_GATOS = "SELECT * FROM GATO";
        private static final String INSERT_GATO = "INSERT INTO GATO (NOME, BIRTH, DONO) VALUES (?, ?, ?)";

    public static void main(String[] args) {

        List<Gato> gatos = new ArrayList<>();

        try {
            Connection conn = DriverManager
                    .getConnection(DATA_BASE_URL, USER_NAME, PASSWORD);

            PreparedStatement preparedStatement =
                    conn.prepareStatement(SELECT_GATOS);

            ResultSet rs = preparedStatement.executeQuery();

            preparedStatement =  conn.prepareStatement(INSERT_GATO);
            preparedStatement.setString(1, "Cookie");
            preparedStatement.setDate(2, java.sql.Date.valueOf("2020-04-23"));
            preparedStatement.setString(3, "Maria");

//            int row = preparedStatement.executeUpdate();

//            System.out.println(row);

            while (rs.next()){
                Gato gato = new Gato();
                gato.setId(rs.getInt("ID"));
                gato.setNome(rs.getString("NOME"));
//                gato.setDono(rs.getString("DONO"));
//                gato.setDataNascimento(rs.getDate("BIRTH"));
                gatos.add(gato);
            }

//            gatos.forEach(var -> System.out.println(var));

            gatos.forEach(System.out::println);

//            var teste = gatos.stream()
//                    .filter(var -> var.getNome().equalsIgnoreCase("brisa"))
//                    .findFirst().get().getId();

//            System.out.println("O ID da Brisa é: " + teste);


        } catch (Exception throwables) {
            System.out.println("Deu bom não!");
            throwables.printStackTrace();
        }

    }

}
