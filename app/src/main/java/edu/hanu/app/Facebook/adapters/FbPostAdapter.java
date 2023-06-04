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
import edu.hanu.app.Facebook.models.FbPost;
import edu.hanu.mydesign.R;

public class FbPostAdapter extends RecyclerView.Adapter<FbPostAdapter.PostHolder> {
    List<FbPost> list;

    public FbPostAdapter(List<FbPost> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_post_one_image_item, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        FbPost itemPost = list.get(position);
        holder.user_name_of_post.setText(itemPost.getUser_name_of_post());
        holder.user_avatar_of_post.setImageResource(itemPost.getUser_avatar_of_post());
        holder.user_image_of_post.setImageResource(itemPost.getUser_image_of_post());
        holder.post_content.setText(itemPost.getPost_content());
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_avatar_of_post;
        private TextView user_name_of_post, post_content;
        private ImageView user_image_of_post;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar_of_post = itemView.findViewById(R.id.user_avatar_of_post);
            user_name_of_post = itemView.findViewById(R.id.user_name_of_post);
            user_image_of_post = itemView.findViewById(R.id.user_image_of_post);
            post_content = itemView.findViewById(R.id.post_content);
        }
    }
}
