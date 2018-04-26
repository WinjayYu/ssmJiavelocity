package com.part.dao;

import com.part.dataobject.PageViewDO;
import com.part.dataobject.PageViewDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageViewDAO {
    long countByExample(PageViewDOExample example);

    int deleteByExample(PageViewDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageViewDO record);

    int insertSelective(PageViewDO record);

    List<PageViewDO> selectByExample(PageViewDOExample example);

    PageViewDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageViewDO record, @Param("example") PageViewDOExample example);

    int updateByExample(@Param("record") PageViewDO record, @Param("example") PageViewDOExample example);

    int updateByPrimaryKeySelective(PageViewDO record);

    int updateByPrimaryKey(PageViewDO record);
}