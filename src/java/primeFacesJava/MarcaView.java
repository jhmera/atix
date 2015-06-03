/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeFacesJava;


import bean.MarcaFacade;
import entidades.Marca;
import entidades.Producto;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


@ManagedBean (name="marcaView")
@ViewScoped
public class MarcaView {
    @EJB
    private bean.MarcaFacade ejbFacade;
     
    private int id_marca;
    private String nombre;
    private int id_tipo;
    
    private Marca marca;
    
    public MarcaView()
    {
        marca = new Marca();
    }

    public MarcaFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(MarcaFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public void dlgEditar(Marca marca){
        setMarca(marca);
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').show();");
    }
    
    public void dlgConfirmar(Marca marca){
        setMarca(marca);
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').show();");
    }
    
    public void save() {
        getEjbFacade().create(marca);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("La marca agregada es: " + marca.getNombre() + " con id "+ marca.getIdMarca() + " perteneciente al tipo " + marca.getIdTipo()));
        marca=new Marca();
    }
    
    public void actualizar() {
        getEjbFacade().edit(marca);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Marca modificada"));
        marca = new Marca();
        RequestContext.getCurrentInstance().execute("PF('dlgEditarWV').hide();");
    }
    
    public void eliminar() {
        getEjbFacade().remove(marca);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Marca eliminada"));
        marca = new Marca();
        RequestContext.getCurrentInstance().execute("PF('dlgConfirmarWV').hide();");
    }
}
