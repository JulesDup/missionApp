package dev.mission.exec;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.MissionAppApplication;
import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerProchainesMission")
public class ListerProchainesMissions implements Runnable {
	private static final Logger LOGGER = Logger.getLogger(MissionAppApplication.class.getName());
	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		LocalDate now = LocalDate.now();
		List<Mission> listMissions = missionRepository.ListerProchaineMission(now);
		for (Mission mission : listMissions) {
			LOGGER.info("Mission débutant aujourd'hui ou a une date ultérieur : " + "ID : " + mission.getId()
					+ " nom : " + mission.getLibelle() + ", Date debut : " + mission.getDateDebut() + ", date fin : "
					+ mission.getDateFin());
		}

	}

}
