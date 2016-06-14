package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalidadEmpleoFragment extends Fragment {

    public CalidadEmpleoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calidad_empleo, container, false);

        Spinner empl_57a = (Spinner) view.findViewById(R.id.empleo_57a);
        Spinner empl_57b = (Spinner) view.findViewById(R.id.empleo_57b);
        Spinner empl_57c = (Spinner) view.findViewById(R.id.empleo_57c);
        Spinner empl_57d = (Spinner) view.findViewById(R.id.empleo_57d);
        Spinner empl_57e = (Spinner) view.findViewById(R.id.empleo_57e);
        Spinner empl_57f = (Spinner) view.findViewById(R.id.empleo_57f);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_57, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_57a.setAdapter(adapter);
        empl_57b.setAdapter(adapter);
        empl_57c.setAdapter(adapter);
        empl_57d.setAdapter(adapter);
        empl_57e.setAdapter(adapter);
        empl_57f.setAdapter(adapter);

        Spinner empl_59 = (Spinner) view.findViewById(R.id.empleo_59);
        ArrayAdapter<CharSequence> adapter59 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_59, android.R.layout.simple_spinner_item);
        adapter59.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_59.setAdapter(adapter59);

        Spinner empl_60 = (Spinner) view.findViewById(R.id.empleo_60);
        ArrayAdapter<CharSequence> adapter60 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_60, android.R.layout.simple_spinner_item);
        adapter60.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_60.setAdapter(adapter60);

        Spinner empl_61 = (Spinner) view.findViewById(R.id.empleo_61);
        ArrayAdapter<CharSequence> adapter61 = ArrayAdapter.createFromResource(getActivity(),R.array.empleo_61, android.R.layout.simple_spinner_item);
        adapter61.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        empl_61.setAdapter(adapter61);

        final EditText ed61 = (EditText) view.findViewById(R.id.otro_61);
        empl_61.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==9){
                    ed61.setVisibility(View.VISIBLE);
                }
                else{
                    ed61.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

}
