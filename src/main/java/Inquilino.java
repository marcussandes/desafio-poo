public class Inquilino {

    private final String nome;
    private final String telefone;
    private final String cpf;

    public Inquilino(String nome, String telefone, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String exibirInfo() {
        return "Proprietario: " + nome +
                " | Telefone: " + telefone +
                " | CPF: " + cpf;
    }
}

