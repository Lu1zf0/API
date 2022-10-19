package com.jociel.apicadastro.banco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jociel.apicadastro.entidade.Usuario;

@Repository
public interface UsuarioBanco extends CrudRepository<Usuario, Integer>{
    
}
//*teste */