package com.capitole.tecnicalTest2.pricesmanagment.service.api.rest;


import com.capitole.common.handleExceptions.to.ErrorResponse;
import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesTo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Validated
@RequestMapping("/rest/v1/prices")
@Tag(name  = "Prices API")
public interface PricesmanagmentRestService {

    @GetMapping("/final/{brand}/{product}")
    @Operation(summary = "Final price of a product", description = "Returns a price for a product, brand and date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a price for a product, brand and date", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PricesTo.class))}),
            @ApiResponse(responseCode = "500", description = "Something was wrong, please try again", content ={ @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)) })
    })
    ResponseEntity<PricesTo> getFinalPrice(@PathVariable("brand") Long brandId, @PathVariable("product") Long productId, @RequestParam String applicationDate);



}
