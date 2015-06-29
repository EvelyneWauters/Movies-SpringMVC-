package be.vdab.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FilmController {
    @Autowired
    FilmRepository filmRepository;


    @RequestMapping("/hello")
    public String hello()  {
        return "home";
    }


    @RequestMapping("/filmlist")
    @ResponseBody
    public String films()   {
        return filmRepository.findAll().toString();
    }

    @RequestMapping("/filmsbyID")
    @ResponseBody
    public String filmsbyID()   {
        return filmRepository.findFilmById(2).toString();
    }

    @RequestMapping("/films")
    public String films(Map<String,Object> model)   {
        model.put("film", filmRepository.findAll());
        return "film/list";
    }

      @RequestMapping("/film")
    public String film(Map<String, Object> model, @RequestParam("id") int filmId)    {
        model.put("film", filmRepository.findOne(filmId));
        return "film/details";
    }

    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String form(Map<String, Object> model, @RequestParam(value = "id",required = false) Integer filmId)    {
        if(filmId!=null)    {
            model.put("film", filmRepository.findFilmById(filmId));
        } else {
            model.put("film", new Film());
        }
        return "film/form";
    }

      //Met Spring MVC kunnen we voor standaard Java Beans ook de volgende code gebruiken
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String create(Film film)  {  //Hier gaat Spring ervanuit dat 'Film' een Java Bean is en dan gaat hij automatisch de setters gebruiken
        filmRepository.save(film);
        return "redirect:/films";
    }

    @RequestMapping(value= "/films", method=RequestMethod.POST)
    public String delete(Film film) {
        filmRepository.delete(film);
        return"redirect:/films";
    }

}
