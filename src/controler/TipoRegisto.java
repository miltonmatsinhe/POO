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
public class TipoRegisto {
    private int codigo;
    private String designacao;

    public TipoRegisto() {
    }

    public TipoRegisto(int codigo, String designacao) {
        this.codigo = codigo;
        this.designacao = designacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    public String toString(){
        return codigo +"\t" +designacao;
    }
    
    public TipoRegisto[] loadTipoRegisto(){
        TipoRegisto designacaos[] = new TipoRegisto[2];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\TIPOREGISTO.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String designacao = arrayLinha[1];
                designacaos[i] = new TipoRegisto(codigo, designacao);
                i++;
            }
            readText.close();            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return designacaos;
    }
    
    public TipoRegisto findEstado(int codigo){
        TipoRegisto designacaos = null;
        TipoRegisto ts[] = loadTipoRegisto();
        for(int i =0; i<ts.length; i++){
            if(ts[i].getCodigo() == codigo){
                designacaos = ts[i];
                break;
            }
        }
        return designacaos;
    }
    
    
    
}
