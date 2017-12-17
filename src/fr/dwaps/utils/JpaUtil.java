package fr.dwaps.utils;

import javax.persistence.EntityManager;

public abstract class JpaUtil {
	public static EntityManager getEntityManager() {
		return AppListener.getEmf().createEntityManager();
	}
}
