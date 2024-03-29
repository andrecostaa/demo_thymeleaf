/**
 * 
 */
package com.estudo.curso.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.estudo.curso.boot.dao.CargoDao;
import com.estudo.curso.boot.domain.Cargo;
import com.estudo.curso.boot.domain.Funcionario;
import com.estudo.curso.boot.service.CargoService;

/**
 * @author andrecosta
 *
 */

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao dao;
	
	
	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		List<Funcionario> funcionarios = buscarPorId(id).getFuncionarios();
		boolean temFuncionarios = !CollectionUtils.isEmpty(funcionarios);
		return temFuncionarios;
	}

}
