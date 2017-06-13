package de.woock.ddd.stattauto.server.auslastung.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.woock.ddd.stattauto.server.auslastung.entity.Zeitraum;

@RestController
@RequestMapping("Auslastung")
public class AuslastungsController {

	@RequestMapping("/")
	public Zeitraum auslastung() {
		return new Zeitraum(LocalDateTime.of(2017, 06, 2, 10, 00).toEpochSecond(ZoneOffset.UTC), 
				            LocalDateTime.of(2017, 06, 2, 12, 00).toEpochSecond(ZoneOffset.UTC));
	}
}
