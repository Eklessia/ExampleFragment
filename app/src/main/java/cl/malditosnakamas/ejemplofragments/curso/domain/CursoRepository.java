package cl.malditosnakamas.ejemplofragments.curso.domain;

import cl.malditosnakamas.ejemplofragments.curso.domain.model.Curso;
import io.reactivex.Single;

public interface CursoRepository {

    Single<Curso> get();

}
