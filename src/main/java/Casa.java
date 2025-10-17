public class Casa extends Imovel {

    private boolean possuiQuintal;

    public Casa(String endereco, int numero, Proprietario proprietario, double valorAluguel, boolean possuiQuintal) {
        super(endereco, numero, proprietario, valorAluguel);
        this.possuiQuintal = possuiQuintal;
    }

    public boolean isPossuiQuintal() {
        return possuiQuintal;
    }

    public void setPossuiQuintal(boolean possuiQuintal) {
        this.possuiQuintal = possuiQuintal;
    }

    @Override
    public String estaAlugado() {
        if (isAlugado()) {
            return "A casa localizada em " + getEndereco() + " está alugada.";
        } else {
            return " A casa localizada em " + getEndereco() + " está disponivel para aluguel.";
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

    @Override
    public void exibirInformacoes() {
        System.out.println("===== CASA ======");
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Valor do aluguel: R$ " + getValorAluguel());
        System.out.println("Possui quintal: " + (possuiQuintal ? "Sim" : "Não"));
        System.out.println(getProprietario().exibirInfo());
        System.out.println(estaAlugado());
        System.out.println();
    }

}
