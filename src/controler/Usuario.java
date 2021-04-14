package controler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Usuario {
    private int id;
    private String username;
    private String password;
    private String nomecompleto;
    private String telefone;
    private String email;
    private String tipouser;
    
    public Usuario() {
    }

    public Usuario(int id, String username, String password, String nomecompleto, String telefone, String email, String tipouser) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nomecompleto = nomecompleto;
        this.telefone = telefone;
        this.email = email;
        this.tipouser = tipouser;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }
    
    public String toString(){
        return id +"\t" +username +"\t" +password +"\t" +nomecompleto +"\t" +telefone +"\t" +email +"\t" +tipouser;
    }
    
    private void incrementaArry(Usuario[] users, int num){
        //verifica se o array está cheio, caso sim duplica a capacidade
        if(num >= users.length){
            Usuario aux[]= users;
            users = new Usuario[aux.length * 2];
            for(int i = 0; i<aux.length; i++){
                users[i] = aux[i];
            }
        }
    }
    
    //Leitura do ficheiro de texto e insercão do seu conteudo no array de objecto empresa
    public Object[][] loadUsuarios(){ 
        Usuario users[] = new Usuario[10];
        int nrElem = 0;
        FileReader fileText =null;
        BufferedReader readText = null;
        Object registos[][]= new Object[1][2];
        try {            
            fileText = new FileReader(new File("C:\\MyFiles\\GestaoSindicato\\USUARIOS.txt"));
            readText = new BufferedReader(fileText);
            while(readText.ready()){
                String arrayLinha[]=readText.readLine().split("\t");
                int id = Integer.parseInt(arrayLinha[0]);
                String user = arrayLinha[1];                
                String pass = arrayLinha[2];
                String nome = arrayLinha[3];
                String telf = arrayLinha[4];
                String email = arrayLinha[5];
                String tipo = arrayLinha[6];
                incrementaArry(users, nrElem);
                users[nrElem] = new Usuario(id, user, pass, nome, telf, email, tipo);
                nrElem++;
            }
            readText.close();
            registos[0][0] = users;
            registos[0][1] =nrElem;            
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(null, "Erro da recuperacao de dados "+ex.getMessage(), "select", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        return registos;
    }
    
    public boolean findUsuario(String username, String password){
//        Sindicato sindicato = new Sindicato();
        boolean ok = false;
        Object registos[][] = loadUsuarios();
        Usuario users[] = (Usuario[])registos[0][0];
        int nrElem = (int)registos[0][1];
        for(int i =0; i<nrElem; i++){
            if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
                ok= true;
                break;
            }
        }
        return ok;
    }
    
}
