package com.nab.posprototype.component.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.posprototype.component.service.ProductService;
import com.nab.posprototype.dto.ProductDTO;

@RestController
@RequestMapping("/product")
public class ProductController {
  private Logger logger = Logger.getLogger(ProductController.class);

  @Autowired
  ProductService service;

  @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> add(@RequestBody(required = true) ProductDTO productDTO) {
    ResponseEntity<String> response;

    logger.info(
        "productDTO -code: " + productDTO.getCode() + " -desc: " + productDTO.getDescription());

    try {
      Integer id = service.add(productDTO);
      if (id == -1)
        response = new ResponseEntity<String>(new StringBuilder(50)
            .append("No se pudo insertar el producto ").append(productDTO.getCode()).toString(),
            HttpStatus.INTERNAL_SERVER_ERROR);

      response = new ResponseEntity<>(new StringBuilder(50).append("El producto ").append(id)
          .append(" fue correctamente insertado").toString(), HttpStatus.OK);

    } catch (Exception e) {
      logger
          .error(new StringBuilder(150).append("An error happens while trying to add the product ")
              .append(productDTO.getCode()).toString());
      response = new ResponseEntity<>(
          new StringBuilder(50).append("An error happens while trying to add the product ")
              .append(productDTO.getCode()).toString(),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return response;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<ProductDTO>> list() {
    List<ProductDTO> productsDTO = service.list();
    return new ResponseEntity<>(productsDTO, HttpStatus.OK);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<ProductDTO> getByKey(@PathVariable Integer id) {

    ProductDTO productDTO = service.getByKey(id);
    HttpStatus httpStatus = HttpStatus.OK;

    if (productDTO == null)
      httpStatus = HttpStatus.NOT_FOUND;

    return new ResponseEntity<>(productDTO, httpStatus);

  }

}
