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

import edu.hanu.app.Instagram.adapters.InsPostAdapter;
import edu.hanu.app.Instagram.adapters.InsStoryAdapter;
import edu.hanu.app.Instagram.models.InsPost;
import edu.hanu.app.Instagram.models.InsStory;
import edu.hanu.mydesign.R;

public class HomeFragment extends Fragment {
    RecyclerView rv_ins_story_list, rv_ins_post_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_instagram, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_ins_story_list = view.findViewById(R.id.rv_ins_story_list);
        rv_ins_post_list = view.findViewById(R.id.rv_ins_post_list);

        setUpStoryAdapter();
        setUpPostAdapter();

    }

    private void setUpStoryAdapter() {
        InsStoryAdapter insStoryAdapter = new InsStoryAdapter(getStoryList());
        LinearLayoutManager verticalLayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rv_ins_story_list.setLayoutManager(verticalLayout);
        rv_ins_story_list.setAdapter(insStoryAdapter);
    }

    private void setUpPostAdapter() {
        InsPostAdapter insPostAdapter = new InsPostAdapter(getPostList());
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rv_ins_post_list.setLayoutManager(horizontalLayout);
        rv_ins_post_list.setAdapter(insPostAdapter);
    }

    private List<InsPost> getPostList() {
        List<InsPost> list = new ArrayList<>();
        list.add(new InsPost(R.drawable.image, R.drawable.image8, "User 1", "03/06/2023", "Đây là nội dung bài post trên instagram.", "gitabigitabi", "Xin giá"));
        list.add(new InsPost(R.drawable.image7, R.drawable.image4, "User 2", "01/06/2023", "Đây là nội dung bài post trên instagram.", "_tomtom211_", "Mình xin giá ạ"));
        list.add(new InsPost(R.drawable.image5, R.drawable.image, "User 3", "29/05/2023", "Đây là nội dung bài post trên instagram.", "blalabla", "Xin giá"));
        list.add(new InsPost(R.drawable.image3, R.drawable.image1, "User 4", "30/05/2023", "Đây là nội dung bài post trên instagram.", "gibugibu", "Xin giá"));

        return list;
    }

    private List<InsStory> getStoryList() {
        List<InsStory> list = new ArrayList<>();
        list.add(new InsStory(R.drawable.image8, "Tin của bạn", true));
        list.add(new InsStory(R.drawable.image2, "bbydannn", false));
        list.add(new InsStory(R.drawable.image5, "jordanvietnam", false));
        list.add(new InsStory(R.drawable.image, "_mikezxc_", false));
        list.add(new InsStory(R.drawable.image6, "tiramitsu", false));
        list.add(new InsStory(R.drawable.image4, "buhubuhu", false));

        return list;
    }
}