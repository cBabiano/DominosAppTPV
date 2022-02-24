package com.paycomet.dominosapptpv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FormEntrega extends Fragment {

    public FormEntrega(){}

    // TODO: Rename and change types and number of parameters
    public static FormEntrega newInstance(String param1, String param2) {
        FormEntrega fragment = new FormEntrega();
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
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_entrega, container, false);

        // Titulo
        TextView titulo = view.findViewById(R.id.textTitulo);

        // Botones
        Button btnImprimir = view.findViewById(R.id.btnImprimir);
        Button btnEmail = view.findViewById(R.id.btnEmail);
        Button btnSMS = view.findViewById(R.id.btnSMS);
        Button link = view.findViewById(R.id.link_entrega);

        // Asignación de textos
        titulo.setText(getString(R.string.titulo_entrega));
        btnImprimir.setText(getString(R.string.imprimir));
        btnEmail.setText(getString(R.string.email));
        btnSMS.setText(getString(R.string.sms));
        link.setText(getString(R.string.no_entregar_ticket));

        return view;
    }
}