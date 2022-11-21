package com.sda.mihai.bookmanagement.controller;

import com.sda.mihai.bookmanagement.service.BookReviewService;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.Scanner;

public class ReviewController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public ReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createReview() {
        try {
            System.out.println("Please insert book title");
            String title = scanner.nextLine();
            System.out.println("Please insert book score");
            int score = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert a comment");
            String comment = scanner.nextLine();

            bookReviewService.create(title, score, comment);
        } catch (
                InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a numeric value for author Id");
        } catch (Exception e) {
            System.out.println("internal system error");
        }
    }
}
