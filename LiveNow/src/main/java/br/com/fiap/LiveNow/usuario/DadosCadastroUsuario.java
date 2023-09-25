package br.com.fiap.LiveNow.usuario;

import br.com.fiap.LiveNow.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

		@NotBlank String nome,

		@NotBlank @Email String email,

		@NotBlank String senha,

		@NotBlank String telefone,

		@NotNull @Valid DadosEndereco endereco) {

}
