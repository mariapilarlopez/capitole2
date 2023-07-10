package com.capitole.tecnicalTest2.pricesmanagment.logic.impl;

import com.capitole.common.handleExceptions.to.ErrorCode;
import com.capitole.common.handleExceptions.to.InternalErrorException;
import com.capitole.tecnicalTest2.pricesmanagment.dataaccess.dao.PricesDao;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.Pricesmanagment;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesSearchCriteria;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named("PricesManagment")
@Transactional
public class PricesmanagmentImpl implements Pricesmanagment {

    private PricesDao pricesDao;

    private static final Logger LOG = LoggerFactory.getLogger(PricesmanagmentImpl.class);

    /**
     * The constructor.
     *
     * @param pricesDao
     */
    @Inject
    public PricesmanagmentImpl(PricesDao pricesDao) {

        this.pricesDao = pricesDao;
    }

    @Override
    public PricesTo getFinalPrice(PricesSearchCriteria criteria) throws Exception {
        List<PricesTo> pricesToList = this.pricesDao.getFinalPrice(criteria);

        List<PricesTo> pricesToListPriority = pricesToList.stream()
                .filter(p -> p.getPriority() == getMaxPriority(pricesToList))
                .collect(Collectors.toList());

        if (pricesToListPriority.size() == 1){
            return pricesToListPriority.get(0);
        }else if (pricesToListPriority.size() == 0){
            return null;
        }else{
            InternalErrorException iee = new InternalErrorException("Impossible get final price. Two or more products meet the requirements ");
            iee.setCode(ErrorCode.MULTIPLERESULTS);
            throw iee;
        }

    }

    private static int getMaxPriority(List<PricesTo> priceToList) {
        return priceToList.stream()
                .mapToInt(PricesTo::getPriority)
                .max()
                .orElse(0);
    }


}
