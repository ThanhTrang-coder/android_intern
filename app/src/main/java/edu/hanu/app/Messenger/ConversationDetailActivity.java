package edu.hanu.app.Messenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.Messenger.adapters.ChatAdapter;
import edu.hanu.app.Messenger.models.BubbleChat;
import edu.hanu.app.Messenger.models.Model;
import edu.hanu.mydesign.R;

public class ConversationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toolbar toolBar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager verticalLayout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayout);
        ChatAdapter adapter = new ChatAdapter(getListChat());
        recyclerView.setAdapter(adapter);
    }

    private List<BubbleChat> getListChat() {
        List<BubbleChat> list = new ArrayList<>();
        list.add(new BubbleChat(ChatAdapter.TYPE_SENDER, R.drawable.image2, "Hi"));
        list.add(new BubbleChat(ChatAdapter.TYPE_RECEIVER, "Hi, Have a nice day!"));
        list.add(new BubbleChat(ChatAdapter.TYPE_SENDER, R.drawable.image2, "How are you?"));
        list.add(new BubbleChat(ChatAdapter.TYPE_RECEIVER, "Great!!!"));
        list.add(new BubbleChat(ChatAdapter.TYPE_RECEIVER,"..."));

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tool_bar_messenger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.phone_call:
                Toast.makeText(this, "phone call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.video_call:
                Toast.makeText(this, "video call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.information:
                Toast.makeText(this, "information", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}