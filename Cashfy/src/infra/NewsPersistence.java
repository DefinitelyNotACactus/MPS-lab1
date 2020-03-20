package infra;

import business.model.News;
import util.InfraException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe que implementa a persistência de dados de usuário (i.e. leitura e escrita da base de dados do sistema)
 * Implementa o padrão de projeto Singleton
 */
public class NewsPersistence extends Persistence<String, News> {

    private static NewsPersistence instance = new NewsPersistence();

    private NewsPersistence() {
        super("news.txt");
    }

    public Map<String, News> load() throws InfraException {
        try {
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(in);
            Map<String, News> news = (HashMap) objectStream.readObject();
            objectStream.close();
            in.close();

            return news;
        } catch(ClassNotFoundException | IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao carregar a base de dados, tente novamente mais tarde!");
        }
    }

    public void save(Map<String, News> news) throws InfraException {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(out);
            objectStream.writeObject(news);
            objectStream.close();
            out.close();
        } catch(IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao salvar na base de dados, tente novamente mais tarde!");
        }
    }

    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo UserPersistence
     * @return A única instância de UserPersistence
     */
    public static synchronized NewsPersistence getInstance() {
        return instance;
    }
}
