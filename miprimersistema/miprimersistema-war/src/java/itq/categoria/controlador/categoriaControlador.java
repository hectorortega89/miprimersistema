/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.categoria.controlador;

import itq.ferreteria.modelo.Categoria;
import itq.ferreteria.servicios.CategoriaServicio;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class categoriaControlador {

    @EJB        //4 cuarto se llama al servicio
    private CategoriaServicio categoriaServicio; //5 quinto declarar variable tipo categoria servicio

    private Categoria categoria;  //1 primero declarar variable

    @PostConstruct
    public void init() {
        categoria = new Categoria();  //2 segundo instanciar variable

    }
//6 sexto crear metodo guardar

    public void guardarCategoria(){
        //9 para consulta si el nombre de la categoria existe: luego ir a CategoriaServicio y crear metodo bypass buscarCategoriaPorNombre
        boolean categoriaExiste = categoriaServicio.buscarCategoriaPorNombre(categoria.getNombr());
        
        if (categoriaExiste) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La categoría ingresada ya existe."));
        } else {
            this.categoria.setEstadpCategoria(Boolean.TRUE);
            categoriaServicio.guardarCategoriaServicio(categoria);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "La categoría ha sido ingresada exitosamente."));
        }
        //7 se define el estado de la variable
        //8 se define el metodo guardarCategoriaServicio con parametro (categoria)

    }

//3 tercero crear metodos getters y setters (encapsulados)
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
