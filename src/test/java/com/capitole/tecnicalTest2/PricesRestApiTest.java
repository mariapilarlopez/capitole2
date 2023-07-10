package com.capitole.tecnicalTest2;

import com.capitole.tecnicalTest2.pricesmanagment.logic.api.to.PricesTo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricesRestApiTest extends AbstractTest {

    private static final String FINAL_PRICE_URL = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getFinalPrice_whenDate20200614100000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-06-14 10:00:00"))
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        PricesTo result = super.mapFromJson(content, PricesTo.class);
        assertTrue(result.getPrice().compareTo(new BigDecimal("35.50"))==0 );
    }

    @Test
    public void getFinalPrice_whenDate20200614160000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-06-14 16:00:00"))
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        PricesTo result = super.mapFromJson(content, PricesTo.class);
        assertTrue(result.getPrice().compareTo(new BigDecimal("25.45"))==0 );
    }

    @Test
    public void getFinalPrice_whenDate20200614210000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-06-14 21:00:00"))
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        PricesTo result = super.mapFromJson(content, PricesTo.class);
        assertTrue(result.getPrice().compareTo(new BigDecimal("35.50"))==0 );
    }

    @Test
    public void getFinalPrice_whenDate20200615100000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-06-15 10:00:00"))
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        PricesTo result = super.mapFromJson(content, PricesTo.class);
        assertTrue(result.getPrice().compareTo(new BigDecimal("30.50"))==0 );
    }

    @Test
    public void getFinalPrice_whenDate20200616210000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-06-16 21:00:00"))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        PricesTo result = super.mapFromJson(content, PricesTo.class);
        assertTrue(result.getPrice().compareTo(new BigDecimal("38.95"))==0 );
    }

    @Test
    public void getFinalPrice_whenDate20200816210000() throws Exception {
        String uri = "/rest/v1/prices/final/%s/%s?applicationDate=%s";

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.get(String.format(FINAL_PRICE_URL, 1,35455,"2020-08-16 21:00:00"))
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.MULTIPLE_CHOICES.value(), status);

    }
}
