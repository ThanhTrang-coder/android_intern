package edu.hanu.app.Facebook.fragments;

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

import edu.hanu.app.Facebook.adapters.FbStoryAdapter;
import edu.hanu.app.Facebook.adapters.FbPostAdapter;
import edu.hanu.app.Facebook.models.FbStory;
import edu.hanu.app.Facebook.models.FbPost;
import edu.hanu.app.Facebook.models.Photo;
import edu.hanu.mydesign.R;
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_facebook, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView fb_post_list = view.findViewById(R.id.fb_post_list);
        FbPostAdapter postAdapter = new FbPostAdapter(getContext(), getPostList());

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        fb_post_list.setLayoutManager(manager);
        fb_post_list.setAdapter(postAdapter);

        RecyclerView fb_story_list = view.findViewById(R.id.fb_story_list);
        FbStoryAdapter newsFeedAdapter = new FbStoryAdapter(getNewsFeedList());

        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        fb_story_list.setLayoutManager(manager1);
        fb_story_list.setAdapter(newsFeedAdapter);
    }

    private List<FbPost> getPostList() {
        List<FbPost> list = new ArrayList<>();

        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo(R.drawable.image7));
        photos.add(new Photo(R.drawable.image6));
        photos.add(new Photo(R.drawable.image3));
        photos.add(new Photo(R.drawable.image8));

        String videoUrl = "https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video2.mp4?alt=media&token=2aa5d754-fe86-4e8a-a07a-cfa79941f66c";

        list.add(new FbPost(FbPostAdapter.TYPE_IMAGE, "Đậu hũ thối", R.drawable.dau_hu_thoi, R.drawable.image2, "1/6 dành cho các 'em bé', tuổi thực tế hay tuổi tâm hồn đều xứng đáng có quàaa"));
        list.add(new FbPost(FbPostAdapter.TYPE_MULTI_IMAGE, "Lang Thang Hà Nội", R.drawable.langthanghn_avatar, photos, "multiple photo"));
        list.add(new FbPost(FbPostAdapter.TYPE_VIDEO, "SUB Factory", R.drawable.sub_factory, videoUrl, "Video!!!"));
        list.add(new FbPost(FbPostAdapter.TYPE_IMAGE, "Halo Hà Nội", R.drawable.halo_avatar, R.drawable.halo_post, "Toàn nói sự thật không đó \uD83E\uDEE3"));
        list.add(new FbPost(FbPostAdapter.TYPE_VIDEO, "SUB Factory", R.drawable.sub_factory, videoUrl, "Video!!!"));
        list.add(new FbPost(FbPostAdapter.TYPE_IMAGE, "Chuyện của Hà Nội", R.drawable.chuyen_cua_hn_avatar, R.drawable.chuyen_cua_hn_post, "Cháu phát âm hợp lý quá, tôi không cãi được \uD83D\uDE02"));

        return list;
    }

    private List<FbStory> getNewsFeedList() {
        List<FbStory> list = new ArrayList<>();
        list.add(new FbStory(R.drawable.image7, true));
        list.add(new FbStory(R.drawable.image9, R.drawable.image2, "User 1", false));
        list.add(new FbStory(R.drawable.image1, R.drawable.image8, "User 2", false));
        list.add(new FbStory(R.drawable.image2, R.drawable.image7, "User 3", false));
        list.add(new FbStory(R.drawable.image3, R.drawable.image6, "User 4", false));
        list.add(new FbStory(R.drawable.image4, R.drawable.image5, "User 5", false));
        list.add(new FbStory(R.drawable.image5, R.drawable.image10, "User 6", false));
        list.add(new FbStory(R.drawable.image6, R.drawable.image1, "User 7", false));
        list.add(new FbStory(R.drawable.image7, R.drawable.image2, "User 8", false));
        list.add(new FbStory(R.drawable.image8, R.drawable.image4, "User 9", false));
        list.add(new FbStory(R.drawable.image3, R.drawable.image5, "User 10", false));
        return list;
    }
}