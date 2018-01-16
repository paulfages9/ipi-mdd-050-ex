package com.ipiecoles.java.mdd050.service;

import com.ipiecoles.java.mdd050.model.Manager;
import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.repository.ManagerRepository;
import com.ipiecoles.java.mdd050.repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private TechnicienRepository technicienRepository;

    public void deleteTechniciens(Long idManager, Long idTechnicien) {

    }

    public Technicien addTechniciens(Long idManager, String matricule) {
        return null;
    }

    public void deleteTechnicien(Long idmanager, Long idtechnicien) {
        Manager m = managerRepository.findOne(idmanager);
        if (m == null) {
            throw new EntityNotFoundException("Le manager d'identifiant " + idmanager + "n'existe pas");
        }

        Technicien t = technicienRepository.findOne(idtechnicien);
        if (t == null) {
            throw new EntityNotFoundException("Le technicien d'identifiant " + idtechnicien + "n'existe pas");
        }

        //Delier le technicien du manager
        m.getEquipe().remove(t);
        managerRepository.save(m);
    }
}
