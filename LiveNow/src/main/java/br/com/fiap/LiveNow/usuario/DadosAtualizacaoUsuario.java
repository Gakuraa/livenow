package br.com.fiap.LiveNow.usuario;

import br.com.fiap.LiveNow.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(

		@NotNull Long id, String nome, String senha, String telefone, DadosEndereco endereco) {

}
