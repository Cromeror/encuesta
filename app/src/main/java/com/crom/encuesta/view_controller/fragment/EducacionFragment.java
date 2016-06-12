package com.crom.encuesta.view_controller.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.subFragment.EstablecimientoEducativoSubFragment;

/**
 * Created by Katherine Buelvas on 15/04/16.
 */
public class EducacionFragment extends Fragment {
    private EstablecimientoEducativoSubFragment establecimiento;
    private Button next;
    private FragmentTransaction transaction;

    public EducacionFragment newInstance() {
        EducacionFragment fragment = new EducacionFragment();
        Bundle args = new Bundle();
        /*args.putInt(PARAM_EDAD, edad);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_educacion, container, false);
        transaction = getActivity().getSupportFragmentManager().beginTransaction();

        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();
        establecimiento = new EstablecimientoEducativoSubFragment();
        Switch estudia = (Switch) view.findViewById(R.id.estudia);
        estudia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    getFragmentManager().beginTransaction().replace(R.id.content_establecimiento, establecimiento).commit();
                } else {
                    getFragmentManager().beginTransaction().remove(establecimiento).commit();
                }
            }
        });
        Spinner nivelEducativo = (Spinner) view.findViewById(R.id.nivel_educativo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.nivel_educativo_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nivelEducativo.setAdapter(adapter);
        nivelEducativo.setSelection(4);
        final Spinner tituloMayor = (Spinner) view.findViewById(R.id.mayor_titulo_obtenido);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.titulo_educativo_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tituloMayor.setAdapter(adapter2);

        nivelEducativo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position <= 3 || position == 6) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });

        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transaction.replace(R.id.contenedor, SaludFragment.newInstance(edad)).commit();
                /*Intent i = new Intent(v.getContext(),FamilyActivity.class);
                startActivity(i);*/

                transaction.replace(R.id.contenedor, new FuerzaFragment()).commit();
            }
        });
    }
}
