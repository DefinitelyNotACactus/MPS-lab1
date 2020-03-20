package infra;

import util.InfraException;

import java.io.File;
import java.util.Map;

/** Classe abstrata de persistência
 * @param <K> A chave da persistência
 * @param <T> O tipo de objeto da persistência
 */
public abstract class Persistence<K, T> {
    protected File file;

    protected Persistence(String fileName) {
        file = new File(fileName);
    }

    abstract public void save(Map<K, T> model) throws InfraException;

    abstract public Map<K, T> load() throws InfraException;
}
