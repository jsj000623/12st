package com.example.a11st_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    ArrayList<Movie> items = new ArrayList<Movie>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.movie_item,viewGroup, false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(Movie item){
        items.add(item);
    }
    public void setItems(ArrayList<Movie> items) {
        this.items = items;
    }
    public Movie getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieName;
        TextView movieCd;
        TextView peopleCount;
        TextView rank;
        TextView rankInten;
        TextView openDt;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movieName);
            movieCd = itemView.findViewById(R.id.movieCd);
            peopleCount = itemView.findViewById((R.id.peopleCount));
            rank = itemView.findViewById(R.id.rank);
            rankInten = itemView.findViewById(R.id.rankInten);
            openDt = itemView.findViewById((R.id.openDt));
        }
        public void setItem(Movie item)
        {
            movieName.setText(item.movieNm);
            movieCd.setText(item.movieCd);
            peopleCount.setText("관객 수: " + (item.audiCnt) + "명");
            rank.setText((item.rank) + "위");
            rankInten.setText((item.rankInten) + "↑");
            openDt.setText("개봉일  " + (item.openDt));
        }
    }
}
