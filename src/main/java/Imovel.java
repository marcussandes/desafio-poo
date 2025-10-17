public abstract class Imovel {

    protected String endereco;
    protected int numero;
    protected boolean alugado;
    protected Proprietario proprietario;
    protected double valorAluguel;

    public Imovel(String endereco, int numero, Proprietario proprietario, double valorAluguel) {
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.valorAluguel = valorAluguel;
        this.alugado = false;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public abstract String estaAlugado();

    public double calcularAluguel(int meses) {
        return(int) (valorAluguel * meses);
    }

    public String contatoProprietario() {
        if (proprietario != null) {
            return "Proprietário: " + proprietario.getNome() +
                    " | Telefone: " + proprietario.getTelefone() +
                    " | CPF: " + proprietario.getCpf();
        } else {
            return "Sem proprietário cadastrado";
        }
    }


    public abstract void exibirInformacoes();
}
