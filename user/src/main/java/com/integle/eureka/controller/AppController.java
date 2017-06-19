package com.integle.eureka.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integle.eureka.entity.Blog;
import com.integle.eureka.entity.User;
import com.integle.eureka.mapper.BlogMapper;

/**
 * @see http://docs.spring.io/spring/docs/5.0.0.RC2/spring-framework-reference/data-access.html#jdbc-introduction
 * @author Administrator
 *
 */
@RestController
public class AppController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	BlogMapper blogMapper;
	
	@Autowired
	TransactionTemplate tatemple;
	
	@Autowired
	JdbcTemplate jdbcTemple;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		System.out.println("port:"+port);
		return "hello world,port:"+port;
	}
	
	@GetMapping("/say/{word}")
	public String say(@PathVariable String word) {
		return "you say:"+word;
	}
	
	@PostMapping("/user")
	public User findUser(@RequestBody User user) {
		return user;
	}
	
	@GetMapping("/go")
	public String go(@RequestParam String provice, @RequestParam String city) {
		return "you want to goto provice:"+provice+",city:"+city;
	}
	
	@GetMapping("/blog/{id}")
	public Blog getBlog(@PathVariable int id) {
		Blog blog = jdbcTemple.queryForObject(
                "select id,title,description from blog",
                new RowMapper<Blog>() {

						public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
							Blog blog = new Blog();
							blog.setId(rs.getInt("id"));
							blog.setTitle(rs.getString("title"));
							blog.setDescription(rs.getString("description"));
							return blog;
						}
                });
		return blog;
	}
	
	@GetMapping("/blogs")
	public List<Blog> getBlogs() {
		List<Blog> blogs = jdbcTemple.query(
                "select id,title,description from blog",
                new RowMapper<Blog>() {

						public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
							Blog blog = new Blog();
							blog.setId(rs.getInt("id"));
							blog.setTitle(rs.getString("title"));
							blog.setDescription(rs.getString("description"));
							return blog;
						}
                });
		return blogs;
	}
	
	@GetMapping("/blog/update")
	@Transactional
	public int updateBlog() {
		
		/*int row = tatemple.execute(new TransactionCallback<Integer>() {

			public Integer doInTransaction(TransactionStatus status) {
				Blog blog = new Blog();
				blog.setId(1);
				blog.setTitle("你好宝贝");
				blog.setDescription("sdfggsfdfggffefsh23232342342"); 
				int row = blogMapper.update(blog);
				
				int j = 1/1;
				return row;
			}
		});*/
		
		int row = jdbcTemple.update("update blog set title=? where id =?", "nidaye2233", 1);
		
		int j = 1/0;
		
		return row;
	}
	
	@RequestMapping("blog/count")
	public int count() {
		int row = jdbcTemple.queryForObject(
				"select count(*) from blog", Integer.class);
		return row;
	}
	
	@GetMapping("/blog/title/{id}")
	public String title(@PathVariable int id) {
		String lastName = jdbcTemple.queryForObject(
                "select title from blog where id = ?",
                new Object[]{id}, String.class);
		return lastName;
	}

}
