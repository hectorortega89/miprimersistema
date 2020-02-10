/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.ferreteria.servicios;

import itq.ferreteria.dao.CategoriaDao;
import itq.ferreteria.modelo.Categoria;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@LocalBean
@Stateless
public class CategoriaServicio {

    @EJB
    private CategoriaDao categoriaDao;

    public void guardarCategoriaServicio(Categoria categoria) {
        categoriaDao.create(categoria);

    }
//10 metodo que devuelve un booleano que consulta en el dao, busca por nombre y si existe devuelve true
    public boolean buscarCategoriaPorNombre(String nombreCategoria) {
//llamar a metodo en el Dao que devuelve un booleano true si categoria por nombre existe
//ir a buscarCategoriaPorNombreDao
        return categoriaDao.buscarCategoriaPorNombreDao(nombreCategoria);
    }

}
