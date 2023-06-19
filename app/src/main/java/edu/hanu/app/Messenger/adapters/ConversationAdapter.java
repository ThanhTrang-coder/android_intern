package edu.hanu.app.Messenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Messenger.ConversationListener;
import edu.hanu.app.Messenger.models.Model2;
import edu.hanu.mydesign.R;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder2> {
    List<Model2> list;
    ConversationListener listener;

    public ConversationAdapter(List<Model2> list, ConversationListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversation, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        Model2 item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        CircleImageView user_avatar;
        TextView user_name, content;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            user_avatar = itemView.findViewById(R.id.user_avatar);
            user_name = itemView.findViewById(R.id.user_name);
            content = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        int pos = getAdapterPosition();
                        listener.onClickChatItem(pos);
                    }
                }
            });
        }

        private void setData(Model2 item) {
            user_avatar.setImageResource(item.getImageUrl());
            user_name.setText(item.getUser_name());
            content.setText(item.getContent());
        }
    }
}
