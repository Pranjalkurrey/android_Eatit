package inn.startXway.eatit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import inn.startXway.eatit.Api.ApiURL;
import inn.startXway.eatit.models.UserResponse;

public class BasicPackAdapter extends RecyclerView.Adapter<BasicPackAdapter.BPViewHolder>
{
    Context mctx;
    List<UserResponse> userResponseList;

    public BasicPackAdapter(Context mctx, List<UserResponse> userResponseList)
    {
        this.mctx = mctx;
        this.userResponseList = userResponseList;
    }

    @NonNull
    @Override
    public BPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(mctx);
        View v = layoutInflater.inflate(R.layout.basic_card,parent,false);
        return new BPViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BPViewHolder bpViewHolder,final int position)
    {
        bpViewHolder.mealTitle.setText(userResponseList.get(position).getMealName());
        bpViewHolder.mealPrice.setText("\u20B9"+userResponseList.get(position).getMealPrice());
        bpViewHolder.mealDescr.setText(userResponseList.get(position).getMealDescr());
        bpViewHolder.mealRating.setText(userResponseList.get(position).getMealRating());
        bpViewHolder.mealStatus.setText(userResponseList.get(position).getMealStatus());
        Picasso.get().load(ApiURL.IMG_URL+userResponseList.get(position).getMealImage()).into(bpViewHolder.mealImage);
        bpViewHolder.BasicPackCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(mctx,CartActivity.class);
                in.putExtra("name",""+userResponseList.get(position).getMealName());
                in.putExtra("price",""+userResponseList.get(position).getMealPrice());
                in.putExtra("description",""+userResponseList.get(position).getMealDescr());
                in.putExtra("mealImage",""+ApiURL.IMG_URL+userResponseList.get(position).getMealImage());
                in.putExtra("mealId",""+userResponseList.get(position).getMealId());

                mctx.startActivity(in);

            }
        });


    }

    @Override
    public int getItemCount()
    {
        return userResponseList.size();
    }

    public class BPViewHolder extends RecyclerView.ViewHolder
    {

        TextView mealTitle,mealPrice,mealRating,mealDescr,mealStatus;
        ImageView mealImage,mealSticker;
        CardView BasicPackCard;


        public BPViewHolder(View itemView)
        {
            super(itemView);
            mealTitle = itemView.findViewById(R.id.mess_meal);
            mealPrice = itemView.findViewById(R.id.meal_price);
            mealRating = itemView.findViewById(R.id.meal_rating);
            mealSticker = itemView.findViewById(R.id.mess_sticker);
            mealDescr = itemView.findViewById(R.id.meal_descr);
            mealImage = itemView.findViewById(R.id.mess_img);
            mealStatus = itemView.findViewById(R.id.meal_status);
            BasicPackCard= itemView.findViewById(R.id.basic_pack_cardView_2);


        }
    }
}
