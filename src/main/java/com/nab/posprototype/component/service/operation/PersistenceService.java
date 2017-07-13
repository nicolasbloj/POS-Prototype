package com.nab.posprototype.component.service.operation;

import java.io.Serializable;

// interface-segregation principle (ISP)
public interface PersistenceService<PK extends Serializable, E, D> {

  public PK add(D dto) throws Exception;

}
