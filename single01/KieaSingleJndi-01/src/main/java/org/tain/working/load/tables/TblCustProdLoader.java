package org.tain.working.load.tables;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TblCustProd;
import org.tain.jpa.repository.TblCustProdRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TblCustProdLoader {

	private static final String basePath = "/Users/kang-air/STS/GIT/KieaJndi/single01/KieaSingleJndi-01/src/main/resources/json";
	private static final String jsonFile = "cust_prod.json";
	
	@Autowired
	private TblCustProdRepository tblCustProdRepository;
	long id = 1L;
	
	public void loading() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.tblCustProdRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String fileName = basePath + File.separator + jsonFile;
			String jsonData = StringTools.stringFromFile(fileName);
			List<TblCustProd> lst = new ObjectMapper().readValue(jsonData, new TypeReference<List<TblCustProd>>() {});
			lst.forEach(itm -> {
				itm.setId(id);
				this.tblCustProdRepository.save(itm);
				this.id ++;
			});
		}
	}
}
