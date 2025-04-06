package Petshop;

import java.util.Scanner;

public class Veterinario extends Funcionario {
    private Scanner scanner = new Scanner(System.in);

    public Veterinario(String nome, String cargo, String cpf) {
        super(nome, cargo, cpf);
    }

    // Visualizar todos os pacientes cadastrados
    public void visualizarPacientes(SistemaPetshop sistema) {
        System.out.println("\n=== Lista de Pacientes ===");

        if (sistema.getPacientes().isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        for (Paciente p : sistema.getPacientes()) {
            System.out.println("Nome: " + p.getNome() + 
                               " | Espécie: " + p.getEspecie() + 
                               " | Raça: " + p.getRaca() +
                               " | Dono: " + p.getDono().getNome());
        }
    }

    // Gera um relatório de todos os tratamentos
    public void gerarRelatorio(SistemaPetshop sistema) {
        System.out.println("\n=== Relatório de Tratamentos ===");
        boolean encontrou = false;

        for (Paciente p : sistema.getPacientes()) {
            if (!p.getTratamentos().isEmpty()) {
                System.out.println("Pet: " + p.getNome());
                for (Tratamento t : p.getTratamentos()) {
                    System.out.println(" - " + t.getDescricao() + " | Em andamento: " + (t.isEmAndamento() ? "Sim" : "Não"));
                }
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum tratamento registrado.");
        }
    }

    // Atualiza o status (em andamento ou não) de um tratamento de um pet
    public void atualizarStatusTratamento(SistemaPetshop sistema) {
        System.out.println("\n=== Atualizar Status de Tratamento ===");
        System.out.print("Nome do paciente: ");
        String nomePaciente = scanner.nextLine();

        Paciente pacienteEncontrado = null;

        for (Paciente p : sistema.getPacientes()) {
            if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                pacienteEncontrado = p;
                break;
            }
        }

        if (pacienteEncontrado == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        if (pacienteEncontrado.getTratamentos().isEmpty()) {
            System.out.println("Esse paciente não possui tratamentos.");
            return;
        }

        System.out.println("Tratamentos do paciente:");
        int i = 1;
        for (Tratamento t : pacienteEncontrado.getTratamentos()) {
            System.out.println(i + " - " + t.getDescricao() + " | Em andamento: " + (t.isEmAndamento() ? "Sim" : "Não"));
            i++;
        }

        System.out.print("Escolha o número do tratamento para atualizar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        if (escolha < 1 || escolha > pacienteEncontrado.getTratamentos().size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Tratamento tratamentoSelecionado = pacienteEncontrado.getTratamentos().get(escolha - 1);

        System.out.print("Novo status (true para em andamento, false para concluído): ");
        boolean novoStatus = scanner.nextBoolean();
        scanner.nextLine();

        tratamentoSelecionado.setEmAndamento(novoStatus);
        System.out.println("Status atualizado com sucesso.");
    }
    
    public void diagnosticarEPrescreverTratamento(SistemaPetshop sistema) {
        System.out.println("\n=== Diagnóstico e Prescrição de Tratamento ===");

        // Lista os pacientes disponíveis
        var pacientes = sistema.getPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente registrado.");
            return;
        }

        for (int i = 0; i < pacientes.size(); i++) {
            Paciente p = pacientes.get(i);
            System.out.printf("%d - %s (%s)\n", i + 1, p.getNome(), p.getEspecie());
        }

        System.out.print("Selecione o paciente pelo número: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        if (escolha < 1 || escolha > pacientes.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Paciente selecionado = pacientes.get(escolha - 1);

        System.out.print("Digite o diagnóstico: ");
        String diagnostico = scanner.nextLine();

        System.out.print("Digite o tratamento recomendado: ");
        String tratamentoDesc = scanner.nextLine();

        Tratamento tratamento = new Tratamento(diagnostico + " - " + tratamentoDesc);
        selecionado.adicionarTratamento(tratamento);

        System.out.println("Tratamento adicionado com sucesso para o paciente " + selecionado.getNome());
    }
}



