package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.subFragment.ListaEdadSubFragment;
import com.crom.encuesta.view_controller.subFragment.ListaHogaresSubFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdentificacionFragment extends Fragment {
    public IdentificacionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_identificacion, container, false);
        Spinner zona = (Spinner) view.findViewById(R.id.spiner_zona);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.zona_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zona.setAdapter(adapter);
        final EditText numHogares = (EditText) view.findViewById(R.id.editText_num_hogares);
       // Button siguiente = (Button) view.findViewById(R.id.)
        numHogares.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    int size = 0;
                    try {
                        size = Integer.parseInt(numHogares.getText()+"");
                    }finally {
                        for (int i = 0;i<size && size>0;i++) {
                            getFragmentManager().beginTransaction().replace(R.id.content_hogares,
                                    ListaHogaresSubFragment.newInstance(size)).commit();
                        }
                    }
                }
                return false;
            }
        });

        final EditText numPersonasHogar = (EditText) view.findViewById(R.id.editText_num_persona_hogar);
        numPersonasHogar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    int size = 0;
                    try {
                        size = Integer.parseInt(numPersonasHogar.getText() + "");
                    } finally {
                        for (int i = 0; i < size && size > 0; i++) {
                            getFragmentManager().beginTransaction().replace(R.id.content_edades,
                                    ListaEdadSubFragment.newInstance(size)).commit();
                        }
                    }
                }
                return false;
            }
        });
        //RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.content_edades);
        //relativeLayout.setVisibility(View.INVISIBLE);

        return view;
    }
}