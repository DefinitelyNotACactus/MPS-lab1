package business.model;

public class Application implements Asset {

    private String ownerName;
    private String financialOptionName;
    private String applicationDate;

    private double value;
    private double profitability;

    public Application(String ownerName, String financialOptionName, String applicationDate, double value) {
        this.ownerName = ownerName;
        this.financialOptionName = financialOptionName;
        this.applicationDate = applicationDate;

        this.value = value;
        this.profitability = 0;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    @Override
    public String getInfo() {
        return "Aplicação de " + ownerName + " em " + financialOptionName +
                ":\nData da aplicação: " + applicationDate +
                "\nValor atual: " + getValue() +
                "\nRentabilidade: " + getProfitability() + "\n";
    }
}
