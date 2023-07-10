package com.capitole.tecnicalTest2.pricesmanagment.service.impl.rest;

import com.capitole.common.handleExceptions.to.ErrorResponse;
import com.capitole.common.handleExceptions.to.InternalErrorException;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.Pricesmanagment;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesSearchCriteria;
import com.capitole.tecnicalTest2.pricesmanagment.service.api.rest.PricesmanagmentRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController("PricesRestService")
public class PricesmanagmentRestServiceImpl implements PricesmanagmentRestService {

    private Pricesmanagment pricesmanagment;

    private static final Logger LOG = LoggerFactory.getLogger(PricesmanagmentRestServiceImpl.class);

    /**
     * The constructor.
     *
     * @param pricesmanagment
     */
    @Inject
    public PricesmanagmentRestServiceImpl(Pricesmanagment pricesmanagment) {

        this.pricesmanagment = pricesmanagment;
    }

    @Override
    public ResponseEntity<? extends Object> getFinalPrice(Long brandId, Long productId, String applicationDate){
        try {
            PricesSearchCriteria criteria = new PricesSearchCriteria(productId, brandId,  applicationDate);
            return new ResponseEntity<>( this.pricesmanagment.getFinalPrice(criteria), HttpStatus.OK);
        } catch(InternalErrorException iee){
            LOG.error("", iee);
            return new ResponseEntity<>(new ErrorResponse(iee.getCode().value(), iee.getCode().getReasonPhrase()),
                    HttpStatus.CONTINUE);
        }catch (Exception e) {
            LOG.error("", e);
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
