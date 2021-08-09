package com.springboot.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.web.app.dao.IUsuarioDao;
import com.springboot.web.app.models.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;

	//Metodo get --> para obtener todos los usuarios
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByUsers() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	//Metodo save --> para crear y actualizar un usuario
	@Override
	@Transactional
	public void saveUser(Usuario usuario) {
        usuarioDao.save(usuario);
	}

	//Metodo delete --> para eliminar un usuario
	@Override
	@Transactional
	public void deleteUser(Usuario usuario) {
        usuarioDao.delete(usuario);
	}

	//Metodo get --> para obtener un usuario
	@Override
	@Transactional(readOnly = true)
	public Usuario findByUser(Usuario usuario) {
		return usuarioDao.findById(usuario.getId()).orElse(null);
	}

}
