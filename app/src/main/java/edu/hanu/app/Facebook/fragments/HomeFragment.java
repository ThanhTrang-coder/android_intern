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

import edu.hanu.app.Facebook.adapters.NewsFeedAdapter;
import edu.hanu.app.Facebook.adapters.PostAdapter;
import edu.hanu.app.Facebook.models.NewsFeed;
import edu.hanu.app.Facebook.models.PostModel;
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

        RecyclerView post_list = view.findViewById(R.id.rvHomeFacebook);
        PostAdapter postAdapter = new PostAdapter(getPostList());

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        post_list.setLayoutManager(manager);
        post_list.setAdapter(postAdapter);

        RecyclerView status_container = view.findViewById(R.id.newsfeed_container);
        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(getNewsFeedList());

        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        status_container.setLayoutManager(manager1);
        status_container.setAdapter(newsFeedAdapter);
    }

    private List<PostModel> getPostList() {
        List<PostModel> list = new ArrayList<>();
        list.add(new PostModel("Đậu hũ thối", R.drawable.dau_hu_thoi, R.drawable.image2, "1/6 dành cho các 'em bé', tuổi thực tế hay tuổi tâm hồn đều xứng đáng có quàaa"));
        list.add(new PostModel("SUB Factory", R.drawable.sub_factory, R.drawable.sub_factory_post, "slow progress is not a failure, it's better than nothing."));
        list.add(new PostModel("Lang Thang Hà Nội", R.drawable.langthanghn_avatar, R.drawable.lang_thang_hn_post, "HÔM NAY LÀ NGÀY ĐẸP ĐỂ TỎ TÌNH ❤️\n" +
                "\n" +
                "CHẮC CHẮN THÀNH CÔNG ❤️❤️❤️\n" +
                "\n" +
                "ĐƯỢC THÌ ĐƯỢC “EM BÉ”\n" +
                "NG.Ã THÌ ĐƯỢC “EM BÉ” BỜ LỐC \uD83E\uDD23"));
        list.add(new PostModel("Halo Hà Nội", R.drawable.halo_avatar, R.drawable.halo_post, "Toàn nói sự thật không đó \uD83E\uDEE3"));
        list.add(new PostModel("SUB Factory", R.drawable.sub_factory, R.drawable.sub_factory_post1, "guilty or jummy"));
        list.add(new PostModel("Chuyện của Hà Nội", R.drawable.chuyen_cua_hn_avatar, R.drawable.chuyen_cua_hn_post, "Cháu phát âm hợp lý quá, tôi không cãi được \uD83D\uDE02"));

        return list;
    }

    private List<NewsFeed> getNewsFeedList() {
        List<NewsFeed> list = new ArrayList<>();
        list.add(new NewsFeed(R.drawable.image7, true));
        list.add(new NewsFeed(R.drawable.image, R.drawable.image2, "User 1", false));
        list.add(new NewsFeed(R.drawable.image1, R.drawable.image8, "User 2", false));
        list.add(new NewsFeed(R.drawable.image2, R.drawable.image7, "User 3", false));
        list.add(new NewsFeed(R.drawable.image3, R.drawable.image6, "User 4", false));
        list.add(new NewsFeed(R.drawable.image4, R.drawable.image5, "User 5", false));
        list.add(new NewsFeed(R.drawable.image5, R.drawable.image, "User 6", false));
        list.add(new NewsFeed(R.drawable.image6, R.drawable.image1, "User 7", false));
        list.add(new NewsFeed(R.drawable.image7, R.drawable.image2, "User 8", false));
        list.add(new NewsFeed(R.drawable.image8, R.drawable.image4, "User 9", false));
        list.add(new NewsFeed(R.drawable.image3, R.drawable.image5, "User 10", false));
        return list;
    }
}