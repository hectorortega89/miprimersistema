/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itq.ferreteria.dao;

import itq.ferreteria.modelo.DetalleTransaccion;
import javax.ejb.Stateless;

/**
 *
 * @author Hector
 */
@Stateless
public class DetalleTransaccionDao extends Generico<DetalleTransaccion> {

    

    public DetalleTransaccionDao() {
        super(DetalleTransaccion.class);
    }
    
}
