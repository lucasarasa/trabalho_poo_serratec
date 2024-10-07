package br.com.vidaadultafacil.pedidos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrinhoProduto {
    int id;
    int FkCarrinho;
    int FkProduto;
   private List<CarrinhoProduto> carrinhoProdutos; 
    private static final Map<Integer, CarrinhoProduto> mapacarrinhoProdutos = new HashMap();
    public CarrinhoProduto(int id, int fkCarrinho, int fkProduto) {
        this.id = id;
        FkCarrinho = fkCarrinho;
        FkProduto = fkProduto;
    }

    public CarrinhoProduto(int fkCarrinho, int fkProduto) {
        this.id = mapacarrinhoProdutos.size() + 1;
        FkCarrinho = fkCarrinho;
        FkProduto = fkProduto;
    }
    
    public int getId() {
        return id;
    }

    public int getFKCarrinho() {
        return FkCarrinho;
    } 

    public int getFkProduto() {
        return FkProduto;
    }
    
   
    public static Map<Integer, CarrinhoProduto> getMapCarrinhoProdutos() {
        return mapacarrinhoProdutos;
    }
}
