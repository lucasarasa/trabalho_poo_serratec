package br.com.vidaadultafacil.sistema;

import br.com.vidaadultafacil.io.LeitorArquivo;

public class Principal {
	
	public static void main(String[] args) throws InterruptedException {
		
		LeitorArquivo.leitor("Banco");
		Menu menu = new Menu();
		menu.menu();
	}
}