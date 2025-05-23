package com.prj.common;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
public abstract class PersistenceServiceBaseImpl<TMapper extends BaseMapper<TEntity>,TEntity> extends ServiceImpl<TMapper,TEntity> implements PersistenceServiceBase<TEntity> {
}
