package com.ipiecoles.java.mdd050;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.model.Manager;
import com.ipiecoles.java.mdd050.model.Technicien;
import com.ipiecoles.java.mdd050.repository.CommercialRepository;
import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import com.ipiecoles.java.mdd050.repository.ManagerRepository;
import com.ipiecoles.java.mdd050.repository.TechnicienRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

//@Component
public class MyRunner /*implements CommandLineRunner */{

    //@Autowired
    private EmployeRepository employeRepository;

    //@Autowired
    private TechnicienRepository technicienRepository;

    //@Autowired
    private CommercialRepository commercialRepository;

   // @Autowired
    private ManagerRepository managerRepository;

    //@Override
    public void run(String... strings) throws Exception {
        Connection connexion = initConnection();
        Statement statement = connexion.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Employe LIMIT 10");
        while ( resultSet.next() ) {
            print(resultSet.getString("nom"));
            print(resultSet.getDate("dateEmbauche"));
        }

    }

    public java.sql.Connection initConnection(){
        String url = "jdbc:mysql://localhost:3306/entreprise";
        String user = "root";
        String pwd = "2poules1jardin";

        java.sql.Connection connexion = null;

        try {
            connexion = java.sql.DriverManager.getConnection(url, user, pwd);
        } catch ( java.sql.SQLException e ) {
            //Problème de connexion à la base !
            print(e.getMessage());
        }
        return connexion;
    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
