package ecanche.apps.sqliteexterna;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lalo
 * Date: 25/06/16
 * Project: RecyclerView
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PostalCodeViewHolder> {

    public static class PostalCodeViewHolder extends RecyclerView.ViewHolder {
        //This class will have all the elements of the card view:
        private CardView cardView;
        private TextView postalAsenta, postalCode;
        private ImageView postalPhoto;

        public PostalCodeViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.postalAsenta = (TextView) itemView.findViewById(R.id.postalAsenta);
            this.postalCode = (TextView) itemView.findViewById(R.id.postalCode);
            this.postalPhoto = (ImageView) itemView.findViewById(R.id.postalPhoto);
        }
    }

    private List<PostalCode> postalCodes;

    public RecyclerViewAdapter(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PostalCodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostalCodeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(PostalCodeViewHolder holder, int position) {
        holder.postalAsenta.setText(this.postalCodes.get(position).getAsenta());
        holder.postalCode.setText(String.valueOf(this.postalCodes.get(position).getCodigo()));
        holder.postalPhoto.setImageResource(this.postalCodes.get(position).getPhotoID());
    }

    @Override
    public int getItemCount() {
        return this.postalCodes.size();
    }

}
