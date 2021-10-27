package com.ion.jewelry.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ion.jewelry.model.entity.NoticeBoard;
import com.ion.jewelry.model.network.Header;
import com.ion.jewelry.model.network.request.NoticeBoardRequest;
import com.ion.jewelry.model.network.response.NoticeBoardResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/jewelry/noticeBoard")
public class NoticeBoardController extends 
		AABaseController<NoticeBoardRequest, NoticeBoardResponse, NoticeBoard>{

	@Override
	@GetMapping("/paging") // http://localhost:8000//jewelry/noticeBoard/paging?page=0
	public Header<List<NoticeBoardResponse>> pagingRead(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 10)
			Pageable pageable) {
		
		log.info("{}", pageable);
		return baseService.pagingRead(pageable);
	}
	
	

}
