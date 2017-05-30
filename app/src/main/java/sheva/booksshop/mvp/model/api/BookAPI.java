package sheva.booksshop.mvp.model.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import sheva.booksshop.mvp.model.entities.BookEntity;

public interface BookAPI {

    @GET("v1/volumes?")
    Observable<BookEntity> getBookList(@Query("q") String query);
}
