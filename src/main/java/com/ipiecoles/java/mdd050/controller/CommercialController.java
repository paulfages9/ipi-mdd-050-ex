package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.exception.EmployeException;
import com.ipiecoles.java.mdd050.model.Commercial;
import com.ipiecoles.java.mdd050.service.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/commercials")
public class CommercialController extends EmployeController {

    @Autowired
    private CommercialService commercialService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8", value = "")
    public Commercial createCommercial (@RequestBody Commercial commercial) {
        return commercialService.creerEmploye(commercial);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8", value = "/{id}")
    public Commercial updateCommercial (@RequestBody Commercial commercial, @PathVariable("id") Long id) throws EmployeException {
        return commercialService.updateEmploye(id, commercial);
    }



}
