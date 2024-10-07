package br.com.vidaadultafacil.pagamentos;

public enum TiposPagamento {

    DEBITO("Débito", 1),
    CREDITO("Crédito", 2),
    BOLETO("Boleto", 3),
    PIX("Pix", 4);

    private final String tipo;
    private final int id;
   
    TiposPagamento(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public static TiposPagamento getById(int id) {
        for (TiposPagamento pagamento : values()) {
            if (pagamento.getId() == id) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("ID inválido: " + id);
    }

    public static TiposPagamento getByTipo(String tipo) {
        for (TiposPagamento pagamento : values()) {
            if (pagamento.getTipo().equalsIgnoreCase(tipo)) {
                return pagamento;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + tipo);
    }
}
