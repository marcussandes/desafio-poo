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

    @Override
    public double calcularAluguel(int meses) {
        double valorBase = super.calcularAluguel(meses);
        double desconto = 0.0;

        if (meses > 12) {
            desconto = valorBase * 0.10;
            System.out.println("(Aplicado desconto de 10% para aluguel acima de 12 meses)");
            double descontoMes = (valorBase - desconto) / meses;
            System.out.println("Por mês o valor sai: R$ " + descontoMes);
        }
        return valorBase - desconto;
    }


    public void exibirInformacoes() {
        System.out.println("===== APARTAMENTO =====");
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Número apartamento: " + numeroApartamento);
        System.out.println("Andar: " + andar);
        System.out.println("Valor do aluguel: R$ " + getValorAluguel());
        System.out.println("Possui garagem: " + (possuiGaragem ? "Sim" : "Não"));
        System.out.println(contatoProprietario());

        if (this.isAlugado()) {
            Inquilino inquilino = this.getInquilino();
            if (inquilino != null) {
                System.out.println("_____________________________");
                System.out.println("ALUGADO PARA: " + inquilino.exibirInfo());
                System.out.println("_____________________________");
            }
        }

    }
}
