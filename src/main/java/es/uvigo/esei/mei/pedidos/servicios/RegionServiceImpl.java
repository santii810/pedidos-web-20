package es.uvigo.esei.mei.pedidos.servicios;

import es.uvigo.esei.mei.pedidos.daos.RegionRepository;
import es.uvigo.esei.mei.pedidos.entidades.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public Region crear(Region Region) {
        return null;
    }

    @Override
    public Region modificar(Region Region) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Region buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Region> buscarTodos() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> buscarPorNombre(String patron) {
        return null;
    }

    @Override
    public List<Region> buscarPorRegion(String patron) {
        return null;
    }
}
