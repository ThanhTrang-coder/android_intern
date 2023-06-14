package edu.hanu.app.Instagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Instagram.models.InsPost;
import edu.hanu.mydesign.R;

public class InsPostAdapter extends RecyclerView.Adapter<InsPostAdapter.DefaultPostHolder> {
    private List<InsPost> list;

    public InsPostAdapter (List<InsPost> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DefaultPostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ins_post_item, parent, false);
        return new DefaultPostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefaultPostHolder holder, int position) {
        InsPost insPost = list.get(position);
        holder.setPost(insPost);
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class DefaultPostHolder extends RecyclerView.ViewHolder {
        TextView ins_user_name_post, ins_post_desc, content_post, commenter_name, comment, like_number;
        private ImageView ins_post_image;
        CircleImageView ins_user_avatar_post;

        public DefaultPostHolder(@NonNull View itemView) {
            super(itemView);

            ins_user_avatar_post = itemView.findViewById(R.id.ins_user_avatar_post);
            ins_post_image = itemView.findViewById(R.id.ins_post_image);
            ins_user_name_post = itemView.findViewById(R.id.ins_user_name_post);
            ins_post_desc = itemView.findViewById(R.id.ins_post_music);
            content_post = itemView.findViewById(R.id.content_post);
            commenter_name = itemView.findViewById(R.id.commenter_name);
            comment = itemView.findViewById(R.id.comment);

        }

        private void setPost (InsPost insPost) {
            ins_user_avatar_post.setImageResource(insPost.getInsAvatar());
            ins_user_name_post.setText(insPost.getInsUserName());
            ins_post_image.setImageResource(insPost.getInsImage());
            ins_post_desc.setText(insPost.getInsUserDesc());
            content_post.setText(insPost.getContent_post());
            commenter_name.setText(insPost.getCommenter_name());
            comment.setText(insPost.getComment());
        }
    }
}
