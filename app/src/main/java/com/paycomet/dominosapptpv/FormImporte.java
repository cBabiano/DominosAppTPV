package com.paycomet.dominosapptpv;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FormImporte extends Fragment {

    String valorImporte = "36,50";

    public FormImporte(){}

    // TODO: Rename and change types and number of parameters
    public static FormImporte newInstance(String param1, String param2) {
        FormImporte fragment = new FormImporte();
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
        View view = inflater.inflate(R.layout.form_importe, container, false);

        // Titulo
        TextView titulo = view.findViewById(R.id.textTitulo);

        // Input
        LinearLayout in = view.findViewById(R.id.inImporte);
        EditText importe = view.findViewById(R.id.importe);
        TextView eu = view.findViewById(R.id.moneda);

        // Botones
        Button link = view.findViewById(R.id.link_importe);
        Button primario = view.findViewById(R.id.btnImporte);

        // Asignación de textos
        titulo.setText(getString(R.string.titulo_importe));
        primario.setText(getString(R.string.confirmar_importe));
        link.setText(getString(R.string.cambiar_importe));

        // Botones

        primario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primario.getText().equals(getString(R.string.confirmar_importe))) {
                    // segundo form
                    Fragment form = new FormEntrega();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frameForms, form);
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {

                    // se deshabilita la edición
                    in.setSelected(false);
                    importe.setFocusable(false);

                    // se cambia el texto de los botones
                    primario.setText(getString(R.string.confirmar_importe));
                    link.setText(getString(R.string.cambiar_importe));
                }
            }
        });

        // Funcionalidad input importe
        importe.setFocusable(false);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (primario.getText().equals(getString(R.string.confirmar_importe))) {

                    // se guarda el importe actual
                    valorImporte = importe.getText().toString();

                    // se permite la edición
                    in.setSelected(true);
                    importe.setFocusable(true);
                    importe.requestFocus();

                    // se cambia el texto de los botones
                    primario.setText(getString(R.string.confirmar_edicion));
                    link.setText(getString(R.string.cancelar_edicion));

                } else {

                    // se deshabilita la edición
                    in.setSelected(false);
                    importe.setFocusable(false);

                    // se cambia el texto de los botones
                    primario.setText(getString(R.string.confirmar_importe));
                    link.setText(getString(R.string.cambiar_importe));

                    // se carga el importe sin modificar
                    importe.setText(valorImporte);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}


