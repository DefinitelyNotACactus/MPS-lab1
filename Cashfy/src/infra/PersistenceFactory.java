package infra;

/** Interface comum para criar objetos de persistência
 * Implementa o padrão de projeto Factory Method
 */
public class PersistenceFactory {
    public Persistence getPersistence(String type) {
        switch (type) {
            case "User":
                return UserPersistence.getInstance();
            case "News":
                return NewsPersistence.getInstance();
            case "Options":
                return OptionPersistence.getInstance();
            default:
                return null;
        }
    }
}
