/**
 * 
 */
package com.estudo.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.estudo.curso.boot.dao.AbstractDAO;
import com.estudo.curso.boot.dao.FuncionarioDao;
import com.estudo.curso.boot.domain.Funcionario;

/**
 * @author andrecosta
 *
 */

@Repository
public class FuncionarioDaoImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDao {

}
