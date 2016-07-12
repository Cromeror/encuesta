package com.crom.encuesta.view_controller.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActionFormFragment extends Fragment {
    private Button next, hogar, miembro;
    private View view;
    private FragmentTransaction transaction;

    public ActionFormFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_action_form, container, false);
        getActivity().setTitle(R.string.app_name);
        next = (Button) view.findViewById(R.id.finish_btn);
        miembro = (Button) view.findViewById(R.id.miembro_btn);
        hogar = (Button) view.findViewById(R.id.hogar_btn);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        init();
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).isActivado())
                    getDialog();
                else {
                    Toast.makeText(getActivity(), "RECUERDE: En esta vista no se guardarán los datos", Toast.LENGTH_SHORT).show();

                }
            }
        });
        miembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new MiembroHogarFragment()).commit();
            }
        });
        hogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new IdentificacionFragment()).commit();
            }
        });
    }

    private void getDialog() {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("RECUERDE: Al guardar los datos no podrá modificarlos\n¿Desea continuar?")
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.i("Finalizar", "");
                        SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());
                        Toast.makeText(getActivity(), "Datos guardados", Toast.LENGTH_SHORT).show();
                        transaction.replace(R.id.contenedor, new IdentificacionFragment()).commit();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }

}