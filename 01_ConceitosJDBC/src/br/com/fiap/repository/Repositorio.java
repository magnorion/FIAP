package br.com.fiap.repository;

import br.com.fiap.dao.EventosDao;
import br.com.fiap.dao.ParticipantesDao;

/*
 * Uso do padr�o repository, com o padr�o Singleton
 * */

public class Repositorio {
	static EventosDao eventosDao;
	static ParticipantesDao participantesDao;
	
	public static EventosDao getEventosDao() {
		if (eventosDao == null) {
			eventosDao = new EventosDao();
		}
		return eventosDao;
	}
	
	public static ParticipantesDao getParticipantesDao() {
		if (participantesDao == null) {
			participantesDao = new ParticipantesDao();
		}
		return participantesDao;
	}
}
