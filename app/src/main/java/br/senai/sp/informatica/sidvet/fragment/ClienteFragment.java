package br.senai.sp.informatica.sidvet.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.senai.sp.informatica.sidvet.R;
import br.senai.sp.informatica.sidvet.model.Cliente;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClienteFragment extends Fragment {

    Cliente cliente;
    TextView nomeCliente;
    TextView cpfCliente;
    TextView dataCliente;
    TextView sexoCliente;
    TextView cepCliente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cliente, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inicializar();
    }

    private void inicializar(){
//        cliente = Parcels.unwrap(getIntent().getParcelableExtra("cliente"));
        nomeCliente = (TextView) getView().findViewById(R.id.nome_cliente);
        nomeCliente.setText("Nome");
    }

}
