package com.utilities;

import java.io.File;

public class GetFilePathUtil {
	
	public String getFilePath(String filePathFromsrc , String fileName) {
		File file = new File(filePathFromsrc + fileName);
		String filePath = file.getAbsolutePath();
		return filePath;
	}
}
