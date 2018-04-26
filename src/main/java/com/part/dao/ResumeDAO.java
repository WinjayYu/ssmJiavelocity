package com.part.dao;

import com.part.dataobject.ResumeDO;
import com.part.dataobject.ResumeDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResumeDAO {
    long countByExample(ResumeDOExample example);

    int deleteByExample(ResumeDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResumeDO record);

    int insertSelective(ResumeDO record);

    List<ResumeDO> selectByExample(ResumeDOExample example);

    ResumeDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResumeDO record, @Param("example") ResumeDOExample example);

    int updateByExample(@Param("record") ResumeDO record, @Param("example") ResumeDOExample example);

    int updateByPrimaryKeySelective(ResumeDO record);

    int updateByPrimaryKey(ResumeDO record);
}