/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import bean.ClienteFacade;
import entidades.Cliente;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ACER
 */
@ManagedBean (name="clienteView")
@ViewScoped
public class ClienteView {
    
     @EJB
    private bean.ClienteFacade ejbFacade;
     
    private int id_cliente;
    private int identificacion;
    private String nombres;
    private String apellidos;
    private int edad;
    
    private Cliente cliente;
    
       
    public ClienteView ( ) {
        cliente =  new Cliente();
    }

    public ClienteFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ClienteFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        
    public void save() {
        getEjbFacade().create(cliente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("El cliente agregado es " + cliente.getNombres() +" "+ cliente.getApellidos() + " con identificacion "+ cliente.getIdentificacion() +" y edad "+ cliente.getEdad()));
    }
    
}
