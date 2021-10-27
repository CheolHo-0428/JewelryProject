package com.ion.jewelry.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ion.jewelry.model.entity.NoticeBoard;
import com.ion.jewelry.model.network.Header;
import com.ion.jewelry.model.network.request.NoticeBoardRequest;
import com.ion.jewelry.model.network.response.NoticeBoardResponse;

@Service
public class NoticeBoardService extends 
	AABaseService<NoticeBoardRequest, NoticeBoardResponse, NoticeBoard> {
	
	//기본 Repository는 baseRepo!!!!
	
	@Override
	public Header<NoticeBoardResponse> create(Header<NoticeBoardRequest> request) {
		NoticeBoardRequest noticeRequest = request.getData();
		
		NoticeBoard board = NoticeBoard.builder()
					.title(noticeRequest.getTitle())
					.content(noticeRequest.getContent())
					.writer(noticeRequest.getWriter())
					.password(noticeRequest.getPassword())
					.privateOk(noticeRequest.getPrivateOk())
					.originFileName(noticeRequest.getOriginFileName())
					.storedFileName(noticeRequest.getStoredFileName())
					.fileSize(noticeRequest.getFileSize())
					.deleteCheck(noticeRequest.getDeleteCheck())
					.build();
		
		NoticeBoard newNoticeBoard = baseRepo.save(board);
		
		return Header.OK(response(newNoticeBoard));
	}

	@Override
	public Header<NoticeBoardResponse> update(Header<NoticeBoardRequest> request) {
		NoticeBoardRequest noticeRequest = request.getData();
		
		Optional<NoticeBoard> optional = baseRepo.findById(noticeRequest.getId());
		
		return optional
			.map(board -> {
				board
					.setTitle(noticeRequest.getTitle())
					.setContent(noticeRequest.getContent())
					.setWriter(noticeRequest.getWriter())
					.setPassword(noticeRequest.getPassword())
					.setPrivateOk(noticeRequest.getPrivateOk())
					.setOriginFileName(noticeRequest.getOriginFileName())
					.setStoredFileName(noticeRequest.getStoredFileName())
					.setFileSize(noticeRequest.getFileSize())
					.setDeleteCheck(noticeRequest.getDeleteCheck());
			return board;
			})
			.map(board -> baseRepo.save(board))
			.map(board -> response(board))
			.map(board -> Header.OK(board))
			.orElseGet(() -> Header.ERROR("업데이트할 데이터가 없습니다."));
	}

	@Override
	public Header delete(Long id) {
		Optional<NoticeBoard> optional = baseRepo.findById(id);
		
		return optional
				.map(board -> {
					baseRepo.delete(board);
					return Header.OK();
				})
				.orElseGet(() -> Header.ERROR("삭제할 데이터가 없습니다."));
	}

	@Override
	public Header<NoticeBoardResponse> selectRead(Long id) {
		Optional<NoticeBoard> optional = baseRepo.findById(id);
		
		return optional
					.map(board -> response(board))
					.map(board -> Header.OK(board))
					.orElseGet(() -> Header.ERROR("조회하신 데이터가 없습니다."));
	}

	@Override
	public Header<List<NoticeBoardResponse>> allRead() {
		List<NoticeBoard> boardList = baseRepo.findAll();
		
		List<NoticeBoardResponse> resBoardList = boardList.stream()
					.map(board -> response(board))
					.collect(Collectors.toList());
		
		return Header.OK(resBoardList);
	}
	
	public NoticeBoardResponse response(NoticeBoard board) {
		NoticeBoardResponse res = NoticeBoardResponse.builder()
				.id(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.password(board.getPassword())
				.privateOk(board.getPrivateOk())
				.originFileName(board.getOriginFileName())
				.storedFileName(board.getStoredFileName())
				.fileSize(board.getFileSize())
				.deleteCheck(board.getDeleteCheck())
				.build();
		
		return res;
	}
	
}