package cl.malditosnakamas.ejemplofragments.curso.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.malditosnakamas.ejemplofragments.R;
import cl.malditosnakamas.ejemplofragments.curso.domain.model.Integrante;

public class CursoAdapter extends RecyclerView.Adapter<CursoViewHolder> {

    private List<Integrante> integrantes;
    private IntegranteItemClickListener listener;

    public CursoAdapter(List<Integrante> integrantes, IntegranteItemClickListener listener) {
        this.integrantes = integrantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_curso, parent, false);
        return new CursoViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {
        holder.bind(integrantes.get(position));
    }

    @Override
    public int getItemCount() {
        return integrantes.size();
    }
}
