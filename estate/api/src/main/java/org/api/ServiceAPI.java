package org.api;

import java.util.List;

import org.pojo.Buliding;

public interface ServiceAPI {
	
	public Buliding loadbiu(Integer id);
	
	public List<Buliding> findBuild(Integer id);
}
