package com.ion.jewelry.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ion.jewelry.model.entity.NoticeBoard;
import com.ion.jewelry.model.network.request.NoticeBoardRequest;
import com.ion.jewelry.model.network.response.NoticeBoardResponse;

@RestController
@RequestMapping("/jewelry/noticeBoard")
public class NoticeBoardController extends 
		AABaseController<NoticeBoardRequest, NoticeBoardResponse, NoticeBoard>{

}
