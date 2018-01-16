package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/employes")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @RequestMapping("/count")
    public Long count() {
        return employeService.countAllEmploye();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    public Employe findById(@PathVariable ("id") Long id)
    {
        Employe employe = employeService.findById(id);
        if (employe == null) {
            throw  new EntityNotFoundException("L'employé d'identifiant : " +
                    id + " n'a pas été trouvé.");
        }
        return employe;
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
    produces = "application/json;charset=utf-8", params ="matricule")
    public Employe findByMatricule (
            @RequestParam("matricule") String matricule)
    {
        Employe employe = employeService.findMyMatricule(matricule);
        if (employe == null) {
            throw  new EntityNotFoundException("L'employé de matricule : " +
                    matricule + " n'a pas été trouvé.");
        }
        return employe;
    }

    @RequestMapping(value = "", method = RequestMethod.GET,
            produces = "application/json;charset=utf-8")
    public Page<Employe> findAllEmployes (
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size,
            @RequestParam("sortProperty") String sortProperty,
            @RequestParam("sortDirection") String sortDirection
            )
    {
     return employeService.findAllEmployes(page,size,sortProperty,sortDirection);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmploye(@PathVariable("id") Long id) {
        employeService.deleteEmploye(id);
    }

}
