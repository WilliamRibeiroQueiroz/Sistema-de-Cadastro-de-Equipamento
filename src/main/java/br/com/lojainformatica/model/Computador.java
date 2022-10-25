/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lojainformatica.model;

/**
 *
 * @author William
 */
public class Computador {
    private static String marca = "WilliamQueiroz";
    private int hd;
    private String processador;
    private int id;
    
    public Computador (){
    }
    
    public Computador(int hd, String processador){
        this.hd = hd;
        this.processador = processador;
    }
    
    public Computador(int id, int hd, String processador){
        this.id = id;
        this.hd = hd;
        this.processador = processador;
    }
    
    public String getMarca(){
        return marca;
    }
    public int getHd(){
        return hd;
    }
    public void setHd(int hd){
        this.hd = hd;
    }
    public String getProcessador(){
        return processador;
    }
    public void setProcessador(String processador){
        this.processador = processador;
    }
    public int getId(){
        return id;
    }
    public void setId (int id){
        this.id = id;
    }
}
