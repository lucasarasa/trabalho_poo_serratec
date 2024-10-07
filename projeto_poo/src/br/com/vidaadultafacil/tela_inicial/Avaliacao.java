package br.com.vidaadultafacil.tela_inicial;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Avaliacao {
    // Chave primária
    private int fkProduto;
    private int id;

    private double nota;
    private String comentario;
    private static final Map<Integer, Avaliacao> avaliacoes = new HashMap();
    private static Logger logger = Logger.getLogger(Avaliacao.class.getName());
    public Avaliacao() { 
    }

    public Avaliacao(int id ,int fkProduto, double nota, String comentario) {
        this.id = id;
    	this.fkProduto = fkProduto;
        this.nota = nota;
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public int getFkProduto() {
        return fkProduto;
    }

    public void setFkProduto(int fkProduto) {
        this.fkProduto = fkProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public static Map <Integer, Avaliacao> getMapAvaliacao() {
    	return avaliacoes;
    }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        } else {
            logger.info("Nota deve estar entre 0 e 10.");
        }
    }

    public void setComentario(String comentario) {
        if (comentario != null && !comentario.trim().isEmpty()) {
            this.comentario = comentario;
        } else {
            logger.info("Comentário não pode ser vazio ou nulo.");
        }
    }

    @Override
    public String toString() {
        return "Avaliacao [fkProduto=" + fkProduto + ", id=" + id + ", nota=" + nota + ", comentario=" + comentario
                + ", usuario=" + "]";
    }
}
