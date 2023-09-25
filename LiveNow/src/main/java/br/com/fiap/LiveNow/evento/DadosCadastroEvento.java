package br.com.fiap.LiveNow.evento;

import java.time.LocalDateTime;

import br.com.fiap.LiveNow.endereco.DadosEndereco;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEvento(

		@NotBlank String nome,

		@NotBlank String descricao,

		@NotNull @Column(name = "dataHora") LocalDateTime dataHora,

		@NotNull @Valid DadosEndereco endereco,

		@NotNull Long criadorId

) {

}
