package de.woock.ddd.stattauto.server.auslastung.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

//@Component
public class HealthChecker implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("message", "all up and running").build();
//		return Health.unknown().build();
//		return Health.down().build();
	}
}
