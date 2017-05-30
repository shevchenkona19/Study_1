package sheva.booksshop.mvp.datamanager;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sheva.booksshop.App;
import sheva.booksshop.mvp.model.entities.BookEntity;
import sheva.booksshop.mvp.model.repository.BooksRepository;

public class DataManager {
    @Inject
    BooksRepository booksRepository;
    public DataManager() {
        App.get().getAppComponent().inject(this);
    }

    public Observable<BookEntity> getBooksByQuery(String query) {
        return booksRepository.getBooksByQuery(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
