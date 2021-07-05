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
    public Region crear(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public Region modificar(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public void eliminar(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public Region buscarPorId(Long id) {
        return regionRepository.findById(id).get();
    }

    @Override
    public List<Region> buscarTodos() {
        return regionRepository.findAll();
    }

    @Override
    public List<Region> buscarPorNombre(String patron) {
        return regionRepository.findByNombre(patron);
    }

}
