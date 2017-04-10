package com.tek.travelbuddy.entities;

import java.io.Serializable;

public interface IEntity extends Serializable {
	int getId();
	Integer getParentId();
	void setId(int value);
}
