package cl.aiep.java.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeguridadController {
	
	@GetMapping("/ingreso")
	public String ingreso() {
		return "login";
	}
}
