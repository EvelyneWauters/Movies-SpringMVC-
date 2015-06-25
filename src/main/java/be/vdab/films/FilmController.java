package be.vdab.films;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FilmController {
    @Autowired
    FilmRepository filmRepository;


    @RequestMapping("/hello")
    public String hello()  {
        return "home";
    }


    @RequestMapping("/films")
    @ResponseBody
    public String films()   {
        return filmRepository.findAll().toString();
    }

    @RequestMapping("/filmsbyID")
    @ResponseBody
    public String filmsbyID()   {
        return filmRepository.findFilmById(2).toString();
    }
}
