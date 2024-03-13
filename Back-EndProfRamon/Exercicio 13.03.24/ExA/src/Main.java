import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            String nomeJogador = retornaValorAleatorio("https://venson.net.br/resources/data/nomes.txt");
            int idade = gerarIdadeAleatoria(17, 40);
            String sobrenome = retornaValorAleatorio("https://venson.net.br/resources/data/sobrenomes.txt");
            String posicao = retornaValorAleatorio("https://venson.net.br/resources/data/posicoes.txt");
            String clube = retornaValorAleatorio("https://venson.net.br/resources/data/clubes.txt");
            System.out.println(
                    nomeJogador + " " + sobrenome + " é um futebolista brasileiro de " + idade + " anos que atua como " + posicao + ". Atualmente defende o " + clube + "."
            );
        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    public static int gerarIdadeAleatoria(int from, int to) {
        Random random = new Random();
        return from + random.nextInt(to - from);
    }

    public static String retornaValorAleatorio(String uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String texto = response.body();
        String[] valores = texto.split("\n");
        int gerarAleatorio = new Random().nextInt(valores.length);
        return valores[gerarAleatorio];
    }
}
