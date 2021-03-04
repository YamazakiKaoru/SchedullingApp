package com.example.Schedulle.auth.account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * ローカルファイルから
 * 画像を読み込み、データを返すクラス
 */
public class ImageFile {

	//画像パス
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = "src/main/resources/static/images/" + fileName;
	}

	/**
	 * base64でエンコードしたデータを文字列で返す
	 * @return
	 */
	public String encodedString() {
		File imageFile = new File(fileName);
		StringBuffer base64String = new StringBuffer();
		try {
			String contentType = Files.probeContentType(imageFile.toPath());
			byte[] fileData = Files.readAllBytes(imageFile.toPath());

			base64String.append("data:");
			base64String.append(contentType);
			base64String.append(";base64,");
			base64String.append(Base64.getEncoder().encodeToString(fileData));
		} catch (IOException e) {
			return "";
		}

		return base64String.toString();
	}

}