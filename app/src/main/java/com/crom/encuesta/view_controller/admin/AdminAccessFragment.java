package com.crom.encuesta.view_controller.admin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminAccessFragment extends Fragment {
private static String ACCESS = "admin2016";

    public AdminAccessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_admin_access, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ACCESS.equals(((EditText) view.findViewById(R.id.editText)).getText().toString())){
                    getFragmentManager().beginTransaction().replace(R.id.contenedor,new AdminContentFragment()).commit();
                }else
                    Toast.makeText(getActivity(), "Contraseña INCORRECTA", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
