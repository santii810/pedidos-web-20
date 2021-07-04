package es.uvigo.esei.mei.pedidos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.esei.mei.pedidos.daos.JugadorRepository;
import es.uvigo.esei.mei.pedidos.entidades.Region;
import es.uvigo.esei.mei.pedidos.entidades.Jugador;

@Service
public class JugadorServiceImpl implements JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public Jugador crear(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador modificar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }

    @Override
    public Jugador buscarPorId(Long id) {
        return jugadorRepository.findById(id).get();
    }

    @Override
    public List<Jugador> buscarTodos() {
        return jugadorRepository.findAll();
    }

    @Override
    public List<Jugador> buscarPorNombre(String patron) {
        return jugadorRepository.findAllByNombre(patron);
    }

    @Override
    public List<Jugador> buscarPorRegion(String patron) {
        return jugadorRepository.buscarPorRegion(patron);
    }
}
