package com.example.homeworkapp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<FriendData> mDataset;
    private String name;

    private ArrayList<FriendData> myDataset;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_friendname;
        public TextView TextView_info; //TextView 클래스 참조변수 생성
        public ImageView ImageView_friendprofile;

        public MyViewHolder(View v) { //생성자, v는 onCreateViewHolder에서 받아온 값들
            super(v); //TextView의 생성자를 가져옴, V로 초기화
            TextView_friendname = v.findViewById(R.id.TextView_friendname);
            TextView_info = v.findViewById(R.id.TextView_info);
            ImageView_friendprofile=v.findViewById(R.id.ImageView_friendprofile);
        }//row의 요소들을 찾는 기능
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<FriendData> myDataset) {
        mDataset = myDataset;
    }
    //MainActivity의 data(myDataset)를 받아서 mDataset에 저장

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        myDataset = new ArrayList<>();
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_row, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }//row를 찾는 기능, inflate: xml을 개체로 변환시켜 준 것

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        FriendData friend = mDataset.get(position);
        holder.TextView_friendname.setText(friend.getName());
        holder.TextView_info.setText(friend.getInfo());
       // holder.ImageView_friendprofile.setImage(friend.getImage());
    }

    @Override
    public int getItemCount() {
        return mDataset != null ? mDataset.size():0 ;
    }

    public void addChat(FriendData friendData){
        mDataset.add(friendData);
        notifyItemInserted(mDataset.size()-1); //데이터 추가
    }

}
