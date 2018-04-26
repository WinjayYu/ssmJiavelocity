package com.part.dao;

import com.part.dataobject.ContactUsDO;
import com.part.dataobject.ContactUsDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContactDAO {
    long countByExample(ContactUsDOExample example);

    int deleteByExample(ContactUsDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContactUsDO record);

    int insertSelective(ContactUsDO record);

    List<ContactUsDO> selectByExampleWithBLOBs(ContactUsDOExample example);

    List<ContactUsDO> selectByExample(ContactUsDOExample example);

    ContactUsDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContactUsDO record, @Param("example") ContactUsDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ContactUsDO record, @Param("example") ContactUsDOExample example);

    int updateByExample(@Param("record") ContactUsDO record, @Param("example") ContactUsDOExample example);

    int updateByPrimaryKeySelective(ContactUsDO record);

    int updateByPrimaryKeyWithBLOBs(ContactUsDO record);

    int updateByPrimaryKey(ContactUsDO record);
}