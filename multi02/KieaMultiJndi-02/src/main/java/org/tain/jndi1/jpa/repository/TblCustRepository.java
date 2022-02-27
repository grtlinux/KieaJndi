package org.tain.jndi1.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.tain.jndi1.jpa.domain.TblCust;

@RepositoryRestResource
public interface TblCustRepository extends JpaRepository<TblCust, Long>{

}
