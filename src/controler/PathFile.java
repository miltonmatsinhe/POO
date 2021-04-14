/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
/**
 *
 * @author Matsinhe
 */
public class PathFile {
    private Path source, newDir;
  // caminho até a pasta onde ficam os ficheiro
public String path="C:\\MyFiles\\FileControl\\PedidoRegisto\\";
    
    public PathFile(){        
    }

    public PathFile(String source, String newDir) {
     /* 
        recebe duas string pelos parametros correspondes a endereco origem do ficheiro
        e endereco destino do ficheiro transforma em enderecos. Copia o ficheiro do 
        endereco origem ao renomeia o ficheiro e coloca no endereco destino  
     */
        try {
            this.source = Paths.get(source);
            this.newDir = Paths.get(path+newDir);
            Files.copy(this.source, this.newDir, REPLACE_EXISTING);
            path = path + newDir;
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
    }
    

    public Path getSource() {
        return source;
    }

    public Path getNewDir() {
        return newDir;
    }

    public String getPath() {
        
        return path;
    }
    
    
    
}
