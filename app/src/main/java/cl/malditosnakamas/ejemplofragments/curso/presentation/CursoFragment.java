package cl.malditosnakamas.ejemplofragments.curso.presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Objects;

import cl.malditosnakamas.ejemplofragments.R;
import cl.malditosnakamas.ejemplofragments.curso.data.local.LocalCursoRepository;
import cl.malditosnakamas.ejemplofragments.curso.domain.ObtenerCursoUseCase;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Curso;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Integrante;
import cl.malditosnakamas.ejemplofragments.databinding.FragmentCursoBinding;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CursoFragment extends Fragment implements IntegranteItemClickListener {

    public static final String AVATAR_URL_PARAM = "url_param";
    private FragmentCursoBinding binding;
    private ObtenerCursoUseCase obtenerCursoUseCase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCursoBinding.inflate(inflater, container, false);
        setupUseCase();
        setupRecyclerView();
        return binding.getRoot();
    }

    @SuppressLint("CheckResult")
    private void setupUseCase() {
        //Crear el objeto no es responsabilidad de esta clase, por ahora lo dejamos así y se
        //resuelve con inyección de dependencias Java: (Dagger, Hilt) / Kotlin: Koin
        obtenerCursoUseCase = new ObtenerCursoUseCase(new LocalCursoRepository());
        obtenerCursoUseCase.obtenerCurso()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(Curso curso) {
        binding.rvCurso.setAdapter(new CursoAdapter(curso.getIntegrantes(), this));
    }

    private void handleError(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void setupRecyclerView() {
        binding.rvCurso.setHasFixedSize(true);
        binding.rvCurso.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onIntegranteItemClickListener(View v, Integrante integrante) {
        Bundle bundle = new Bundle();
        bundle.putString(AVATAR_URL_PARAM, integrante.getUrlImagen());
        Navigation.findNavController(v).navigate(R.id.action_cursoFragment_to_integranteFragment, bundle);
    }
}
