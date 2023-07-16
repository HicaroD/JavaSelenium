package com.hicarod.builders;

import com.github.javafaker.Faker;

public class Product {
  public Integer code;
  public String name;
  public Integer quantitity;
  public Double value;
  public String registerDate;

  public Product() {
    Faker faker = new Faker();

    this.code = faker.number().numberBetween(0, 10000);
    this.name = faker.name().firstName();
    this.quantitity = faker.number().numberBetween(0, 1000);
    this.value = faker.number().randomDouble(2, 0, 1000);
    this.registerDate = faker.date().toString();
  }
}
