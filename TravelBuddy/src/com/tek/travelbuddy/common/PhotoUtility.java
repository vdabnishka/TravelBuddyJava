package com.tek.travelbuddy.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;

public abstract class PhotoUtility {
	public static Bitmap loadImage(byte [] data) {
		
		Bitmap image = null;
		
		if (data != null && data.length > 0) {
			try {
				ByteArrayInputStream stream = new ByteArrayInputStream(data);
				image = BitmapFactory.decodeStream(stream);

				stream.close();
			}
			catch (IOException e) { }
		}
		
		return image;
	}
	
	public static byte[] getImageData(Bitmap image) {
		byte [] data = null;
		
		if (image != null) {
			try {
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				image.compress(CompressFormat.JPEG, 100, stream);
				data = stream.toByteArray();
				
				stream.close();
			}
			catch (IOException e) { }
		}
		
		return data;
	}
}
