package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    Connection conexao;
    Conexao() throws SQLException{
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrota","root","zeeh291011");
    }
}
