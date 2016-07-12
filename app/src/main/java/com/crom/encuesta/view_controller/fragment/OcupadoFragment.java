package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.model.Ocupado;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class OcupadoFragment extends Fragment {
    private Button next;
    private View view;
    private FragmentTransaction transaction;
    private Ocupado ocupado;

    public OcupadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_ocupado, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarE));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ocupado = ((MainActivity) getActivity()).getOcupado();

        next = (Button) view.findViewById(R.id.next_gnrl_btn);
        init();
        Spinner ocupado_4 = (Spinner) view.findViewById(R.id.e4spinner);
        ArrayAdapter<CharSequence> spinner_adapter_4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_4, android.R.layout.simple_spinner_item);
        spinner_adapter_4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_4.setAdapter(spinner_adapter_4);
        ocupado_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String scountry = adapter.getItemAtPosition(position).toString();

                if (scountry.equalsIgnoreCase("no")) {
                    Spinner ocupado_5 = (Spinner) view.findViewById(R.id.e5spinner);
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
                    Spinner ocupado_7a = (Spinner) view.findViewById(R.id.ocupado_7a);
                    EditText ocupado_8 = (EditText) view.findViewById(R.id.ocupado_8);
                    TextView textView_9_text = (TextView) view.findViewById(R.id.ocupado_9_texto);
                    Spinner ocupado_9 = (Spinner) view.findViewById(R.id.ocupado_9);
                    CheckBox ocupado_11_a = (CheckBox) view.findViewById(R.id.ocupado_10_a);
                    CheckBox ocupado_11_b = (CheckBox) view.findViewById(R.id.ocupado_10_b);
                    CheckBox ocupado_11_c = (CheckBox) view.findViewById(R.id.ocupado_10_c);
                    TextView ocupado_5_text = (TextView) view.findViewById(R.id.ocupado_5_texto);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    TextView ocupado_7_text = (TextView) view.findViewById(R.id.ocupado_7_texto);
                    TextView ocupado_7a_text = (TextView) view.findViewById(R.id.ocupado_7a_texto);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    TextView ocupado_11_text = (TextView) view.findViewById(R.id.ocupado_10_texto);

                    ocupado_5.setVisibility(View.GONE);
                    ocupado_6.setVisibility(View.GONE);
                    ocupado_7.setVisibility(View.GONE);
                    ocupado_7a.setVisibility(View.GONE);
                    ocupado_8.setVisibility(View.GONE);
                    ocupado_9.setVisibility(View.GONE);
                    ocupado_11_a.setVisibility(View.GONE);
                    ocupado_11_b.setVisibility(View.GONE);
                    ocupado_11_c.setVisibility(View.GONE);
                    ocupado_5_text.setVisibility(View.GONE);
                    ocupado_6_text.setVisibility(View.GONE);
                    ocupado_7_text.setVisibility(View.GONE);
                    ocupado_7a_text.setVisibility(View.GONE);
                    ocupado_8_text.setVisibility(View.GONE);
                    textView_9_text.setVisibility(View.GONE);
                    ocupado_11_text.setVisibility(View.GONE);

                } else {
                    Spinner ocupado_5 = (Spinner) view.findViewById(R.id.e5spinner);
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
                    Spinner ocupado_7a = (Spinner) view.findViewById(R.id.ocupado_7a);
                    EditText ocupado_8 = (EditText) view.findViewById(R.id.ocupado_8);
                    TextView textView_9_text = (TextView) view.findViewById(R.id.ocupado_9_texto);
                    Spinner ocupado_9 = (Spinner) view.findViewById(R.id.ocupado_9);
                    CheckBox ocupado_11_a = (CheckBox) view.findViewById(R.id.ocupado_10_a);
                    CheckBox ocupado_11_b = (CheckBox) view.findViewById(R.id.ocupado_10_b);
                    CheckBox ocupado_11_c = (CheckBox) view.findViewById(R.id.ocupado_10_c);
                    TextView ocupado_5_text = (TextView) view.findViewById(R.id.ocupado_5_texto);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    TextView ocupado_7_text = (TextView) view.findViewById(R.id.ocupado_7_texto);
                    TextView ocupado_7a_text = (TextView) view.findViewById(R.id.ocupado_7a_texto);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    TextView ocupado_11_text = (TextView) view.findViewById(R.id.ocupado_10_texto);

                    ocupado_5.setVisibility(View.VISIBLE);
                    ocupado_6.setVisibility(View.VISIBLE);
                    ocupado_7.setVisibility(View.VISIBLE);
                    ocupado_7a.setVisibility(View.VISIBLE);
                    ocupado_8.setVisibility(View.VISIBLE);
                    ocupado_9.setVisibility(View.VISIBLE);
                    ocupado_11_a.setVisibility(View.VISIBLE);
                    ocupado_11_b.setVisibility(View.VISIBLE);
                    ocupado_11_c.setVisibility(View.VISIBLE);
                    ocupado_5_text.setVisibility(View.VISIBLE);
                    ocupado_6_text.setVisibility(View.VISIBLE);
                    ocupado_7_text.setVisibility(View.VISIBLE);
                    ocupado_7a_text.setVisibility(View.VISIBLE);
                    ocupado_8_text.setVisibility(View.VISIBLE);
                    textView_9_text.setVisibility(View.VISIBLE);
                    ocupado_11_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner ocupado_9 = (Spinner) view.findViewById(R.id.ocupado_9);
        ArrayAdapter spinner_adapter_9 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        spinner_adapter_9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_9.setAdapter(spinner_adapter_9);


        Spinner ocupado_5 = (Spinner) view.findViewById(R.id.e5spinner);
        ArrayAdapter spinner_adapter_5 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_5, android.R.layout.simple_spinner_item);
        spinner_adapter_5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_5.setAdapter(spinner_adapter_5);
        ocupado_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if (position == 1 || position == 2) {
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    ocupado_6.setVisibility(View.GONE);
                    ocupado_6_text.setVisibility(View.GONE);
                } else {
                    Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
                    TextView ocupado_6_text = (TextView) view.findViewById(R.id.ocupado_6_texto);
                    ocupado_6.setVisibility(View.VISIBLE);
                    ocupado_6_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner ocupado_6 = (Spinner) view.findViewById(R.id.ocupado_6);
        ArrayAdapter spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_6, android.R.layout.simple_spinner_item);
        spinner_adapter_6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_6.setAdapter(spinner_adapter_6);

        Spinner ocupado_8 = (Spinner) view.findViewById(R.id.ocupado_7a);
        ArrayAdapter spinner_adapter_8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_8, android.R.layout.simple_spinner_item);
        spinner_adapter_8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_8.setAdapter(spinner_adapter_8);

        Spinner ocupado_7 = (Spinner) view.findViewById(R.id.ocupado_7);
        ArrayAdapter spinner_adapter_7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_7, android.R.layout.simple_spinner_item);
        spinner_adapter_7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_7.setAdapter(spinner_adapter_7);
        ocupado_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (position == 1 || position == 2) {
                    Spinner ocupado_7a = (Spinner) view.findViewById(R.id.ocupado_7a);
                    TextView ocupado_7a_text = (TextView) view.findViewById(R.id.ocupado_7a_texto);
                    EditText ocupado_8 = (EditText) view.findViewById(R.id.ocupado_8);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    ocupado_7a.setVisibility(View.GONE);
                    ocupado_7a_text.setVisibility(View.GONE);
                    ocupado_8.setVisibility(View.GONE);
                    ocupado_8_text.setVisibility(View.GONE);
                } else {
                    Spinner ocupado_7a = (Spinner) view.findViewById(R.id.ocupado_7a);
                    TextView ocupado_7a_text = (TextView) view.findViewById(R.id.ocupado_7a_texto);
                    EditText ocupado_8 = (EditText) view.findViewById(R.id.ocupado_8);
                    TextView ocupado_8_text = (TextView) view.findViewById(R.id.ocupado_8_texto);
                    ocupado_7a.setVisibility(View.VISIBLE);
                    ocupado_7a_text.setVisibility(View.VISIBLE);
                    ocupado_8.setVisibility(View.VISIBLE);
                    ocupado_8_text.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        ((LinearLayout) view.findViewById(R.id.ocupado12a)).setVisibility(View.GONE);
        Spinner ocupado_12 = (Spinner) view.findViewById(R.id.ocupado_12);
        ArrayAdapter spinner_adapter_12 = ArrayAdapter.createFromResource(getActivity(),
                R.array.ocupados_12, android.R.layout.simple_spinner_item);
        spinner_adapter_12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ocupado_12.setAdapter(spinner_adapter_12);
        ocupado_12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Trabajador por cuenta propia") || scountry.equalsIgnoreCase("Otro")) {
                    //save();
                    ((LinearLayout) view.findViewById(R.id.ocupado12a)).setVisibility(View.VISIBLE);
                    next.setVisibility(View.GONE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.ocupado12a)).setVisibility(View.GONE);
                    next.setVisibility(View.VISIBLE);
                }
                if (scountry.equalsIgnoreCase("Trabajador familiar sin remuneración")) {
                    if (save())                        SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());

                    transaction.replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        ((Button) view.findViewById(R.id.otro_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new OcupadoIndependienteFragment()).commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (save())                        SuperDAO.getInstance().update(((MainActivity) getActivity()).getDb(), ((MainActivity) getActivity()).getVivienda().getId(),((MainActivity) getActivity()).getVivienda());

                transaction.replace(R.id.contenedor, new OcupadosAsalariadosFragment()).commit();
            }
        });
    }

    private boolean save() {
        ocupado.setE1(((EditText) view.findViewById(R.id.e1)).getText().toString());
        ocupado.setE2(((EditText) view.findViewById(R.id.e2)).getText().toString());
        ocupado.setE3(((EditText) view.findViewById(R.id.e3)).getText().toString());

        Spinner e4Spinner = (Spinner) view.findViewById(R.id.e4spinner);
        ocupado.setE4(e4Spinner.getSelectedItem().toString());
        if (e4Spinner.getSelectedItemPosition() == 1) {
            return save11_12();
        }
        Spinner e5Spinner = (Spinner) view.findViewById(R.id.e5spinner);
        ocupado.setE5(e5Spinner.getSelectedItem().toString());
        if (e5Spinner.getSelectedItemPosition() > 0) {
            return save7();
        }
        Spinner e6Spinner = (Spinner) view.findViewById(R.id.ocupado_6);
        ocupado.setE6(e6Spinner.getSelectedItem().toString());
        return save7();
    }

    private boolean save7() {
        Spinner e7Spinner = (Spinner) view.findViewById(R.id.ocupado_7);
        ocupado.setE7(e7Spinner.getSelectedItem().toString());
        if (e7Spinner.getSelectedItemPosition() > 0) {
            return save9();
        }
        Spinner e7aSpinner = (Spinner) view.findViewById(R.id.ocupado_7a);
        ocupado.setE7a(e7aSpinner.getSelectedItem().toString());
        ocupado.setE8(((EditText) view.findViewById(R.id.ocupado_8)).getText().toString());
        return save9();
    }

    private boolean save9() {
        Spinner e9Spinner = (Spinner) view.findViewById(R.id.ocupado_9);
        ocupado.setE9(e9Spinner.getSelectedItem().toString());
        CheckBox checkBox1 = (CheckBox) view.findViewById(R.id.ocupado_10_a);
        CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.ocupado_10_b);
        CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.ocupado_10_c);
        ocupado.setE10a(checkBox1.getText().toString());
        ocupado.setE10b(checkBox2.getText().toString());
        ocupado.setE10c(checkBox3.getText().toString());
        return save11_12();
    }

    private boolean save11_12() {
        ocupado.setE11(((EditText) view.findViewById(R.id.e11)).getText().toString());
        Spinner e12Spinner = (Spinner) view.findViewById(R.id.ocupado_12);
        if (e12Spinner.getSelectedItemPosition() == 8) {
            ocupado.setE12(((EditText) view.findViewById(R.id.e12editText)).getText().toString());
        } else
            ocupado.setE12(e12Spinner.getSelectedItem().toString());
        return true;
    }

}
