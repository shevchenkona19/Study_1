package sheva.booksshop.mvp.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sheva.booksshop.R;
import sheva.booksshop.mvp.model.entities.Item;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
    private Context context;
    private List<Item> bookList;
    private LayoutInflater inflater;

    public BookListAdapter(Context context){
        this.context = context;
        bookList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        final Item book = bookList.get(position);
        boolean isSale = book.getSaleInfo().getSaleability().equals("FOR_SALE");
        if (isSale){
            holder.btnBuy.setEnabled(true);
            holder.btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(book.getSaleInfo().getBuyLink()));
                    context.startActivity(intent);
                }
            });
            holder.tvPrice.setText(book.getSaleInfo().getRetailPrice().getAmount() + " " +
                book.getSaleInfo().getRetailPrice().getCurrencyCode());
        } else {
            holder.tvPrice.setText("Not for sale");
            holder.btnBuy.setEnabled(false);
        }
        if (book.getVolumeInfo().getTitle().length() > 35) {
            holder.tvTitle.setText(book.getVolumeInfo().getTitle().substring(0, 35) + "...");
        } else {
            holder.tvTitle.setText(book.getVolumeInfo().getTitle());
        }
        try {
            holder.tvAuthor.setText(book.getVolumeInfo().getAuthors().get(0));
        } catch (Exception e){
            //doNTHING
        }
        try {
            Picasso.with(context)
                    .load(book.getVolumeInfo().getImageLinks().getThumbnail())
                    .into(holder.ivBookThumbnail);
        } catch (Exception e) {
            try {
                Picasso.with(context)
                        .load(book.getVolumeInfo().getImageLinks().getSmallThumbnail())
                        .into(holder.ivBookThumbnail);
            } catch (Exception e1) {
                //doNTHING
            }
        }
    }

    public void updateList(List<Item> list) {
        bookList.clear();
        bookList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivBookThumbnail)
        ImageView ivBookThumbnail;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvAuthor)
        TextView tvAuthor;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.btnBuy)
        Button btnBuy;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
