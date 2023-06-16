package edu.hanu.app.test.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.test.SecondActivity;
import edu.hanu.app.test.adapters.TestAdapter;
import edu.hanu.app.test.models.HorizontalModel;
import edu.hanu.mydesign.R;

public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvHorizontal = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rvHorizontal.setLayoutManager(manager);
        TestAdapter adapter = new TestAdapter(getList());
        rvHorizontal.setAdapter(adapter);

//        RecyclerView rvVertical = view.findViewById(R.id.rvVertical);
//        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        rvVertical.setLayoutManager(manager1);
//        TestAdapter adapter1 = new TestAdapter(getList());
//        rvVertical.setAdapter(adapter1);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<HorizontalModel> getList() {
        List<HorizontalModel> list = new ArrayList<>();
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));
        list.add(new HorizontalModel(R.drawable.image6, "User name 1"));

        return list;
    }
}