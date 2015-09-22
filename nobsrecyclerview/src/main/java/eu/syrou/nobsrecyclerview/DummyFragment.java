package eu.syrou.nobsrecyclerview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Syrou on 2015-09-20.
 */
public class DummyFragment extends Fragment {

    private int color;
    SimpleRecyclerAdapter adapter;
    private ArrayList mData;

    public DummyFragment() {
    }

    @SuppressLint("ValidFragment")
    public DummyFragment(int color, ArrayList data) {
        this.color = color;
        mData=data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dummy_fragment, container, false);

        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
        frameLayout.setBackgroundColor(color);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SimpleRecyclerAdapter(mData);
        recyclerView.setAdapter(adapter);

        return view;
    }

}