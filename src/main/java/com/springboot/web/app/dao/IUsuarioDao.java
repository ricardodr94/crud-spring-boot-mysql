package com.springboot.web.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.springboot.web.app.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario,Integer>{

}
