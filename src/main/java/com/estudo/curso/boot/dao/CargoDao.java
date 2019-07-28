/**
 * 
 */
package com.estudo.curso.boot.dao;

import java.util.List;

import com.estudo.curso.boot.domain.Cargo;

/**
 * @author andrecosta
 *
 */
public interface CargoDao {

	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();

	
}
