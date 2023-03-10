package com.tibame.tga105.forum.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.forum.entity.ArticleEntity;
import com.tibame.tga105.forum.entity.ReplyEntity;


@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity,Integer> {
	
	@Query(value = "select * from reply_entity where articleid= ? order by reply_datetime",nativeQuery = true)
	public List<ReplyEntity> findByArticleEntity(Integer articleid);
	
	
}
