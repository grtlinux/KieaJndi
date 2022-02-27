package org.tain.jndi2.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tain.jndi2.jpa.domain.TblProd;

//@RepositoryRestResource
@Repository
public interface TblProdRepository extends JpaRepository<TblProd, Long>{

}
