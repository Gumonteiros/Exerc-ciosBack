import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JogadorGerador {
    private static final String NOMES_URL = "https://venson.net.br/resources/data/nomes.txt";
    private static final String SOBRENOMES_URL = "https://venson.net.br/resources/data/sobrenomes.txt";
    private static final String POSICOES_URL = "https://venson.net.br/resources/data/posicoes.txt";
    private static final String CLUBES_URL = "https://venson.net.br/resources/data/clubes.txt";

    private static final List<String> nomes = new ArrayList<>();
    private static final List<String> sobrenomes = new ArrayList<>();
    private static final List<String> posicoes = new ArrayList<>();
    private static final List<String> clubes = new ArrayList<>();

    static {
        try {
            inicializarLista(nomes, NOMES_URL);
            inicializarLista(sobrenomes, SOBRENOMES_URL);
            inicializarLista(posicoes, POSICOES_URL);
            inicializarLista(clubes, CLUBES_URL);
        } catch (Exception e) {
            System.err.println("Erro ao inicializar as listas: " + e.getMessage());
        }
    }

    private static void inicializarLista(List<String> lista, String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String texto = response.body();
        String[] valores = texto.split("\n");
        for (String valor : valores) {
            lista.add(valor);
        }
    }

    public static Jogador gerarJogadorAleatorio() {
        Random random = new Random();
        String nome = nomes.get(random.nextInt(nomes.size()));
        String sobrenome = sobrenomes.get(random.nextInt(sobrenomes.size()));
        int idade = 17 + random.nextInt(24); // Idade entre 17 e 40 anos
        String posicao = posicoes.get(random.nextInt(posicoes.size()));
        String clube = clubes.get(random.nextInt(clubes.size()));
        return new Jogador(nome, sobrenome, idade, posicao, clube);
    }
}

