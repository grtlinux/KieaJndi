package org.tain;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tain.utils.CurrentInfo;
import org.tain.working.Working;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class KieaSingleJndi01Application implements CommandLineRunner {

	public static void main(String[] args) {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get(), LocalDateTime.now());
		SpringApplication.run(KieaSingleJndi01Application.class, args);
	}

	@Autowired
	private Working working;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("KANG-20220225 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			try {
				this.working.doing();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (!Boolean.TRUE) {
			System.exit(0);
		}
	}
}
