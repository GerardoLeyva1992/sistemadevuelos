package edu.uacm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.uacm.domain.Aeropuerto;
import edu.uacm.domain.AeropuertoRepository;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private AeropuertoRepository repository;

    @RequestMapping(value="", method=RequestMethod.GET)
    public String listPosts(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "posts/list";
    }

    @RequestMapping(value = "/{idaeropuerto}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long idaeropuerto) {
        repository.delete(idaeropuerto);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public String newProject() {
        return "posts/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("nombreaeropuerto") String nombreaeropuerto,@RequestParam("ciudad") String ciudad,@RequestParam("pais") String pais) {
        Aeropuerto post=new Aeropuerto();
        post.setNombreaeropuerto(nombreaeropuerto);
        post.setCiudad(ciudad);
        post.setPais(pais);
    	repository.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("post_idaeropuerto") long idaeropuerto,
                               @RequestParam("nombreaeropuerto") String nombreaeropuerto,@RequestParam("ciudad") String ciudad,@RequestParam("pais") String pais) {
        Aeropuerto post = repository.findOne(idaeropuerto);
        String param;
       // if(@RequestParam("param")==nombreaeropuerto)
        post.setNombreaeropuerto(nombreaeropuerto);
        post.setCiudad(ciudad);
        post.setPais(pais);
        repository.save(post);
        return new ModelAndView("redirect:/posts");
    }

    @RequestMapping(value = "/{idaeropuerto}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long idaeropuerto,
                       Model model) {
        Aeropuerto post = repository.findOne(idaeropuerto);
        model.addAttribute("post", post);
        return "posts/edit";
    }


}
