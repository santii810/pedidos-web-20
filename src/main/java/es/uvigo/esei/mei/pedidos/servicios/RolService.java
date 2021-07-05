package es.uvigo.esei.mei.pedidos.servicios;

import es.uvigo.esei.mei.pedidos.entidades.Rol;

import java.util.List;

public interface RolService {
	public Rol crear(Rol Rol);
	public Rol modificar(Rol Rol);
	public void eliminar(Long id);
	public Rol buscarPorId(Long id);
	public List<Rol> buscarTodos();
	public List<Rol> buscarPorNombre(String patron);


}
