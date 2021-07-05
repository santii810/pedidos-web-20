package es.uvigo.esei.mei.pedidos.controladores;

import es.uvigo.esei.mei.pedidos.entidades.Rol;
import es.uvigo.esei.mei.pedidos.servicios.RolService;
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
@RequestMapping("/rol")
public class RolController {
    @Autowired
    RolService rolService;


    @GetMapping
    public String prepararListarRoles(Model modelo) {
        List<Rol> roles = rolService.buscarTodos();
        modelo.addAttribute("roles", roles);
        return "rol/listado_roles";
    }

    @GetMapping("nuevo")
    public ModelAndView prepararNuevoCliente() {
        Rol rol = new Rol();

        ModelAndView result = new ModelAndView();
        result.addObject("rol", rol);
        result.addObject("esNuevo", true);
        result.setViewName("rol/editar_rol");
        return result;
    }

    @PostMapping("nuevo")
    public String crearCliente(@Valid @ModelAttribute Rol rol, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            rolService.crear(rol);
            return "redirect:/rol";
        } else {
            return null;
        }
    }

    @PostMapping
    public String actualizarListarRoles(@RequestParam(required = false) String nombreRol,
                                            Model modelo) {
        List<Rol> roles;
        if ((nombreRol != null) && !nombreRol.isEmpty()) {
            roles = rolService.buscarPorNombre(nombreRol);
        } else {
            roles = rolService.buscarTodos();
        }
        modelo.addAttribute("roles", roles);
        return "rol/listado_roles";
    }

    @GetMapping("{id}/eliminar")
    public String borrarElemento(@PathVariable("id") Long id, Model modelo) {
        Rol rol = rolService.buscarPorId(id);
        if (rol != null) {
            rolService.eliminar(rol.getId());
            return "redirect:/rol";
        } else {
            modelo.addAttribute("mensajeError", "Rol no encontrado");
            return "error";
        }
    }


    @GetMapping("{id}")
    public String prepararEditarElemento(@PathVariable("id") Long id, Model modelo) {
        try {
            modelo.addAttribute("rol", rolService.buscarPorId(id));
            modelo.addAttribute("esNuevo", false);
            return "rol/editar_rol";
        } catch (EntityNotFoundException e) {
            modelo.addAttribute("error", "Rol no encontrado");
            return "error";
        }
    }


    @PostMapping("{id}")
    public String actualizarElemento(@Valid @ModelAttribute Rol rol, BindingResult resultado) {
        if (!resultado.hasErrors()) {
            rolService.modificar(rol);
            return "redirect:/rol";
        } else {
            return null;
        }
    }


}
