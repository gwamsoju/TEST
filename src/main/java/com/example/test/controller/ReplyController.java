package com.example.test.controller;

import com.example.test.Service.ReplyService;
import com.example.test.VO.Reply;
import com.example.test.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/new")            // @RequestBody는 JSON형태의 데이터를 자바 객체로 바꿔준다.
    public ResponseEntity<String> create( @RequestBody Reply reply){ // postman으로 요청할 때, JSON 형식으로 넣었기 때문에 ....

        int i = replyService.insertReply(reply);
        System.out.println(reply);

        return i == 1
        ? new ResponseEntity<>("success", HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/pages/{bno}/{page}")
    public ResponseEntity<List<Reply>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){

        PageUtil pageUtil = new PageUtil(page, 10);

        return new ResponseEntity<>(replyService.getReplyList(bno, pageUtil), HttpStatus.OK);
    }

    @DeleteMapping("/{rno}")
    public ResponseEntity<String> delete(@PathVariable Long rno){
        int delete = replyService.delete(rno);

        return delete == 1
                ? new ResponseEntity<>("success",HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method={ RequestMethod.PUT, RequestMethod.PATCH}, value="/{rno}")
    public ResponseEntity<String> update(@RequestBody Reply reply, @PathVariable("rno") Long rno){

        reply.setRno(rno);

        return replyService.update(reply) == 1
                ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

