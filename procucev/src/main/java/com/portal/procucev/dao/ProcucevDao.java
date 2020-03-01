package com.portal.procucev.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProcucevDao<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
