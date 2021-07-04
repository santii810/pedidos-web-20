package es.uvigo.esei.mei.pedidos.entidades;

import lombok.*;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Campeon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Jugador> jugadores;

    @ManyToOne
    private Rol rol;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Partida> partidas;


}
