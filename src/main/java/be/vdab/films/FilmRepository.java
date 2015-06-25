package be.vdab.films;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film findAllFilms();

    Film findFilmById(Integer id);

    Film findFilmByTitle(String title);

    Film findAllFilmsOrderByAsc();



@ComponentScan("be.vdab");

}
