package br.com.vidaadultafacil.io;

import br.com.aula_poo.utils.Util;
import br.com.vidaadultafacil.suporte.Suporte;
import br.com.vidaadultafacil.tela_inicial.Avaliacao;
import br.com.vidaadultafacil.tela_inicial.Produto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Relatorio {

	private static Logger logger = Logger.getLogger(Relatorio.class.getName());
	public static void relatorioCliente(char op2) {
                        
        if (op2 == 'P') {
            Util.setupLogger().log(Level.INFO, "__________INICIO__________\n");
            LocalDateTime data = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Util.setupLogger().log(Level.INFO, data.format(formato));
            for (Map.Entry<Integer, Produto> prod : Produto.getMapProdutos().entrySet()) {
                Util.setupLogger().log(Level.INFO, "\nNumero do Produto: " + prod.getValue().getId() + "\nNome do Produto:" + prod.getValue().getNome() + "\nDescricao do Produto: " + prod.getValue().getDescricaoProd() + "\nAutor: " + prod.getValue().getAutor() + "\nPreco: " + prod.getValue().getPreco() + " R$" + "\nDuracao: " + prod.getValue().getDuracao() + " min");
            }
                Util.setupLogger().log(Level.INFO, "\n__________FIM__________\n\n");
        
        } else if (op2 == 'A') {
            Util.setupLogger().log(Level.INFO, "__________INICIO__________\n");
            LocalDateTime data = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            Util.setupLogger().log(Level.INFO, data.format(formato));
            for(Map.Entry<Integer, Avaliacao> aval : Avaliacao.getMapAvaliacao().entrySet()) {
                Util.setupLogger().log(Level.INFO, "\nNota: " + aval.getValue().getNota() + "\nComentario: " + aval.getValue().getComentario() +  "\nProduto: " + aval.getValue().getFkProduto() + "\n\n");
            }
            Util.setupLogger().log(Level.INFO, "\n__________FIM__________\n\n");
        }     
    }

    public static void relatorioAdmin(char op){

        String nome = "relatorio_admin";
        boolean verificador = true;
        Scanner sc = new Scanner(System.in);

        while (verificador == true) { 
            Util.setupLogger().log(Level.INFO, "Deseja visualizar os relatorios ou sair?\n[1]Visualizar\n[2]Sair\n");
            char opcao = sc.next().charAt(0);

            if(opcao == '2'){
                verificador = false;
            } else {
                try {
                    BufferedWriter buffWrite = new BufferedWriter(new FileWriter(LeitorArquivo.PATH_BASICO + nome + LeitorArquivo.EXTENSAO, true));
        
                    if(op == 'T'){
                        Util.setupLogger().log(Level.INFO, "\tMenu\n[P]Produtos\t[A]Avaliacoes\n[S]Suporte\n");
                        char op2 = sc.next().charAt(0);
        
                        if (op2 == 'P') {
                            Util.setupLogger().log(Level.INFO, "__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            Util.setupLogger().log(Level.INFO, data.format(formato));
                            for (Map.Entry<Integer, Produto> prod : Produto.getMapProdutos().entrySet()) {
                                Util.setupLogger().log(Level.INFO, "\nNome do Produto: " + prod.getValue().getNome() + "\nDescricao do Produto: " + prod.getValue().getDescricaoProd() + "\nAutor: " + prod.getValue().getAutor() + "\nPreco: " + prod.getValue().getPreco() + "\nDuracao: " + prod.getValue().getDuracao() + "\n\n");
                            }
                            Util.setupLogger().log(Level.INFO, "\n__________FIM__________\n\n");
        
                        } else if (op2 == 'A') {
                            Util.setupLogger().log(Level.INFO, "__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            Util.setupLogger().log(Level.INFO, data.format(formato));
                            for(Map.Entry<Integer, Avaliacao> aval : Avaliacao.getMapAvaliacao().entrySet()) {
                                Util.setupLogger().log(Level.INFO, "\nNota: " + aval.getValue().getNota() + "\nComentario: " + aval.getValue().getComentario() + "\nProduto: " + aval.getValue().getFkProduto() + "\n\n");
                            }
                            Util.setupLogger().log(Level.INFO, "\n__________FIM__________\n\n");
        
                        } else if (op2 == 'S') {
                            Util.setupLogger().log(Level.INFO, "__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            Util.setupLogger().log(Level.INFO, data.format(formato));
                            for(Map.Entry<Integer, Suporte> sup : Suporte.getMapSuporte().entrySet()) {
                                Util.setupLogger().log(Level.INFO, "\nMensagem: " + sup.getValue().getMensagem() + "\n\n");
                            }
                            Util.setupLogger().log(Level.INFO, "\n__________FIM__________\n\n");
                        }
        
                    } else if(op == 'I'){
                        Util.setupLogger().log(Level.INFO, "\tMenu\n[P]Produtos\t[A]Avaliacoes\n[S]Suporte\n");
                        char op2 = sc.next().charAt(0);
        
                        if (op2 == 'P') {
                            buffWrite.append("__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            buffWrite.append(data.format(formato));
                            for (Map.Entry<Integer, Produto> prod : Produto.getMapProdutos().entrySet()) {
                                buffWrite.append("\nNome do Produto: " + prod.getValue().getNome() + "\nDescricao do Produto: " + prod.getValue().getDescricaoProd() + "\nAutor: " + prod.getValue().getAutor() + "\nPreco: " + prod.getValue().getPreco() + "\nDuracao: " + prod.getValue().getDuracao() + "\n\n");
                            }
                            buffWrite.append("\n__________FIM__________\n\n");
                            buffWrite.close();
                            logger.info("Relatorio gerado com sucesso!");
        
                        } else if (op2 == 'A') {
                            buffWrite.append("__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            buffWrite.append(data.format(formato));
                            for(Map.Entry<Integer, Avaliacao> aval : Avaliacao.getMapAvaliacao().entrySet()) {
                                buffWrite.append("\nNota: " + aval.getValue().getNota() + "\nComentario: " + aval.getValue().getComentario() + "\nProduto: " + aval.getValue().getFkProduto() + "\n\n");
                            }
                            buffWrite.append("\n__________FIM__________\n\n");
                            buffWrite.close();
                            logger.info("Relatorio gerado com sucesso!");
        
                        } else if (op2 == 'S') {
                            buffWrite.append("__________INICIO__________\n");
                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            buffWrite.append(data.format(formato));
                            for(Map.Entry<Integer, Suporte> sup : Suporte.getMapSuporte().entrySet()) {
                                buffWrite.append("\nMensagem: " + sup.getValue().getMensagem() + "\n\n");
                            }
                            buffWrite.append("\n__________FIM__________\n\n");
                            buffWrite.close();
                            logger.info("Relatorio gerado com sucesso!");
                        }
                    }
                    verificador = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }	
}