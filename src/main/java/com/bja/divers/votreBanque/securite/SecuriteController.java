package com.bja.divers.votreBanque.securite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuriteController {

//    appel de la methode en get 
    @RequestMapping(value="/login")
    public String login() {
	
	return "login";
    }
    
    
    // l'appel en post se fait par le bouton valider
    
   @RequestMapping("/") // action par defaut
    public String home() {	
	return "redirect:/operations";
    }
}
