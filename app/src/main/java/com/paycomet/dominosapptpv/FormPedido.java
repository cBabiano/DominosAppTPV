package com.paycomet.dominosapptpv;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FormPedido extends Fragment{

    public FormPedido(){}

    // TODO: Rename and change types and number of parameters
    public static FormPedido newInstance(String param1, String param2) {
        FormPedido fragment = new FormPedido();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.form_pedido, container, false);

        Button confirmar1 = (Button) view.findViewById(R.id.confirmar1);
        confirmar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("PRUEBA","AAAAAAA");
                // segundo form
                Fragment form = new FormImporte();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameForms, form);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}

