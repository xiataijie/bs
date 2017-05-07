package com.bs.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

	/**
	 * 图片上传到服务器
	 * @param uploadFile
	 * @return
	 */
	public Map uploadPicture(MultipartFile uploadFile);
	
}
