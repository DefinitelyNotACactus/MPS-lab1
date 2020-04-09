package infra;

import util.InfraException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface comum para criar objetos de persistência Implementa o padrão de
 * projeto Factory Method
 */
public class PersistenceFactory {
	public Persistence getPersistence(String type) throws InfraException {
		switch (type) {
		case "User":
			return UserPersistence.getInstance();
		case "News":
			return NewsPersistence.getInstance();
		case "Options":
			return OptionPersistence.getInstance();
		default: // Não existe tal tipo
			throw new InfraException("Erro ao selecionar a seguinte persistência: " + type);
		}
	}
}
