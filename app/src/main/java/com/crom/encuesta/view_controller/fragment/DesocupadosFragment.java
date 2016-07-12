package com.crom.encuesta.view_controller.fragment;


import android.graphics.Color;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Desocupado;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.custom.DialogBuilder;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DesocupadosFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public DesocupadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_desocupados, container, false);
        getActivity().setTitle(getString(R.string.capMHogarF));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        return view;
    }

    private void init() {
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

        final EditText ed3 = (EditText) view.findViewById(R.id.desocupados_3);
        des_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 8) {
                    ed3.setVisibility(View.VISIBLE);
                } else {
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
                if (position == 8) {
                    ed8.setVisibility(View.VISIBLE);
                } else {
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
                if (position == 7) {
                    ed11.setVisibility(View.VISIBLE);
                } else {
                    ed11.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText ed13 = (EditText) view.findViewById(R.id.desocupados_13);
        Spinner spinner13 = (Spinner) view.findViewById(R.id.spinner_desocupados_13);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(getActivity(),
                R.array.si_no, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner13.setAdapter(adapter13);
        spinner13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                if (i == 0) {
                    ed13.setVisibility(View.VISIBLE);
                } else {
                    ed13.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner4 = (Spinner) view.findViewById(R.id.spinner_desocupados_4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.desocupados_4_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setSelection(1);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int position, long l) {
                switch (position) {
                    case 0:
                        if (save(4))
                            transaction.replace(R.id.contenedor, new OtrosIngresosFragment()).commit();
                        break;
                    case 1:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        final TextView desocupado12 = (TextView) view.findViewById(R.id.textview_desocupados_12);
        desocupado12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuilder dialogBuilder = new DialogBuilder();
                desocupado.setF12(callBackList);
                dialogBuilder.MultipleChoiceList(callBackList, desocupado12, getActivity(), "", R.array.desocupados_12_array);
            }
        });
        desocupado12.setBackgroundColor(Color.RED);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save(1))
                    transaction.replace(R.id.contenedor, new OtrosIngresosFragment()).commit();
            }
        });
    }

    private ArrayList<String> callBackList = new ArrayList();
    private Desocupado desocupado = new Desocupado();

    private boolean save(int caso) {
        ((MainActivity) getActivity()).getMiembro().setDesocupado(desocupado);
        desocupado.setF1(((EditText) view.findViewById(R.id.desocupados_1)).getText().toString());
        desocupado.setF2(((EditText) view.findViewById(R.id.desocupados_2)).getText().toString());
        Spinner desocupados_spinner = (Spinner) view.findViewById(R.id.spiner_desocupados_3);
        if (!desocupados_spinner.getSelectedItem().toString().equalsIgnoreCase("otro"))
            desocupado.setF3(desocupados_spinner.getSelectedItem().toString());
        else {
            desocupado.setF3(((EditText) view.findViewById(R.id.desocupados_3)).getText().toString());
        }
        if (caso == 4) {
            Spinner desocupado4 = (Spinner) view.findViewById(R.id.spinner_desocupados_4);
            desocupado.setF4(desocupado4.getSelectedItem().toString());
            if (desocupado4.getSelectedItemPosition() == 0) {
                Log.i("Desocupado", desocupado.toString());
                return true;
            }
        }


        desocupado.setF5(((EditText) view.findViewById(R.id.desocupados_5)).getText().toString());
        desocupado.setF6(((EditText) view.findViewById(R.id.desocupados_6)).getText().toString());
        desocupado.setF7(((EditText) view.findViewById(R.id.desocupados_7)).getText().toString());

        desocupados_spinner = (Spinner) view.findViewById(R.id.spiner_desocupados_8);
        if (!desocupados_spinner.getSelectedItem().toString().equalsIgnoreCase("otro"))
            desocupado.setF8(desocupados_spinner.getSelectedItem().toString());
        else {
            desocupado.setF8(((EditText) view.findViewById(R.id.desocupados_8)).getText().toString());
        }
        desocupado.setF9(((Spinner) view.findViewById(R.id.spiner_desocupados_9)).getSelectedItem().toString());
        desocupado.setF10(((Spinner) view.findViewById(R.id.spiner_desocupados_10)).getSelectedItem().toString());
        Spinner spinner11 = (Spinner) view.findViewById(R.id.spiner_desocupados_11);
        if (spinner11.getSelectedItemPosition() == 8) {
            desocupado.setF11(((EditText) view.findViewById(R.id.desocupados_11)).getText().toString());
        } else
            desocupado.setF11(spinner11.getSelectedItem().toString());
        if (!((EditText) view.findViewById(R.id.desocupados_12)).getText().toString().equals("")) {
            desocupado.getF12().add(((EditText) view.findViewById(R.id.desocupados_12)).getText().toString());
        }

        Spinner spinner13 = (Spinner) view.findViewById(R.id.spinner_desocupados_13);
        if (spinner13.getSelectedItemPosition() == 0)
            desocupado.setF13(((EditText) view.findViewById(R.id.desocupados_13)).getText().toString());
        else desocupado.setF13(spinner13.getSelectedItem().toString());
        desocupado.setMiembroId(((MainActivity) getActivity()).getMiembro().getId());
        Log.i("Desocupado", desocupado.toString());
        SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());
        return true;
    }

}
