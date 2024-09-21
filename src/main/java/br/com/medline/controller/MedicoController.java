package br.com.medline.controller;

import br.com.medline.domain.medico.DadosCadastroMedicoDTO;
import br.com.medline.domain.medico.Medico;
import br.com.medline.domain.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    private MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedicoDTO dadosCadastroMedico){
        medicoRepository.save(new Medico(dadosCadastroMedico));
    }

}
