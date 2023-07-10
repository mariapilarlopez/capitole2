package com.capitole.tecnicalTest2.pricesmanagment.dataaccess.dao;


import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesSearchCriteria;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesTo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PricesDao<Prices, Long>{

    List<PricesTo> getFinalPrice(PricesSearchCriteria criteria);


}
