/**
 * 
 */
package com.estudo.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.estudo.curso.boot.dao.AbstractDAO;
import com.estudo.curso.boot.dao.DepartamentoDao;
import com.estudo.curso.boot.domain.Departamento;

/**
 * @author andrecosta
 *
 */

@Repository
public class DepartamentoDaoImpl extends AbstractDAO<Departamento, Long> implements DepartamentoDao {

}
