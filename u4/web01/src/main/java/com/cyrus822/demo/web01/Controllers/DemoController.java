package com.cyrus822.demo.web01.Controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cyrus822.demo.web01.Models.CustomException;
import com.cyrus822.demo.web01.Models.DemoModel;
import com.cyrus822.demo.web01.Repos.DemoRepo;
import com.cyrus822.demo.web01.Utils.CustomValidator;
import jakarta.validation.Valid;

@Controller
public class DemoController {
 
    @Autowired
    private DemoRepo repo;

    @Autowired
    private CustomValidator validator;

    @GetMapping({"", "/", "/index", "/retrieve"})
    public String index(ModelMap map){
        map.addAttribute("allObj", repo.findAll());
        return "index";
    }

    @GetMapping("/retrieve/{Id}")
    public String retrieve(@PathVariable("Id") Integer id, ModelMap map) throws CustomException{
        Optional<DemoModel> oObj = repo.findById(id);
        if(!oObj.isPresent()){
            throw new CustomException("C001", String.format("Record wit Id [%d] not found!", id), "/index");
        }
        map.addAttribute("obj", oObj.get());
        return "detail";
    }

    @GetMapping("/create")
    public String create(ModelMap map){
        map.addAttribute("formObj", new DemoModel());
        return "form";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("formObj") DemoModel model, BindingResult err, ModelMap map){
        validator.validate(model, err);
        if(err.hasErrors()){
            map.addAttribute("formObj", model);
            return "form";
        }
        repo.save(model);
        return "redirect:/index";
    }

    @GetMapping("/update/{Id}")
    public String update(@PathVariable("Id") Integer id, ModelMap map) throws CustomException{
        Optional<DemoModel> oObj = repo.findById(id);
        if(!oObj.isPresent()){
            throw new CustomException("C002", String.format("Record wit Id [%d] not found!", id), "/index");
        }        
        map.addAttribute("formObj", oObj.get());
        return "form";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("formObj") DemoModel model, BindingResult err, ModelMap map){
        validator.validate(model, err);
        if(err.hasErrors()){
            map.addAttribute("formObj", model);
            return "form";
        }
        repo.save(model);
        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) throws CustomException{
        Optional<DemoModel> oObj = repo.findById(id);
        if(!oObj.isPresent()){
            throw new CustomException("C003", String.format("Record wit Id [%d] not found!", id), "/index");
        }
        repo.delete(oObj.get());
        return "redirect:/index";
    }
}