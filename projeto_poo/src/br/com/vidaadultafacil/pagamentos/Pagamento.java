package br.com.vidaadultafacil.pagamentos;

import java.util.HashMap;
import java.util.Map;

public class Pagamento {

    private int id;
    private int fkProduto;
    private int fkCliente;
    private double valor;  
    private int parcelas;

    //Map
    private static final Map<Integer, Pagamento> pagamentos = new HashMap<>();

    // Construtor
    public Pagamento(int id, int fkProduto, int fkCliente, double valor, int parcelas) {
        this.id = id;
        this.fkProduto = fkProduto;
        this.fkCliente = fkCliente;
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        if (parcelas <= 0) {
            throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que zero.");
        }
        this.parcelas = parcelas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    public static Map<Integer, Pagamento> getMapaPagamentos() {
        return pagamentos;
    }

    // Sobrescrita
    @Override
    public String toString() {
        return "Pagamento [id=" + id + ", fkProduto=" + fkProduto + ", fkCliente=" + fkCliente 
                + ", valor=" + valor 
                + ", parcelas=" + parcelas + "]";
    }
}
