package sheva.booksshop.mvp.view.interfaces;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import sheva.booksshop.mvp.model.entities.Item;

public interface IMainActivityView extends MvpView {
    void updateListWithBookList(List<Item> bookList);
}
