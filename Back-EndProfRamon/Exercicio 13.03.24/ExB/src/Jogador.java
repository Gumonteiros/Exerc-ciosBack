public class Jogador {
    private String nome;
    private String sobrenome;
    private int idade;
    private String posicao;
    private String clube;

    public Jogador(String nome, String sobrenome, int idade, String posicao, String clube) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.posicao = posicao;
        this.clube = clube;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getClube() {
        return clube;
    }

    public String getDescricao() {
        return nome + " " + sobrenome + " é um futebolista brasileiro de " + idade + " anos que atua como " + posicao + ". Atualmente defende o " + clube + ".";
    }
}

