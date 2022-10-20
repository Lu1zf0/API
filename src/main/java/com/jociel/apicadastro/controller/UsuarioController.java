package com.jociel.apicadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> pegueporID(@PathVariable int id){
        return acessoBanco.findById(id);
    }
    
    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Usuario novousuario){
        acessoBanco.save(novousuario);
        }
    
    @PutMapping("/alterar/{id}")
    public void alterar(@PathVariable int id, @RequestBody Usuario usuario){
        acessoBanco.findById(id).map(user ->{
            user.setNome(usuario.getNome());
            user.setUsuario(usuario.getUsuario());
            user.setEmail(usuario.getEmail());
            user.setSenha(usuario.getSenha());
            return acessoBanco.save(user);
        } );
    } 
     
    
}
