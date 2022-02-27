package org.tain.working.load.tables;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.jpa.domain.TblCust;
import org.tain.jpa.repository.TblCustRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.StringTools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TblCustLoader {

	private static final String basePath = "/Users/kang-air/STS/GIT/KieaJndi/single01/KieaSingleJndi-01/src/main/resources/json";
	private static final String jsonFile = "cust.json";
	
	@Autowired
	private TblCustRepository tblCustRepository;
	long id = 1L;
	
	public void loading() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.tblCustRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String fileName = basePath + File.separator + jsonFile;
			String jsonData = StringTools.stringFromFile(fileName);
			List<TblCust> lst = new ObjectMapper().readValue(jsonData, new TypeReference<List<TblCust>>() {});
			lst.forEach(itm -> {
				itm.setId(id);
				this.tblCustRepository.save(itm);
				this.id ++;
			});
		}
	}
}
