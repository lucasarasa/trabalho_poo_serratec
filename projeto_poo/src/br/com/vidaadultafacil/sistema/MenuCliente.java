package br.com.vidaadultafacil.sistema;

import br.com.aula_poo.utils.Util;
import br.com.vidaadultafacil.io.Relatorio;
import br.com.vidaadultafacil.pedidos.Carrinho;
import java.util.Scanner;
import java.util.logging.Logger;

public class MenuCliente implements MenuInterface  {

	private static Logger logger = Util.setupLogger();

	@Override
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		int opcao2;

		logger.info("\n\t\tSeja bem-vindo, \n");
		logger.info("\n\t\t\tMENU DO CLIENTE\n");
        logger.info("\n\t\tEscolha seu curso e comece viver melhor!\n\t\tPorque viver de miojo e so uma fase... certo?");
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.warning("Erro durante a pausa: " + e.getMessage());
        }

		while (escolha != 3) {  
			logger.info("\n(1) Lista de Produtos");
			logger.info("(2) Avaliacao");
			logger.info("(3) Sair");
			logger.info("Escolha uma opcao: ");
			escolha = scanner.nextInt();
			scanner.nextLine();
			switch (escolha) {
				
			case 1:
				logger.info("\n\tProdutos Disponiveis:\n");
				Relatorio.relatorioCliente('P');
				logger.info("\n\n\t\tDeseja comprar algum produto?\n");
				logger.info("(1) Sim\n(2) Nao");
				logger.info("Escolha uma opcao: ");
				opcao2 = scanner.nextInt();

				if (opcao2 == 1) {
					logger.info("\n\nEscolha o produto que deseja comprar: ");
					int idProduto = scanner.nextInt();
					Carrinho carrinho = new Carrinho(1);
					carrinho.adicionarProduto(idProduto);		
					logger.info("\nProduto adicionado ao carrinho com sucesso!\n");

					logger.info("\n\t\tDeseja finalizar a compra?\n");
					logger.info("(1) Sim\n(2) Nao, adicionar mais produtos");
					logger.info("Escolha uma opcao: ");
					int opcao3 = scanner.nextInt();

					if(opcao3 == 1) {
						logger.info("Obrigado por comprar conosco!\n");
						carrinho.finalizarCompra();
					} else {
						logger.info("Adicione mais produtos ao carrinho!\n");
						menu();
					}
				}
				break;
				
			case 2:			
					logger.info("Aguenta firme, ja vamos te salvar!) ");
	                try {
	                    Thread.sleep(3000);
						Relatorio.relatorioCliente('A');
	                } catch (InterruptedException e) {
	                    logger.warning("Erro durante a pausa: " + e.getMessage());
	                }
				break;
				
			case 3:
				logger.info("Saindo... Volte antes que o caos comece!");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    logger.warning("Erro durante a pausa: " + e.getMessage());
                }
                logger.info("\n\t\tObrigado por visitar a Easy Adult Life\n\n");
				break;
				
			default:
				logger.info("Opcao invalida! Por favor, escolha novamente.\n\n");
			}
		}
		scanner.close();
	}
}
