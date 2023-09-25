package br.com.fiap.LiveNow.avaliacao;

public record DadosListagemAvaliacao(Long id, int nota, String comentario, Long eventoId) {

	public DadosListagemAvaliacao(Avaliacao avaliacao) {
		this(avaliacao.getId(), avaliacao.getNota(), avaliacao.getComentario(),
				(avaliacao.getEvento() != null) ? avaliacao.getEvento().getId() : null);

	}

}
