package sheva.booksshop.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import sheva.booksshop.mvp.model.api.BookAPI;
import sheva.booksshop.mvp.model.repository.BooksRepository;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    public BookAPI provideBookAPI(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(BookAPI.class);
    }

    @Provides
    @Singleton
    public BooksRepository provideBooksRepository() {
        return new BooksRepository();
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
