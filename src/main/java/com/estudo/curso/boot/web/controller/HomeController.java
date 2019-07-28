/**
 * 
 */
package com.estudo.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author andrecosta
 *
 */

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
}
