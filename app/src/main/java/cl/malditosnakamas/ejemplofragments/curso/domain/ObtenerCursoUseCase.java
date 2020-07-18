package cl.malditosnakamas.ejemplofragments.curso.domain;

import cl.malditosnakamas.ejemplofragments.curso.domain.model.Curso;
import io.reactivex.Single;

//Command
//Interactors
public class ObtenerCursoUseCase {

    private CursoRepository repository;

    public ObtenerCursoUseCase(CursoRepository repository) {
        this.repository = repository;
    }

    public Single<Curso> obtenerCurso(){
        return repository.get();
    }

}
