package br.com.fiap.LiveNow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.LiveNow.avaliacao.Avaliacao;
import br.com.fiap.LiveNow.avaliacao.AvaliacoeRepository;
import br.com.fiap.LiveNow.avaliacao.DadosAtualizacaoAvaliacao;
import br.com.fiap.LiveNow.avaliacao.DadosCadastroAvaliacao;
import br.com.fiap.LiveNow.avaliacao.DadosListagemAvaliacao;
import br.com.fiap.LiveNow.evento.EventoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	private AvaliacoeRepository avaliacoesRepository;

	@Autowired
	private EventoRepository eventoRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@Valid @RequestBody DadosCadastroAvaliacao dados) {
		Avaliacao avaliacao = new Avaliacao(dados, eventoRepository);
		avaliacoesRepository.save(avaliacao);
	}

	@GetMapping
	public Page<DadosListagemAvaliacao> listar(@PageableDefault(size = 10, sort = { "nota" }) Pageable paginacao) {
		return avaliacoesRepository.findAll(paginacao).map(DadosListagemAvaliacao::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoAvaliacao dados) {
		var avaliacao = avaliacoesRepository.getReferenceById(dados.id());
		avaliacao.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		avaliacoesRepository.deleteById(id);
	}

}
