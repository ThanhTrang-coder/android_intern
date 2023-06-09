package edu.hanu.app.Messenger.fragments;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.Messenger.ConversationDetailActivity;
import edu.hanu.app.Messenger.ConversationListener;
import edu.hanu.app.Messenger.adapters.StoryAdapter;
import edu.hanu.app.Messenger.adapters.ConversationAdapter;
import edu.hanu.app.Messenger.models.Model;
import edu.hanu.app.Messenger.models.Model2;
import edu.hanu.mydesign.R;

public class ChatFragment extends Fragment implements ConversationListener {
    private List<Model> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvStory = view.findViewById(R.id.rvStory);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rvStory.setLayoutManager(horizontalLayout);
        StoryAdapter adapter = new StoryAdapter(getListChatHorizontal(), this);
        rvStory.setAdapter(adapter);

        RecyclerView rvConversation = view.findViewById(R.id.rvConversation);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvConversation.setLayoutManager(manager1);
        ConversationAdapter adapter2 = new ConversationAdapter(getListChatVertical(), this);
        rvConversation.setAdapter(adapter2);
    }

    private List<Model> getListChatHorizontal() {
        list = new ArrayList<>();
        list.add(new Model(R.drawable.image6, "User name 1"));
        list.add(new Model(R.drawable.image6, "User name 2"));
        list.add(new Model(R.drawable.image6, "User name 3"));
        list.add(new Model(R.drawable.image6, "User name 4"));
        list.add(new Model(R.drawable.image6, "User name 5"));
        list.add(new Model(R.drawable.image6, "User name 16"));
        list.add(new Model(R.drawable.image6, "User name 7"));
        list.add(new Model(R.drawable.image6, "User name 69"));
        list.add(new Model(R.drawable.image6, "User name 18"));
        list.add(new Model(R.drawable.image6, "User name 13"));

        return list;
    }

    private List<Model2> getListChatVertical() {
        List<Model2> list = new ArrayList<>();
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));
        list.add(new Model2(R.drawable.image6, "User name 1", "Content"));

        return list;
    }

    @Override
    public void onClickChatItem(int position) {
        Toast.makeText(getContext(), "clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ConversationDetailActivity.class);
        intent.putExtra("name", list.get(position).getUser_name());
        startActivity(intent);
    }
}