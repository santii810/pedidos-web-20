package es.uvigo.esei.mei.pedidos.servicios;

import es.uvigo.esei.mei.pedidos.daos.RolRepository;
import es.uvigo.esei.mei.pedidos.entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public Rol crear(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol modificar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol buscarPorId(Long id) {
        return rolRepository.findById(id).get();
    }

    @Override
    public List<Rol> buscarTodos() {
        return rolRepository.findAll();
    }

    @Override
    public List<Rol> buscarPorNombre(String patron) {
        return rolRepository.findByNombre(patron);
    }

}
