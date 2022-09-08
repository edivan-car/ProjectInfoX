/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.infox.dal;

import java.sql.*;

/**
 *
 * @author Edivan
 */
public class ModuloConexao {
    // Método resposável por estabeler a conexão com o DB
    public static Connection conector(){
        Connection conexao = null;
        
        // chama o driver para conexão
        String driver = "com.mysql.cj.jdbc.Driver";
        
        // Armazenar informações referente ao banco
        String url="jdbc:mysql://localhost:3306/dbinfox";
        String user="root";
        String password = "@EDI#$2486%edi?";
        
        //Estabelecer a conexão
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
    }
}
