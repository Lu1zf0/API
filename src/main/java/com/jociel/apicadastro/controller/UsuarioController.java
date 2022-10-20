package com.jociel.apicadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jociel.apicadastro.banco.UsuarioBanco;
import com.jociel.apicadastro.entidade.Usuario;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioBanco acessoBanco;

    @GetMapping("/usuarios")
    public List<Usuario> listaUsuarios(){
        return (List<Usuario>)acessoBanco.findAll();
    }

    @GetMapping("/usuario{id}")
    public Optional<Usuario> pegueporID(@PathVariable int id){
        return acessoBanco.findById(id);
    }
    
}
