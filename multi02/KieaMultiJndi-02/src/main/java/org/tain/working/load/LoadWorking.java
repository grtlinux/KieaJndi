package org.tain.working.load;

import org.springframework.stereotype.Component;
import org.tain.utils.CurrentInfo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoadWorking {

	public void doing() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			if (Boolean.TRUE) loadTblCust();
			if (Boolean.TRUE) loadTblProd();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	//@Autowired
	//private TblCustLoader tblCustLoader;
	
	private void loadTblCust() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		//if (Boolean.TRUE) this.tblCustLoader.loading();
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	//@Autowired
	//private TblProdLoader tblProdLoader;
	
	private void loadTblProd() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		//if (Boolean.TRUE) this.tblProdLoader.loading();
	}
}
