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

import br.com.fiap.LiveNow.evento.DadosAtualizacaoEvento;
import br.com.fiap.LiveNow.evento.DadosCadastroEvento;
import br.com.fiap.LiveNow.evento.DadosListagemEvento;
import br.com.fiap.LiveNow.evento.Evento;
import br.com.fiap.LiveNow.evento.EventoRepository;
import br.com.fiap.LiveNow.usuario.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroEvento dados) {
		Evento evento = new Evento(dados, usuarioRepository);
		eventoRepository.save(evento);
	}

	@GetMapping
	public Page<DadosListagemEvento> listar(@PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
		return eventoRepository.findAll(paginacao).map(DadosListagemEvento::new);
	}

	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoEvento dados) {
		var evento = eventoRepository.getReferenceById(dados.id());
		evento.atualizarInformacoes(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		eventoRepository.deleteById(id);
	}

}
