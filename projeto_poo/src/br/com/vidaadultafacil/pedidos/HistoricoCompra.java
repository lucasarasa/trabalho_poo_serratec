package br.com.vidaadultafacil.pedidos;

import br.com.vidaadultafacil.usuarios.Cliente;
import java.util.HashMap;
import java.util.Map;

public class HistoricoCompra {

	// Chave primária
	private int id;	

	// Chave Estrangeira
	private int fkProduto;
	private int fkCliente;
	private int fkPagamento;

	// Identificação do pedido
	int idPedido;

	// Usuário que realizou o pedido
	Cliente usuario;
	//Map
	private static final Map<Integer, HistoricoCompra> historicoCompras = new HashMap<>();
	
	public HistoricoCompra() {
		
	}

	public HistoricoCompra(int id, int fkProduto, int fkCliente, int fkPagamento, int idPedido, Cliente usuario) {
		super();
		this.id = id;
		this.fkProduto = fkProduto;
		this.fkCliente = fkCliente;
		this.fkPagamento = fkPagamento;
		this.idPedido = idPedido;
		this.usuario = usuario;
	}

	public HistoricoCompra(int int1, int int2, int int3, int int4, int int5) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public int getFkProduto() {
		return fkProduto;
	}

	public int getFkCliente() {
		return fkCliente;
	}

	public int getFkPagamento() {
		return fkPagamento;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public Cliente getUsuario() {
		return usuario;
	}

	public static Map<Integer, HistoricoCompra> getHistoricoCompras() {
		return historicoCompras;
	}

	@Override
	public String toString() {
		return "HistoricoCompra [id=" + id + ", fkProduto=" + fkProduto + ", fkCliente=" + fkCliente + ", fkPagamento="
				+ fkPagamento + ", idPedido=" + idPedido + ", usuario=" + usuario + "]";
	}
	
}