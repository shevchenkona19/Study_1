package sheva.booksshop.mvp.presenter.activities;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import sheva.booksshop.App;
import sheva.booksshop.mvp.datamanager.DataManager;
import sheva.booksshop.mvp.model.entities.BookEntity;
import sheva.booksshop.mvp.model.entities.Item;
import sheva.booksshop.mvp.presenter.base.BasePresenter;
import sheva.booksshop.mvp.presenter.interfaces.IMainActivityPresenter;
import sheva.booksshop.mvp.view.interfaces.IMainActivityView;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<IMainActivityView> implements IMainActivityPresenter{
    @Inject
    DataManager manager;

    public MainActivityPresenter() {
        App.get().getAppComponent().inject(this);
    }


    @Override
    public void updateListWithQuery(String query) {
        final List<Item> bookList = new ArrayList<>();
        Subscription subscription = manager.getBooksByQuery(query)
                .subscribe(new Subscriber<BookEntity>() {
                    @Override
                    public void onCompleted() {
                        getViewState().updateListWithBookList(bookList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MY", e.getMessage());
                    }

                    @Override
                    public void onNext(BookEntity bookEntity) {
                        bookList.addAll(bookEntity.getItems());
                    }
                });
        unsubscribeOnDestroy(new CompositeSubscription(subscription));
    }
}
