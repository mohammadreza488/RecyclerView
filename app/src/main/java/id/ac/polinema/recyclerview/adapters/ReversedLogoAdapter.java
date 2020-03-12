package id.ac.polinema.recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.ac.polinema.recyclerview.R;
import id.ac.polinema.recyclerview.ViewTypeActivity;
import id.ac.polinema.recyclerview.models.TeamLogo;

public class ReversedLogoAdapter extends RecyclerView.Adapter<ReversedLogoAdapter.ViewHolder> {

    private static final int LOGO_LEFT = 1;
    private static final int LOGO_RIGHT = 2;
    private final Context context;
    private final List<TeamLogo> items;

    public ReversedLogoAdapter(Context context, List<TeamLogo> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ReversedLogoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == LOGO_LEFT) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_logo, parent, false);
        } else if (viewType == LOGO_RIGHT) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_logo_reversed, parent, false);
        }
        return new ReversedLogoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeamLogo item=items.get(position);
        //atur image di baris ini//
        holder.nameText.setText(item.getName());

        Glide.with(context).load(item.getLogo()).into(holder.logoImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? LOGO_RIGHT : LOGO_LEFT;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView logoImage;
        TextView nameText;
        public ViewHolder(View itemview) {
            super(itemview);
            logoImage = itemView.findViewById(R.id.image_logo);
            nameText =itemView.findViewById(R.id.text_name);
        }
    }
}
