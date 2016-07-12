package com.crom.encuesta.view_controller.admin;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.crom.encuesta.R;
import com.crom.encuesta.persistence.SuperDAO;
import com.crom.encuesta.view_controller.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarBDFragment extends Fragment {


    public ListarBDFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_bd, container, false);
        // For the cursor adapter, specify which columns go into which views
        String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
        int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1

        // Create an empty adapter we will use to display the loaded data.
        // We pass null for the cursor, then update it in onLoadFinished()
        ListView listView = (ListView) view.findViewById(R.id.listViewBd);
        ArrayList<String> values = new ArrayList<>();
        for (String s : SuperDAO.getInstance().read(((MainActivity) getActivity()).getDb())) {
            int i = 0;
            String s1 = "";
            for (int j = 0; j<s.toCharArray().length; j++) {
                char c = s.toCharArray()[j];
                switch (i){
                    case 0:
                        s1+=c;
                        break;
                    case 4:
                        s1+=c;
                        break;
                    case 5:
                        s1+=c;
                        break;
                    case 6:
                        s1+=c;
                        break;
                    case 7:
                        j=s.toCharArray().length;
                        break;
                }
                if(c==',')
                    i++;
            }
            values.add(s1);
        }
        if (values.isEmpty())
            values.add("Sin registros");
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
        FloatingActionButton button3 = (FloatingActionButton) view.findViewById(R.id.btnBack);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new AdminContentFragment()).commit();
                //v.setVisibility(View.GONE);
            }
        });
        return view;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
