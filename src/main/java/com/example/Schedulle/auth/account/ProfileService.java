package com.example.Schedulle.auth.account;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Schedulle.auth.UserEntity;
import com.example.Schedulle.auth.UserService;

@Service
public class ProfileService {

	@Autowired
	UserService userService;

	//保存先のパス
	public static final String PROFILE_IMAGE_DEST = "src/main/resources/static/images/";

	/**
	 *　ローカルファイルに指定画像を保存する
	 * @param multipartFile　指定画像
	 * @param user　保存するユーザー
	 */
	public void updatePhoto(MultipartFile multipartFile, UserEntity user) {

		try {
			// 拡張子を取得
			String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			// ファイル名を名前にリネイム
			File oldFileName = new File(multipartFile.getOriginalFilename());
			File newFileName = new File(user.getName() + extension);
			oldFileName.renameTo(newFileName);

			// 保存先を定義
			byte[] bytes = multipartFile.getBytes();

			// 指定ファイルへ読み込みファイルを書き込み
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(PROFILE_IMAGE_DEST + newFileName)));

			//ユーザ情報の更新
			user.setFileName(user.getName() + extension);
			userService.update(user);

			stream.write(bytes);
			stream.close();

		} catch (Exception e) {
			System.out.println("error");
		}

	}

	/**
	 * ユーザーのプロフィール画像の取得
	 * @param user　ユーザー
	 * @return　画像データ
	 */
	public String getProfileData(UserEntity user) {
		ImageFile file = new ImageFile();
		file.setFileName(user.getFileName());
		return file.encodedString();

	}


}




