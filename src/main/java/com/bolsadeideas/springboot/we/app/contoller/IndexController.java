package com.bolsadeideas.springboot.we.app.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bolsadeideas.springboot.we.app.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Autowired
	Usuario usuario;
	
	List<Usuario> usuarios = new ArrayList<>();

	  @GetMapping(value= {"/index","/","/home"})
	  public String index(Model model) {
		  model.addAttribute("hola","hola Spring");
		  return "index";
	  
	  }
	 
	  @RequestMapping("/perfil")
	  public String perfil(Model model) {
	  
		  usuario.setNombre("Carlos");
		  usuario.setApellido("Garcia");
		  usuario.setEmail("carlos@yrtr.vom");
		  
		  model.addAttribute("usuario", usuario);
		  model.addAttribute("titulo","Perfil del usuario: ".concat(usuario.getNombre()));
		  
		  return "perfil";
	  
	  }
	  @RequestMapping("/listar")
	  public List<Usuario> listarUsuarios(Model model) {
		  
		return usuarios;
		  
		  
	  }

}
