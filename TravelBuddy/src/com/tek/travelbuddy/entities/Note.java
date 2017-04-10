package com.tek.travelbuddy.entities;

import android.graphics.Bitmap;

public class Note implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int _noteId;
	private int _tripId;
	private String _title;
	private String _content;
	
	private Bitmap _image;
	
	public Note(int tripId, String title, String content) {
		this(0, tripId, title, content);
	}

	public Note(int noteId, int tripId, String title, String content) {
		_noteId = noteId;
		_tripId = tripId;
		_title = title;
		_content = content;
	}

	public int getNoteId() {
		return _noteId;
	}
	public void setNoteId(int noteId) {

		_noteId = noteId;
	}
	public int getTripId() {
		return _tripId;
	}
	public void setTripId(int tripId) {
		_tripId = tripId;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}
	public String getContent() {
		return _content;
	}
	public void setContent(String content) {
		_content = content;
	}
	
	public Bitmap getImage() {
		return _image;
	}
	
	public void setImage(Bitmap image) {
		_image = image;
	}

	public int getId() {
		return getNoteId();
	}

	public void setId(int value) {
		setNoteId(value);
	}
	
	public Integer getParentId() {
		return getTripId();
	}

}
