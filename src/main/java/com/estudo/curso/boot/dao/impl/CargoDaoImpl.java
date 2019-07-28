/**
 * 
 */
package com.estudo.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.estudo.curso.boot.dao.AbstractDAO;
import com.estudo.curso.boot.dao.CargoDao;
import com.estudo.curso.boot.domain.Cargo;

/**
 * @author andrecosta
 *
 */

@Repository
public class CargoDaoImpl extends AbstractDAO<Cargo, Long> implements CargoDao {

}
