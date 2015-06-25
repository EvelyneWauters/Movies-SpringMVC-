package be.vdab.films;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Film findFilmById(Integer id);

}
