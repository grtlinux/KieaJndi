package org.tain.jndi1.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_cust")
@Data
public class TblCust {

	@Id
	private long id;
	
	private String code;
	
	private String name;
	
	private String desc;
}
