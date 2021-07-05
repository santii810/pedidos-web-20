package es.uvigo.esei.mei.pedidos.daos;

import es.uvigo.esei.mei.pedidos.entidades.Jugador;
import es.uvigo.esei.mei.pedidos.entidades.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
