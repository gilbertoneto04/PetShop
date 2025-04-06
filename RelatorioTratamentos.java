package Petshop;

import java.util.List;

public class RelatorioTratamentos {
    public static void gerarRelatorioTratamentos(List<Paciente> pacientes) {
        System.out.println("=== Relatório de Tratamentos ===");
        for (Paciente paciente : pacientes) {
            System.out.println("Paciente: " + paciente.getNome() + 
                               " | Dono: " + paciente.getDono().getNome());
            for (Tratamento t : paciente.getTratamentos()) {
                System.out.println(" - Tratamento: " + t.getDescricao() + 
                                   " | Em andamento: " + (t.isEmAndamento() ? "Sim" : "Não"));
            }
        }
    }
}
