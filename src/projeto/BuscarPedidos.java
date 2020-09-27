/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author user
 */
public class BuscarPedidos {
    
    public static void BuscarPedidos() throws IOException, ClassNotFoundException, SQLException, ParseException {
        char sucesso = 'A';
        Scanner scan = new Scanner(new FileReader("D:\\Integrador\\Recebido\\pedido.txt"));
        String[][] linhas = new String[100][3];
        String Npedido, DataEntrega, Endereco, Descricao;
        float Peso = 0, Cubagem = 0, PesoTotal = 0, CubagemTotal = 0;
        int i = 0;
        while(scan.hasNextLine()){            
                linhas[i] = scan.nextLine().split("\t");
                i++;  
                }        
        scan.close();
        Npedido = linhas[0][0];
        DataEntrega = linhas[0][1];
        Endereco = linhas[0][2];
            if (ValidaData.isValidDateEntrega(DataEntrega) == true){                    
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conexao;
                    conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestaofrotas?useTimezone=true&serverTimezone=UTC","javaapp","projeto");
                    for (int row = 1; linhas[row][0] != null; row++) {
                        Descricao = linhas[row][0];                        
                        Peso = Float.parseFloat(linhas[row][1]);
                        PesoTotal = PesoTotal+Peso;                        
                        Cubagem = Float.parseFloat(linhas[row][2]);
                        CubagemTotal= CubagemTotal+Cubagem;                         
                        try{
                            PreparedStatement cadastrarItem =
                            conexao.prepareStatement("INSERT INTO itempedido(ID,ID_Pedido,Descricao,Peso,Cubagem) VALUES (?,?,?,?,?)");
                            cadastrarItem.setString(1, null);
                            cadastrarItem.setString(2, Npedido);
                            cadastrarItem.setString(3, Descricao);                            
                            cadastrarItem.setFloat(4, Peso);
                            cadastrarItem.setFloat(5, Cubagem);
                            cadastrarItem.executeUpdate();
                            sucesso = 'S';
                            }catch (Exception erro){
                                sucesso ='N';
                                    }
                    }                    
                    try{
                            PreparedStatement cadastrarPedido =
                            conexao.prepareStatement("INSERT INTO pedidovenda(ID,NumeroPedido,DataEntrega,Endereco,PesoTotal,CubagemTotal) VALUES (?,?,?,?,?,?)");
                            cadastrarPedido.setString(1, null);
                            cadastrarPedido.setString(2, Npedido);
                            cadastrarPedido.setString(3, DataEntrega);                            
                            cadastrarPedido.setString(4, Endereco);
                            cadastrarPedido.setFloat(5, PesoTotal);
                            cadastrarPedido.setFloat(6, CubagemTotal);
                            cadastrarPedido.executeUpdate();
                            sucesso = 'S';
                            }catch (Exception erro){
                                sucesso ='N';
                                
                                    }                   
                }else{
                    sucesso ='N';
                }
            
    Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
    String strDate = dateFormat.format(date);
    strDate = strDate.replaceAll("[-: ]","");
    if(sucesso =='S'){
            Path fileToMovePath = Paths.get("D:\\Integrador\\Recebido\\pedido.txt");
            Path targetPath = Paths.get("D:\\Integrador\\Integrado_BKP\\pedido"+strDate+".txt");
            Files.move(fileToMovePath, targetPath);
            JOptionPane.showMessageDialog(null,"Carga de arquivo realizada com sucesso!",
                                                                    "Carga OK",JOptionPane.INFORMATION_MESSAGE);
        }else{
            Path fileToMovePath = Paths.get("D:\\Integrador\\Recebido\\pedido.txt");
            Path targetPath = Paths.get("D:\\Integrador\\Erro\\pedido"+strDate+".txt");
            Files.move(fileToMovePath, targetPath);
            JOptionPane.showMessageDialog(null,"Problema na Carga, validar arquivo de origem.",
                                                                    "ERRO!",JOptionPane.WARNING_MESSAGE);
            
        }
    }
}

