package br.com.vidaadultafacil.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class Boleto extends Pagamento {

    private long NumBoleto;
    private int id;
    private static final Map<Integer, Boleto> boleto = new HashMap<>();

    public Boleto(TiposPagamento tipo, int id, int fkProduto, int fkCliente, double valor, int parcelas, long NumBoleto) {
        super(id, fkProduto, fkCliente, valor, parcelas);
        this.NumBoleto = NumBoleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumBoleto() {
        return NumBoleto;
    }

    public void setNumBoleto(int NumBoleto) {
        this.NumBoleto = NumBoleto;
    }

    public static Map<Integer, Boleto> getMapBoleto() {
        return boleto;
    }

}
