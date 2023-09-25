package br.com.fiap.LiveNow.avaliacao;

import br.com.fiap.LiveNow.evento.Evento;
import br.com.fiap.LiveNow.evento.EventoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Avaliacao")
@Table(name = "avaliacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int nota;

	private String comentario;

	@ManyToOne
	@JoinColumn(name = "evento_id", referencedColumnName = "id")
	private Evento evento;

	public Avaliacao(@Valid DadosCadastroAvaliacao dados, EventoRepository eventoRepository) {
		this.nota = dados.nota();
		this.comentario = dados.comentario();

		if (dados.eventoId() != null) {
			this.evento = eventoRepository.findById(dados.eventoId()).orElse(null);
		} else {
			this.evento = null;
		}

	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoAvaliacao dados) {
		if (dados.nota() != -1) {
			this.nota = dados.nota();
		}
		if (dados.comentario() != null) {
			this.comentario = dados.comentario();
		}
	}

}
