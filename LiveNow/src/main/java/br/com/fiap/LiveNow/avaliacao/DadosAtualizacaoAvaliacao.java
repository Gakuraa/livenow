package br.com.fiap.LiveNow.avaliacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAvaliacao(

		@NotNull Long id,

		int nota,

		String comentario) {

}
