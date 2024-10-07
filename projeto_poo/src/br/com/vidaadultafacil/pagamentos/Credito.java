package br.com.vidaadultafacil.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class Credito extends Pagamento {

    private int NumCartaoCredito;
    private int id;
    private static final Map<Integer, Credito> credito = new HashMap<>();

    public Credito(TiposPagamento tipo, int id, int fkProduto, int fkCliente, double valor, int parcelas, int NumCartaoCredito) {
        super(id, fkProduto, fkCliente, valor, parcelas);
        this.NumCartaoCredito = NumCartaoCredito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCartaoCredito() {
        return NumCartaoCredito;
    }

    public void setNumCartaoCredito(int NumCartaoCredito) {
        this.NumCartaoCredito = NumCartaoCredito;
    }

    public static Map<Integer, Credito> getMapCredito() {
        return credito;
    }

}
