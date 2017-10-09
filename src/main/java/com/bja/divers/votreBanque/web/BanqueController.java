package com.bja.divers.votreBanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bja.divers.votreBanque.entities.Compte;
import com.bja.divers.votreBanque.entities.Operation;
import com.bja.divers.votreBanque.services.IBanqueService;

@Controller
public class BanqueController {

    @Autowired
    private IBanqueService banqueService;
    
    @RequestMapping("/operations")
    public String index() {
	return "comptes";
    }
    
    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String num, @RequestParam(name="page",defaultValue="0")int page
	    , @RequestParam(name="size",defaultValue="5")Integer size) {
	try {
	    model.addAttribute("numCompte",num);
	    Compte cp = banqueService.consulterCompte(num);
	    
	    Page<Operation> operations = banqueService.listOp(num, page, size);
	    model.addAttribute("listeOperations", operations.getContent());
	    
	    int[] pages = new int[operations.getTotalPages()];
	    model.addAttribute("pages",pages);
	    
	    model.addAttribute("compte",cp);
	}catch(Exception e) {
	    model.addAttribute("exception",e);
	}
	
	return "comptes";
    }
    

    @RequestMapping(value="/saveOperation", method=RequestMethod.POST)
    public String saveOperation(Model model, String typeOperation, 
	    			String numCompte, double montant, String numCompte2) {
	try {
		if(typeOperation.equals("versement")) {
		    banqueService.verser(numCompte, montant);
		}
		else if(typeOperation.equals("retrait")) {
		    banqueService.retirer(numCompte, montant);
		}
		else {
		    banqueService.virement(numCompte, numCompte2, montant);
		}
		//return consulter(model, numCompte);		
	}
	catch (Exception e) {
	    model.addAttribute("error",e);
	    //return "comptes";
	    return "redirect:/consulterCompte?num="+numCompte+"&error="+e.getMessage();
	}
	return "redirect:/consulterCompte?num="+numCompte;
    }
    
    
    
    
}
