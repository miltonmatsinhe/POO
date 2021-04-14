/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Provincia {
    private int codigo;
    private String nome;

    public Provincia() {
    }

    public Provincia(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return codigo +"\t" +nome;
    }
    
    public Provincia[] loadProvincias(){
        Provincia provincias[] = new Provincia[11];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\PROVINCIA.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String nome = arrayLinha[1];
                provincias[i] = new Provincia(codigo, nome);
                i++;
            }
            readText.close();            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return provincias;
    }
    
    public Provincia findProvincia(int codigo){
        Provincia prov = new Provincia();
        Provincia ps[] = loadProvincias();
        for(int i =0; i<ps.length; i++){
            if(ps[i].getCodigo() == codigo){
                prov = ps[i];
                break;
            }
        }
        return prov;
    }
    
}
