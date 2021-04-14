/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import javax.swing.JOptionPane;
public class Sindicato {
    private int codigo;
    private String sigla;
    private String designacao;
    private String representante;
    private int codDist;
    private String endereco;
    private String contacto;
    private Date data;
    private int categoria;
    private int estado;
    private int numInss;
    private int codActiv;
    private String fileActa;
    private String fileEstatuto;
    private String fileLista;
    private String fileCertidao;
    private String fileConvocatoria;
    private Date dataDespacho;
    private String despacho;

    public Sindicato() {
    }

    public Sindicato(int codigo, String sigla, String designacao, String representante, int codDist, String endereco, String contacto, Date data, int categoria, int estado, int numInss, int codActiv, String fileActa, String fileEstatuto, String fileLista, String fileCertidao, String fileConvocatoria, Date dataDespacho, String despacho) {
        this.codigo = codigo;
        this.sigla = sigla;
        this.designacao = designacao;
        this.representante = representante;
        this.codDist = codDist;
        this.endereco = endereco;
        this.contacto = contacto;
        this.data = data;
        this.categoria = categoria;
        this.estado = estado;
        this.numInss = numInss;
        this.codActiv = codActiv;
        this.fileActa = fileActa;
        this.fileEstatuto = fileEstatuto;
        this.fileLista = fileLista;
        this.fileCertidao = fileCertidao;
        this.fileConvocatoria = fileConvocatoria;
        this.dataDespacho = dataDespacho;
        this.despacho = despacho;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDesignacao() {
        return designacao;
    }

    public String getRepresentante() {
        return representante;
    }

    public int getCodDist() {
        return codDist;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getContacto() {
        return contacto;
    }

    public Date getData() {
        return data;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getEstado() {
        return estado;
    }

    public int getNumInss() {
        return numInss;
    }

    public int getCodActiv() {
        return codActiv;
    }

    public String getFileActa() {
        return fileActa;
    }

    public String getFileEstatuto() {
        return fileEstatuto;
    }

    public String getFileLista() {
        return fileLista;
    }

    public String getFileCertidao() {
        return fileCertidao;
    }

    public String getFileConvocatoria() {
        return fileConvocatoria;
    }

    public Date getDataDespacho() {
        return dataDespacho;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public void setCodDist(int codDist) {
        this.codDist = codDist;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setNumInss(int numInss) {
        this.numInss = numInss;
    }

    public void setCodActiv(int codActiv) {
        this.codActiv = codActiv;
    }

    public void setFileActa(String fileActa) {
        this.fileActa = fileActa;
    }

    public void setFileEstatuto(String fileEstatuto) {
        this.fileEstatuto = fileEstatuto;
    }

    public void setFileLista(String fileLista) {
        this.fileLista = fileLista;
    }

    public void setFileCertidao(String fileCertidao) {
        this.fileCertidao = fileCertidao;
    }

    public void setFileConvocatoria(String fileConvocatoria) {
        this.fileConvocatoria = fileConvocatoria;
    }

    public void setDataDespacho(Date dataDespacho) {
        this.dataDespacho = dataDespacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public String toString() {
        return  codigo + "\t" +sigla + "\t" +designacao + "\t" +representante + "\t" +codDist + "\t" +endereco + "\t" +contacto + "\t" +data + "\t" +categoria + "\t" +estado + "\t" +numInss + "\t" +codActiv + "\t" +fileActa + "\t" +fileEstatuto + "\t" +fileLista + "\t" +fileCertidao + "\t" +fileConvocatoria + "\t" +dataDespacho + "\t" +despacho;
    }
    
    private void incrementaArry(Sindicato sindicatos[], int nrElem){
        //verifica se o array está cheio, caso sim duplica a capacidade
        if(nrElem >= sindicatos.length){
            Sindicato aux[]= sindicatos;
            sindicatos = new Sindicato[aux.length * 2];
            for(int i = 0; i<aux.length; i++){
                sindicatos[i] = aux[i];
            }
        }
    }
        
    //Leitura do ficheiro de texto e insercão do seu conteudo no array de objecto empresa
    public Object[][] loadSindicatos(){ 
        Sindicato sindicatos[] = new Sindicato[100];
        int nrElem = 0;
        FileReader fileText =null;
        BufferedReader readText = null;
        Object registos[][]= new Object[1][2];
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\SINDICATO.txt"));
            readText = new BufferedReader(fileText);
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int codigo = Integer.parseInt(arrayLinha[0]);
                String sigla = arrayLinha[1];
                String desig = arrayLinha[2];
                String repre = arrayLinha[3];
                int codDist = Integer.parseInt(arrayLinha[4]);
                String endere = arrayLinha[5];
                String contac = arrayLinha[6];
                Date data = Date.valueOf(arrayLinha[7]);
                int categ = Integer.parseInt(arrayLinha[8]);
                int estad = Integer.parseInt(arrayLinha[9]);
                int inss = Integer.parseInt(arrayLinha[10]);
                int codAct = Integer.parseInt(arrayLinha[11]);
                String fActa = arrayLinha[12];
                String fEstat = arrayLinha[13];
                String fLista = arrayLinha[14];
                String fCertidao = arrayLinha[15];
                String fConvocatoria = arrayLinha[16];                
                Date dataDesp = null;
                if(!arrayLinha[17].equalsIgnoreCase("null")){
                    dataDesp = Date.valueOf(arrayLinha[17]);
                }
                String despacho = arrayLinha[18];
                incrementaArry(sindicatos, nrElem);
                sindicatos[nrElem] = new Sindicato(codigo, sigla, desig, repre, codDist, endere, contac, data, categ, estad, inss, codAct, fActa, fEstat, fLista, fCertidao, fConvocatoria, dataDesp, despacho);
                nrElem++;
            }
            readText.close();  
            registos[0][0] = sindicatos;
            registos[0][1] = nrElem;
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return registos;
    }
    
    public Sindicato findSindicato(int codigo){
        Sindicato sindicato = new Sindicato();
        Object sinds[][] = loadSindicatos();
        Sindicato ss[] = (Sindicato[])sinds[0][0];
        int nrElem = (int)sinds[0][1];
        for(int i =0; i<nrElem; i++){
            if(ss[i].getCodigo() == codigo){
                sindicato = ss[i];
                break;
            }
        }
        return sindicato;
    }
    
    
    
}
