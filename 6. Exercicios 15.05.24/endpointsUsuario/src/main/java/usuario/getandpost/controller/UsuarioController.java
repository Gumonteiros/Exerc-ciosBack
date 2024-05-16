package usuario.getandpost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import usuario.getandpost.model.Usuario;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    // Simulação de um banco de dados temporário
    private Map<String, Usuario> usuarios = new HashMap<>();

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody Usuario usuario) {
        // Verifica se o usuário já existe pelo e-mail
        if (usuarios.containsValue(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado");
        }
        usuarios.put(usuario.getId(), usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable String usuarioId) {
        Usuario usuario = usuarios.get(usuarioId);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PatchMapping("/{usuarioId}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable String usuarioId, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarios.get(usuarioId);
        // verifica se usuário existe
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        // verifica se email do usuário já está cadastrado
        if (!usuario.getEmail().equals(usuarioAtualizado.getEmail()) && usuarios.containsValue(usuarioAtualizado.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado");
        }
        // Atualiza apenas os campos fornecidos na requisição
        if (usuarioAtualizado.getNome() != null) {
            usuario.setNome(usuarioAtualizado.getNome());
        }
        if (usuarioAtualizado.getEmail() != null) {
            usuario.setEmail(usuarioAtualizado.getEmail());
        }
        if (usuarioAtualizado.getSenha() != null) {
            usuario.setSenha(usuarioAtualizado.getSenha());
        }
        if (usuarioAtualizado.getContato() != null) {
            usuario.setContato(usuarioAtualizado.getContato());
        }

        return ResponseEntity.ok("Usuário atualizado com sucesso");
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable String usuarioId) {
        Usuario usuario = usuarios.remove(usuarioId);
        // verifica se usuário existe
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
        }
}