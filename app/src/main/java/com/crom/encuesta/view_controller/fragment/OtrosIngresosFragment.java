package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtrosIngresosFragment extends Fragment {


    public OtrosIngresosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_otros_ingresos, container, false);

        Switch otros1 = (Switch) view.findViewById(R.id.otros_ingresos1);
        Switch otros2a = (Switch) view.findViewById(R.id.otros_ingresos2a);
        Switch otros2b = (Switch) view.findViewById(R.id.otros_ingresos2b);
        Switch otros2c = (Switch) view.findViewById(R.id.otros_ingresos2c);

        final TextView Totros2a = (TextView) view.findViewById(R.id.otros_text2a);
        final TextView Totros2b = (TextView) view.findViewById(R.id.otros_text2b);
        final TextView Totros2c = (TextView) view.findViewById(R.id.otros_text2c);


        otros2a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2a.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2a.setVisibility(View.GONE);
                }
            }
        });

        otros2b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2b.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2b.setVisibility(View.GONE);
                }
            }
        });
        otros2c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Totros2c.setVisibility(View.VISIBLE);
                }
                else{
                    Totros2c.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }

}
