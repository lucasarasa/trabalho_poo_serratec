package br.com.vidaadultafacil.sistema;

import br.com.aula_poo.utils.Util;
import br.com.vidaadultafacil.io.EscritorArquivo;
import br.com.vidaadultafacil.usuarios.Administrador;
import br.com.vidaadultafacil.usuarios.CadastroNovo;
import br.com.vidaadultafacil.usuarios.Cliente;
import java.util.Scanner;
import java.util.logging.Logger;

public class Menu implements MenuInterface  {
	
	private static Logger logger = Logger.getLogger(Util.class.getName());
	Scanner sc = new Scanner(System.in);

	@Override
	public void menu() {

		boolean autenticado = false;
		Menu menu = new Menu();	
		MenuLogo menuLogo = new MenuLogo();
		

		try {
		
			char op;
			menuLogo.menuLogo();
			logger.info("\n\t\t\t EASY ADULT LIFE\n\t\t\t-------------------\n\tTornando a vida independente descomplicada e acessivel!\n");
			logger.info("Digite como gostaria de ser chamado(a):");
			String nome = sc.next();

			String mensagemBemvindo = String.format("Bem vindo(a) %s voce deseja acessar o sistema como CLIENTE ou ADMINISTRADOR?\n", nome);
			logger.info(mensagemBemvindo);
			logger.info("\n(1) CLIENTE\n(2) ADMINISTRADOR");
			int opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
				case 1:
					logger.info("\n(1) Acessar sua conta\n(2) Cadastro");
					int opcaoCliente = sc.nextInt();

					switch (opcaoCliente) {
						case 1:
							logger.info("\nVoce escolheu acessar sua conta.\nAguarde");
							Thread.sleep(2000);

							while(autenticado == false){
								logger.info("Digite seu email: ");
								String email = sc.next();
								logger.info("Digite sua senha: ");
								String senha = sc.next();
								autenticado = Cliente.login(email, senha);
								if(autenticado == true){
									MenuCliente menuCliente = new MenuCliente();
									menuCliente.menu();
								}
							}							
							break;
						case 2:
							logger.info("\n\nVocê escolheu se cadastrar.\n\n");						
							CadastroNovo cadastroNv = new CadastroNovo();
							EscritorArquivo escArq = new EscritorArquivo();
							escArq.salvarCadastroEmArquivo(cadastroNv.criarCadastro());
							Thread.sleep(2000);		
							MenuCliente menuCliente = new MenuCliente();
							menuCliente.menu();
							break;
						default:
							logger.info("Opção inválida.");
							menu.menu();
							break;
					}
					break;

				case 2:
					logger.info("\nVoce escolheu acessar o sistema como administrador\n");
					Thread.sleep(2000);
					
					while(autenticado == false){
						logger.info("Digite seu email: ");
						String email = sc.next();
						logger.info("\nDigite sua senha: ");
						String senha = sc.next();
						autenticado = Administrador.login(email, senha);
						if(autenticado == true){
							MenuAdmin menuAdmin = new MenuAdmin();
							menuAdmin.menu();
						}
					}	
					break;

				default:
					logger.info("Opção inválida.");
					break;
			}
			sc.close();
		} catch(InterruptedException e){
			logger.info("Erro contagem de tempo...");	
		}
    }
}
