package cl.malditosnakamas.ejemplofragments.integrante.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import cl.malditosnakamas.ejemplofragments.curso.presentation.CursoFragment;
import cl.malditosnakamas.ejemplofragments.databinding.FragmentIntegranteBinding;

public class IntegranteFragment extends Fragment {

    private FragmentIntegranteBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentIntegranteBinding.inflate(inflater, container, false);
        String urlAvatar = getArguments().getString(CursoFragment.AVATAR_URL_PARAM);
        Picasso.get().load(urlAvatar).into(binding.ivAvatar);
        return binding.getRoot();
    }
}
