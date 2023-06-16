package edu.hanu.app.Messenger.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.Messenger.models.BubbleChat;
import edu.hanu.mydesign.R;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_SENDER = 0;
    public static final int TYPE_RECEIVER = 1;
    List<BubbleChat> list;

    public ChatAdapter (List<BubbleChat> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_SENDER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_send, parent, false);
            return new SenderHolder(view);
        } else if (viewType == TYPE_RECEIVER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receive, parent, false);
            return new ReceiverHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BubbleChat item = list.get(position);
        if(item.getType() == TYPE_SENDER) {
            SenderHolder senderHolder = (SenderHolder) holder;
            senderHolder.setData(item);
        } else if (item.getType() == TYPE_RECEIVER) {
            ReceiverHolder receiverHolder = (ReceiverHolder) holder;
            receiverHolder.setData(item);
        }
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class SenderHolder extends RecyclerView.ViewHolder {
        CircleImageView sender_avatar;
        TextView sender_content;

        public SenderHolder(@NonNull View itemView) {
            super(itemView);

            sender_avatar = itemView.findViewById(R.id.sender_avatar);
            sender_content = itemView.findViewById(R.id.sender_content);
        }

        private void setData(BubbleChat item) {
            sender_avatar.setImageResource(item.getSender_avatar());
            sender_content.setText(item.getSender_content());
        }
    }

    public class ReceiverHolder extends RecyclerView.ViewHolder {
        TextView receiver_content;

        public ReceiverHolder(@NonNull View itemView) {
            super(itemView);

            receiver_content = itemView.findViewById(R.id.receiver_content);
        }

        private void setData(BubbleChat item) {
            receiver_content.setText(item.getReceiver_content());

        }
    }
}
