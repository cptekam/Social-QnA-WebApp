package org.upgrad.services;

import org.springframework.stereotype.Service;

@Service
public class CommentServiceImp implements CommentService {
    @Override
    public int findUserIdfromComment(int commentId) {
        return 2;
    }
}
