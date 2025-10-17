public class Apartamento extends Imovel {

    private int numeroApartamento;
    private int andar;
    private boolean possuiGaragem;

    public Apartamento(String endereco, int numero, Proprietario proprietario, double valorAluguel, int numeroApartamento, int andar, boolean possuiGaragem) {
        super(endereco, numero, proprietario, valorAluguel);
        this.numeroApartamento = numeroApartamento;
        this.andar = andar;
        this.possuiGaragem = possuiGaragem;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public boolean isPossuiGaragem() {
        return possuiGaragem;
    }

    public void setPossuiGaragem(boolean possuiGaragem) {
        this.possuiGaragem = possuiGaragem;
    }

    @Override
    public String estaAlugado() {
        if (isAlugado()) {
            return "O apartamento número " + numeroApartamento + " está alugado.";
        } else {
            return "O apartamento número " + numeroApartamento + " está disponivel para alugar.";
        }
    }

    public void exibirInformacoes() {
        System.out.println("===== APARTAMENTO =====");
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Número apartamento: " + numeroApartamento);
        System.out.println("Andar: " + andar);
        System.out.println("Valor do aluguel: R$ " + getValorAluguel());
        System.out.println("Possui garagem: " + (possuiGaragem ? "Sim" : "Não"));
        System.out.println(contatoProprietario());
        System.out.println(estaAlugado());
    }
}
