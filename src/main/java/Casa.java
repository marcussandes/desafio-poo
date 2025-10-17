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
