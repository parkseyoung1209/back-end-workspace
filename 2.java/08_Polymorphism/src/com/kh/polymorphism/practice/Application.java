package com.kh.polymorphism.practice;

import java.util.Scanner;

import com.kh.polymorphism.practice.controller.BookController;
import com.kh.polymorphism.practice.model.parents.Book;

public class Application {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book book = new Book();
		BookController bc = new BookController();
	}

}
