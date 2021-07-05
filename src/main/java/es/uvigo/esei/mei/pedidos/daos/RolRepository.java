package es.uvigo.esei.mei.pedidos.daos;

import es.uvigo.esei.mei.pedidos.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query("SELECT r from Rol r where r.nombre like %:name%")
    List<Rol> findByNombre(@Param("name") String patron);
}
