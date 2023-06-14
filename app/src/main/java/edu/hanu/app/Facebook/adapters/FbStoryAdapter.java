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
import edu.hanu.app.Facebook.models.FbStory;
import edu.hanu.mydesign.R;

public class FbStoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_ADD_STORY = 1;
    private static int TYPE_DEFAULT_STORY = 2;
    private List<FbStory> list;

    public FbStoryAdapter(List<FbStory> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        FbStory fbStory = list.get(position);
        if(fbStory.isUser()) {
            return TYPE_ADD_STORY;
        } else {
            return TYPE_DEFAULT_STORY;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(TYPE_ADD_STORY == viewType) {
            View view = inflater.inflate(R.layout.fb_add_story_item, parent, false);
            return new AddUserStoryHolder(view);
        } else if (TYPE_DEFAULT_STORY == viewType) {
            View view = inflater.inflate(R.layout.fb_story_item, parent, false);
            return new DefaultStoryHolder(view);
        }
        return new DefaultStoryHolder(inflater.inflate(R.layout.fb_story_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FbStory fbStory = list.get(position);
        if(TYPE_ADD_STORY == holder.getItemViewType()) {
            AddUserStoryHolder addUserStoryHolder = (AddUserStoryHolder) holder;
            addUserStoryHolder.user_avatar.setImageResource(fbStory.getUserAvatar());
        } else if(TYPE_DEFAULT_STORY == holder.getItemViewType()) {
            DefaultStoryHolder defaultStoryHolder = (DefaultStoryHolder) holder;
            defaultStoryHolder.default_user_name.setText(fbStory.getUserName());
            defaultStoryHolder.default_user_story.setImageResource(fbStory.getUserStoryImg());
            defaultStoryHolder.default_user_avatar.setImageResource(fbStory.getUserAvatar());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class AddUserStoryHolder extends RecyclerView.ViewHolder {
        private ImageView user_avatar;

        public AddUserStoryHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar = itemView.findViewById(R.id.user_avatar);
        }
    }

    public class DefaultStoryHolder extends RecyclerView.ViewHolder {
        TextView default_user_name;
        ImageView default_user_story;
        CircleImageView default_user_avatar;

        public DefaultStoryHolder(@NonNull View itemView) {
            super(itemView);

            default_user_name = itemView.findViewById(R.id.default_user_name);
            default_user_story = itemView.findViewById(R.id.default_user_story);
            default_user_avatar = itemView.findViewById(R.id.default_user_avatar);
        }
    }
}
