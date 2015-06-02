/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import bean.VentaFacade;
import entidades.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean(name = "ventaView")
@ViewScoped
public class VentaView {

    @EJB
    private bean.VentaFacade ejbFacade;

    private int id_venta;
    private Date fecha;
    private int cantidad;
    private int id_producto;
    private int id_cliente;
    private Date date3;

    
    private Venta venta;

    public VentaFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(VentaFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
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
    
    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public void save() {
        getEjbFacade().create(venta);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("La fecha de venta es" + fecha + "Con una cantidad de" + cantidad + "del producto" + id_producto + "al cliente con id" + id_cliente));
    }

}
