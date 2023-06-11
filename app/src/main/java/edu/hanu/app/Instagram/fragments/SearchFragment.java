package edu.hanu.app.Instagram.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.Instagram.adapters.ListPhotoAdapter;
import edu.hanu.app.Instagram.models.ListPhoto;
import edu.hanu.app.Instagram.models.Photo;
import edu.hanu.mydesign.R;

public class SearchFragment extends Fragment {
    RecyclerView rcvPhoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_instagram, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvPhoto = view.findViewById(R.id.rcvPhoto);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcvPhoto.setLayoutManager(manager);

        ListPhotoAdapter adapter = new ListPhotoAdapter(getListPhoto());
        rcvPhoto.setAdapter(adapter);
    }

    private List<ListPhoto> getListPhoto() {
        List<ListPhoto> listPhotos = new ArrayList<>();

        List<Photo> list = new ArrayList<>();
        list.add(new Photo(R.drawable.image6));
        list.add(new Photo(R.drawable.image7));
        list.add(new Photo(R.drawable.image5));

        List<Photo> list2 = new ArrayList<>();
        list2.add(new Photo(R.drawable.image6));
        list2.add(new Photo(R.drawable.image3));
        list2.add(new Photo(R.drawable.image5));
        list2.add(new Photo(R.drawable.image8));
        list2.add(new Photo(R.drawable.image7));

        List<Photo> list3 = new ArrayList<>();
        list3.add(new Photo(R.drawable.image7));
        list3.add(new Photo(R.drawable.image5));
        list3.add(new Photo(R.drawable.image6));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LARGE, list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID, list));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID, list3));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LARGE, list2));

        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_LARGE, list2));
        listPhotos.add(new ListPhoto(ListPhotoAdapter.TYPE_GRID, list));

        return listPhotos;
    }
}