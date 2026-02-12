package com.wipro.book.service;

import com.wipro.book.bean.Bookbean;
import com.wipro.book.dao.BookDao;

public class Administrator {

    public String addBook(Bookbean bookBean) {
        if (bookBean == null) {
            return "INVALID";
        }
        if (bookBean.getIsbn() == null || bookBean.getIsbn().isEmpty()) {
            return "INVALID";
        }
        if (bookBean.getBookName() == null || bookBean.getBookName().isEmpty()) {
            return "INVALID";
        }
        if (bookBean.getCost() <= 0) {
            return "INVALID";
        }
        if (bookBean.getBookType() != 'G' && bookBean.getBookType() != 'T') {
            return "INVALID";
        }
        if (bookBean.getAuthor() == null) {
            return "INVALID";
        }
        if (bookBean.getAuthor().getAuthorName() == null ||
            bookBean.getAuthor().getAuthorName().isEmpty()) {
            return "INVALID";
        }
        BookDao bookdao = new BookDao();
        if (bookdao.createBook(bookBean) == 1) {
            return "SUCCESS";
        }
        return "FAILURE";
    }

    public Bookbean viewBook(String isbn) {
        BookDao bookdao = new BookDao();
        Bookbean bookBean = bookdao.fetchBook(isbn);
        return bookBean;
    }
}
