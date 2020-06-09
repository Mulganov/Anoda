package com.mulganov.test_task.anoda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.ViewHolder> {

    // Список юзеров
    private List<Element> mData;

    private LayoutInflater mInflater;

    public BoxAdapter(Context context, List<Element> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Element el = mData.get(position);

        holder.user_name.setText(el.user.name);
        holder.user_location.setText(el.user.location);

        StringBuilder likes = new StringBuilder();
        likes.append("Liked by ");

        for (int i = 0; i < 3; i++){
            if (el.likes.get(i) != null)
                likes.append(el.likes.get(i)).append(", ");
            else
                break;
        }

        if (el.likes.size() > 4){
            likes.append(" and ").append((el.likes.size()-3)).append(" others");
        }

        holder.likes.setText(likes);

        StringBuilder tags = new StringBuilder();
        tags.append(el.user.name).append(" Beauty ");

        for (String str: el.tags){
            tags.append(str).append(" ");
        }

        holder.tags.setText(tags);

        long date = el.date;

        long present_date = System.currentTimeMillis();

        long data = present_date - date;

        data /= 1000;       // секунды

        String sData = data + " seconds ago";

        if (data > 60){
            data /= 60;     // минуты
            sData = data + " minutes ago";

            if (data > 60){
                data /= 60;     // часы
                sData = data + " hours ago";

                if (data > 24){
                    data /= 24;     // дни
                    sData = data + " days ago";
                }
            }
        }

        holder.date.setText(sData);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView user_name;
        TextView user_location;
        TextView likes;
        TextView tags;
        TextView date;

        ViewHolder(View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
            user_location = itemView.findViewById(R.id.user_location);
            likes = itemView.findViewById(R.id.likes);
            tags = itemView.findViewById(R.id.tags);
            date = itemView.findViewById(R.id.date);

            user_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "user_name", Toast.LENGTH_SHORT).show();
                }
            });
            user_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "user_location", Toast.LENGTH_SHORT).show();
                }
            });;
            likes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "likes", Toast.LENGTH_SHORT).show();
                }
            });;
            tags.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "tags", Toast.LENGTH_SHORT).show();
                }
            });;
            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "date", Toast.LENGTH_SHORT).show();
                }
            });;

            itemView.findViewById(R.id.user_photo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "user_photo", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "settings", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.lenta_main_photo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "lenta_main_photo", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.like).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "like", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.coments).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "coments", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.direct).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "direct", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.flag).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "flag", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

}