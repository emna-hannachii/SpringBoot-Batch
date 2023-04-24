package tn.esprit.spring.stationskibatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.stationskibatch.entities.Abonnement;
import tn.esprit.spring.stationskibatch.entities.TypeAbonnement;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer> {



}
