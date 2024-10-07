package br.com.vidaadultafacil.io;

import br.com.vidaadultafacil.tela_inicial.Produto;
import br.com.vidaadultafacil.usuarios.Cliente;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
public class EscritorArquivo {

    private static final String CAMINHO_ARQUIVO = "./temp/Banco.txt";
    private static final Set<Integer> idsExistentes = new HashSet<>();
    private static Logger logger = Logger.getLogger(EscritorArquivo.class.getName());
    // Carrega os IDs existentes do arquivo de banco (tanto de clientes quanto de produtos)
    public static void carregarIdsDoArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                // Verifica se há ao menos dois elementos na linha e se o segundo elemento é numérico
                if (dados.length > 1 && dados[1].matches("\\d+")) {
                    try {
                        int id = Integer.parseInt(dados[1]);  // O ID está no índice 1 da linha formatada
                        idsExistentes.add(id);
                    } catch (NumberFormatException e) {
                        logger.info("Erro ao converter ID para número na linha: " + linha);
                    }
                } else {
                    // Se não for possível processar a linha, loga ou ignora
                    logger.info("Linha inválida ou não contém ID: " + linha);
                }
            }
        } catch (IOException e) {
            logger.info("Erro ao carregar IDs do arquivo: " + e.getMessage());
        }
    }


    // Gera um ID único
    public static int gerarIdUnico() {
        int novoId = idsExistentes.size() + 1;
        while (idsExistentes.contains(novoId)) {
            novoId++;
        }
        idsExistentes.add(novoId);
        return novoId;
    }

    // Salva o cadastro de cliente ou produto no arquivo .txt
    public static void salvarCadastroEmArquivo(String linhaCadastro) {
        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {

            // Salva no formato: "TIPO;dados do cadastro"
            pw.println(linhaCadastro);

            logger.info("Informações foram salvas no arquivo " + CAMINHO_ARQUIVO);
        } catch (IOException e) {
            logger.info("Erro ao salvar as informações no arquivo: " + e.getMessage());
        }
    }

	public static void salvarCadastroClienteEmArquivo(Cliente novoCliente) {
		// TODO Auto-generated method stub
		
	}

	public static void salvarCadastroProdutoEmArquivo(Produto novoProduto) {
		// TODO Auto-generated method stub
		
	}
}
