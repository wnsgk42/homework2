package com.example.homeworkapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainContext extends AppCompatActivity {

    //FrameLayout container;
    FragmentChat fragmentChat;
    FragmentFriend fragmentFriend;
    FragmentSetting fragmentSetting;
    FragmentNews fragmentNews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);

        //Intent intent = getIntent();

        fragmentChat = new FragmentChat();
        fragmentFriend = new FragmentFriend();
        fragmentNews = new FragmentNews();
        fragmentSetting = new FragmentSetting();

        Button Button_friend = findViewById(R.id.Button_friend);
        Button Button_chat = findViewById(R.id.Button_chat);
        Button Button_news = findViewById(R.id.Button_news);
        Button Button_set = findViewById(R.id.Button_set);

        Button_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentFriend).commit();
            }
        });


        Button_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentChat).commit();
            }
        });


        Button_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentSetting).commit();
            }
        });


        Button_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.container, fragmentNews).commit();
            }
        });

    }
}
