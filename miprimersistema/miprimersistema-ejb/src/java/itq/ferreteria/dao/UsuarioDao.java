/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.ferreteria.dao;

import itq.ferreteria.modelo.Usuario;
import javax.ejb.Stateless;

/**
 *
 * @author Hector
 */
@Stateless
public class UsuarioDao extends Generico<Usuario> {

    

    public UsuarioDao() {
        super(Usuario.class);
    }
    
}
