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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.crom.encuesta.R;
import com.crom.encuesta.model.TIC;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;
import com.crom.encuesta.view_controller.util.Validador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicsFragment extends Fragment {
    public View view;
    private FragmentTransaction transaction;
    private Spinner tics_1;
    private Spinner tics_2;
    private Spinner tics_5;
    private TIC tic;

    public TicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tics, container, false);
        getActivity().setTitle(getString(R.string.capMHogarI));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        tic = new TIC();
        init();

        return view;
    }

    private void init() {
        tics_1 = (Spinner) view.findViewById(R.id.spiner_tic_1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_1_2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_1.setAdapter(adapter1);

        tics_2 = (Spinner) view.findViewById(R.id.spiner_tic_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_1_2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_2.setAdapter(adapter2);
        final LinearLayout ocultar = (LinearLayout) view.findViewById(R.id.tic_ocultar);
        tics_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    ocultar.setVisibility(View.VISIBLE);
                } else {
                    ocultar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText tic3otro = (EditText) view.findViewById(R.id.et3);
        final EditText tic4otro = (EditText) view.findViewById(R.id.et4);
        tic3otro.setVisibility(View.GONE);
        tic4otro.setVisibility(View.GONE);

        CheckBox tic3g = (CheckBox) view.findViewById(R.id.cbox_tics_3g);
        tic3g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    tic3otro.setVisibility(View.VISIBLE);
                else
                    tic3otro.setVisibility(View.GONE);

            }
        });
        CheckBox tic4g = (CheckBox) view.findViewById(R.id.cbox_tics_4g);
        tic4g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    tic4otro.setVisibility(View.VISIBLE);
                else
                    tic4otro.setVisibility(View.GONE);

            }
        });

        tics_5 = (Spinner) view.findViewById(R.id.spiner_tic_5);
        adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.tics_5, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tics_5.setAdapter(adapter2);

        Button next = (Button) view.findViewById(R.id.next_gnrl_btn);
        Log.i("##", "Mas adelante se le presentarán las opciones que puede colocar en la barra de acciones");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())
                    transaction.replace(R.id.contenedor, new ActionFormFragment()).commit();
            }
        });
    }

    private boolean save() {
        if(((LinearLayout)view.findViewById(R.id.tic_ocultar)).getVisibility()==View.VISIBLE) {
            CheckBox tic3a = (CheckBox) view.findViewById(R.id.cbox_tics_3a);
            CheckBox tic3b = (CheckBox) view.findViewById(R.id.cbox_tics_3b);
            CheckBox tic3c = (CheckBox) view.findViewById(R.id.cbox_tics_3c);
            CheckBox tic3d = (CheckBox) view.findViewById(R.id.cbox_tics_3d);
            CheckBox tic3e = (CheckBox) view.findViewById(R.id.cbox_tics_3e);
            CheckBox tic3f = (CheckBox) view.findViewById(R.id.cbox_tics_3f);
            CheckBox tic3g = (CheckBox) view.findViewById(R.id.cbox_tics_3g);

            CheckBox tic4a = (CheckBox) view.findViewById(R.id.cbox_tics_4a);
            CheckBox tic4b = (CheckBox) view.findViewById(R.id.cbox_tics_4b);
            CheckBox tic4c = (CheckBox) view.findViewById(R.id.cbox_tics_4c);
            CheckBox tic4d = (CheckBox) view.findViewById(R.id.cbox_tics_4d);
            CheckBox tic4e = (CheckBox) view.findViewById(R.id.cbox_tics_4e);
            CheckBox tic4f = (CheckBox) view.findViewById(R.id.cbox_tics_4f);
            CheckBox tic4g = (CheckBox) view.findViewById(R.id.cbox_tics_4g);

            EditText tic3otro = (EditText) view.findViewById(R.id.et3);
            EditText tic4otro = (EditText) view.findViewById(R.id.et4);

            if (Validador.isEmptyMultiCheckBoxes(tic3a, tic3b, tic3c, tic3d, tic3e, tic3f, tic3g)
                    || Validador.isEmptyMultiCheckBoxes(tic4a, tic4b, tic4c, tic4d, tic4e, tic4f, tic4g)) {
                DialogBuilder builder = new DialogBuilder();
                builder.dialogIncompleteField(getActivity(), getString(R.string.incomplete));
                return false;
            }
            if (tic3g.isChecked()) {
                tic.setI3(multiCheckBoxesAsList(tic3a, tic3b, tic3c, tic3d, tic3e, tic3f));
                tic.getI3().add(tic3otro.getText().toString());
            } else {
                tic.setI3(multiCheckBoxesAsList(tic3a, tic3b, tic3c, tic3d, tic3e, tic3f));
            }
            if (tic4g.isChecked()) {
                tic.setI4(multiCheckBoxesAsList(tic4a, tic4b, tic4c, tic4d, tic4e, tic4f));
                tic.getI4().add(tic3otro.getText().toString());
            } else {
                tic.setI4(multiCheckBoxesAsList(tic4a, tic4b, tic4c, tic4d, tic4e, tic4f));
            }
        }
        tic.setI1(tics_1.getSelectedItem().toString());
        tic.setI2(tics_2.getSelectedItem().toString());
        tic.setI5(tics_5.getSelectedItem().toString());
        tic.setMiembroId(((MainActivity) getActivity()).getMiembro().getId());
        ((MainActivity) getActivity()).getMiembro().setTic(tic);
        Log.i("TIC toString", tic.toString());
        return true;
    }

    private ArrayList<String> multiCheckBoxesAsList(CheckBox... checkBoxes) {
        ArrayList<String> result = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked())
            result.add(checkBox.getText().toString());
        }
        return result;
    }
}
