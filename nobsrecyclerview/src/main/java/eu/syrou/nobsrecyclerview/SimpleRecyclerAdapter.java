package eu.syrou.nobsrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Syrou on 2015-09-20.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {
    private List<String> mItems;

    public SimpleRecyclerAdapter(List<String> items) {
        mItems = items;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_1, viewGroup, false));
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(mItems.get(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(android.R.id.text1);
        }
    }
}