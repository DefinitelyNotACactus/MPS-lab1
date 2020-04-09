package business.model;

import java.io.Serializable;

public interface Asset extends Serializable {
    double getValue();

    double getProfitability();

    String getInfo();
}
