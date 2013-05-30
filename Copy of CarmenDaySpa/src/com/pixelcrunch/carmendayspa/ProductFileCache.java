package com.pixelcrunch.carmendayspa;

import java.io.File;
import java.net.URLEncoder;

import android.content.Context;

public class ProductFileCache {

	private File cacheDir;

	public ProductFileCache(Context context) {
		// Find the dir to save cached images
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED))
			cacheDir = new File(
					android.os.Environment.getExternalStorageDirectory(),
					"CarmenProducts");
		else
			cacheDir = context.getCacheDir();
		if (!cacheDir.exists())
			cacheDir.mkdirs();
	}

	public File getFile(String url) {
		// URLEncoder is deprecated, tell android to suck it up
		@SuppressWarnings("deprecation")
		String filename = URLEncoder.encode(url);
		File f = new File(cacheDir, filename);
		return f;

	}

	public void clear() {
		File[] files = cacheDir.listFiles();
		if (files == null)
			return;
		for (File f : files)
			f.delete();
	}

}