/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;


public class CriarDemanda {
    
    public static void CriarDemanda() throws ClassNotFoundException, SQLException, ParseException{
        String motorista = "02607014085";
        String IDPedido = "6";
        String IDMotorista = null;
        String Placa = null;
        String NOMEMotorista = null;
        String NumPedido = null, DataEntrega = null, Endereco = null ;
        Float PesoTotal = null, CubagemTotal = null;
        double Latitude = 0, Longitude = 0;
               
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao;
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
        Statement st = conexao.createStatement();
        st.executeQuery("Select ID, Nome from motorista where CPF ='"+motorista+"'");
        ResultSet rs = st.getResultSet();
        if(rs.next()){
        IDMotorista = rs.getString(1);
        NOMEMotorista = rs.getString(2);
        }
        Statement sta = conexao.createStatement();
        sta.executeQuery("SELECT distinct Placa FROM gestaofrotas.veiculo INNER JOIN motorista WHERE ID_Motorista = "+IDMotorista+"");
        ResultSet rss = sta.getResultSet();
        if(rss.next()){
        Placa = rss.getString(1);
        }
        Statement stat = conexao.createStatement();
        stat.executeQuery("SELECT numeropedido, DataEntrega, Endereco, PesoTotal, CubagemTotal from PedidoVenda where ID ="+IDPedido+"");
        ResultSet rsss = stat.getResultSet();
        if(rsss.next()){
        NumPedido = rsss.getString(1);
        DataEntrega = rsss.getString(2);
        Endereco = rsss.getString(3);
        PesoTotal = rsss.getFloat(4);
        CubagemTotal = rsss.getFloat(5);
        Latitude=(double) BuscarCoordenadas.Latitude(Endereco);
        Longitude=(double) BuscarCoordenadas.Longitude(Endereco);
        }
        
        try{
            PreparedStatement cadastrar =
            conexao.prepareStatement("INSERT INTO demanda(ID,NomeMotorista,NomeVeiculo,NumeroPedido,DataEntrega,EnderecoDestino,PesoTotal,CubagemTotal,LongitudeEntrega,LatitudeEntrega) VALUES (?,?,?,?,?,?,?,?,?,?)");
            cadastrar.setString(1, null);
            cadastrar.setString(2, NOMEMotorista);
            cadastrar.setString(3, Placa);
            cadastrar.setString(4, NumPedido);
            cadastrar.setString(5, DataEntrega);
            cadastrar.setString(6, Endereco);
            cadastrar.setFloat(7, PesoTotal);
            cadastrar.setFloat(8, CubagemTotal);
            cadastrar.setDouble(9, Longitude);
            cadastrar.setDouble(10, Latitude);
            cadastrar.executeUpdate();            
            JOptionPane.showMessageDialog(null,"Demanda cadastrada com sucesso",
            "Cadastrado",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Problema no cadastro",
            "Cadastrado",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
}
