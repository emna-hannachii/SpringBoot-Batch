package tn.esprit.spring.stationskibatch.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import tn.esprit.spring.stationskibatch.entities.Abonnement;
import tn.esprit.spring.stationskibatch.entities.Skieur;
import tn.esprit.spring.stationskibatch.entities.TypeAbonnement;
import tn.esprit.spring.stationskibatch.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static tn.esprit.spring.stationskibatch.entities.TypeAbonnement.MENSUEL;

@Slf4j
@Component
public class SkieurProcessor implements ItemProcessor<Skieur, Skieur> {


	/*12. logique métier de notre job*/
	@Override
	public Skieur process(Skieur skieur) {

		///récupérer la date début d'abonnement relative à la date du jour
		// calculer par défaut la date fin pour un abonnement mensuel
		// affecter par défaut le prix d'abonnement pour un abonnement mensuel
		Long numAbonnement = ThreadLocalRandom.current().nextLong(1000000); // numéro abonnement généré automatiquement
		LocalDate dateDebutAbonnement = LocalDate.now();
		LocalDate dateFinAbonnement = null;
		Float prixAbon = null;
		// calculer la date fin  et affecter  le prix d'abonnement
		// pour les deux autres types d'abonnement

		// calculer la date fin  et affecter  le prix d'abonnement
		// pour les deux autres types d'abonnement

		switch (skieur.getTypeAbon()) {

			case "ANNUEL":
				dateDebutAbonnement = LocalDate.now();
				dateFinAbonnement = LocalDate.now().plusMonths(12);
				prixAbon = 600F;
				Abonnement ab=Abonnement.builder().numAbon(numAbonnement).dateDebut(dateDebutAbonnement).dateFin(dateFinAbonnement).prixAbon(prixAbon).typeAbon(TypeAbonnement.ANNUEL).build();
				skieur.setAbonnement(ab);

				break;
			case "SEMESTRIEL":
				dateDebutAbonnement = LocalDate.now();
				dateFinAbonnement = LocalDate.now().plusMonths(6);
				prixAbon = 300F;
				Abonnement ab2=Abonnement.builder().numAbon(numAbonnement).dateDebut(dateDebutAbonnement).dateFin(dateFinAbonnement).prixAbon(prixAbon).typeAbon(TypeAbonnement.ANNUEL).build();
				skieur.setAbonnement(ab2);
			case "MENSUEL":
				dateDebutAbonnement = LocalDate.now();
				dateFinAbonnement = LocalDate.now().plusMonths(1);
				prixAbon = 60F;
				Abonnement ab3=Abonnement.builder().numAbon(numAbonnement).dateDebut(dateDebutAbonnement).dateFin(dateFinAbonnement).prixAbon(prixAbon).typeAbon(TypeAbonnement.ANNUEL).build();
				skieur.setAbonnement(ab3);
				break;
		}
		Abonnement a = Abonnement.builder().numAbon(numAbonnement).dateDebut(dateDebutAbonnement)
				.dateFin(dateFinAbonnement).prixAbon(prixAbon).typeAbon(MENSUEL).build();

		//TODO 6
		return skieur;

	}

}
