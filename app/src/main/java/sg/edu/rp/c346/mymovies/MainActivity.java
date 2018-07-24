package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Movie> MovieList;
    CustomAdapter caMovieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listView);

        MovieList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,10,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,4,15);

        Movie list1 = new Movie("The Avengers", "2012", "pg13", "Action | Sci-Fi", date1, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        Movie list2 = new Movie("Planes", "2013", "pg","Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");

        MovieList.add(list1);
        MovieList.add(list2);

        caMovieList = new CustomAdapter(this,R.layout.moviecontent,MovieList);

        lv.setAdapter(caMovieList);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Intent intent = new Intent(getBaseContext(),Main2Activity.class);
               Movie newMovie = MovieList.get(position);

                intent.putExtra("Title", newMovie.getTitle());
                intent.putExtra("Year", newMovie.getYear());
                intent.putExtra("Rated", newMovie.getRated());
                intent.putExtra("Genre", newMovie.getGenre());
                intent.putExtra("Watched on", newMovie.getWatched_on_String());
                intent.putExtra("In theatre", newMovie.getIn_theatre());
                intent.putExtra("Description", newMovie.getDescription());

                startActivity(intent);
            }
        });
    }
}