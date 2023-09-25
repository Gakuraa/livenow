package br.com.fiap.LiveNow.avaliacao;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAvaliacao(

		@Min(1) @Max(10) int nota,

		@NotBlank String comentario,

		@NotNull Long eventoId

) {

}
