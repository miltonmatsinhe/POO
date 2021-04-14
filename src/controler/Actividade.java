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
public class Actividade {
    private int codigo;
    private String seccao;
    private String nome;

    public Actividade() {
    }

    public Actividade(int codigo, String seccao, String nome) {
        this.codigo = codigo;
        this.seccao = seccao;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSeccao() {
        return seccao;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSeccao(String seccao) {
        this.seccao = seccao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return codigo +"\t" +seccao +"\t" +nome;
    }
    
    public Actividade[] loadActividades(){
        Actividade actividades[] = new Actividade[21];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\ACTIVIDADE.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String seccao = arrayLinha[1];
                String nome = arrayLinha[2];
                actividades[i] = new Actividade(codigo, seccao, nome);
                i++;
            }
            readText.close();            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return actividades;
    }
    
    public Actividade findActividade(int codigo){
        Actividade activ = null;
        Actividade as[] = loadActividades();
        for(int i =0; i<as.length; i++){
            if(as[i].getCodigo() == codigo){
                activ = as[i];
                break;
            }
        }
        return activ;
    }
}
