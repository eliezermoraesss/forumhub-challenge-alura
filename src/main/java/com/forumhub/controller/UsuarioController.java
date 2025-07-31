package com.forumhub.controller;

import com.forumhub.dto.DadosCadastroUsuario;
import com.forumhub.dto.DadosDetalhamentoUsuario;
import com.forumhub.model.Usuario;
import com.forumhub.respository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    private ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dto) {
        Usuario usuario = new Usuario(dto);
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        repository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario.getId(), usuario.getNome(), usuario.getEmail()));
    }
}
