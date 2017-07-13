package com.nab.posprototype.component.repository.operation;

import java.io.Serializable;
import java.util.List;


// interface-segregation principle (ISP)
public interface SearchRepository<PK extends Serializable, E> {

  public List<E> list(); // BusinessExc , map!

  public E getByKey(PK key);

}
// Principio de Segregación de Interfaces. (SOLID 4ª parte)
// En un caso real ProductRepository no tendría un metodo persist en POS.
