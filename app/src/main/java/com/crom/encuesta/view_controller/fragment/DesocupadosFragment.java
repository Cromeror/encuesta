package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesocupadosFragment extends Fragment {


    public DesocupadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desocupados, container, false);

        Spinner des_3 = (Spinner) view.findViewById(R.id.spiner_desocupados_3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_3_8, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_3.setAdapter(adapter3);

        Spinner des_8 = (Spinner) view.findViewById(R.id.spiner_desocupados_8);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_3_8, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_8.setAdapter(adapter8);

        Spinner des_9 = (Spinner) view.findViewById(R.id.spiner_desocupados_9);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_9, android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_9.setAdapter(adapter9);

        Spinner des_10 = (Spinner) view.findViewById(R.id.spiner_desocupados_10);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_10, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_10.setAdapter(adapter10);

        Spinner des_11 = (Spinner) view.findViewById(R.id.spiner_desocupados_11);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_11, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_11.setAdapter(adapter11);

        Spinner des_12 = (Spinner) view.findViewById(R.id.spiner_desocupados_12);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_12, android.R.layout.simple_spinner_item);
        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        des_12.setAdapter(adapter12);

        final EditText ed3 = (EditText) view.findViewById(R.id.desocupados_3);
        des_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==8){
                    ed3.setVisibility(View.VISIBLE);
                }
                else{
                    ed3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final EditText ed8 = (EditText) view.findViewById(R.id.desocupados_8);
        des_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==8){
                    ed8.setVisibility(View.VISIBLE);
                }
                else{
                    ed8.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText ed11 = (EditText) view.findViewById(R.id.desocupados_11);
        des_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==7){
                    ed11.setVisibility(View.VISIBLE);
                }
                else{
                    ed11.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText ed12 = (EditText) view.findViewById(R.id.desocupados_12);
        des_12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==6){
                    ed12.setVisibility(View.VISIBLE);
                }
                else{
                    ed12.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText ed13 = (EditText) view.findViewById(R.id.desocupados_13);
        Switch swt13 = (Switch) view.findViewById(R.id.switch_desocupados_13);
        swt13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ed13.setVisibility(View.VISIBLE);
                }
                else{
                    ed13.setVisibility(View.GONE);
                }
            }
        });


        return view;
    }

}
