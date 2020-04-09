package infra;

import util.InfraException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe abstrata de persistência
 * 
 * @param <K> A chave da persistência
 * @param <T> O tipo de objeto da persistência
 */
public abstract class Persistence<K, T> {
	protected File file;

	protected Persistence(String fileName) {
		file = new File(fileName);
	}

	public void save(Map<K, T> model) throws InfraException {
		try {
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream objectStream = new ObjectOutputStream(out);
			objectStream.writeObject(model);
			objectStream.close();
			out.close();
		} catch (IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Erro ao salvar na base de dados, tente novamente mais tarde!");
		}
	}

	public Map<K, T> load() throws InfraException {
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objectStream = new ObjectInputStream(in);
			Map<K, T> model = (HashMap) objectStream.readObject();
			objectStream.close();
			in.close();

			return model;
		} catch (ClassNotFoundException | IOException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Erro ao carregar a base de dados, tente novamente mais tarde!");
		}
	}
}
