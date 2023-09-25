package br.com.fiap.LiveNow.evento;

import java.time.LocalDateTime;

public record DadosListagemEvento(Long id, String nome, String descricao, LocalDateTime dataHora) {

	public DadosListagemEvento(Evento evento) {
		this(evento.getId(), evento.getNome(), evento.getDescricao(), evento.getDataHora());

	}

}
