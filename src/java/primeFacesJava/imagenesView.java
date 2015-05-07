/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package primeFacesJava;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ACER
 */
public class imagenesView {
    private List<String> imagenes;
     
    @PostConstruct
    public void init() {
        imagenes = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            imagenes.add("atix" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return imagenes;
    }
}
