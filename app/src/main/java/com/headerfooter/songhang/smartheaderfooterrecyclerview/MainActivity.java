package com.headerfooter.songhang.smartheaderfooterrecyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.headerfooter.songhang.library.SmartRecyclerAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random(100);
    private RecyclerView recyclerView;
    private CardView headerView, footerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new RecyclerView.Adapter<ViewHolder>() {

            boolean isStaggered;

            @Override
            public void onAttachedToRecyclerView(RecyclerView recyclerView) {
                super.onAttachedToRecyclerView(recyclerView);
                isStaggered = recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager;
            }

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
                int[] heights = {300, 400, 500};
                FrameLayout frameLayout = (FrameLayout) holder.itemView;
                if (isStaggered) {
                    ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
                    int height = heights[random.nextInt(3)];
                    lp.height = height;
                    holder.itemView.setLayoutParams(lp);
                    holder.itemView.setBackgroundColor(Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                }
                ((TextView) frameLayout.getChildAt(0)).setText("positon: " + position);
            }

            @Override
            public int getItemCount() {
                return 50;
            }
        };

        initHeadAndFooterView();
        showLine();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_line) {
            showLine();
            return true;
        }

        if (id == R.id.action_grid) {
            showGrid();
            return true;
        }

        if (id == R.id.action_staggered) {
            showStagger();
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    private void showGrid() {
        Toast.makeText(this, "GridLayoutManager", Toast.LENGTH_SHORT).show();
        setTitle("GridLayoutManager");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter);
        smartRecyclerAdapter.setFooterView(footerView);
        smartRecyclerAdapter.setHeaderView(headerView);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(smartRecyclerAdapter);
    }

    private void showLine() {
        Toast.makeText(this, "LinerLayoutManager", Toast.LENGTH_SHORT).show();
        setTitle("LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter);
        smartRecyclerAdapter.setFooterView(footerView);
        smartRecyclerAdapter.setHeaderView(headerView);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(smartRecyclerAdapter);
    }


    private void showStagger() {
        Toast.makeText(this, "StaggeredGridLayoutManager", Toast.LENGTH_SHORT).show();
        setTitle("StaggeredGridLayoutManager");
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        SmartRecyclerAdapter smartRecyclerAdapter = new SmartRecyclerAdapter(adapter);
        smartRecyclerAdapter.setFooterView(footerView);
        smartRecyclerAdapter.setHeaderView(headerView);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(smartRecyclerAdapter);
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
