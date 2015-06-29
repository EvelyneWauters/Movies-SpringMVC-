package be.vdab.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //dit is ook mogelijk met Spring, Spring heeft meerdere opties om hetzelfde te doen
//    @RequestMapping("/films")
//    public String films()   {
//        Map<String, Object> model = new HashMap<>(String, Object);
//        model.put("film", filmRepository.findAll());
//        return new ModelAndView("film/list", model);
//    }

    @RequestMapping("/film")
    public String film(Map<String, Object> model, @RequestParam("id") int filmId)    {
        model.put("film", filmRepository.findOne(filmId));
        return "film/details";
    }

    @RequestMapping("/form")
    public String form()    {
        return "film/form";
    }

    //Zoals vroeger:
//    @RequestMapping(value= "/create", method = RequestMethod.POST)
//    public String create(HttpServletRequest request)  {
//        String title = request.getParameter("title");
//        String urlImage = request.getParameter("urlImage");
//        filmRepository.save(new Film(title, urlImage));
//        return "redirect:/films";
//    }

//    @RequestMapping(value = "/create", method = RequestMethod.Post)
//    public String create(@RequestParam("title") String title, @RequestParam("urlImage") String urlImage)    {
//        Film film = new Film();
//        film.setTitle(title);
//        film.setUrlImage(urlImage);
//        filmRepository.save(film);
//        return "reduirect:/films";
//    }

    //Met Spring MVC kunnen we voor standaard Java Beans ook de volgende code gebruiken
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String create(Film film)  {  //Hier gaat Spring ervanuit dat 'Film' een Java Bean is en dan gaat hij automatisch de setters gebruiken
        filmRepository.save(film);
        return "redirect:/films";
    }



}
