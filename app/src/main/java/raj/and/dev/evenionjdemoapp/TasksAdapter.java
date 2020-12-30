package raj.and.dev.evenionjdemoapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Raj Aryan on 12/30/2020.
 * Mahiti Infotech
 * raj.aryan@mahiti.org
 */
public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<DataModel> taskList;

    public TasksAdapter(Context mCtx, List<DataModel> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_tasks, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        DataModel t = taskList.get(position);
        holder.textViewTask.setText(t.getLabel());
        holder.textViewDesc.setText(t.getDescription());
//        setImageUsingFilePath(t.getFilePath());
        Picasso.get().load(t.getFilePath()).into(holder.iv1);


        /*if (t.isFinished())
            holder.textViewStatus.setText("Completed");
        else
            holder.textViewStatus.setText("Not Completed");*/
    }

    private void setImageUsingFilePath(String filePath) {

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewTask, textViewDesc;
        ImageView iv1;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewTask = itemView.findViewById(R.id.textViewTask);
            textViewDesc = itemView.findViewById(R.id.textViewDesc);
            iv1 = itemView.findViewById(R.id.iv1);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            DataModel task = taskList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
            intent.putExtra("task", task);
            mCtx.startActivity(intent);
        }
    }
}

