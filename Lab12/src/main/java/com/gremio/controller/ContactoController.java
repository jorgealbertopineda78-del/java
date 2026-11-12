package com.gremio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    // Spring inyecta el repository automáticamente
    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // GET /contactos → muestra la lista
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // GET /nuevo → muestra el formulario vacío
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // POST /guardar → recibe el formulario y guarda en BD
    // Si el contacto trae id hace UPDATE; si el id es null hace INSERT
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    // GET /editar/{id} → muestra el formulario con los datos del contacto
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        return repo.findById(id)
                .map(c -> {
                    model.addAttribute("contacto", c);
                    return "nuevo";
                })
                .orElse("redirect:/contactos");   // si no existe, vuelve a la lista
    }

    // POST /eliminar/{id} → borra el contacto
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/contactos";
    }
}