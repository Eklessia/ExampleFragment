package cl.malditosnakamas.ejemplofragments.curso.presentation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import cl.malditosnakamas.ejemplofragments.curso.domain.model.Integrante;
import cl.malditosnakamas.ejemplofragments.databinding.ItemCursoBinding;

public class CursoViewHolder extends RecyclerView.ViewHolder {

    private ItemCursoBinding binding;
    private IntegranteItemClickListener listener;

    public CursoViewHolder(@NonNull View itemView, IntegranteItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        binding = ItemCursoBinding.bind(itemView);
    }

    public void bind(Integrante integrante) {
        Picasso.get().load(integrante.getUrlImagen()).into(binding.ivAvatar);
        binding.tvNombre.setText(integrante.getNombre());
        binding.tvDescripcion.setText(integrante.getDescripcion());
        binding.cvItemIntegrante.setOnClickListener((View view) -> goToDetailsIntegrante(view, integrante));
    }

    private void goToDetailsIntegrante(View view, Integrante integrante) {
        if(listener != null){
            listener.onIntegranteItemClickListener(view, integrante);
        }
    }


}
