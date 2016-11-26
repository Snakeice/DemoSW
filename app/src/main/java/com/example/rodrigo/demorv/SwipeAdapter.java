package com.example.rodrigo.demorv;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.marshalchen.ultimaterecyclerview.SwipeableUltimateViewAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeLayout;

import java.util.List;

/**
 * Created by Rodrigo on 26/11/2016.
 */

public class SwipeAdapter extends SwipeableUltimateViewAdapter<DataModel> {
    public SwipeAdapter(List<DataModel> items) {
        super(items);
    }


    @Override
    protected int getNormalLayoutResId() {
        return DVHolder.layout;
    }

    @Override
    protected UltimateRecyclerviewViewHolder newViewHolder(final View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
        final DVHolder dvHolder = new DVHolder(view, true);
        dvHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(view.getContext(), "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });
        dvHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAt(dvHolder.getPosition());
                Toast.makeText(view.getContext(), "Deleted " + dvHolder.getPosition(), Toast.LENGTH_SHORT).show();
            }
        });

        return dvHolder;
    }

    @Override
    protected void withBindHolder(UltimateRecyclerviewViewHolder holder, DataModel data, int position) {
        super.withBindHolder(holder, data, position);
        ((DVHolder) holder).name.setText(data.name);
        ((DVHolder) holder).nickname.setText(data.nickname);

    }

    @Override
    public DVHolder newFooterHolder(View view) {
        return new DVHolder(view, false);
    }

    @Override
    public DVHolder newHeaderHolder(View view) {
        return new DVHolder(view, false);
    }


    public static class DVHolder extends UltimateRecyclerviewViewHolder {
        public static final int layout = R.layout.data_item;
        public TextView name;
        public TextView nickname;
        public Button deleteButton;
        public SwipeLayout swipeLayout;

        public DVHolder(View itemView, boolean bind) {
            super(itemView);
            if (bind) {
                name = (TextView) itemView.findViewById(R.id.name);
                nickname = (TextView) itemView.findViewById(R.id.nickname);
                deleteButton = (Button) itemView.findViewById(R.id.delete);
                swipeLayout = (SwipeLayout) itemView.findViewById(R.id.recyclerview_swipe);
                swipeLayout.setDragEdge(SwipeLayout.DragEdge.Right);
                swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
            }
        }
    }
}
