package com.crom.encuesta.view_controller.admin;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminContentFragment extends Fragment {


    public AdminContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin_content, container, false);
        Button button = (Button) view.findViewById(R.id.btnImport);
        Button btnList = (Button) view.findViewById(R.id.btnList);
        Button btnDrop = (Button) view.findViewById(R.id.btnDrop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExternalStorageWritable()) {
                    try {
                        File ruta_sd_global = Environment.getExternalStorageDirectory();
                        //File ruta_sd_app_musica = getExternalFilesDir(Environment.DIRECTORY_MUSIC);
                        Calendar c = Calendar.getInstance();
                        String dia = Integer.toString(c.get(Calendar.DATE));
                        String mes = Integer.toString(c.get(Calendar.MONTH));
                        String annio = Integer.toString(c.get(Calendar.YEAR));
                        String hora = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
                        File f = new File(ruta_sd_global.getAbsolutePath(), "import_" + hora + "_" + dia + "-" + mes + "-" + annio + ")].csv");

                        OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                        for (String vivienda : SuperDAO.getInstance().read(((MainActivity) getActivity()).getDb())) {
                            fout.write(vivienda.toString() + "");
                        }
                        fout.close();
                        Toast.makeText(getActivity(), "Fichero creado con éxito\n Ruta: " + ruta_sd_global.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        //Log.i("Ficheros", vivienda.toString());
                    } catch (Exception ex) {
                        Log.i("#####", "" + ex.toString());
                        Toast.makeText(getActivity(), "Error al escribir fichero", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new ListarBDFragment()).commit();
            }
        });
        btnDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SuperDAO.getInstance().drop(((MainActivity) getActivity()).getDb());
                SuperDAO.getInstance().create(((MainActivity) getActivity()).getDb());
                Toast.makeText(getActivity(), "Base de datos Vacia.", Toast.LENGTH_SHORT).show();
                //getFragmentManager().beginTransaction().replace().commit();
            }
        });
        return view;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}
