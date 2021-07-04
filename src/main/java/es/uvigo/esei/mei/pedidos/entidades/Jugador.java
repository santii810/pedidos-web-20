package es.uvigo.esei.mei.pedidos.entidades;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    private Region region;

    @ManyToMany
    private List<Campeon> campeones;



}
