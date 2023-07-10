package com.capitole.tecnicalTest2.pricesmanagment.logic.api;

import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesSearchCriteria;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesTo;

public interface Pricesmanagment {

    /**
     * Get the price for a brand, product and date
     * @param criteria
     * @return
     */
    PricesTo getFinalPrice(PricesSearchCriteria criteria) throws Exception;


}
