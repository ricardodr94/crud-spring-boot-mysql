package com.springboot.web.app.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.springboot.web.app.models.Usuario;
import com.springboot.web.app.services.IUsuarioService;

@Controller
@RequestMapping("/app")  
public class AppController {
	
	@Value("${titulo}")
	private String titulo;
	
	@Value("${titleTable}")
	private String tituloTablaUsuarios;

    @Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/home")
	public String getHome(Model model) {			
		model.addAttribute("titulo", tituloTablaUsuarios);
		model.addAttribute("usuarios", usuarioService.findByUsers());
		return "pages/home";
	}
	
	
	//---------------------------------------------------------------------
	
	@GetMapping("/form")
	public String form(Usuario usuario) {
		return "pages/form";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		usuarioService.saveUser(usuario);
		return "redirect:/app/home";
	}
	
	//---------------------------------------------------------------------
	@GetMapping("/editar/{id}")
	public String editar(Usuario usuario, Model model) {
		usuario = usuarioService.findByUser(usuario);
		model.addAttribute("usuario", usuario);
		return "pages/form";
	}
	
	//----------------------------------------------------------------------
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Usuario usuario) {
		usuarioService.deleteUser(usuario);
		return "redirect:/app/home";
	}
	
	

}
