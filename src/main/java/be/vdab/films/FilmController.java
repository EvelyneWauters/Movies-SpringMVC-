package be.vdab.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
