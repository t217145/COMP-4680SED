package com.comp4680.webportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.comp4680.webportal.models.CustomException;
import com.comp4680.webportal.models.Events;
import com.comp4680.webportal.repos.EventsRepo;
import com.comp4680.webportal.utils.EventsValidator;
import jakarta.validation.Valid;

@Controller
@RequestMapping({ "/", "/events" })
public class EventsController {
    private static final String SUBPATH = "events/";

    @Autowired
    private EventsRepo repo;

    @Autowired
    private EventsValidator validator;

    @GetMapping({ "", "/", "index" })
    public String index(ModelMap map) {
        map.addAttribute("events", repo.findAll());
        return SUBPATH + "index";
    }

    // Add a method to create a new event
    @GetMapping("/create")
    public String create(ModelMap map) {
        map.addAttribute("event", new Events());
        return SUBPATH + "form";
    }

    // Add a method to save the new event
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("event") Events event, BindingResult result, ModelMap map) {
        validator.validate(event, result);
        if (result.hasErrors()) {
            map.addAttribute("event", event);
            return SUBPATH + "form";
        }
        repo.save(event);
        return "redirect:index";
    }

    // Add a method to edit an existing event
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap map) throws CustomException {
        if (!repo.findById(id).isPresent()) {
            throw new CustomException("EVT-EDIT", String.format("Event not found with id [%d]", id), "/events/index");
        }
        map.addAttribute("event", repo.findById(id).get());
        return SUBPATH + "form";
    }

    // Add a method to save the updated event
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("event") Events event, BindingResult result, ModelMap map)
            throws CustomException {
        validator.validate(event, result);
        if (result.hasErrors()) {
            map.addAttribute("event", event);
            return SUBPATH + "form";
        }
        repo.save(event);
        return "redirect:index";
    }

    // Add a method to delete an event
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) throws CustomException {
        if (!repo.findById(id).isPresent()) {
            throw new CustomException("EVT-DEL", String.format("Event not found with id [%d]", id), "/events/index");
        }
        if (repo.isEventsEnded(id).isPresent()) {
            throw new CustomException("EVT-DEL", "Event is already ended", "/events/index");
        }
        repo.deleteById(id);
        return "redirect:/" + SUBPATH + "index";
    }
}