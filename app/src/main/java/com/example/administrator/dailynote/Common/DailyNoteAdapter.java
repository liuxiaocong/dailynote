package com.example.administrator.dailynote.Common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.dailynote.Home.Note.Model.DailyActivityModel;
import com.example.administrator.dailynote.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiuXiaocong on 7/29/2016.
 */
public class DailyNoteAdapter extends RecyclerView.Adapter<DailyNoteAdapter.DailyNoteViewHolder> {

    public interface DailyNoteAdapterListener {

    }

    private Context mContext;
    private DailyNoteAdapterListener mDailyNoteAdapterListener;
    private LayoutInflater mLayoutInflater;
    private ArrayList<DailyActivityModel> mData = new ArrayList<>();

    public DailyNoteAdapter(Context context, DailyNoteAdapterListener dailyNoteAdapterListener) {
        mContext = context;
        mDailyNoteAdapterListener = dailyNoteAdapterListener;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<DailyActivityModel> data) {
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public DailyNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DailyNoteViewHolder(mLayoutInflater.inflate(R.layout.adapter_daily_note, parent, false));
    }

    @Override
    public void onBindViewHolder(DailyNoteViewHolder holder, int position) {
        DailyActivityModel dailyActivityModel = mData.get(position);
        holder.mTimeTextView.setText(dailyActivityModel.mTime + "");
        holder.mNoteTextView.setText(dailyActivityModel.mNote);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class DailyNoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.time)
        TextView mTimeTextView;
        @BindView(R.id.note)
        TextView mNoteTextView;

        public DailyNoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
