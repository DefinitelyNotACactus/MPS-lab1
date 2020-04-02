package infra;

import business.model.FinancialOption;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.InfraException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pablo
 */
public class OptionPersistence extends Persistence<String, FinancialOption> {

    private static OptionPersistence instance = new OptionPersistence();

    private OptionPersistence() {
        super("options.txt");
    }

    @Override
    public void save(Map<String, FinancialOption> options) throws InfraException {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(out);
            objectStream.writeObject(options);
            objectStream.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao salvar na base de dados, tente novamente mais tarde!");
        }
    }

    @Override
    public Map<String, FinancialOption> load() throws InfraException {
        try {
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(in);
            Map<String, FinancialOption> options = (HashMap) objectStream.readObject();
            objectStream.close();
            in.close();

            return options;
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            throw new InfraException("Erro ao carregar a base de dados, tente novamente mais tarde!");
        }
    }
    
    /** Padrão de projeto: Singleton
     * Garantir que exista apenas um objeto do tipo OptionPersistence
     * @return A única instância de UserPersistence
     */
    public static synchronized OptionPersistence getInstance() {
        return instance;
    }

}
