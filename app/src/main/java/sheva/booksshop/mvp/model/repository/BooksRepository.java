package sheva.booksshop.mvp.model.repository;

import javax.inject.Inject;

import rx.Observable;
import sheva.booksshop.App;
import sheva.booksshop.mvp.model.api.BookAPI;
import sheva.booksshop.mvp.model.entities.BookEntity;

public class BooksRepository {
    @Inject
    BookAPI bookAPI;

    public BooksRepository() {
        App.get().getAppComponent().inject(this);
    }

    public Observable<BookEntity> getBooksByQuery(String query) {
        return bookAPI.getBookList(query);
    }
}
