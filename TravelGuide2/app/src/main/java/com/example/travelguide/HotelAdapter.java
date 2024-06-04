package com.example.travelguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
  private List<Hotel> hotelList;
  private Context context;

  public HotelAdapter(List<Hotel> hotelList, Context context) {
    this.hotelList = hotelList;
    this.context = context;
  }

  @NonNull
  @Override
  public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_item, parent, false);
    return new HotelViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
    Hotel hotel = hotelList.get(position);
    holder.hotelName.setText(hotel.getName());
    holder.hotelDescription.setText(hotel.getDescription());
    holder.hotelPrice.setText(String.format("$%.2f", hotel.getPrice()));
    holder.hotelImage.setImageResource(hotel.getImageResourceId());

    holder.rateButton.setOnClickListener(v -> {
      // Handle the rate button click
    });
  }

  @Override
  public int getItemCount() {
    return hotelList.size();
  }

  static class HotelViewHolder extends RecyclerView.ViewHolder {
    TextView hotelName;
    TextView hotelDescription;
    TextView hotelPrice;
    ImageView hotelImage;
    Button rateButton;

    HotelViewHolder(View view) {
      super(view);
      hotelName = view.findViewById(R.id.hotelName);
      hotelDescription = view.findViewById(R.id.hotelDescription);
      hotelPrice = view.findViewById(R.id.hotelPrice);
      hotelImage = view.findViewById(R.id.hotelImage);
      rateButton = view.findViewById(R.id.rateButton);
    }
  }

  public void setHotels(List<Hotel> hotels) {
    this.hotelList = hotels;
    notifyDataSetChanged();  // Notify the adapter that the data set has changed
  }
}
