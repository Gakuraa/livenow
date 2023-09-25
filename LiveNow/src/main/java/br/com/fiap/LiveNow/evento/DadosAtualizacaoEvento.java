package br.com.fiap.LiveNow.evento;

import java.time.LocalDateTime;

import br.com.fiap.LiveNow.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEvento(@NotNull Long id, String nome, String descricao, LocalDateTime dataHora,
		DadosEndereco endereco) {

}
