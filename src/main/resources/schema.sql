DROP TABLE IF EXISTS PRICES;

create table PRICES(
  ID int auto_increment not null,
  BRAND_ID int,
  START_DATE datetime,
  END_DATE datetime,
  PRICE_LIST int,
  PRODUCT_ID int,
  PRIORITY int,
  PRICE decimal (7,2),
  CURR varchar(3)
);