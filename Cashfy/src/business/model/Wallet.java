package business.model;

import java.util.ArrayList;
import java.util.List;

public class Wallet implements Asset {

    private String ownerName;
    private List<Asset> assets;

    public Wallet(String ownerName) {
        this.ownerName = ownerName;
        this.assets = new ArrayList<>();
    }

    @Override
    public double getValue() {
        double sumValues = 0;
        for(Asset asset : assets) {
            sumValues += asset.getValue();
        }
        return sumValues;
    }

    @Override
    public double getProfitability() {
        if(assets.isEmpty()) {
            return 0;
        }

        double sumProfitability = 0;
        for(Asset asset : assets) {
            sumProfitability += asset.getProfitability();
        }

        return sumProfitability / assets.size();
    }

    @Override
    public String getInfo() {
        String info = "Informações da Carteira de " + ownerName + ":\n";
        for(Asset asset: assets) {
            info += asset.getInfo();
        }
        info += "Valor da carteira: " + getValue() + "\n";
        info += "Rentabilidade: " + getProfitability() + "\n";

        return info;
    }

    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public void removeAsset(Asset asset) {
        assets.remove(asset);
    }
}
