package com.example.staggeredgridrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//继承RecyclerView.Adapter就必须重写 onCreateViewHolder()，onBindViewHolder(), getItemCount()三个方法
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<Picture> mPictureList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        //用view注册点击事件
        View pictureView;

        ImageView pictureImage;
        TextView pictureName;

        public ViewHolder(View view){
            super(view);
            //view赋给实参
            pictureView = view;
            pictureImage = (ImageView)view.findViewById(R.id.picture_image);
            pictureName = (TextView)view.findViewById(R.id.picture_name);
        }
    }

    public PictureAdapter(List<Picture> pictureList){
        mPictureList = pictureList;
    }

    //创建viewHolder实例
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Picture picture = mPictureList.get(position);
                Toast.makeText(v.getContext(),"You clicked view" + picture.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.pictureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Picture picture = mPictureList.get(position);
                Toast.makeText(v.getContext(),"You clicked image" + picture.getImageId(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    //对RecyclerView子项的数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picture picture = mPictureList.get(position);
        holder.pictureImage.setImageResource(picture.getImageId());
        holder.pictureName.setText(picture.getName());
    }

    //返回RecyclerView的总子项数量
    @Override
    public int getItemCount() {
        return mPictureList.size();
    }
}
