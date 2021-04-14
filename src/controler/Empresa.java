/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import javax.swing.JOptionPane;
public class Empresa {
    private int numInss;
    private int nuit;
    private String nome;
    private int codDist;
    private String endereco;
    private int codActiv;
    private String telefone;
    private int estado;
    private Date dataDespacho;
    private String despacho;
    
    public Empresa() {
    }

    public Empresa(int numInss, int nuit, String nome, int codDist, String endereco, int codActiv, String telefone, int estado, Date dataDespacho, String despacho) {
        this.numInss = numInss;
        this.nuit = nuit;
        this.nome = nome;
        this.codDist = codDist;
        this.endereco = endereco;
        this.codActiv = codActiv;
        this.telefone = telefone;
        this.estado = estado;
        this.dataDespacho = dataDespacho;
        this.despacho = despacho;
    }

    public int getNumInss() {
        return numInss;
    }

    public int getNuit() {
        return nuit;
    }

    public String getNome() {
        return nome;
    }

    public int getCodDist() {
        return codDist;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getCodActiv() {
        return codActiv;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getEstado() {
        return estado;
    }

    public Date getDataDespacho() {
        return dataDespacho;
    }

    public String getDespacho() {
        return despacho;
    }
    

    public void setNumInss(int numInss) {
        this.numInss = numInss;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodDist(int codDist) {
        this.codDist = codDist;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCodActiv(int codActiv) {
        this.codActiv = codActiv;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setDataDespacho(Date dataDespacho) {
        this.dataDespacho = dataDespacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }
    
    public String toString(){
        return numInss +"\t" +nuit +"\t" +nome +"\t" +codDist +"\t" +endereco +"\t" +codActiv +"\t" +telefone +"\t" +estado +"\t" +dataDespacho +"\t" +despacho;
    }
    
    private void incrementaArry(Empresa[] emps, int num){
        //verifica se o array está cheio, caso sim duplica a capacidade
        if(num >= emps.length){
            Empresa aux[]= emps;
            emps = new Empresa[aux.length * 2];
            for(int i = 0; i<aux.length; i++){
                emps[i] = aux[i];
            }
        }
    }
    
    //Leitura do ficheiro de texto e insercão do seu conteudo no array de objecto empresa
    public Object[][] loadEmpresas(){ 
        Empresa empresas[] = new Empresa[10];
        int nrElem = 0;
        FileReader fileText =null;
        BufferedReader readText = null;
        Object registos[][]= new Object[1][2];
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\EMPRESA.txt"));
            readText = new BufferedReader(fileText);
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int numInss = Integer.parseInt(arrayLinha[0]);
                int nuit = Integer.parseInt(arrayLinha[1]);
                String nome = arrayLinha[2];
                int codDist = Integer.parseInt(arrayLinha[3]);
                String endereco = arrayLinha[4];
                int codAct = Integer.parseInt(arrayLinha[5]);
                String telef = arrayLinha[6];
                int codEst = Integer.parseInt(arrayLinha[7]);
                Date dataDesp = null; 
                if(!arrayLinha[8].equalsIgnoreCase("null")){
                    dataDesp = Date.valueOf(arrayLinha[8]);
                }
                String despacho = arrayLinha[9];
                incrementaArry(empresas, nrElem);
                empresas[nrElem] = new Empresa(numInss, nuit, nome, codDist, endereco, codAct, telef, codEst, dataDesp, despacho);
                nrElem++;
            }
            readText.close();
            registos[0][0] = empresas;
            registos[0][1] =nrElem;            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return registos;
    }
    
    public Empresa findEmpresa(int numInss){
        Empresa emp = new Empresa();
        Object emps[][] = loadEmpresas();
        Empresa es[] = (Empresa[])emps[0][0];
        int nrElem = (int)emps[0][1];
        for(int i =0; i<nrElem; i++){
            if(es[i].getNumInss() == numInss){
                emp = es[i];
                break;
            }
        }
        return emp;
    }
    
    
}
