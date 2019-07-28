/**
 * 
 */
package com.estudo.curso.boot.dao;

import java.util.List;

import com.estudo.curso.boot.domain.Departamento;

/**
 * @author andrecosta
 *
 */
public interface DepartamentoDao {

	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();
	
}
