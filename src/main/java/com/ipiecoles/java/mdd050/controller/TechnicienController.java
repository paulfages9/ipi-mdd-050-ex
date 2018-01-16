package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.service.TechnicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/techniciens")
public class TechnicienController extends EmployeController {

}
