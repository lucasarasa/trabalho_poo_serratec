package br.com.vidaadultafacil.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class Pix extends Pagamento {

    private long chavePix;
    private int id;
    private static final Map<Integer, Pix> pix = new HashMap<>();

    public Pix(TiposPagamento tipo, int id, int fkProduto, int fkCliente, double valor, int parcelas, long chavePix) {
        super(id, fkProduto, fkCliente, valor, parcelas);
        this.chavePix = chavePix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getChavePix() {
        return chavePix;
    }

    public void setChavePix(int chavePix) {
        this.chavePix = chavePix;
    }

    public static Map<Integer, Pix> getMapPix() {
        return pix;
    }

}
