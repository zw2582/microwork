package com.integle.eureka.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.integle.eureka.entity.Blog;

@Mapper
public interface BlogMapper {

	public int update(Blog blog);
	
	public Blog selectOne(int id);
}
