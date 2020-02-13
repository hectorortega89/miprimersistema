package itq.ferreteria.dao;

import itq.ferreteria.modelo.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CategoriaDao extends Generico<Categoria> {

    public CategoriaDao() {
        super(Categoria.class);
    }

    //metodo que se encarga de hacer la consulta a la bdd, 
    public boolean buscarCategoriaPorNombreDao(String nombreCategoria) {
        //con try intentamos hacer una consulta SELECT a la bdd para saber si existe el nombre de categoria consultado

        try {
            //creamos variable tipo List<Categoria> de clase Categoria, nombre de variable listaCategoria
            List<Categoria> listaCategoria = new ArrayList<>();
            //StringBuilder es una secuencia de caracteres mutable, se usa instanciando StringBuilder y pasando el String como parametro
            StringBuilder sql = new StringBuilder();
            //el metodo append es usado para adjuntar en este caso la variable sql
            sql.append("SELECT c FROM Categoria c WHERE c.nombr = :nombr");
            //se crea variable tipo Query que almacenará la consulta
            Query nuevaQuery;
            //obtiene la entidad, crea una query dando los parametros la consulta sql adjunta, establece como parametro el nombre del campo y el nombre de la categoria que se busca
            nuevaQuery = getEntityManager().createQuery(sql.toString()).setParameter("nombr", nombreCategoria);
            //en la variable listaCategoria se almacena el resultado de la nueva Query en formato ResultList que devuelve una lista de objetos resultantes
            listaCategoria = nuevaQuery.getResultList();
            //si la listaCategoria es no-nula y listaCategoria es diferente de vacia, retorna verdad
            if (listaCategoria != null && !listaCategoria.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public List<Categoria> obtenerCategoriasActivasDao() {
        try {
            List<Categoria> resultado = new ArrayList<>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM Categoria c WHERE c.estadpCategoria = :estadpCategoria");
            Query query;
            query = getEntityManager().createQuery(sql.toString()).setParameter("estadpCategoria", true);
            resultado = query.getResultList();
            if (resultado != null && !resultado.isEmpty()) {
                return resultado;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }

    }

}
