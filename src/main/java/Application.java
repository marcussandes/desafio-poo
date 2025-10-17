import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static ArrayList<Imovel> imoveis = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CORRETORA IMOBILIARIA MS =====");
            System.out.println("1 - Cadastrar Casa");
            System.out.println("2 - Cadastrar Apartamento");
            System.out.println("3 - Listar Imóveis");
            System.out.println("4 - Alugar/Disponibilizar Imóvel");
            System.out.println("5 - Calcular valor total do aluguel");
            System.out.println("6 - Remover Imóvel");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCasa();
                case 2 -> cadastrarApartamento();
                case 3 -> listarImoveis();
                case 4 -> alterarStatusAluguel();
                case 5 -> calcularValorAluguel();
                case 6 -> removerAluguel();
                case 0 -> System.out.println("Encerrando o sistema!");
                default -> System.out.println("Opção inválida! Tente novamente, por favor.");
            }

        } while (opcao != 0);
    }

    private static void cadastrarCasa() {
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Numero: ");
        int numero = sc.nextInt();
        sc.nextLine();

        System.out.print("Valor do aluguel: ");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nome do proprietário: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        boolean possuiQuintal = false;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Possui quintal? (Sim/Não): ");
            String resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("Sim")) {
                possuiQuintal = true;
                entradaValida = true;
            } else if (resposta.equalsIgnoreCase("Não") || resposta.equalsIgnoreCase("Nao")) {
                possuiQuintal = false;
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 'Sim' ou 'Não'.");
            }

        }

        Proprietario proprietario = new Proprietario(nome, telefone, cpf);

        Casa novaCasa = new Casa(endereco, numero,  proprietario, valor, possuiQuintal);
        imoveis.add(novaCasa);

        System.out.println("Casa cadastrada com sucesso!");
    }

    private static void cadastrarApartamento() {
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Numero do apartamento: ");
        int numeroApartamento = sc.nextInt();

        System.out.print("Andar: ");
        int andar = sc.nextInt();
        sc.nextLine();

        System.out.print("Valor do aluguel: ");
        double valorAluguel = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nome do proprietário: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();



        boolean possuiGaragem = false;
        boolean entradaValida = false;


        while (!entradaValida) {
            System.out.print("Possui garagem? (Sim/Não): ");
            String resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("Sim")) {
                possuiGaragem = true;
                entradaValida = true;
            } else if (resposta.equalsIgnoreCase("Não") || resposta.equalsIgnoreCase("Nao")) {
                possuiGaragem = false;
                entradaValida = true;
            } else {
                System.out.println("Opção inválida. Por favor, digite 'Sim' ou 'Não'.");
            }
        }

        Proprietario proprietario = new Proprietario(nome, telefone, cpf);



        Apartamento ap = new Apartamento(endereco, numeroApartamento, proprietario, valorAluguel, numeroApartamento, andar, possuiGaragem);
        imoveis.add(ap);

        System.out.println("Apartamento cadastrado com sucesso!");

    }

    private static void listarImoveis() {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imovel cadastrado!");
            return;
        }

        for (int i = 0; i < imoveis.size(); i++) {
            Imovel imovel = imoveis.get(i);

            System.out.println("=================================");
            System.out.println("|| ÍNDICE DO IMÓVEL: [" + i + "] ||");
            System.out.println("=================================");
            imovel.exibirInformacoes();
        }
    }

    private static void alterarStatusAluguel() {
        listarImoveis();

        System.out.println("Informe o indice do imovel para alterar o status - começando em 0: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice >= 0 && indice < imoveis.size()) {
            Imovel imovel = imoveis.get(indice);
            if (imovel.isAlugado()) {
                imovel.setAlugado(false);
                imovel.setInquilino(null);
                System.out.println("Imóvel desocupado e disponivel para aluguel.");
            } else {
                System.out.println("\n--- Dados do novo inquilino ---");
                System.out.print("Nome do inquilino: ");
                String nomeInquilino = sc.nextLine();

                System.out.print("Telefone do inquilino: ");
                String tellInquilino = sc.nextLine();

                System.out.print("CPF do inquilino: ");
                String cpfInquilino = sc.nextLine();

                Inquilino novoInquilino = new Inquilino(nomeInquilino, tellInquilino, cpfInquilino);

                imovel.setInquilino(novoInquilino);
                imovel.setAlugado(true);

                System.out.println("Imovel alugado com sucesso para " + nomeInquilino + ".");
            }
    } else {
            System.out.println("Indice inválido!");
        }
    }

    private static void calcularValorAluguel() {
        listarImoveis();

        System.out.println("Informe o indice do imóvel: ");
        int indice = sc.nextInt();

        if (indice >= 0 && indice < imoveis.size()) {
            Imovel imovel = imoveis.get(indice);
            System.out.println("Informe o periodo (em meses) para o calculo do aluguel: ");
            int meses = sc.nextInt();

            System.out.println("Valor total do aluguel R$ " + imovel.calcularAluguel(meses));

        } else {
            System.out.println("Indice inválido!");
        }
    }

    private static void removerAluguel() {
        listarImoveis();

        System.out.println("Informe o indice do imóvel a remover: ");
        int indice = sc.nextInt();

        if (indice >=0 && indice < imoveis.size()) {
            imoveis.remove(indice);
            System.out.println("Imóvel removido com sucesso!");
        } else {
            System.out.println("indice inválido!");
        }
    }




}
