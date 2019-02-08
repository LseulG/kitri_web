package com.kitri.action.album;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;

public class AlbumWriteAction implements Action {

	// 2 자기자신 변수 하나 만들어라
	private static Action albumWriteAction;

	// 3 한번만 생성하고
	static {
		albumWriteAction = new AlbumWriteAction();
	}

	// 1 프라이빗으로 막아라
	private AlbumWriteAction() {}

	// 4 다른대서 쓸 수 있게 getter 만들기
	public static Action getAlbumWriteAction() {
		return albumWriteAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return null;
	}

}
