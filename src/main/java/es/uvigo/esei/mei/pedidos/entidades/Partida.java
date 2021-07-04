package es.uvigo.esei.mei.pedidos.entidades;

import lombok.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Partida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar fecha;
    @Temporal(TemporalType.DATE)
    private Date descripcion;
    @ManyToMany
    private List<Campeon> campeones;
    @ManyToOne
    private Temporada temporada;

}
