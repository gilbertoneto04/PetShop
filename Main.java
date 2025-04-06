package Petshop;

import java.util.Scanner;

public class Main {
    private static SistemaPetshop sistema = new SistemaPetshop();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adicionando alguns dados iniciais para teste
        inicializarDadosTeste();

        System.out.println("<<< Bem-vindo ao Sistema de Petshop >>>");
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Login como Cliente");
            System.out.println("2 - Login como Funcionário");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1:
                    loginCliente();
                    break;
                case 2:
                    loginFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void loginCliente() {
        System.out.println("\n=== Login Cliente ===");
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (Cliente.login(usuario, senha)) {
            menuCliente(usuario);
        }
    }

    private static void loginFuncionario() {
        System.out.println("\n=== Login Funcionário ===");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        Funcionario funcionarioLogado = null;
        
        for (Funcionario f : sistema.getFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                funcionarioLogado = f;
                break;
            }
        }
        
        if (funcionarioLogado != null) {
            System.out.println("Bem-vindo, " + funcionarioLogado.getNome() + "!");
            
            if (funcionarioLogado instanceof Administrador) {
                menuAdministrador((Administrador) funcionarioLogado);
            } else if (funcionarioLogado instanceof Veterinario) {
                menuVeterinario((Veterinario) funcionarioLogado);
            } else {
                menuFuncionario(funcionarioLogado);
            }
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    private static void menuCliente(String usuario) {
        Cliente cliente = null;
        
        // Encontrar o cliente pelo usuário
        for (Cliente c : sistema.getClientes()) {
            if (c.getNome().equalsIgnoreCase(usuario)) {
                cliente = c;
                break;
            }
        }
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        while (true) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1 - Visualizar meus pets");
            System.out.println("2 - Visualizar tratamentos dos meus pets");
            System.out.println("0 - Logout");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    listarPetsCliente(cliente);
                    break;
                case 2:
                    visualizarTratamentosCliente(cliente);
                    break;
                case 0:
                    System.out.println("Logout realizado com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuFuncionario(Funcionario funcionario) {
        while (true) {
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("1 - Listar clientes");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Listar serviços disponíveis");
            System.out.println("4 - Listar ordens de serviço");
            System.out.println("0 - Logout");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    sistema.listarClientes();
                    break;
                case 2:
                    sistema.listarPacientes();
                    break;
                case 3:
                    sistema.listarServicos();
                    break;
                case 4:
                    sistema.listarOrdensServico();
                    break;
                case 0:
                    System.out.println("Logout realizado com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void menuVeterinario(Veterinario vet1) {
        while (true) {
            System.out.println("\n=== Menu Veterinário ===");
            System.out.println("1 - Visualizar pacientes");
            System.out.println("2 - Atualizar status de tratamento");
            System.out.println("3 - Gerar relatório de tratamentos");
            System.out.println("4 - Diagnosticar e prescrever tratamento");
            System.out.println("0 - Logout");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    vet1.visualizarPacientes(sistema);
                    break;
                case 2:
                    vet1.atualizarStatusTratamento(sistema);
                    break;
                case 3:
                    vet1.gerarRelatorio(sistema);
                    break;
                case 4:
                    vet1.diagnosticarEPrescreverTratamento(sistema);
                    break;
    
                case 0:
                    System.out.println("Logout realizado com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }


    private static void menuAdministrador(Administrador admin) {
        while (true) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1 - Listar funcionários");
            System.out.println("2 - Adicionar funcionário");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Listar pacientes");
            System.out.println("5 - Listar serviços disponíveis");
            System.out.println("6 - Adicionar serviço");
            System.out.println("7 - Listar ordens de serviço");
            System.out.println("8 - Gerar relatório de tratamentos");
            System.out.println("0 - Logout");
            System.out.print("Opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    sistema.listarFuncionarios();
                    break;
                case 2:
                    adicionarFuncionario(admin);
                    break;
                case 3:
                    sistema.listarClientes();
                    break;
                case 4:
                    sistema.listarPacientes();
                    break;
                case 5:
                    sistema.listarServicos();
                    break;
                case 6:
                    adicionarServico();
                    break;
                case 7:
                    sistema.listarOrdensServico();
                    break;
                case 8:
                    RelatorioTratamentos.gerarRelatorioTratamentos(sistema.getPacientes());
                    break;
                case 0:
                    System.out.println("Logout realizado com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void listarPetsCliente(Cliente cliente) {
        System.out.println("\n=== Meus Pets ===");
        boolean encontrou = false;
        
        for (Paciente p : sistema.getPacientes()) {
            if (p.getDono().equals(cliente)) {
                System.out.println("Nome: " + p.getNome() + " | Espécie: " + p.getEspecie() + " | Raça: " + p.getRaca());
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum pet cadastrado para este cliente.");
        }
    }

    private static void visualizarTratamentosCliente(Cliente cliente) {
        System.out.println("\n=== Tratamentos dos Meus Pets ===");
        boolean encontrou = false;
        
        for (Paciente p : sistema.getPacientes()) {
            if (p.getDono().equals(cliente) && !p.getTratamentos().isEmpty()) {
                System.out.println("Pet: " + p.getNome());
                for (Tratamento t : p.getTratamentos()) {
                    System.out.println(" - " + t.getDescricao() + " | Em andamento: " + (t.isEmAndamento() ? "Sim" : "Não"));
                }
                encontrou = true;
            }
        }
        
        if (!encontrou) {
            System.out.println("Nenhum tratamento encontrado para seus pets.");
        }
    }

    private static void adicionarFuncionario(Administrador admin) {
        System.out.println("\n=== Adicionar Funcionário ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Cargo (Funcionario/Administrador): ");
        String cargo = scanner.nextLine();
        
        if (cargo.equalsIgnoreCase("Administrador")) {
            Administrador novoAdmin = new Administrador(nome, cpf);
            sistema.adicionarFuncionario(novoAdmin);
            System.out.println("Administrador adicionado com sucesso!");
        } else {
            Funcionario novoFunc = new Funcionario(nome, cpf, "Funcionario");
            sistema.adicionarFuncionario(novoFunc);
            System.out.println("Funcionário adicionado com sucesso!");
        }
    }

    private static void adicionarServico() {
        System.out.println("\n=== Adicionar Serviço ===");
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        
        Servico novoServico = new Servico(descricao, preco);
        sistema.adicionarServico(novoServico);
        System.out.println("Serviço adicionado com sucesso!");
    }

    private static void inicializarDadosTeste() {
        // Adicionando clientes (agora com CPF)
   
        Cliente cliente1 = new Cliente("João Silva", "11999999999", "11111111111", "joao", "123");
        Cliente cliente2 = new Cliente("Maria Souza", "11888888888", "22222222222", "maria", "456");
        sistema.adicionarCliente(cliente1);
        sistema.adicionarCliente(cliente2);
        
        // Adicionando funcionários (já usava CPF)
        Funcionario func1 = new Funcionario("Carlos Oliveira", "33333333333", "Atendente");
        Veterinario vet1 = new Veterinario("Dra. Lais Caldas", "12312312312", "Veterinário");
        Administrador admin1 = new Administrador("Ana Pereira", "44444444444");
        sistema.adicionarFuncionario(func1);
        sistema.adicionarFuncionario(admin1);
        sistema.adicionarFuncionario(vet1);
        
        // Adicionando serviços
        Servico servico1 = new Servico("Banho e Tosa", 50.0);
        Servico servico2 = new Servico("Consulta Veterinária", 100.0);
        sistema.adicionarServico(servico1);
        sistema.adicionarServico(servico2);
        
        // Adicionando pacientes (agora usando CPF do dono)
        Paciente pet1 = new Paciente("Rex", "Cachorro", "Labrador", cliente1);
        Paciente pet2 = new Paciente("Mimi", "Gato", "Siamês", cliente2);
        sistema.adicionarPaciente(pet1);
        sistema.adicionarPaciente(pet2);
        
        // Adicionando tratamentos
        Tratamento tratamento1 = new Tratamento("Vacinação anual");
        Tratamento tratamento2 = new Tratamento("Castração");
        pet1.adicionarTratamento(tratamento1);
        pet2.adicionarTratamento(tratamento2);
    }
}