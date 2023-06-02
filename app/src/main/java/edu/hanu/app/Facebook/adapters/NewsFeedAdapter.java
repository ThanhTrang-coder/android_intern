package edu.hanu.app.Facebook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Facebook.models.NewsFeed;
import edu.hanu.mydesign.R;

public class NewsFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_CREATE_NEWS = 1;
    private static int TYPE_OTHER_NEWS = 2;
    private List<NewsFeed> list;

    public NewsFeedAdapter(List<NewsFeed> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        NewsFeed newsFeed = list.get(position);
        if(newsFeed.isUser()) {
            return TYPE_CREATE_NEWS;
        } else {
            return TYPE_OTHER_NEWS;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(TYPE_CREATE_NEWS == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_create_news, parent, false);
            return new CreateUserNewsHolder(view);
        } else if (TYPE_OTHER_NEWS == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_facebook, parent, false);
            return new OtherNewsHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsFeed newsFeed = list.get(position);
        if(TYPE_CREATE_NEWS == holder.getItemViewType()) {
            CreateUserNewsHolder createUserNewsHolder = (CreateUserNewsHolder) holder;
            createUserNewsHolder.user_avatar.setImageResource(newsFeed.getUserAvatar());
        } else if(TYPE_OTHER_NEWS == holder.getItemViewType()) {
            OtherNewsHolder otherNewsHolder = (OtherNewsHolder) holder;
            otherNewsHolder.other_name.setText(newsFeed.getOtherName());
            otherNewsHolder.other_news.setImageResource(newsFeed.getOtherNewsImg());
            otherNewsHolder.other_avatar.setImageResource(newsFeed.getOtherAvatar());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class CreateUserNewsHolder extends RecyclerView.ViewHolder {
        private ImageView user_avatar;

        public CreateUserNewsHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar = itemView.findViewById(R.id.user_avatar);
        }
    }

    public class OtherNewsHolder extends RecyclerView.ViewHolder {
        private ImageView other_news;
        private CircleImageView other_avatar;
        private TextView other_name;

        public OtherNewsHolder(@NonNull View itemView) {
            super(itemView);

            other_name = itemView.findViewById(R.id.other_name);
            other_news = itemView.findViewById(R.id.other_news);
            other_avatar = itemView.findViewById(R.id.other_avatar);
        }
    }
}
