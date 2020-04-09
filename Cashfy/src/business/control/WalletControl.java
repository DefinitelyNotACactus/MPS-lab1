package business.control;

import business.model.Application;
import business.model.Asset;
import business.model.Wallet;
import infra.PersistenceFactory;
import util.InfraException;
import util.InvalidAddException;
import util.InvalidAssetException;

import java.util.HashMap;
import java.util.Map;

public class WalletControl {
    private Map<String, Asset> wallets;

    public WalletControl() throws InfraException {
        wallets = new PersistenceFactory().getPersistence("Wallet").load();
    }

    public WalletControl(HashMap<String, Asset> wallets) {
        this.wallets = wallets;
    }

    public void add(String... params) throws InvalidAddException {
        if(params.length % 4 != 0) {
            throw new InvalidAddException("Foram informados menos parametros do que o necessario: " + params.length);
        }
        for(int i = 0; i < params.length; i += 4) {
            if(wallets.containsKey(params[0])) {
                Wallet wallet = (Wallet) wallets.get(params[0]);
                wallet.addAsset(new Application(params[0], params[1], params[2], Double.parseDouble(params[3])));
            } else {
                Wallet newWallet = new Wallet(params[0]);
                newWallet.addAsset(new Application(params[0], params[1], params[2], Double.parseDouble(params[3])));
                wallets.put(params[0], newWallet);
            }
        }
    }

    public void listAll() {
        // TODO
    }

    public String list(String login) throws InvalidAssetException {
        if(wallets.containsKey(login)) {
            return wallets.get(login).getInfo();
        }
        throw new InvalidAssetException("Usuário " + login + " não possui carteira!");
    }

    public void del(String login) throws InvalidAssetException {
        if(wallets.containsKey(login)) {
            wallets.remove(login);
        } else {
            throw new InvalidAssetException("Tentando apagar carteira de Usuário " + login + " que não possui carteira!");
        }
    }

    public void save() throws InfraException {
        new PersistenceFactory().getPersistence("Wallet").save(wallets);
    }
}
