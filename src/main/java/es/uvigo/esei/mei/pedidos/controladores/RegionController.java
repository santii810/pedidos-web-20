package es.uvigo.esei.mei.pedidos.controladores;

import es.uvigo.esei.mei.pedidos.entidades.Jugador;
import es.uvigo.esei.mei.pedidos.entidades.Region;
import es.uvigo.esei.mei.pedidos.servicios.JugadorService;
import es.uvigo.esei.mei.pedidos.servicios.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/region")
public class RegionController {
    @Autowired
    RegionService regionService;


    @GetMapping
    public String prepararListarRegiones(Model modelo) {
        List<Region> regiones = regionService.buscarTodos();
        modelo.addAttribute("regiones", regiones);
        return "region/listado_regiones";
    }

    @GetMapping("nuevo")
    public ModelAndView prepararNuevoCliente() {
        Region region = new Region();

        ModelAndView result = new ModelAndView();
        result.addObject("region", region);
        result.addObject("esNuevo", true);
        result.setViewName("region/editar_region");
        return result;
    }

    @PostMapping("nuevo")
    public String crearCliente(@Valid @ModelAttribute Region region, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            regionService.crear(region);
            return "redirect:/region";
        } else {
            return null;
        }
    }

    @PostMapping
    public String actualizarListarRegiones(@RequestParam(required = false) String nombreRegion,
                                            Model modelo) {
        List<Region> regiones;
        if ((nombreRegion != null) && !nombreRegion.isEmpty()) {
            regiones = regionService.buscarPorNombre(nombreRegion);
        } else {
            regiones = regionService.buscarTodos();
        }
        modelo.addAttribute("regiones", regiones);
        return "region/listado_regiones";
    }

    @GetMapping("{id}/eliminar")
    public String borrarElemento(@PathVariable("id") Long id, Model modelo) {
        Region region = regionService.buscarPorId(id);
        if (region != null) {
            regionService.eliminar(region.getId());
            return "redirect:/region";
        } else {
            modelo.addAttribute("mensajeError", "Region no encontrado");
            return "error";
        }
    }


    @GetMapping("{id}")
    public String prepararEditarElemento(@PathVariable("id") Long id, Model modelo) {
        try {
            modelo.addAttribute("region", regionService.buscarPorId(id));
            modelo.addAttribute("esNuevo", false);
            return "region/editar_region";
        } catch (EntityNotFoundException e) {
            modelo.addAttribute("error", "Region no encontrado");
            return "error";
        }
    }


    @PostMapping("{id}")
    public String actualizarElemento(@Valid @ModelAttribute Region region, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            regionService.modificar(region);
            return "redirect:/region";
        } else {
            return null;
        }
    }


}
