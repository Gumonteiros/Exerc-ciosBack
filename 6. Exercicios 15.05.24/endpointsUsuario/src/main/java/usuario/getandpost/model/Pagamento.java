package usuario.getandpost.model;

public class Pagamento {
    private String id;
    private String data;
    private String formaPagamento;
    private Float valor;

      // Construtor padrão
      public Pagamento() {
    }

    // Contrutor com todos os campos setados
    public Pagamento(String id, String data, String formaPagamento, Float valor) {
        this.id = id;
        this.data = data;
        this.formaPagamento = formaPagamento;
        this.valor = valor;
    }

    //Getter e setter para todos os campos

    public String getIdPagamento() {
        return id;
    }

    public void setIdPagamento(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
