package com.ohj4.kasvit;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlarmsRecyclerAdapter extends RecyclerView.Adapter<AlarmsRecyclerAdapter.ViewHolder> {

    private static final String TAG = "AlarmsRecyclerAdapter";

    private ArrayList<Alarm> alarmList;
    private Context context;

    public AlarmsRecyclerAdapter(Context context, ArrayList<Alarm> alarmList) {
        this.alarmList = alarmList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_alarm, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Alarm alarm = alarmList.get(holder.getAdapterPosition());
    }

    @Override
    public int getItemCount() {
        return  alarmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private EditText alarmTime;
        private Switch alarmSwitch;
        private EditText alarmDesc;
        private TextView repeatText;
        private Spinner spinner;

        public ViewHolder(final View itemView) {
            super(itemView);
            alarmTime = itemView.findViewById(R.id.alarm_time);
            alarmSwitch = itemView.findViewById(R.id.alarm_switch);
            alarmDesc = itemView.findViewById(R.id.alarm_desc);
            repeatText = itemView.findViewById(R.id.repeat_text);
            spinner = itemView.findViewById(R.id.repeat_spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    context,
                    R.array.repeat_intervals,
                    android.R.layout.simple_spinner_item
            );

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
    }

}