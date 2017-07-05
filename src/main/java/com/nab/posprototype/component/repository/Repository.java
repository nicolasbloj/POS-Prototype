package com.nab.posprototype.component.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author root nab
 */
public interface Repository<PK extends Serializable, E> {

    public List<E> list(); //BusinessExc , map!

    public E persist(E entity) throws Exception; 
    
    public E getByKey(PK key);

}
