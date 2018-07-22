package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upgrad.model.User;
import org.upgrad.services.AnswerService;
import org.upgrad.services.CommentService;
import org.upgrad.services.NotificationService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class CommentController {
    @Autowired
    private AnswerService answerService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;

    public CommentController() {
    }

    @PostMapping("/api/comment")
    public ResponseEntity <?> giveComment(@RequestParam("answerId") Integer answerId, @RequestParam("comment") String comment, HttpSession session) {
        User currUser = (User) session.getAttribute ( "currUser" );
        if (currUser == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {
            return new ResponseEntity <> ( " answerId " + answerId + " commented successfully.", HttpStatus.CREATED );
        }
    }

    @PutMapping("/api/comment/{commentId}")
    public ResponseEntity <?> editComment(@PathVariable("commentId") Integer commentId, @RequestParam("comment") String comment, HttpSession session) {
        User currUser = (User) session.getAttribute ( "currUser" );
        if (currUser == null) {

            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {
            if (currUser.getRole ().equalsIgnoreCase ( "admin" ) || (currUser.getId () == commentService.findUserIdfromComment ( commentId ))) {
                return new ResponseEntity <> ( "Comment with commentId " + commentId + " edited successfully.", HttpStatus.OK );
            } else {
                return new ResponseEntity <> ( "You do not have rights to edit this comment.", HttpStatus.UNAUTHORIZED );
            }
        }
    }


    @DeleteMapping("/api/comment/{commentId}")
    public ResponseEntity <?> deleteCommen(@PathVariable("commentId") Integer commentId, HttpSession session) {
        User currUser = (User) session.getAttribute ( "currUser" );
        if (currUser == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );

        } else {
            if (currUser.getRole ().equalsIgnoreCase ( "admin" ) || (currUser.getId () == commentService.findUserIdfromComment ( commentId ))) {
                return new ResponseEntity <> ( "Comment with commentId " + commentId + " deleted successfully.", HttpStatus.OK );
            } else {
                return new ResponseEntity <> ( "You do not have rights to delete this comment!", HttpStatus.UNAUTHORIZED );
            }
        }
    }


//
//    @GetMapping("/api/comment/all/{answerId}")
//    public ResponseEntity <?> getAllCommentsByAnswer (){
//
//    }
}
