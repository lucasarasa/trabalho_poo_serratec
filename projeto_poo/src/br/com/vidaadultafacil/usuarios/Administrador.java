package br.com.vidaadultafacil.usuarios;
import br.com.aula_poo.utils.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Administrador extends Usuario {
	private int id;
	boolean isAdmin;
	private static Logger logger = Util.setupLogger();
	private static final Map<String, Administrador> admins = new HashMap<>();
	
	public Administrador() {
	}

	public Administrador(int id, String nome, String email, String senha, String telefone, boolean isAdmin) {
		super(nome, email, senha, telefone);
		this.id = id;
		this.isAdmin = isAdmin;
		admins.put(email, this);
	}

	public Administrador(String nome, String email, String senha, String telefone, boolean isAdmin) {
		super(nome, email, senha, telefone);
		this.id = admins.size() + 1;
		this.isAdmin = isAdmin;
		admins.put(email, this);
	}

	public boolean getisAdmin() {
		return isAdmin;
	}

	public int getId() {
		return id;
	}

	//Método autenticação
	public static boolean login(String email, String senha) {
        Administrador admin = admins.get(email);
        if (admin != null && admin.getSenha().equals(senha)) {
            logger.info("\nLogin bem-sucedido!\n");
            return true;
        } else {
            logger.info("\nCredenciais invalidas!\n");
            return false;
        }
    }

	public static Map<String, Administrador> getMapAdmin() {
        return admins;
    }

	public String toDbLine() {
		return String.format("Administrador;%s;%s\n", this.nome, this.email, this.senha, this.telefone, this.isAdmin);
	}

	public String toString() {
		return "Admin{" + "nome='" + getNome() + '\'' + ", email='" + getEmail() + '\'' + ", isAdmin=" + isAdmin + '}';
	}
}