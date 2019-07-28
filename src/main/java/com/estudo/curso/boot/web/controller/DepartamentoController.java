/**
 * 
 */
package com.estudo.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estudo.curso.boot.domain.Departamento;
import com.estudo.curso.boot.service.DepartamentoService;

/**
 * @author andrecosta
 *
 */

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	private static final String FAIL = "fail";
	private static final String SUCCESS = "success";
	private static final String MSG_DEPARTAMENTO_NAO_REMOVIDO = "Departamento não removido. Possui cargo(s) vinculado(s).";
	@Autowired
	private DepartamentoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", service.buscarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento, RedirectAttributes attr) {
		service.salvar(departamento);
		attr.addFlashAttribute(SUCCESS, "Departamento inserido com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "/departamento/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Departamento departamento, RedirectAttributes attr) {
		service.editar(departamento);
		attr.addFlashAttribute(SUCCESS, "Departamento editado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.departamentoTemCargos(id)) {
			model.addAttribute(FAIL, MSG_DEPARTAMENTO_NAO_REMOVIDO);
		} else {
			service.excluir(id);
			model.addAttribute(SUCCESS, "Departamento excluído com sucesso.");
		}
		return listar(model);
	}
	
}
