package org.upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.upgrad.model.User;
import org.upgrad.services.AnswerService;
import org.upgrad.services.UserService;

import javax.servlet.http.HttpSession;

@RestController
public class AnswerController {

    /*
     * This QuestionService consist of all the implementations of business logic related to answer information of the app and
     * interact with repositories to access/store data in the database.
     */
    @Autowired
    private AnswerService answerService;

    /*
     * This UserService consist of all the implementations of business logic related to user login information of the app and
     * interact with repositories to access/store data in the database.
     */
    @Autowired
    private UserService userService;

    public AnswerController() {
    }
    /*
     * This end point is implemented to get all answers related to particular question id
     */

    @GetMapping("/api/answer/all/{questionId}")
    ResponseEntity <?> getAnswersByQuestionId(@PathVariable("questionId") int questionId, HttpSession session) {
        if (session.getAttribute ( "currUser" ) == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            if (!String.valueOf ( answerService.isQuestionIdForAnswerValid ( questionId ) ).equalsIgnoreCase ( "null" )) {
                return new ResponseEntity <> ( answerService.getAllAnswersToQuestion ( questionId ), HttpStatus.OK );
            } else {
                return new ResponseEntity <> ( "Question with id " + questionId + " doesn't contains answer", HttpStatus.NOT_FOUND );
            }
        }
    }

    /*
     * This end point is implemented to get all answers related to posted by particular user
     */

    @GetMapping("/api/answer/all")
    ResponseEntity <?> getAnswersByUserId(HttpSession session) {
        if (session.getAttribute ( "currUser" ) == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            User user = (User) session.getAttribute ( "currUser" );
            String uname = user.getUserName ();
            int userId = userService.findUserIdByName ( uname );
            return new ResponseEntity <> ( answerService.getAllAnswersByUser ( userId ), HttpStatus.OK );
        }
    }



    @GetMapping("/api/answer/likes/{questionId}")
    public ResponseEntity <?> getAllAnswersByLikes(@PathVariable("questionId") Integer questionId, HttpSession session) {

        if (session.getAttribute ( "currUser" ) == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            return new ResponseEntity <> ( answerService.getAllAnswersByLikes ( questionId ), HttpStatus.OK );
        }

    }

    @DeleteMapping("/api/answer/{answerId}")
    public ResponseEntity <?> deleteAnswer(@PathVariable("answerId") Integer answerId, HttpSession session) {
        User loggedInUser = (User) session.getAttribute ( "currUser" );
        System.out.println ( loggedInUser );
        if (loggedInUser == null) {
            return new ResponseEntity <> ( "Please Login first to access this endpoint!", HttpStatus.UNAUTHORIZED );
        } else {
            //remaining check ser who created the question to implement
            if ((loggedInUser.getRole ().equalsIgnoreCase ( "admin" )) || (userService.findUserIdByName ( loggedInUser.getUserName () ) == answerService.findUserIdfromAnswer ( answerId ))) {
                answerService.deleteAnswer ( answerId );
                return new ResponseEntity <> ( " Answer with answerId " + answerService.findUserIdfromAnswer ( answerId ) + " deleted successfully.", HttpStatus.OK );

            } else {
                return new ResponseEntity <> ( "You do not have rights to delete this answer.", HttpStatus.UNAUTHORIZED );
            }
        }
    }
}