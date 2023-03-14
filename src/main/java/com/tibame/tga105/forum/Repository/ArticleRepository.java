package com.tibame.tga105.forum.Repository;

import com.tibame.tga105.forum.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Integer> {

    public  ArticleEntity findByArticleid(Integer articleid);

    Page<ArticleEntity> findAll (Pageable pageable);
    List<ArticleEntity> findArticleEntitiesByArticlecontextLike(String context);
    
    @Query(value = "select * from article  where userid=?", nativeQuery = true)
    List<ArticleEntity> findUserArticle(Integer userid);
    
    @Query("select a from ArticleEntity a where length(a.articletitle) >?1")
    List<ArticleEntity>findByJPQL(int length);

    @Modifying
    @Query("update ArticleEntity a set a.articletitle=?1 ,a.articlecontext=?2 where a.articleid=?3")
    int updateByJPQL(String articletitle,
                     String articlecontext,
                     Integer articleid);

    @Query(value = "select * from article  where article_title like %?% or article_context like  %?%", nativeQuery = true)
    List<ArticleEntity> findByKeyWords(String articletitle,
                                       String articlecontext);

    @Query(value = "select * from article where articletypeid=? ", nativeQuery = true)
    List<ArticleEntity> findByArticleTypeId(Integer articletypeid);
    
    @Query(value = "SELECT * FROM article order by like_count desc limit 5 ", nativeQuery = true)
    List<ArticleEntity> findArticlePopularity();
    
    @Query(value = "SELECT * FROM article order by view_count desc limit 5 ", nativeQuery = true)
    List<ArticleEntity> findArticleView();
    
    
    @Query(value = "SELECT * FROM article order by post_datetime desc  ", nativeQuery = true)
    List<ArticleEntity> sortByPostdatetime();
}

