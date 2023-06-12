package edu.hanu.app.Tiktok.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.Tiktok.adapters.VideoAdapter;
import edu.hanu.app.Tiktok.models.VideoObject;
import edu.hanu.mydesign.R;
public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_tiktok, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);

        List<VideoObject> list = new ArrayList<>();

        VideoObject obj1 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video.mp4?alt=media&token=d5f8a658-f41d-4cf2-b7f3-574dc2ba269d", "User 1", "This is the basic description which is to be changed.", "#hastag1", "A Thousand Years");
        list.add(obj1);

        VideoObject obj2 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video1.mp4?alt=media&token=58faa721-69cd-4c53-b243-91b6e85b95d9", "User 2", "This is the basic description which is to be changed.", "#hastag2", "Yêu Đơn Phương Là Gì");
        list.add(obj2);

        VideoObject obj3 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video3.mp4?alt=media&token=c8ec45f6-9067-4bb2-b489-b5c77eddafb4", "User 3", "This is the basic description which is to be changed.", "#hastag4", "Cheap Thrills - Sia");
        list.add(obj3);

        VideoObject obj4 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video4.mp4?alt=media&token=e26d5570-b0cb-44d2-8546-3ec48f3b1e47", "User 4", "This is the basic description which is to be changed.", "#hastag5", "Alone - Alan Walker & Ava Max");
        list.add(obj4);

        VideoObject obj5 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video5.mp4?alt=media&token=82df824b-7e65-4e3b-a5fb-38a7605402e8", "User 5", "This is the basic description which is to be changed.", "#hastag6", "");
        list.add(obj5);

        VideoObject obj6 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video6.mp4?alt=media&token=007c998a-e360-4c1f-bf7e-000ad04c39aa", "User 6", "This is the basic description which is to be changed.", "#hastag7", "");
        list.add(obj6);

        VideoObject obj7 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video8.mp4?alt=media&token=482aab7f-307b-4e03-8c46-f560e6c0d680", "User 7", "This is the basic description which is to be changed.", "#hastag8", "Kỳ Vọng Sai Lầm");
        list.add(obj7);

        VideoObject obj8 = new VideoObject("https://firebasestorage.googleapis.com/v0/b/my-app-cb08d.appspot.com/o/video7.mp4?alt=media&token=ad15bae2-6ca8-487c-9795-abfa06ad5cfd", "User 8", "This is the basic description which is to be changed.", "#hastag9", "Syren - ");
        list.add(obj8);

        viewPager2.setAdapter(new VideoAdapter(list));
    }
}