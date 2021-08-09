package com.springboot.web.app.services;

import java.util.*;

import com.springboot.web.app.models.Usuario;

public interface IUsuarioService {
	
	//Metodo get --> obtener todos lo usuarios
	public List<Usuario> findByUsers();
	
	
	//Metodo update
	public void saveUser(Usuario usuario);
	
	//Metodo delete
	public void deleteUser(Usuario usuario);
	
	//Metodo --> obtener un usuario 
	public Usuario findByUser(Usuario usuario);

}
