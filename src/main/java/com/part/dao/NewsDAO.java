package com.part.dao;

import com.part.dataobject.NewsDO;
import com.part.dataobject.NewsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsDAO {
    long countByExample(NewsDOExample example);

    int deleteByExample(NewsDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewsDO record);

    int insertSelective(NewsDO record);

    List<NewsDO> selectByExample(NewsDOExample example);

    NewsDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewsDO record, @Param("example") NewsDOExample example);

    int updateByExample(@Param("record") NewsDO record, @Param("example") NewsDOExample example);

    int updateByPrimaryKeySelective(NewsDO record);

    int updateByPrimaryKey(NewsDO record);
}