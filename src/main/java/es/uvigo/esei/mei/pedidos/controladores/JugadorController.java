package es.uvigo.esei.mei.pedidos.controladores;

import java.util.List;

import es.uvigo.esei.mei.pedidos.entidades.Region;
import es.uvigo.esei.mei.pedidos.servicios.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import es.uvigo.esei.mei.pedidos.entidades.Jugador;
import es.uvigo.esei.mei.pedidos.servicios.JugadorService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/jugador")
public class JugadorController {
    @Autowired
    JugadorService jugadorService;
    @Autowired
    RegionService regionService;

    @GetMapping
    public String prepararListarJugadores(Model modelo) {
        List<Jugador> jugadores = jugadorService.buscarTodos();
        modelo.addAttribute("jugadores", jugadores);
        return "jugador/listado_jugadores";
    }

    @GetMapping("nuevo")
    public ModelAndView prepararNuevoCliente() {
        Jugador jugador = new Jugador();
        List<Region> regiones =regionService.buscarTodos();

        ModelAndView result = new ModelAndView();
        result.addObject("jugador", jugador);
        result.addObject("esNuevo", true);
        result.addObject("regiones", regiones);
        result.setViewName("jugador/editar_jugador");
        return result;
    }

    @PostMapping("nuevo")
    public String crearCliente(@Valid @ModelAttribute Jugador jugador, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            jugadorService.crear(jugador);
            return "redirect:/jugador";
        } else {
            return null;
        }
    }

    @PostMapping
    public String actualizarListarClientes(@RequestParam(required = false) String nombreJugador,
                                           @RequestParam(required = false) String nombreRegion, Model modelo) {
        List<Jugador> jugadores;
        if ((nombreJugador != null) && !nombreJugador.isEmpty()) {
            jugadores = jugadorService.buscarPorNombre(nombreJugador);
        } else if ((nombreRegion != null) && !nombreRegion.isEmpty()) {
            jugadores = jugadorService.buscarPorRegion(nombreRegion);
        } else {
            jugadores = jugadorService.buscarTodos();
        }
        modelo.addAttribute("jugadores", jugadores);
        return "jugador/listado_jugadores";
    }

    @GetMapping("{id}/eliminar")
    public String borrarElemento(@PathVariable("id") Long id, Model modelo) {
        Jugador jugador = jugadorService.buscarPorId(id);
        if (jugador != null) {
            jugadorService.eliminar(jugador.getId());
            return "redirect:/jugador";
        } else {
            modelo.addAttribute("mensajeError", "Jugador no encontrado");
            return "error";
        }
    }


    @GetMapping("{id}")
    public String prepararEditarElemento(@PathVariable("id") Long id, Model modelo) {
        try {
            modelo.addAttribute("jugador", jugadorService.buscarPorId(id));
            modelo.addAttribute("regiones", regionService.buscarTodos());
            modelo.addAttribute("esNuevo", false);
            return "jugador/editar_jugador";
        } catch (EntityNotFoundException e) {
            modelo.addAttribute("error", "Jugador no encontrado");
            return "error";
        }
    }


    @PostMapping("{id}")
    public String actualizarElemento(@Valid @ModelAttribute Jugador jugador, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            jugadorService.modificar(jugador);
            return "redirect:/clientes";
        } else {
            return null;
        }
    }


}
