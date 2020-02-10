/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.ferreteria.dao;

import itq.ferreteria.modelo.Operacion;
import javax.ejb.Stateless;

/**
 *
 * @author Hector
 */
@Stateless
public class OperacionDao extends Generico<Operacion> {

    

    public OperacionDao() {
        super(Operacion.class);
    }
    
}
