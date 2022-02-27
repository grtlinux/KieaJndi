package org.tain.working.load;

//@Component
//@Transactional(transactionManager = "jndi2TransactionManager")
//@Slf4j
public class TblProdLoader {

	/*
	private static final String basePath = "/Users/kang-air/STS/GIT/KieaJndi/single01/KieaSingleJndi-01/src/main/resources/json";
	private static final String jsonFile = "prod.json";
	
	@Autowired
	private TblProdRepository tblProdRepository;
	long id = 1L;
	
	public void loading() throws Exception {
		log.info("KANG-20210405 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			this.tblProdRepository.deleteAll();
		}
		
		if (Boolean.TRUE) {
			String fileName = basePath + File.separator + jsonFile;
			String jsonData = StringTools.stringFromFile(fileName);
			List<TblProd> lst = new ObjectMapper().readValue(jsonData, new TypeReference<List<TblProd>>() {});
			lst.forEach(itm -> {
				itm.setId(id);
				this.tblProdRepository.save(itm);
				this.id ++;
			});
		}
	}
	*/
}
