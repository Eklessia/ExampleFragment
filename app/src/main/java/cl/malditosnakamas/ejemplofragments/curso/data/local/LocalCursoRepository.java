package cl.malditosnakamas.ejemplofragments.curso.data.local;

import java.util.ArrayList;
import java.util.List;

import cl.malditosnakamas.ejemplofragments.curso.domain.CursoRepository;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Curso;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Integrante;
import io.reactivex.Single;

public class LocalCursoRepository implements CursoRepository {

    //Se puede definir un origen local de datos
    //SQlite (Room de Jetpack)
    //Shared Preferences
    //File
    //Cualquier dato

    @Override
    public Single<Curso> get() {
        return Single.just(new Curso("Curso TD", getFakeIntegrantes()));
    }

    private List<Integrante> getFakeIntegrantes() {
        List<Integrante> goku = new ArrayList<>();
        for (int x = 1; x < 100; x++) {
            goku.add(getFakeIntegrante(x));
        }
        return goku;
    }

    private Integrante getFakeIntegrante(int x) {
        return new Integrante(
                "Nombre " + x,
                obtainUrlFake(x),
                "Descripcion " + x
        );
    }

    private String obtainUrlFake(Integer id) {
        return "https://rickandmortyapi.com/api/character/avatar/" + id + ".jpeg";
    }
}
