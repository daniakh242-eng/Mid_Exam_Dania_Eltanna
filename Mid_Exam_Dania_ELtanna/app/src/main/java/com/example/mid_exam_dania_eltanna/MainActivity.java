package com.example.mid_exam_dania_eltanna;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int currentArtwork = 0;

    private final int[] artworkImages = {
            R.drawable.artwork1,
            R.drawable.artwork2,
            R.drawable.artwork3,
            R.drawable.artwork4,
            R.drawable.artwork5,
            R.drawable.artwork6
    };

    private final String[] titles = {
            "Deep Field Stellar Deaths",
            "Deep Field in Golden Light",
            "Deep Field in Violet Light",
            "Deep Field: Cosmic Glow",
            "David",
            "Mona Lisa"
    };

    private final String[] artists = {
            "NASA, ESA, CSA, STScI",
            "NASA, ESA, CSA, STScI",
            "NASA, ESA, CSA, STScI",
            "NASA, ESA, CSA, STScI",
            "Michelangelo",
            "Leonardo da Vinci"
    };

    private final String[] years = {
            "2022",
            "2022",
            "2022",
            "2022",
            "1501–1504",
            "1503–1519"
    };

    private TextView artworkCounter;
    private TextView artworkTitle;
    private TextView artworkArtist;
    private ImageView artworkImage;
    private Button previousButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artworkCounter = findViewById(R.id.artworkCounter);
        artworkTitle = findViewById(R.id.artworkTitle);
        artworkArtist = findViewById(R.id.artworkArtist);
        artworkImage = findViewById(R.id.artworkImage);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        if (savedInstanceState != null) {
            currentArtwork = savedInstanceState.getInt("currentArtwork", 0);
        }

        previousButton.setOnClickListener(view -> {
            if (currentArtwork > 0) {
                currentArtwork--;
                showArtwork();
            }
        });

        nextButton.setOnClickListener(view -> {
            if (currentArtwork < titles.length - 1) {
                currentArtwork++;
                showArtwork();
            }
        });

        showArtwork();
    }

    private void showArtwork() {
        artworkImage.setImageResource(artworkImages[currentArtwork]);
        artworkCounter.setText((currentArtwork + 1) + " / " + titles.length);
        artworkTitle.setText(titles[currentArtwork]);
        artworkArtist.setText(
                artists[currentArtwork] + " (" + years[currentArtwork] + ")"
        );

        boolean previousEnabled = currentArtwork > 0;
        boolean nextEnabled = currentArtwork < titles.length - 1;

        previousButton.setEnabled(previousEnabled);
        nextButton.setEnabled(nextEnabled);

        previousButton.setBackgroundTintList(
                ColorStateList.valueOf(
                        previousEnabled ? 0xFF98501D : 0xFFDDD6CF
                )
        );

        nextButton.setBackgroundTintList(
                ColorStateList.valueOf(
                        nextEnabled ? 0xFF98501D : 0xFFDDD6CF
                )
        );

        previousButton.setTextColor(
                previousEnabled ? 0xFFFFFFFF : 0xFF807A74
        );

        nextButton.setTextColor(
                nextEnabled ? 0xFFFFFFFF : 0xFF807A74
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentArtwork", currentArtwork);
        super.onSaveInstanceState(outState);
    }
}