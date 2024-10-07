package br.com.vidaadultafacil.io;

import br.com.aula_poo.utils.Util;
import br.com.vidaadultafacil.pagamentos.Boleto;
import br.com.vidaadultafacil.pagamentos.Credito;
import br.com.vidaadultafacil.pagamentos.Debito;
import br.com.vidaadultafacil.pagamentos.Pagamento;
import br.com.vidaadultafacil.pagamentos.Pix;
import br.com.vidaadultafacil.pagamentos.TiposPagamento;
import br.com.vidaadultafacil.pedidos.Carrinho;
import br.com.vidaadultafacil.pedidos.HistoricoCompra;
import br.com.vidaadultafacil.suporte.Suporte;
import br.com.vidaadultafacil.tela_inicial.Avaliacao;
import br.com.vidaadultafacil.tela_inicial.CategoriaProdutos;
import br.com.vidaadultafacil.tela_inicial.Produto;
import br.com.vidaadultafacil.usuarios.Administrador;
import br.com.vidaadultafacil.usuarios.Cliente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;


public class LeitorArquivo {
    static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) {
		BufferedReader buffRead;
		try {
			buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
			String linha = "";

			while (true) { 
				linha = buffRead.readLine();

				if(linha != null) {
					String[] dados = linha.split(";");

					if (dados[0].equalsIgnoreCase("Cliente")){
						Cliente clientes = new Cliente(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5], dados[6]);
						clientes.getMapClientes().put(dados[1], clientes);
					}
					else if (dados[0].equalsIgnoreCase("Administrador")) {
						Administrador admin = new Administrador(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5], Boolean.parseBoolean(dados[6]));
						Administrador.getMapAdmin().put(dados[1], admin);
					}
					else if (dados[0].equalsIgnoreCase("Produto")) {
						Produto prod = new Produto(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), dados[3], dados[4], dados[5], Double.parseDouble(dados[6]), Integer.parseInt(dados[7]));
						prod.getMapProdutos().put(Integer.parseInt(dados[1]), prod);	
					}
					else if (dados[0].equalsIgnoreCase("Avaliacao")) {
						Avaliacao aval = new Avaliacao(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Double.parseDouble(dados[3]), dados[4]);
						aval.getMapAvaliacao().put(Integer.parseInt(dados[1]), aval);
					}
					else if (dados[0].equalsIgnoreCase("CategoriaProdutos")) {
						CategoriaProdutos CatProd = new CategoriaProdutos(Integer.parseInt(dados[1]), dados[2], dados[3]);
						CatProd.getMapCateProd().put(Integer.parseInt(dados[1]), CatProd);
					}
					else if (dados[0].equalsIgnoreCase("Suporte")) {
						Suporte sup = new Suporte(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), dados[3]);
						sup.getMapSuporte().put(Integer.parseInt(dados[1]), sup);
					}
					else if (dados[0].equalsIgnoreCase("Carrinho")) {
						Carrinho carrinho = new Carrinho(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]));
						carrinho.getMapCarrinho().put(Integer.parseInt(dados[1]), carrinho);
					}
					else if (dados[0].equalsIgnoreCase("HistoricoCompra")) {
						HistoricoCompra hisComp = new HistoricoCompra(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
						HistoricoCompra.getHistoricoCompras().put(Integer.parseInt(dados[1]), hisComp);
					}
					else if (dados[0].equalsIgnoreCase("Pagamento")) {
						Pagamento Pagam = new Pagamento(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), Integer.parseInt(dados[5]));
						Pagam.getMapaPagamentos().put(Integer.parseInt(dados[1]), Pagam);
					}
					else if (dados[0].equalsIgnoreCase(TiposPagamento.DEBITO.getTipo())) {
						Debito debito = new Debito(TiposPagamento.DEBITO, Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6]));
						Debito.getMapDebito().put(Integer.parseInt(dados[1]), debito);
					}
					else if (dados[0].equalsIgnoreCase(TiposPagamento.CREDITO.getTipo())) {
						Credito credito = new Credito(TiposPagamento.CREDITO, Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Integer.parseInt(dados[6]));
						Credito.getMapCredito().put(Integer.parseInt(dados[1]), credito);
					}
					else if (dados[0].equalsIgnoreCase(TiposPagamento.PIX.getTipo())) {
						Pix pix = new Pix(TiposPagamento.PIX, Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Long.parseLong(dados[6]));
						Pix.getMapPix().put(Integer.parseInt(dados[1]), pix);
					}
					else if (dados[0].equalsIgnoreCase(TiposPagamento.BOLETO.getTipo())) {
						Boleto boleto = new Boleto(TiposPagamento.BOLETO, Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), Integer.parseInt(dados[5]), Long.parseLong(dados[6]));
						Boleto.getMapBoleto().put(Integer.parseInt(dados[1]), boleto);
					}
				} else {
					break;
				}
			}
			buffRead.close();
		} catch (FileNotFoundException e) {
			String result = "Arquivo não encontrado no caminho " + PATH_BASICO + path + EXTENSAO;
			Util.setupLogger().log(Level.INFO, result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
