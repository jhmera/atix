/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import bean.ProductoFacade;
import bean.VentaFacade;
import entidades.Producto;
import entidades.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

/**
 *
 * @author ACER
 */
@ManagedBean(name = "ventaView")
@ViewScoped
public class VentaView {

    @EJB
    private bean.VentaFacade ejbFacade;
    @EJB
    private bean.ProductoFacade productoFacade;

    private int id_venta;
    private Date fecha;
    private int cantidad;
    private int id_producto;
    private int id_cliente;
    
    private DataModel productos = null;
    
    private List<Producto> lstProductos;
    
    public VentaView ( ) {
        iniciarLista();
        venta = new Venta();
    }
    
    private Venta venta;

    public VentaFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(VentaFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(List<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }
    
    private void iniciarLista() {
        //lstProductos = getProductoFacade().findAll();
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public void save() {
        int cantProducto = venta.getIdProducto().getCantidad();
        int cantSolicitada = Integer.parseInt(venta.getCantidad()+"");
        if (cantProducto > cantSolicitada) {
            getEjbFacade().create(venta);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("La fecha de venta es " + venta.getFecha()+ " Con una cantidad de " + venta.getCantidad() + " del producto " + venta.getIdProducto().getNombre() + " al cliente con id " + venta.getIdCliente().getNombres()));
            
            cantProducto -= cantSolicitada;
            Producto producto = venta.getIdProducto();
            producto.setCantidad(cantProducto);
            getProductoFacade().edit(producto);
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("La cantidad no se encuetra disponible"));
        }
    }

}
