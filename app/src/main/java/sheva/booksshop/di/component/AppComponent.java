package sheva.booksshop.di.component;

import javax.inject.Singleton;

import dagger.Component;
import sheva.booksshop.di.module.AppModule;
import sheva.booksshop.di.module.RetrofitModule;
import sheva.booksshop.mvp.datamanager.DataManager;
import sheva.booksshop.mvp.model.repository.BooksRepository;
import sheva.booksshop.mvp.presenter.activities.MainActivityPresenter;

@Component(modules = {AppModule.class, RetrofitModule.class})
@Singleton
public interface AppComponent {
    void inject(DataManager manager);
    void inject(BooksRepository repository);
    void inject(MainActivityPresenter presenter);
}
