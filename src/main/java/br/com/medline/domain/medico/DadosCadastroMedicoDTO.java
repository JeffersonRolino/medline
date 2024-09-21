package br.com.medline.domain.medico;

import br.com.medline.domain.endereco.DadosEnderecoDTO;

public record DadosCadastroMedicoDTO(String nome, String email, String crm, Especialidade especialidade, DadosEnderecoDTO endereco) {
}
