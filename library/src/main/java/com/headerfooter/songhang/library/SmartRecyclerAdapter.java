package com.headerfooter.songhang.library;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by songhang on 16/4/25.
 */
public class SmartRecyclerAdapter extends RecyclerViewAdapterWrapper {
    public static final int TYPE_HEADER = 111;
    public static final int TYPE_FOOTER = 112;

    private View headerView, footerView;

    public SmartRecyclerAdapter(@NonNull RecyclerView.Adapter targetAdapter, @NonNull RecyclerView.LayoutManager layoutManager) {
        super(targetAdapter);
        setGirdSpanSize(layoutManager);
    }

    public void setHeaderView(View view) {
        headerView = view;
        getWrappedAdapter().notifyDataSetChanged();
    }

    public void removeHeaderView() {
        headerView = null;
        getWrappedAdapter().notifyDataSetChanged();
    }

    public void setFooterView(View view) {
        footerView = view;
        getWrappedAdapter().notifyDataSetChanged();
    }

    public void removeFooterView() {
        footerView = null;
        getWrappedAdapter().notifyDataSetChanged();
    }

    private void setGirdSpanSize(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    boolean isShowHeader = (position == 0 && hasHeader());
                    boolean isShowFooter = (position == getItemCount() - 1 && hasFooter());
                    if (isShowFooter || isShowHeader) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    private boolean hasHeader() {
        return headerView != null;
    }

    private boolean hasFooter() {
        return footerView != null;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + (hasHeader() ? 1 : 0) + (hasFooter() ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (hasHeader() && position == 0) {
            return TYPE_HEADER;
        }

        if (hasFooter() && position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return super.getItemViewType(hasHeader() ? position - 1: position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new RecyclerView.ViewHolder(headerView) {
            };
        }

        if (viewType == TYPE_FOOTER) {
            return new RecyclerView.ViewHolder(footerView) {
            };
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER || getItemViewType(position) == TYPE_FOOTER) {
            return;
        }
        super.onBindViewHolder(holder, hasHeader() ? position - 1 : position);
    }
}
