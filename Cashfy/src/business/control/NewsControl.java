package business.control;

import business.model.News;
import infra.PersistenceFactory;
import util.InfraException;
import util.InvalidAddException;

import java.util.Map;

public class NewsControl {
    private Map<String, News> news;

    public NewsControl() throws InfraException {
        news = new PersistenceFactory().getPersistence("News").load();
    }

    public void add(String [] params) throws InvalidAddException {
        if(params.length % 2 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i += 2) {
            news.put(params[i], new News(params[i], params[i + 1]));
        }
    }

    public void list(String title) {
        // TODO
    }

    public void listAll() {
        // TODO
    }
}
