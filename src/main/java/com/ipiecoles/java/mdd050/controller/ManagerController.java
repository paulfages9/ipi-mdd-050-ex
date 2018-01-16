package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers")
public class ManagerController extends EmployeController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(method = RequestMethod.GET, value="/{idmanager}/equipe/{idtechnicien}/remove")
    public void deleteTechnicien (@PathVariable("idmanager") Long idmanager,
                                  @PathVariable("idtechnicien") Long idtechnicien) {
        managerService.deleteTechnicien(idmanager, idtechnicien);

    }
}
