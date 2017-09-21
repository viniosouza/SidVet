package br.senai.sp.informatica.sidvet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.senai.sp.informatica.sidvet.R;
import br.senai.sp.informatica.sidvet.model.Pet;

/**
 * Created by Tecnico_Tarde on 23/06/2017.
 */

public class RVPetAdapter extends RecyclerView.Adapter<RVPetAdapter.PetViewHolder>{
    private final List<Pet> pets;
    private final Context context;

    public RVPetAdapter(Context context, List<Pet> pets){
        this.context = context;
        this.pets = pets;
    }



    @Override
    public RVPetAdapter.PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.nome.setText(pet.getNome());
        holder.idade.setText(pet.getIdade());


    }

    @Override
    public int getItemCount() {
       return pets != null ? pets.size() : 0;
    }


    public static class PetViewHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView idade;
        private View itemView;

        public PetViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            nome = (TextView) itemView.findViewById(R.id.nome_adapter_pet);
            idade = (TextView) itemView.findViewById(R.id.idade_adapter_pet);
        }

    }
}
