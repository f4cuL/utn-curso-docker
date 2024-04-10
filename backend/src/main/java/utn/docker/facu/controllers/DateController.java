package utn.docker.facu.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import utn.docker.facu.entity.Date;
import utn.docker.facu.repository.DateRepository;


@Controller
public class DateController {

    @Autowired
    private DateRepository repository;

    @GetMapping("/")
    public String showHome(Model model) {
        List<String> dates = StreamSupport.stream(repository.findAll().spliterator(), false).map(date -> date.getFecha().withNano(0).toString())
                .collect(Collectors.toList());
        String datesHtml = String.join(" || ", dates);
        model = model.addAttribute("dates", datesHtml);
        return "home";
    }

    @GetMapping("/new-date")
    public String newDate(Model model) {
        Date newDate = new Date();
        newDate.setFecha(LocalDateTime.now());
        repository.save(newDate);
        return "new-date";
    }

    @GetMapping("/delete-all")
    public String deleteAll(Model model) {
        repository.deleteAll();
        return "delete-all";
    }
}
