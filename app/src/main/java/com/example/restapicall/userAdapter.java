package com.example.restapicall;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.restapicall.databinding.ItemUserBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userholder> {

    MainActivity mainActivity;
    List<Usermodel> alluserList;
    ItemUserBinding itemUserBinding;
    private  SelectListener listener;
    public userAdapter(MainActivity mainActivity, List<Usermodel> alluserList) {


    this.mainActivity=mainActivity;
    this.alluserList=alluserList;
    this.listener=listener;
    }

    @NonNull
    @Override
    public userholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemUserBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new userholder(itemUserBinding);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull userholder holder, int position) {



        itemUserBinding.itemTxt.setText(alluserList.get(position).getTitle());
        Picasso.get()
                .load(alluserList.get(position).getThumbnailUrl())
                .into(itemUserBinding.imageview);
        itemUserBinding.id.setText(Integer.toString(alluserList.get(position).getId()));


    }

    @Override
    public int getItemCount() {
        return alluserList.size();
    }

    class   userholder extends RecyclerView.ViewHolder {
        TextView itemtxt;
        ImageView userimageView;
        TextView id;


        public userholder(@NonNull ItemUserBinding binding) {
            super(binding.getRoot());
            itemtxt =binding.itemTxt;
            userimageView=binding.imageview;
            id=binding.id;

        }
    }
}
