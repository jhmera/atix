/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;

import bean.TipoFacade;
import entidades.Tipo;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean (name="tipoView")
@ViewScoped
public class TipoView {
    @EJB
    private bean.TipoFacade ejbFacade;
     
    private int id_tipo;
    private String nombre;
    
    private Tipo tipo;
    
       
    public TipoView ( ) {
        tipo =  new Tipo();
    }

    public TipoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(TipoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public void dlgEditar(Tipo tipo){
        setTipo(tipo);
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').show();");
    }
    
    public void dlgConfirmar(Tipo tipo){
        setTipo(tipo);
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').show();");
    }
    
    public void save() {
        getEjbFacade().create(tipo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("El Tipo agregado es: " + tipo.getNombre() + " con id "+ tipo.getIdTipo()));
        tipo=new Tipo();
    }
    
    public void abrirEditar(Tipo tipo) {
        this.tipo = tipo;
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').show();");
    }
    
    public void actualizar() {
        getEjbFacade().edit(tipo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Tipo modificado"));
        tipo = new Tipo();
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').hide();");
    }
    
    public void eliminar() {
        getEjbFacade().remove(tipo);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Tipo eliminado"));
        tipo = new Tipo();
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').hide();");
    }
    
}
