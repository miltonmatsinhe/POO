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
public class Categoria {
    private int codigo;
    private String designacao;
    private int codTipo;

    public Categoria() {
    }

    public Categoria(int codigo, String designacao, int codTipo) {
        this.codigo = codigo;
        this.designacao = designacao;
        this.codTipo = codTipo;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public int getCodTipo() {
        return codTipo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    public String toString(){
        return codigo +"\t" +designacao +"\t" +codTipo;
    }
    
    public Categoria[] loadCategoria(){
        Categoria designacaos[] = new Categoria[4];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\CATEGORIA.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String designacao = arrayLinha[1];
                int codTipo = Integer.parseInt(arrayLinha[2]);
                designacaos[i] = new Categoria(codigo, designacao, codTipo);
                i++;
            }
            readText.close();            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return designacaos;
    }
    
    public Categoria findCategoria(int codigo){
        Categoria designacaos = null;
        Categoria cs[] = loadCategoria();
        for(int i =0; i<cs.length; i++){
            if(cs[i].getCodigo() == codigo){
                designacaos = cs[i];
                break;
            }
        }
        return designacaos;
    }
    
    
    
}
