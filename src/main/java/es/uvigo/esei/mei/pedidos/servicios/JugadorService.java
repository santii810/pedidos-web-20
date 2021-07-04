package es.uvigo.esei.mei.pedidos.servicios;

import java.util.List;

import es.uvigo.esei.mei.pedidos.entidades.Region;
import es.uvigo.esei.mei.pedidos.entidades.Jugador;

public interface JugadorService {
	public Jugador crear(Jugador jugador);
	public Jugador modificar(Jugador jugador);
	public void eliminar(Long id);
	public Jugador buscarPorId(Long id);
	public List<Jugador> buscarTodos();
	public List<Jugador> buscarPorNombre(String patron);
	public List<Jugador> buscarPorRegion(String patron);


}
