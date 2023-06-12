package edu.hanu.app.Tiktok.adapters;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.Tiktok.models.VideoObject;
import edu.hanu.mydesign.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<VideoObject> videoObjects;

    public VideoAdapter (List<VideoObject> videoObjects) {
        this.videoObjects = videoObjects;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoObjects(videoObjects.get(position));
    }

    @Override
    public int getItemCount() {
        if(videoObjects != null) {
            return videoObjects.size();
        }
        return 0;
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView user_name, videoDesc, videoHastag, music_name;
        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            user_name = itemView.findViewById(R.id.user_name);
            videoDesc = itemView.findViewById(R.id.video_desc);
            videoHastag = itemView.findViewById(R.id.video_hastag);
            music_name = itemView.findViewById(R.id.music_name);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        private void setVideoObjects(VideoObject obj) {
            user_name.setText(obj.getUser_name());
            videoDesc.setText(obj.getVideoDesc());
            videoHastag.setText(obj.getVideoHastag());
            music_name.setText(obj.getMusic_name());
            videoView.setVideoPath(obj.getVideoUrl());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();
                }
            });

            //for play and pause
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
