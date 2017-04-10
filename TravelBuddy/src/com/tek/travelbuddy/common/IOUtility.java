package com.tek.travelbuddy.common;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;

public abstract class IOUtility {
	public static String ReadTextFromAssests(AssetManager assets, String path) {
		InputStream stream;
		String text;
		
		try {
			stream = assets.open(path);
			int size = stream.available();
			byte[] buffer = new byte[size];
			stream.read(buffer);
			stream.close();
			text = new String(buffer);
		}
		catch (IOException e) {
			text = "";
		}
		
		return text;
	}
}
