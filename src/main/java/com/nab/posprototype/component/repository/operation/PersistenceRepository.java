package com.nab.posprototype.component.repository.operation;

import java.io.Serializable;

// interface-segregation principle (ISP)
public interface PersistenceRepository<PK extends Serializable, E> {

  public E persist(E entity) throws Exception;


}
