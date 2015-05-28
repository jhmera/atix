/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean
public class ProductoView {

    
    private int id_producto;
    private String nombre;
    private int costo;
    private int cantidad;
    private int id_marca;
    private int number4; 
 
   public int getId_Producto() {
        return id_producto;
    }

    public void setId_Producto(int id_Producto) {
        this.id_producto = id_Producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
 
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("tienes" +cantidad + " de " + nombre + " con valor $"+ costo+" y marca "+ id_marca));
    }
    
     public int getNumber4() {
        return number4;
    }
 
    public void setNumber4(int number4) {
        this.number4 = number4;
    }
    
}
