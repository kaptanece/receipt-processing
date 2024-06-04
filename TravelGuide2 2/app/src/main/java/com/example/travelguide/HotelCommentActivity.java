package com.example.travelguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class HotelCommentActivity extends AppCompatActivity {

  private TextView hotelNameTextView;
  private TextView hotelPriceTextView;
  private EditText commentInput;
  private Button submitCommentButton;
  private RecyclerView commentsRecyclerView;
  private HotelCommentAdapter commentAdapter;
  private List<Comment> comments;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hotel_detail);

    hotelNameTextView = findViewById(R.id.hotel_name);
    hotelPriceTextView = findViewById(R.id.hotel_price);
    commentInput = findViewById(R.id.comment_input);
    submitCommentButton = findViewById(R.id.submit_comment_button);
    commentsRecyclerView = findViewById(R.id.comments_recycler_view);

    String hotelName = getIntent().getStringExtra("hotelName");
    int hotelPrice = getIntent().getIntExtra("hotelPrice", 0);

    hotelNameTextView.setText(hotelName);
    hotelPriceTextView.setText("Price: $" + hotelPrice);

    comments = new ArrayList<>();
    commentAdapter = new HotelCommentAdapter(this, comments);
    commentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    commentsRecyclerView.setAdapter(commentAdapter);

    // Add sample comments
    loadSampleComments();

    submitCommentButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String newCommentText = commentInput.getText().toString();
        if (!newCommentText.isEmpty()) {
          Comment newComment = new Comment(newCommentText, "User"); // Assuming "User" as the commenter
          comments.add(newComment);
          commentAdapter.notifyItemInserted(comments.size() - 1);
          commentInput.setText(""); // Clear input field
        }
      }
    });
  }

  private void loadSampleComments() {
    comments.add(new Comment("Great stay!", "John"));
    comments.add(new Comment("Very clean.", "Jane"));
    comments.add(new Comment("Would recommend.", "Alice"));
    commentAdapter.notifyDataSetChanged();
  }
}
