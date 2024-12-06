package pe.edu.cibertec.cl2_jpa_velasquez_hans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDetalleDto;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.dto.FilmDto;
import pe.edu.cibertec.cl2_jpa_velasquez_hans.service.FilmService;

import java.util.List;

@Controller
public class FilmController {
    @Autowired
    FilmService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "listado";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetalleDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "detalle";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetalleDto filmDetailDto = maintenanceService.findDetailById(id);
        model.addAttribute("film", filmDetailDto);
        return "editar";
    }

    @PostMapping("/edit-confirm")
    public String edit(@ModelAttribute FilmDetalleDto film, Model model) {
        maintenanceService.updateFilm(film);
        return "redirect:/listado/start";
    }

    @GetMapping("/crear")
    public String create(Model model) {
        return "crear";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        maintenanceService.deleteFilm(id);
        return "redirect:/listado/start";
    }
}
