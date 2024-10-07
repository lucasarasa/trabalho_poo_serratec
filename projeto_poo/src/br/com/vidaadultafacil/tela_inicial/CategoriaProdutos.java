package br.com.vidaadultafacil.tela_inicial;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class CategoriaProdutos {
		
	// Chave primária
	private int id;

	private int fkProduto;
	String categoria;
	String descricaoCat;

	private static final Map<Integer, CategoriaProdutos> catProd = new HashMap();
	private static Logger logger = Logger.getLogger(CategoriaProdutos.class.getName());
	public CategoriaProdutos() {
	}

	public CategoriaProdutos(int id, String categoria, String descricaoCat) {
		this.id = id;
		this.categoria = categoria;
		this.descricaoCat = descricaoCat;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		if (categoria!=null && !categoria.trim().isEmpty()) {
			this.categoria = categoria;			
		} else {
			logger.info("A categoria não pode ser vazia ou nulo.");
		}
	}

	public String getDescricaoCat() {
		return descricaoCat;
	}

	public void setDescricaoCat(String descricaoCat) {
		if(descricaoCat!=null && !descricaoCat.trim().isEmpty()){
			this.descricaoCat = descricaoCat;
		} else {
			logger.info("A descrição não pode ser vazia ou nulo.");
		}
	}

	public static Map<Integer, CategoriaProdutos> getMapCateProd() {
		return catProd;
	}

	public int getIdCategoria() {
		return id;
	}

	public void setIdCategoria(int idCategoria) {
		this.id = idCategoria;
	}

	public int getFkProduto() {
		return fkProduto;
	}
	
	@Override
	public String toString() {
		return "CategoriaProdutos [idCategoria=" + id + ", categoria=" + categoria + ", descricaoCat="
				+ descricaoCat + ", catProd=" + catProd + "]";
	}
}