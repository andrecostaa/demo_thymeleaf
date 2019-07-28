/**
 * 
 */
package com.estudo.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudo.curso.boot.domain.Cargo;
import com.estudo.curso.boot.domain.Departamento;
import com.estudo.curso.boot.service.CargoService;
import com.estudo.curso.boot.service.DepartamentoService;

/**
 * @author andrecosta
 *
 */

@Controller
@RequestMapping("/cargos")
public class CargoController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String MSG_CARGO_NAO_REMOVIDO = "Cargo não removido. Possui funcionário(s) vinculado(s).";
	
	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute(SUCCESS, "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute(SUCCESS, "Registro atualizado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (cargoService.cargoTemFuncionarios(id)) {
			attr.addFlashAttribute(FAIL, MSG_CARGO_NAO_REMOVIDO);
		} else {
			cargoService.excluir(id);
			attr.addFlashAttribute(SUCCESS, "O cargo foi excluído com sucesso.");
		}
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {
		return departamentoService.buscarTodos();
	}
}
