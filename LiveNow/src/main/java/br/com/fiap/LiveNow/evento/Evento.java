package br.com.fiap.LiveNow.evento;

import java.time.LocalDateTime;

import br.com.fiap.LiveNow.endereco.Endereco;
import br.com.fiap.LiveNow.usuario.Usuario;
import br.com.fiap.LiveNow.usuario.UsuarioRepository;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Evento")
@Table(name = "eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataHora;

	@ManyToOne
	@JoinColumn(name = "criador_id", referencedColumnName = "id")
	private Usuario criador;

	@Embedded
	private Endereco endereco;

	public Evento(@Valid DadosCadastroEvento dados, UsuarioRepository usuarioRepository) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.dataHora = dados.dataHora();
		this.endereco = new Endereco(dados.endereco());

		this.criador = usuarioRepository.findById(dados.criadorId()).orElse(null);

	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoEvento dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.dataHora() != null) {
			this.dataHora = dados.dataHora();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}
}
