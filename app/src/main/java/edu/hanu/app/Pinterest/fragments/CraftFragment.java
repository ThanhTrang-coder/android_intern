package edu.hanu.app.Pinterest.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.hanu.app.Pinterest.adapters.CraftAdapter;
import edu.hanu.app.Pinterest.models.Craft;
import edu.hanu.mydesign.R;

public class CraftFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_craft, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        CraftAdapter adapter = new CraftAdapter(getContext(), getData());
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Craft> getData() {
        ArrayList<Craft> list = new ArrayList<>();
        list.add(new Craft(R.drawable.image, "Image 1"));
        list.add(new Craft(R.drawable.image4, "Image 2"));
        list.add(new Craft(R.drawable.image5, "Image 3"));
        list.add(new Craft(R.drawable.image2, "Image 4"));
        list.add(new Craft(R.drawable.image8, "Image 5"));
        list.add(new Craft(R.drawable.image5, "Image 5"));
        list.add(new Craft(R.drawable.image6, "Image 6"));
        list.add(new Craft(R.drawable.image4, "Image 4"));
        list.add(new Craft(R.drawable.image1, "Image 5"));
        list.add(new Craft(R.drawable.image6, "Image 6"));
        list.add(new Craft(R.drawable.image4, "Image 6"));
        list.add(new Craft(R.drawable.image8, "Image 4"));

        return list;
    }
}