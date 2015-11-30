package org.okou.lippen.dao.annotation.generic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.okou.lippen.dao.annotation.IGenericMapper;
import org.okou.lippen.dao.annotation.mybatis.LippenParam;
import org.okou.lippen.dao.annotation.mybatis.provider.LippenGenericSqlProvider;

public interface GenericMapper extends IGenericMapper
{
	@SelectProvider(type=LippenGenericSqlProvider.class, method="findAll")
	public <T> List<Map<String, Object>> find(LippenParam<T> query);
	@SelectProvider(type=LippenGenericSqlProvider.class, method="get")
	public <T> Map<String, Object> get(T query);
	@InsertProvider(type=LippenGenericSqlProvider.class, method="save")
	@Options(useGeneratedKeys=true)
	public <T> void save(T po);
	@UpdateProvider(type=LippenGenericSqlProvider.class, method="update")
	public <T> int update(T po);
	@UpdateProvider(type=LippenGenericSqlProvider.class, method="delete")
	public <T> int delete(T po);
	
}