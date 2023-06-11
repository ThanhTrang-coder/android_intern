package edu.hanu.app.Facebook.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Facebook.models.FbPost;
import edu.hanu.mydesign.R;

public class FbPostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_MULTI_IMAGE = 2;
    public static final int TYPE_VIDEO = 3;
    private List<FbPost> list;
    private Context context;

    public FbPostAdapter(Context context, List<FbPost> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        FbPost fbPost = list.get(position);
        return fbPost.getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(TYPE_IMAGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_post_one_image_item, parent, false);
            return new ImageViewHolder(view);
        } else if (TYPE_MULTI_IMAGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_post_multiple_image_item, parent, false);
            return new MultipleImageViewHolder(view);
        } else if (TYPE_VIDEO == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_post_video_item, parent, false);
            return new VideoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FbPost post_item = list.get(position);
        if(TYPE_IMAGE == post_item.getType()) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            imageViewHolder.user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            imageViewHolder.user_name_of_post.setText(post_item.getUser_name_of_post());
            imageViewHolder.post_content.setText(post_item.getPost_content());
            imageViewHolder.user_image_of_post.setImageResource(post_item.getUser_image_of_post());
        } else if (TYPE_MULTI_IMAGE == post_item.getType()) {
            MultipleImageViewHolder multipleImageViewHolder = (MultipleImageViewHolder) holder;
            multipleImageViewHolder.user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            multipleImageViewHolder.user_name_of_post.setText(post_item.getUser_name_of_post());
            multipleImageViewHolder.post_content.setText(post_item.getPost_content());
            multipleImageViewHolder.image_1.setImageResource(post_item.getPhotos().get(0).getResourceId());
            multipleImageViewHolder.image_2.setImageResource(post_item.getPhotos().get(1).getResourceId());
            multipleImageViewHolder.image_3.setImageResource(post_item.getPhotos().get(2).getResourceId());
            multipleImageViewHolder.image_4.setImageResource(post_item.getPhotos().get(3).getResourceId());
        } else if (TYPE_VIDEO == post_item.getType()) {
            VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
            videoViewHolder.user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            videoViewHolder.user_name_of_post.setText(post_item.getUser_name_of_post());
            videoViewHolder.post_content.setText(post_item.getPost_content());

            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(videoViewHolder.videoView);
            videoViewHolder.videoView.setMediaController(mediaController);
            Uri uri = Uri.parse(post_item.getVideoUrl());
            videoViewHolder.videoView.setVideoURI(uri);
            videoViewHolder.videoView.start();
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_avatar_of_post;
        private TextView user_name_of_post, post_content;
        private ImageView user_image_of_post;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar_of_post = itemView.findViewById(R.id.user_avatar_of_post);
            user_name_of_post = itemView.findViewById(R.id.user_name_of_post);
            user_image_of_post = itemView.findViewById(R.id.user_image_of_post);
            post_content = itemView.findViewById(R.id.post_content);
        }
    }

    public class MultipleImageViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_avatar_of_post;
        private TextView user_name_of_post, post_content;
        private ImageView image_1, image_2, image_3, image_4;

        public MultipleImageViewHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar_of_post = itemView.findViewById(R.id.user_avatar_of_post);
            user_name_of_post = itemView.findViewById(R.id.user_name_of_post);
            post_content = itemView.findViewById(R.id.post_content);
            image_1 = itemView.findViewById(R.id.image_1);
            image_2 = itemView.findViewById(R.id.image_2);
            image_3 = itemView.findViewById(R.id.image_3);
            image_4 = itemView.findViewById(R.id.image_4);
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_avatar_of_post;
        private TextView user_name_of_post, post_content;
        private VideoView videoView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar_of_post = itemView.findViewById(R.id.user_avatar_of_post);
            user_name_of_post = itemView.findViewById(R.id.user_name_of_post);
            post_content = itemView.findViewById(R.id.post_content);
            videoView = itemView.findViewById(R.id.videoView);
        }
    }
}
