package br.com.vidaadultafacil.usuarios;

import br.com.vidaadultafacil.io.EscritorArquivo;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.logging.Logger;
public class CadastroNovo {
	
	private static Logger logger = Logger.getLogger(CadastroNovo.class.getName());
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    Scanner scanner = new Scanner(System.in);
    
    // Valida o formato do e-mail
    public static boolean validarEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    // Valida o CPF 
    public static boolean validarCpf(String cpf) {
        String cpfNumeros = cpf.replaceAll("\\D", ""); // Remove qualquer não número
        return cpfNumeros.length() == 11;
    }

    // Cria um novo cadastro de cliente
    public String criarCadastro() {

        logger.info("Bem-vindo ao cadastro de novos clientes!");

        // Carregar IDs existentes antes de gerar um novo
        EscritorArquivo.carregarIdsDoArquivo();

        String nome;
        String email = null; 
        String senha;
        String telefone; 
        String cpf;

        // Entrada do nome
        logger.info("Digite seu nome: ");
        nome = scanner.nextLine();

        // Validação de email
        do {
            logger.info("Digite seu e-mail: ");
            email = scanner.nextLine();

            if (!validarEmail(email)) {
                logger.info("E-mail inválido. Por favor, insira um e-mail válido.");
            } else if (Cliente.getMapClientes().containsKey(email)) {
                logger.info("Este e-mail já está cadastrado. Por favor, use outro e-mail.");
                email = null;
            }
        } while (email == null || !validarEmail(email));

        // Entrada da senha
        logger.info("Digite uma senha: ");
        senha = scanner.nextLine();

        // Entrada do telefone
        logger.info("Digite seu telefone: ");
        telefone = scanner.nextLine();

        // Validação do CPF
        do {
            logger.info("Digite seu CPF (apenas números): ");
            cpf = scanner.nextLine();

            if (!validarCpf(cpf)) {
                logger.info("CPF inválido. Deve conter exatamente 11 dígitos.");
            }
        } while (!validarCpf(cpf));

        // Gera um ID único
        int novoId = EscritorArquivo.gerarIdUnico();

        // Cria um novo cliente com o ID gerado e adiciona ao mapa de clientes
        Cliente novoCliente = new Cliente(novoId, nome, email, senha, telefone, cpf);
        Cliente.getMapClientes().put(email, novoCliente);
        
        
        logger.info("Cadastro realizado com sucesso! Seu ID é: " + novoId);
        
        // Salva o cadastro no arquivo txt
        EscritorArquivo.salvarCadastroClienteEmArquivo(novoCliente);

//        scanner.close();  // Fechar o scanner após o uso
        String cl = "Cliente;" + novoId+";"+ nome+";"+ email+";"+ senha+";"+ telefone+";"+ cpf;
        return cl;
    }
}
