package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

	/**
	 * Permet de lister les prochaine missions a partir d'un date
	 * 
	 * @param maDate
	 * @return
	 */
	@Query("select m from Mission m where m.dateDebut > :maDate")
	List<Mission> ListerProchaineMission(@Param("maDate") LocalDate maDate);

	@Query("select m from Mission m where m.dateDebut > :maDate and m.tauxJournalier >= :monTaux")
	List<Mission> listerProchainesMissionsParTauxJournalier(@Param("maDate") LocalDate maDate,
			@Param("monTaux") BigDecimal monTaux);

}
