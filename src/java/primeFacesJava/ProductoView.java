/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import bean.ProductoFacade;
import entidades.Producto;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ACER
 */
@ManagedBean (name="productoView")
@ViewScoped
public class ProductoView {

    
    @EJB
    private bean.ProductoFacade ejbFacade;
    
    private Producto producto;

    public ProductoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ProductoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public ProductoView ( ) {
        producto =  new Producto();
    }
    
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
    
     public int getNumber4() {
        return number4;
    }
 
    public void setNumber4(int number4) {
        this.number4 = number4;
    }
    
    public void dlgEditar(Producto producto){
        setProducto(producto);
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').show();");
    }
    
    public void dlgConfirmar(Producto producto){
        setProducto(producto);
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').show();");
    }
 
    public void save() {
        getEjbFacade().create(producto);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("tienes" + producto.getCantidad() + " unidades de " + producto.getNombre() + " con valor $"+ producto.getCosto()+" y marca "+ producto.getIdMarca()));
    }
    
    public void actualizar() {
        getEjbFacade().edit(producto);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Producto modificado"));
        producto = new Producto();
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').hide();");
    }
    
    public void eliminar() {
        getEjbFacade().remove(producto);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Producto eliminado"));
        producto = new Producto();
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').hide();");
    }
    
}
