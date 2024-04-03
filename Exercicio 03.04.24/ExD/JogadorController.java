import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogadorController {

    @GetMapping("/jogador")
    public Jogador gerarJogadorAleatorio() {
        return JogadorGerador.gerarJogadorAleatorio();
    }
}