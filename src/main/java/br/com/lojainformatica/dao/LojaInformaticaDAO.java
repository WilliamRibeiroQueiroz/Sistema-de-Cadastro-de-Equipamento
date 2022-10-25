/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lojainformatica.dao;

import br.com.lojainformatica.model.Computador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class LojaInformaticaDAO {
    
    
    public static String url = "jdbc:mysql://localhost:3306/lojainformatica";
    public static String login = "root";
    public static String senha = "";
    
    //CRUD
    
    public static boolean salvar(Computador obj){
        
        Connection conexao = null;
        boolean retorno = false;
        
        try {
            
            //TODO: Implementar insert na tabela lojainformatica
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrir a conexão
            conexao = DriverManager.getConnection(url,login,senha);
            
            //Criar o comando sql
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO computador (id,marca,hd,processador) VALUES(?,?,?,?)");
            comandoSQL.setInt(1,obj.getId());
            comandoSQL.setString(2,obj.getMarca());
            comandoSQL.setInt(3, obj.getHd());
            comandoSQL.setString(4, obj.getProcessador());
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
                
    }
    
    public static ArrayList<Computador> listar(){
        
        Connection conexao = null;
        ArrayList<Computador> lista = new ArrayList<Computador>();
        
        try {
            //Implementar consulta à tabela computador
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrir a conexão
            conexao = DriverManager.getConnection(url,login,senha);
            
            //Criar o comando SQL
            PreparedStatement comandoSQL =
            conexao.prepareStatement("SELECT * FROM computador");
            
            //Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs!=null){
                while(rs.next()){
                    Computador novoObjeto = new Computador();
                    novoObjeto.setId(rs.getInt("id"));
                    novoObjeto.setHd(rs.getInt("hd"));
                    novoObjeto.setProcessador(rs.getString("processador"));
                    
                    lista.add(novoObjeto);
                    
                }
            }
            
                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return lista;
    }

    public static Computador consultarPorID(int id){
        Computador lista = new Computador();

        //TODO: Implementar consulta à tabela computador pelo id

        return lista;
    }

    public static boolean atualizar(Computador obj){
        
        Connection conexao = null;
        boolean retorno = false;
        
        try {
            
            //TODO: Implementar insert na tabela computador
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrir a conexão
            conexao = DriverManager.getConnection(url,login,senha);
            
            //Criar o comando sql
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE computador SET marca=?, hd=?, processador=? WHERE id = ?");
            comandoSQL.setString(1,obj.getMarca());
            comandoSQL.setInt(2,obj.getHd());
            comandoSQL.setString(3, obj.getProcessador());
            comandoSQL.setInt(4,obj.getId());
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }
    
    public static boolean excluir(int id){
    
        Connection conexao = null;
        boolean retorno = false;
        
        try {
            
            //TODO: Implementar insert na tabela computador
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Abrir a conexão
            conexao = DriverManager.getConnection(url,login,senha);
            
            //Criar o comando sql
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM computador WHERE id=?");
            comandoSQL.setInt(1,id);            
            
            //Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
               retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    
    }
    
}
