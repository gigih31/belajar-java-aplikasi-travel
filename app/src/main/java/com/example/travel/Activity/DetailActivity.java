package com.example.travel.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.travel.Domain.ItemDomain;
import com.example.travel.R;
import com.example.travel.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
    ActivityDetailBinding binding;
    private ItemDomain object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.descriptionTxt.setText(object.getDescription());
        binding.addressTxt.setText(object.getAddress());
        binding.bedTxt.setText(""+object.getBed());
        binding.durationTxt.setText(object.getDuration());
        binding.distanceTxt.setText(object.getDistance());
        binding.ratingTxt.setText(object.getScore()+"Rating");
        binding.ratingBar.setRating((float) object.getScore());
        binding.backBtn.setOnClickListener(v -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getPic())
                .into(binding.pic);

        binding.addToCartBtn.setOnClickListener(v -> {
            Intent intent=new Intent(DetailActivity.this, TicketActivity.class);
            intent.putExtra("object",object);
            startActivity(intent);
        });
    }

    private void getIntentExtra() {
        object= (ItemDomain) getIntent().getSerializableExtra("object");
    }
}