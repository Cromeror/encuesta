package com.crom.encuesta.view_controller.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
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
import com.crom.encuesta.view_controller.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;

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
                saveExternal();
                getDialog();

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
                        try {
                            Toast.makeText(getActivity(), "Datos guardados", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {

                        }
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

    public void saveExternal() {
        if (isExternalStorageWritable()) {
            try {
                File ruta_sd_global = Environment.getExternalStorageDirectory();
                Date fecha = new Date();
                File f = new File(ruta_sd_global.getAbsolutePath(), "import_" + fecha + ".csv");
                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                fout.write(((MainActivity) getActivity()).getVivienda().toString() + "");
                fout.close();
            } catch (Exception ex) {
                Log.i("#####", "" + ex.toString());
                Toast.makeText(getActivity(), "Error al escribir fichero", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}