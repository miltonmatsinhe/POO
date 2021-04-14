package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import java.sql.*;
import javax.swing.JOptionPane;
public class Conexao {
    private Connection connection;
    
    public Conexao(){
        try{
          Class.forName("com.mysql.jdbc.Driver");
          connection = DriverManager.getConnection("jdbc:mysql://localhost/GESTAOSINDICATO", "root", "#Saposmor1985#$");
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "DRIVER NÃO CARREGADO: CONTACTA ADMINISTRADOR DO SISTEMA\n"+ex.getMessage());
            ex.printStackTrace();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,  "ERROS DE CONEÇÃO COM MYSQL:  CONTACTA ADMINISTRADOR DO SISTEMA amerilanga@gmail.com\n"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
        
}
