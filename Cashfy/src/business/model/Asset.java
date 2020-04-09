package business.model;

import java.io.Serializable;

/** Interface do Componente
 * Implementa o padrão de projeto Composite
 */
public interface Asset extends Serializable {
    double getValue();

    double getProfitability();

    String getInfo();
}
