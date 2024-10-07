package br.com.vidaadultafacil.usuarios;
import java.util.logging.Logger;
public abstract class Usuario {
	// Chave primária
	protected int id;

	protected String nome;
	protected String email;
	protected String senha;
	protected String telefone;
	private static Logger logger = Logger.getLogger(Usuario.class.getName());
	public Usuario() {
	}

	// Método Construtor
	public Usuario(String nome, String email, String senha, String telefone) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.trim().isEmpty()) {
		this.nome = nome;
		} else {
			logger.info("Nome não pode ser vazio ou nulo.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.trim().isEmpty()) {
		this.email = email;
	} else { 
		logger.info("Email não pode ser vazio ou nulo.");
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null && !senha.trim().isEmpty()) {
		this.senha = senha;
	} else {
		logger.info("Senha não pode ser vazia ou nula.");
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone != null && !telefone.trim().isEmpty()) {
		this.telefone = telefone;
	} else {
		logger.info("Telefone não pode ser vazio ou nulo.");
		}
	}

	public int getIdUsuario() {
		return id;
	}

	public void setIdUsuario(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario{" + ", nome='" + nome + '\'' + ", email='" + email + '\'' + ", senha='" + senha + '\''
				+ ", telefone='" + telefone + '\'' + '}';
	}
}
