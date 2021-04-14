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
public class Distrito {
    private int codigo;
    private String nome;
    private int codProv;

    public Distrito() {
    }

    public Distrito(int codigo, String nome, int codProv) {
        this.codigo = codigo;
        this.nome = nome;
        this.codProv = codProv;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodProv() {
        return codProv;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodProv(int codProv) {
        this.codProv = codProv;
    }
    
    public String toString(){
        return codigo +"\t" +nome +"\t" +codProv;
    }
    
    public Distrito[] loadDistritos(){
        Distrito dists[] = new Distrito[161];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\DISTRITOS.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String nome = arrayLinha[1];
                int codProv = Integer.parseInt(arrayLinha[2]);
                dists[i] = new Distrito(codigo, nome, codProv);
                i++; // incrementa uma unidade para poder inserir na proxima posicao do array                
            }
            readText.close();
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return dists;
    }
    
    public Distrito findDistrito(int codigo){
        Distrito distrito = null;
        Distrito ds[] = loadDistritos();
        for(int i =0; i<ds.length; i++){
            if(ds[i].getCodigo() == codigo){
                distrito = ds[i];
                break;
            }
        }
        return distrito;
    }
    
}
