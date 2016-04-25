package com.headerfooter.songhang.smartheaderfooterrecyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CardView headerView, footerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        adapter = new RecyclerView.Adapter<ViewHolder>() {
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                CardView cardView = new CardView(MainActivity.this);
                RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 100);
                layoutParams.setMargins(10, 10, 10, 10);
                cardView.setLayoutParams(layoutParams);

                TextView textView = new TextView(MainActivity.this);
                textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                textView.setGravity(Gravity.CENTER);
                textView.setTextColor(Color.BLACK);

                cardView.addView(textView);

                ViewHolder viewHolder = new ViewHolder(cardView);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                FrameLayout frameLayout = (FrameLayout) holder.itemView;
                ((TextView) frameLayout.getChildAt(0)).setText("positon: " + position);
            }

            @Override
            public int getItemCount() {
                return 50;
            }
        };

        initHeadAndFooterView();

        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
        SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter, linearLayoutManager);
        smartRecyclerAdapter.setFooterView(footerView);
        smartRecyclerAdapter.setHeaderView(headerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(smartRecyclerAdapter);
    }

    private void initHeadAndFooterView() {
        //header view
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, 400);
        layoutParams.setMargins(10, 10, 10, 10);

        headerView = new CardView(this);
        headerView.setLayoutParams(layoutParams);
        TextView head = new TextView(this);
        head.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        head.setBackgroundColor(Color.BLUE);
        head.setTextColor(Color.WHITE);
        head.setGravity(Gravity.CENTER);
        head.setText("THIS IS HEADER VIEW");
        headerView.addView(head);

        //footer view
        footerView = new CardView(this);
        footerView.setLayoutParams(layoutParams);
        TextView footer = new TextView(this);
        footer.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        footer.setBackgroundColor(Color.RED);
        footer.setText("THIS IS FOOTER VIEW");
        footer.setGravity(Gravity.CENTER);
        footer.setTextColor(Color.WHITE);
        footerView.addView(footer);
    }

    public void switchLayout(View view) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            Toast.makeText(this, "LinearLayoutManager", Toast.LENGTH_SHORT).show();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter, linearLayoutManager);
            smartRecyclerAdapter.setFooterView(footerView);
            smartRecyclerAdapter.setHeaderView(headerView);

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(smartRecyclerAdapter);
        } else {
            Toast.makeText(this, "GridLayoutManager", Toast.LENGTH_SHORT).show();
            GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 3);
            SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter, linearLayoutManager);
            smartRecyclerAdapter.setFooterView(footerView);
            smartRecyclerAdapter.setHeaderView(headerView);

            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(smartRecyclerAdapter);
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
