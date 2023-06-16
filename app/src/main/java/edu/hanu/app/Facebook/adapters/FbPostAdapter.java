package edu.hanu.app.Facebook.adapters;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fb_post_one_image, parent, false);
            return new ImageViewHolder(view);
        } else if (TYPE_MULTI_IMAGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fb_post_multiple_image, parent, false);
            return new MultipleImageViewHolder(view);
        } else if (TYPE_VIDEO == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fb_post_video, parent, false);
            return new VideoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FbPost post_item = list.get(position);
        if(TYPE_IMAGE == post_item.getType()) {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            imageViewHolder.setImage(post_item);
        } else if (TYPE_MULTI_IMAGE == post_item.getType()) {
            MultipleImageViewHolder multipleImageViewHolder = (MultipleImageViewHolder) holder;
            multipleImageViewHolder.setMultipleImage(post_item);
        } else if (TYPE_VIDEO == post_item.getType()) {
            VideoViewHolder videoViewHolder = (VideoViewHolder) holder;
            videoViewHolder.setVideo(post_item);
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

        public void setImage(FbPost post_item) {
            user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            user_name_of_post.setText(post_item.getUser_name_of_post());
            post_content.setText(post_item.getPost_content());
            user_image_of_post.setImageResource(post_item.getUser_image_of_post());
        }
    }

    public class MultipleImageViewHolder extends RecyclerView.ViewHolder {
        TextView user_name_of_post, post_content;
        ImageView image_1, image_2, image_3, image_4;
        CircleImageView user_avatar_of_post;

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

        public void setMultipleImage (FbPost post_item) {
            user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            user_name_of_post.setText(post_item.getUser_name_of_post());
            post_content.setText(post_item.getPost_content());
            image_1.setImageResource(post_item.getPhotos().get(0).getResourceId());
            image_2.setImageResource(post_item.getPhotos().get(1).getResourceId());
            image_3.setImageResource(post_item.getPhotos().get(2).getResourceId());
            image_4.setImageResource(post_item.getPhotos().get(3).getResourceId());
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView user_avatar_of_post;
        private TextView user_name_of_post, post_content;
        private VideoView videoView;
        private ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar_of_post = itemView.findViewById(R.id.user_avatar_of_post);
            user_name_of_post = itemView.findViewById(R.id.user_name_of_post);
            post_content = itemView.findViewById(R.id.post_content);
            videoView = itemView.findViewById(R.id.videoView);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        private void setVideo(FbPost post_item) {
            user_avatar_of_post.setImageResource(post_item.getUser_avatar_of_post());
            user_name_of_post.setText(post_item.getUser_name_of_post());
            post_content.setText(post_item.getPost_content());
            videoView.setVideoPath(post_item.getVideoUrl());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();
                }
            });

            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(videoView.isPlaying()) {
                        videoView.pause();
                        return false;
                    } else {
                        videoView.start();
                        return false;
                    }
                }
            });
        }
    }
}
