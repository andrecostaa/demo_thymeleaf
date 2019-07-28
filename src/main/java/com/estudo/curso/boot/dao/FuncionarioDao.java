/**
 * 
 */
package com.estudo.curso.boot.dao;

import java.util.List;

import com.estudo.curso.boot.domain.Funcionario;

/**
 * @author andrecosta
 *
 */
public interface FuncionarioDao {

void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();

	
}
