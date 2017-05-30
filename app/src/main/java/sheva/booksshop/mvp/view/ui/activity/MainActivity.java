package sheva.booksshop.mvp.view.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sheva.booksshop.R;
import sheva.booksshop.mvp.model.entities.Item;
import sheva.booksshop.mvp.presenter.activities.MainActivityPresenter;
import sheva.booksshop.mvp.view.adapters.BookListAdapter;
import sheva.booksshop.mvp.view.interfaces.IMainActivityView;

public class MainActivity extends MvpAppCompatActivity implements IMainActivityView{
    @BindView(R.id.rvBookList)
    RecyclerView rvBookList;
    @BindView(R.id.svSearchBook)
    SearchView searchView;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    private BookListAdapter adapter;
    @InjectPresenter
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new BookListAdapter(this);
        rvBookList.setLayoutManager(new LinearLayoutManager(this));
        rvBookList.setAdapter(adapter);
        rvBookList.setVisibility(View.GONE);
        pbLoading.setVisibility(View.GONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pbLoading.setVisibility(View.VISIBLE);
                presenter.updateListWithQuery(query);
                rvBookList.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rvBookList.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    @Override
    public void updateListWithBookList(List<Item> bookList) {
        pbLoading.setVisibility(View.GONE);
        adapter.updateList(bookList);
    }
}
