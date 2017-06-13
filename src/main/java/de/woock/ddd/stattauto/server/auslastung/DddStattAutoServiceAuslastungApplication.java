package de.woock.ddd.stattauto.server.auslastung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EurekaStatusChangedEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class DddStattAutoServiceAuslastungApplication {

	@Value("${auslastung.refresh.period}")
	String period = "0";
	
	@Autowired DiscoveryClient dc;
	
	@Scheduled(fixedDelay=5000)
	public void doit() {
		System.out.println(getUri());
	}

	private String getUri() {
		return String.format("%s/", dc.getInstances("REGISTRY-SERVICE").get(0).getUri());
	}

	public static void main(String[] args) {
		SpringApplication.run(DddStattAutoServiceAuslastungApplication.class, args);
	}

	@RequestMapping("/")
	public String refreshPeriod() {
		return String.format("Auslastungs-Management refresh period:%s", period);
	}
	
//	@EventListener(classes=EurekaStatusChangedEvent.class, condition="#root.event.status.toString() == 'UP'")
//	public void onEurekaStatusChanged(EurekaStatusChangedEvent event) {
//		if(event.getStatus() == InstanceInfo.InstanceStatus.DOWN || event.getStatus() == InstanceInfo.InstanceStatus.OUT_OF_SERVICE) { 
//			System.out.println("Eureka Event");
//		}
//	}
}
