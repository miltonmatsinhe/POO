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
public class EstadoEmpresa {
    private int codigo;
    private String estado;

    public EstadoEmpresa() {
    }

    public EstadoEmpresa(int codigo, String estado) {
        this.codigo = codigo;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString(){
        return codigo +"\t" +estado;
    }
    
    public EstadoEmpresa[] loadEstado(){
        EstadoEmpresa estados[] = new EstadoEmpresa[4];
        FileReader fileText =null;
        BufferedReader readText = null;
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\ESTADOEMPRESA.txt"));
            readText = new BufferedReader(fileText);
            int i =0;
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String estado = arrayLinha[1];
                estados[i] = new EstadoEmpresa(codigo, estado);
                i++;
            }
            readText.close();            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return estados;
    }
    
    public EstadoEmpresa findEstado(int codigo){
        EstadoEmpresa estados = null;
        EstadoEmpresa es[] = loadEstado();
        for(int i =0; i<es.length; i++){
            if(es[i].getCodigo() == codigo){
                estados = es[i];
                break;
            }
        }
        return estados;
    }
    
    
    
}
