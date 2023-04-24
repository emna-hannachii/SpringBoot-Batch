package tn.esprit.spring.stationskibatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.stationskibatch.entities.Skieur;
import tn.esprit.spring.stationskibatch.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Integer> {


}
