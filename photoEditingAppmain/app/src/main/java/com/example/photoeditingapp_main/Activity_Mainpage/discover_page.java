package com.example.photoeditingapp_main.Activity_Mainpage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.photoeditingapp_main.R;
import com.example.photoeditingapp_main._Classes.GlobalVariables;
import com.example.photoeditingapp_main._Classes.PictureItem;
import com.example.photoeditingapp_main._Classes._DiscoverAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link discover_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class discover_page extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GlobalVariables gv;
    _DiscoverAdapter adapter;
    ArrayList<PictureItem> listDiscoverItem;
    RecyclerView rv;

    public discover_page() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment discover_page.
     */
    // TODO: Rename and change types and number of parameters
    public static discover_page newInstance(String param1, String param2) {
        discover_page fragment = new discover_page();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover_page, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView pageName = requireActivity().findViewById(R.id.pageName);
        pageName.setText("DISCOVER");

        gv = (GlobalVariables) requireActivity().getApplication();
        listDiscoverItem = gv.listDiscoverItem;

        rv = view.findViewById(R.id.recyclerview_discover);

        Log.i("DISCOVER", Integer.toString(listDiscoverItem.size()));

        adapter = new _DiscoverAdapter(gv.listDiscoverItem, gv.tempImageStorage);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }
}