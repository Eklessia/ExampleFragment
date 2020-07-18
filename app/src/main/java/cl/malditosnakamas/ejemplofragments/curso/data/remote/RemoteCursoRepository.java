package cl.malditosnakamas.ejemplofragments.curso.data.remote;

import cl.malditosnakamas.ejemplofragments.curso.domain.CursoRepository;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Curso;
import io.reactivex.Single;

public class RemoteCursoRepository implements CursoRepository {

    //implementar una api de Retrofit
    //Todos los pasos para conectarnos a una api

    @Override
    public Single<Curso> get() {
        return null;
    }
}
