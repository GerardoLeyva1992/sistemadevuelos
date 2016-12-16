package edu.uacm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/xmls")
public class XMLController {
	   @RequestMapping(value="", method=RequestMethod.GET)
	    public String listPosts(Model model) {
		   model.addAttribute("xmls");
	        return "xmls/CiudadesPais";
	    }
}
