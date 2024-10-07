package br.com.vidaadultafacil.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class Debito extends Pagamento {

    private TiposPagamento tipo = TiposPagamento.DEBITO;
    private int NumCartaoDebito;
    private int id;
    private static final Map<Integer, Debito> debito = new HashMap<>();

    public Debito(TiposPagamento tipo, int id, int fkProduto, int fkCliente, double valor, int parcelas, int NumCartaoDebito) {
        super(id, fkProduto, fkCliente, valor, parcelas);
        this.NumCartaoDebito = NumCartaoDebito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumCartaoDebito() {
        return NumCartaoDebito;
    }

    public void setNumCartaoDebito(int NumCartaoDebito) {
        this.NumCartaoDebito = NumCartaoDebito;
    }

    public TiposPagamento getTipo() {
        return tipo;
    }

    public static Map<Integer, Debito> getMapDebito() {
        return debito;
    }

}
