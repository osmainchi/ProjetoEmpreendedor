/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import org.json.simple.parser.ParseException;


public class Teste {
    

 public static void main(String args[]) throws ParseException{
    String endereco;
    double lat, lgn;
    endereco = "Ludwig-Erhard-Straße 8, 45891 Gelsenkirchen, Alemanha";
    
    lat=(double) BuscarCoordenadas.Latitude(endereco);
    lgn=(double) BuscarCoordenadas.Longitude(endereco);
    
    System.out.println("Lat = "+lat);
    System.out.println("Lgn = "+lgn);
 }
}
