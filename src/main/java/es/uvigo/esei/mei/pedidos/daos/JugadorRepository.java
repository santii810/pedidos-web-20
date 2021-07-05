package es.uvigo.esei.mei.pedidos.daos;

import java.util.List;

import es.uvigo.esei.mei.pedidos.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.uvigo.esei.mei.pedidos.entidades.Region;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query("SELECT j from Jugador j where j.nombre like %:name%")
    List<Jugador> findAllByNombre(@Param("name") String nombre);

    @Query("SELECT j from Jugador j join j.region r where r.nombre like %:name%")
    List<Jugador> buscarPorRegion(@Param("name") String nombre);
}
