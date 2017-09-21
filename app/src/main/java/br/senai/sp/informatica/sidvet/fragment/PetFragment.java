package br.senai.sp.informatica.sidvet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.informatica.sidvet.R;
import br.senai.sp.informatica.sidvet.adapter.RVPetAdapter;
import br.senai.sp.informatica.sidvet.model.Cliente;
import br.senai.sp.informatica.sidvet.model.Pet;
import br.senai.sp.informatica.sidvet.rest.JsonParser;
import br.senai.sp.informatica.sidvet.rest.RestAddress;
import br.senai.sp.informatica.sidvet.task.HandlerTask;
import br.senai.sp.informatica.sidvet.task.HandlerTaskAdapter;
import br.senai.sp.informatica.sidvet.task.TaskRest;


/**
 * A simple {@link Fragment} subclass.
 */
public class PetFragment extends Fragment {
    View view;
    RecyclerView recyclerPet;
    List<Pet> pets = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshPet;



    public PetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pet, container, false);
        getAnimal();
        return view;
    }

    private void getAnimal(){
        new TaskRest(TaskRest.RequestMethod.GET, handlerListar, true, createSwipeRefresh()).execute(RestAddress.listaPet);
    }

    private SwipeRefreshLayout createSwipeRefresh() {
        swipeRefreshPet = (SwipeRefreshLayout)
                view.findViewById(R.id.refreshPets);
        // associa um listener ao swiperefresh
        swipeRefreshPet.setOnRefreshListener(onRefreshPets());
        return null;
    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshPets(){
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAnimal();
            }
        };
    }


    private HandlerTask handlerListar = new HandlerTaskAdapter(){
        @Override
        public void onSucess(String c) {
            super.onSucess(c);
            JsonParser<Pet> parser = new JsonParser<>(Pet.class);
            pets = parser.toList(c, Pet[].class);
            createRecyclerView(pets);
        }
    };

    private void createRecyclerView(List<Pet> pets) {
        recyclerPet = (RecyclerView)
                view.findViewById(R.id.recycler_pet);
        recyclerPet.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerPet.setHasFixedSize(true);
        // instancia o adaptador
        RVPetAdapter adapter = new
                RVPetAdapter(getContext(), pets);
        recyclerPet.setAdapter(adapter);
    }







}
