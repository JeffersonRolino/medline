package br.com.medline.controller;

import br.com.medline.domain.medico.DadosCadastroMedicoDTO;
import br.com.medline.domain.medico.DadosListagemMedicoDTO;
import br.com.medline.domain.medico.Medico;
import br.com.medline.domain.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    private MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar(Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(DadosListagemMedicoDTO::new);
    }

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dadosCadastroMedico){
        medicoRepository.save(new Medico(dadosCadastroMedico));
    }

}
