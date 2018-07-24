package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView name;
    TextView year;
    TextView category;
    TextView description;
    TextView watchon;
    TextView theater;
    ImageView rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviecontent);

        name = findViewById(R.id.textViewName);
        year = findViewById(R.id.textViewYear);
        category = findViewById(R.id.textViewCategory);
        description = findViewById(R.id.textViewDescription);
        watchon = findViewById(R.id.textViewWatchOn);
        theater = findViewById(R.id.textViewTheatre);
        rating = findViewById(R.id.imageView);

        Intent intentReceived = getIntent();

        String Title = intentReceived.getStringExtra("Title");
        String Year = intentReceived.getStringExtra("Year");
        String Rated = intentReceived.getStringExtra("Rated");
        String Watchon = intentReceived.getStringExtra("Watch");
        String Genre = intentReceived.getStringExtra("Genre");
        String Theatre = intentReceived.getStringExtra("In theatre");
        String Description = intentReceived.getStringExtra("Description");
        float rate = intentReceived.getFloatExtra("Rating",0);

        name.setText(Title);
        year.setText(Year+"-");
        category.setText(Genre);

        description.setText("\n"+Description+"\n");
        watchon.setText("Watch on: "+Watchon);
        theater.setText("In Theatre: "+Theatre+"\n");

        if(Rated.equalsIgnoreCase("g")){
            rating.setImageResource(R.drawable.rating_g);

        }else if(Rated.equalsIgnoreCase("pg")) {
            rating.setImageResource(R.drawable.rating_pg);

        }else if(Rated.equalsIgnoreCase("pg13")) {
            rating.setImageResource(R.drawable.rating_pg13);

        }else if(Rated.equalsIgnoreCase("nc16")) {
            rating.setImageResource(R.drawable.rating_nc16);

        }else if(Rated.equalsIgnoreCase("m18")) {
            rating.setImageResource(R.drawable.rating_m18);

        }else{
            rating.setImageResource(R.drawable.rating_r21);
        }
    }
}

