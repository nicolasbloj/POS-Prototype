package com.nab.posprototype.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Integer id;
  @Column(name = "codigo")
  private String code;
  @Column(name = "descripcion")
  private String description;

  public Product() {
    super();
  }

  public Product(String code, String description) {
    super();
    this.code = code;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

}
