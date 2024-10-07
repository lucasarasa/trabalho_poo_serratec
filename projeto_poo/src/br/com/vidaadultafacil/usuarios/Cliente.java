package br.com.vidaadultafacil.usuarios;

import br.com.aula_poo.utils.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Cliente extends Usuario {
	private static Logger logger = Util.setupLogger();
    // Chave primária
    private int id;
    private String cpf = "";
    private boolean cpfValido = false;
    private static final Map<String, Cliente> clientes = new HashMap<>();

    public Cliente(int id, String nome, String email, String senha, String telefone, String cpf) {
        super(nome, email, senha, telefone);
        this.id = id;
        this.cpf = cpf;
        clientes.put(email, this);
    }

    public Cliente(String nome, String email, String senha, String telefone, String cpf) {
        super(nome, email, senha, telefone);
        this.id = clientes.size() + 1;
        this.cpf = cpf;
        clientes.put(email, this);
    }

    public void setCpf(String cpf) {
        while (!cpfValido) {            
            if (cpf != null) {
                String cpfNumeros = cpf.replaceAll("\\D", "");

                // Verifica se o CPF tem 11 dígitos
                if (cpfNumeros.length() == 11) {
                    this.cpf = cpfNumeros;
                    cpfValido = true;
                } else {
                    logger.info("CPF deve conter exatamente 11 dígitos. Tente novamente.");
                }
            } else {
                logger.info("CPF não pode ser nulo. Tente novamente.");
            }
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Map<String, Cliente> getMapClientes() {
        return clientes;
    }

    // realizar login
    public static boolean login(String email, String senha) {
        Cliente cliente = clientes.get(email);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            logger.info("\nLogin bem-sucedido!");
            return true;
        } else {
            logger.info("\nCredenciais inválidas!");
            return false;
        }
    }

    public String toDbLine() {
        return String.format("Cliente;%s;%s;%s;%s;%s\n", this.nome, this.email, this.senha, this.telefone, this.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
