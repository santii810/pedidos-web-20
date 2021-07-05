package es.uvigo.esei.mei.pedidos.servicios;

import es.uvigo.esei.mei.pedidos.entidades.Region;

import java.util.List;

public interface RegionService {
	public Region crear(Region Region);
	public Region modificar(Region Region);
	public void eliminar(Long id);
	public Region buscarPorId(Long id);
	public List<Region> buscarTodos();
	public List<Region> buscarPorNombre(String patron);


}
