package com.example.dars_21_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private RecyclerView rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        rv = view.findViewById(R.id.rv);
//        getActivity() instanceof MainActivity
        Adapter adapter = new Adapter(getActivity(), genPosts());
        rv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rv.setAdapter(adapter);
    }

    private ArrayList<Post> genPosts() {
        ArrayList<Post> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add(new Post("title-" + i, Constant.CONTENT));
        }
        return list;
    }
}
