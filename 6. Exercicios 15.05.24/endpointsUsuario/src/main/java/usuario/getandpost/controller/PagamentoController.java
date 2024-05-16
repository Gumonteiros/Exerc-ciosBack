package usuario.getandpost.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import usuario.getandpost.model.Pagamento;
import usuario.getandpost.model.Usuario;

@RestController
@RequestMapping("/pagamentos")

public class PagamentoController {

    // Simulação de um banco de dados temporário
    private Map<String, Usuario> usuarios = new HashMap<>();
    private Map<String, Pagamento> pagamentos = new HashMap<>();

    @RequestMapping
    public ResponseEntity<String> verificarUsuario(@RequestBody Usuario usuario,@RequestBody Pagamento pagamento) {
        // Verifica se o usuário já existe pelo Id e verifica de existe pendencia no pagamento pelo Id
        if (usuarios.containsValue(usuario.getId())) {

            if (pagamentos.containsValue(pagamento.getIdPagamento())){
                return ResponseEntity.status(HttpStatus.FOUND).body("Pagamento Encontrado");
            }
            else{ 
                return ResponseEntity.status(HttpStatus.CONFLICT).body("não existe pagamento com este id");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado");
    }

    @PostMapping
    public ResponseEntity<String> criarPagamento(@RequestBody Pagamento pagamento) {
        // Verifica se existe algum pagamento
        if (pagamentos.containsValue(pagamento.getIdPagamento())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamentos não encontrados");
        }
        pagamentos.put(pagamento.getIdPagamento(), pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento Realizado!");
    }

    @GetMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> obterPagamento(@PathVariable String idPagamento) {
        Pagamento pagamento = pagamentos.get(idPagamento);
        if (pagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{idPagamento}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable String idPagamento) {
        Pagamento pagamento = pagamentos.remove(idPagamento);
        // verifica se usuário existe
        if (pagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
        }
    
}
