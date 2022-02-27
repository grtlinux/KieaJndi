package org.tain.working.load;

//@Component
//@EntityScan(basePackages = {"org.tain.jndi1.**"})
//@Transactional(transactionManager = "jndi1TransactionManager")
//@Slf4j
public class TblCustLoader {

	/*
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
	*/
}
