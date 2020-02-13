/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.ferreteria.servicios;

import itq.ferreteria.dao.CategoriaDao;
import itq.ferreteria.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;

@LocalBean
@Stateless
public class CategoriaServicio {

    @EJB
    private CategoriaDao categoriaDao;
    
    public Boolean guardarCategoria(Categoria categoria) {
        Categoria cat = categoriaDao.editEntity(categoria);
        return cat != null;
    }

    public void guardarCategoriaServicio(Categoria categoria) {
        categoriaDao.create(categoria);

    }
//10 metodo que devuelve un booleano que consulta en el dao, busca por nombre y si existe devuelve true

    public boolean buscarCategoriaPorNombre(String nombreCategoria) {
//llamar a metodo en el Dao que devuelve un booleano true si categoria por nombre existe
//ir a buscarCategoriaPorNombreDao
        return categoriaDao.buscarCategoriaPorNombreDao(nombreCategoria);
    }

    public List<Categoria> obtenerCategoriasActivas() {
        return categoriaDao.obtenerCategoriasActivasDao();
    }

    public List<SelectItem> obtenerListaItemCategorias() {
        List<SelectItem> listaSelectItems = new ArrayList<>();
        List<Categoria> listaCategorias = categoriaDao.obtenerCategoriasActivasDao();
        if (listaCategorias != null && !listaCategorias.isEmpty()) {
            for(Categoria categoria : listaCategorias){
                listaSelectItems.add(new SelectItem(categoria.getIdCategoria(), categoria.getNombr()));
            }
            return listaSelectItems;
        } else {
            return null;
        }

    }
}
