CREATE SCHEMA IF NOT EXISTS CAPITOLE;

CREATE TABLE CAPITOLE.BRAND (
  BRAND_ID NUMERIC(16,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  NAME VARCHAR(50) DEFAULT '',
  CONSTRAINT BRAND_PK PRIMARY KEY (BRAND_ID)
);

COMMENT ON TABLE CAPITOLE.BRAND IS 'Marcas';
COMMENT ON COLUMN CAPITOLE.BRAND.BRAND_ID IS 'Identificador de la marca (PK autonumerico)';
COMMENT ON COLUMN CAPITOLE.BRAND.NAME IS 'Nombre';



CREATE TABLE CAPITOLE.PRICES (
                                 BRAND_ID NUMERIC(16,0) NOT NULL,
                                 PRODUCT_ID NUMERIC(16,0) NOT NULL,
                                 RATE_ID NUMERIC(16,0) NOT NULL,
                                 START_DATE TIMESTAMP NOT NULL,
                                 END_DATE TIMESTAMP NOT NULL,
                                 PRIORITY INT NOT NULL,
                                 PRICE NUMERIC(16,2) NOT NULL,
                                 CURR VARCHAR(3) NOT NULL
);

