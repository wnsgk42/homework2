package com.example.homeworkapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentFriend extends Fragment {

    Button Button_send;
    EditText EditText_msg;

    private RecyclerView recyclerView; // RecyclerView 클래스를 사용키 위한 참조변수
    private RecyclerView.Adapter mAdapter; // RecyclerView 클래스를 사용키 위한 참조변수
    private RecyclerView.LayoutManager layoutManager;// RecyclerView 클래스를 사용키 위한 참조변수
    private ArrayList<Chatdata> myDataset;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String nick="data_nick";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview =(ViewGroup) inflater.inflate(R.layout.fragmentfriend,container,false);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_chat);//RecyclerView 참조

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        Button_send = findViewById(R.id.Button_send);
        EditText_msg = findViewById(R.id.EditText_msg);

        Button_send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Chatdata chatdata= new Chatdata();
                chatdata.setMsg(EditText_msg.getText().toString());
                chatdata.setNick(nick);
                myRef.push().setValue(chatdata);
            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Chatdata chat =dataSnapshot.getValue(Chatdata.class);
                ((MyAdapter)mAdapter).addChat(chat);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return rootview;
    }
}
