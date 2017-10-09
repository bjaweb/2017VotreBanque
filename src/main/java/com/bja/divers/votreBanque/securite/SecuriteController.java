package com.bja.divers.votreBanque.securite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuriteController {

//    @RequestMapping(value="/login",method=RequestMethod.POST)
    @RequestMapping(value="/login")
    public String login() {
	
	return "login";
    }
    
    
//    @RequestMapping("/") // action par defaut
//    public String home() {	
//	return "redirect:/operations";
//    }
}
