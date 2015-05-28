/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean
@ViewScoped
public class DropdownView implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    
    private String tipo;
    private String marca;
    private int number4; 
    private Map<String,String> tipos;
    private Map<String,String> marcas;
     
    @PostConstruct
    public void init() {
        tipos  = new HashMap<String, String>();
        tipos.put("Zapatos", "Zapatos");
        tipos.put("Ropa", "Ropa");
        tipos.put("Accesorios", "Accesorios");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("Adidas", "Adidas");
        map.put("Nike", "Nike");
        map.put("Polo", "Polo");
        data.put("Zapatos", map);
         
        map = new HashMap<String, String>();
        map.put("Polo", "Polo");
        map.put("Atix", "Atix");
        data.put("Ropa", map);
         
        map = new HashMap<String, String>();
        map.put("Balon", "Balon");
        map.put("Canilleras ", "Canilleras");
        map.put("Guantes", "Guantes");
        data.put("Accesorios", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public Map<String, String> getTipos() {
        return tipos;
    }
 
    public Map<String, String> getMarcas() {
        return marcas;
    }
 
    public void onTipoChange() {
        if(tipo !=null && !tipo.equals(""))
            marcas = data.get(tipo);
        else
            marcas = new HashMap<String, String>();
    }
     
    public void displayLocation() {
        FacesMessage msg;
        if(marca != null && tipo != null)
            msg = new FacesMessage("Seleccion la marca", marca + " de tipo " + tipo + "con valor de $" + number4);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "marca no seleccionada."); 
             
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
      public int getNumber4() {
        return number4;
    }
 
    public void setNumber4(int number4) {
        this.number4 = number4;
}
}