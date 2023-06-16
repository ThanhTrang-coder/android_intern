package edu.hanu.app.Instagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Instagram.models.InsStory;
import edu.hanu.mydesign.R;

public class InsStoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_ADD_STORY = 1;
    private static int TYPE_DEFAULT_STORY = 2;
    private List<InsStory> list;

    public InsStoryAdapter(List<InsStory> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        InsStory insStory = list.get(position);
        if(insStory.isUser()) {
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
            View view = inflater.inflate(R.layout.item_ins_add_story, parent, false);
            return new AddUserStoryHolder(view);
        } else if (TYPE_DEFAULT_STORY == viewType) {
            View view = inflater.inflate(R.layout.item_ins_story, parent, false);
            return new DefaultStoryHolder(view);
        }
        return new DefaultStoryHolder(inflater.inflate(R.layout.item_ins_story, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        InsStory insStory = list.get(position);
        if(TYPE_ADD_STORY == holder.getItemViewType()) {
            AddUserStoryHolder addUserStoryHolder = (AddUserStoryHolder) holder;
            addUserStoryHolder.ins_avatar.setImageResource(insStory.getInsAvatar());
        } else if(TYPE_DEFAULT_STORY == holder.getItemViewType()) {
            DefaultStoryHolder defaultStoryHolder = (DefaultStoryHolder) holder;
            defaultStoryHolder.ins_default_avatar.setImageResource(insStory.getInsAvatar());
            defaultStoryHolder.ins_user_name.setText(insStory.getInsUserName());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class AddUserStoryHolder extends RecyclerView.ViewHolder {
        CircleImageView ins_avatar;

        public AddUserStoryHolder(@NonNull View itemView) {
            super(itemView);

            ins_avatar = itemView.findViewById(R.id.ins_avatar);
        }
    }

    public class DefaultStoryHolder extends RecyclerView.ViewHolder {
        TextView ins_user_name;
        CircleImageView ins_default_avatar;

        public DefaultStoryHolder(@NonNull View itemView) {
            super(itemView);

            ins_default_avatar = itemView.findViewById(R.id.ins_default_avatar);
            ins_user_name = itemView.findViewById(R.id.ins_user_name);
        }
    }
}
