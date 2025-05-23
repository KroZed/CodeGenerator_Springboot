package com.prj.common;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import com.prj.persistence.entity.EntityBase;
import com.prj.util.HttpRequestUtil;
import com.prj.util.PagedData;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RestController
public abstract class AbstractApiController<T extends EntityBase> extends ApiControllerBase {
    @Autowired
    private TransactionUtil transactionUtil;
    protected abstract PersistenceServiceBase<T> getPersistenceService();
    protected abstract void setConditions(QueryWrapper<?> criteria, HttpServletRequest request);
    protected abstract void validate(T e);
    protected abstract void setFkObject(T e);
    protected abstract void setCustomConditions(QueryWrapper<?> criteria, HttpServletRequest request);
    protected abstract void setSuggestConditions(QueryWrapper<?> criteria, HttpServletRequest request);
    protected abstract void validateWhenAdd(T e);
    protected abstract void validateWhenUpdate(T e);
    protected abstract void beforeSetFk(T e);
    protected abstract void customGetLogic(T e);
    protected abstract void customListLogic(T e);
    protected abstract void customListLogic(List<?> list);
    protected abstract void setDefaultValueWhenAdd(T e);
    protected abstract void setDefaultValueWhenUpdate(T e);
    protected abstract void beforeAdd(T e);
    protected abstract void afterAdd(T e);
    protected abstract void beforeUpdate(T e);
    protected abstract void afterUpdate(T e);
    protected abstract void beforeDelete(T e);
    protected abstract void afterDelete(T e);
    protected abstract String getEntityTitle();
    protected void setSortingRule(QueryWrapper<T> criteria, HttpServletRequest request){
        setSortingRule(criteria, request, "orderBy");
    }
    protected void setSortingRule(QueryWrapper<T> criteria, HttpServletRequest request, String orderByKey){
        String orderBy = HttpRequestUtil.getParameter(request,"orderBy");
        if(orderBy!=null && orderBy.trim().length()>0){
            String[] parts = orderBy.split(",");
            for(int i=0;i<parts.length;i++){
                String fieldName = parts[i].trim();
                if(fieldName==null || fieldName.length()==0){ continue;}
                String[] subs = fieldName.split(" ");
                if(subs.length>1 && subs[1].trim().equalsIgnoreCase("desc")){
                    criteria = criteria.orderByDesc(subs[0]);
                } else {
                    criteria = criteria.orderByAsc(fieldName);
                }
            }
        }
    }
    @GetMapping("/{id}")
    public Object get(@ApiParam(value = "对象标识符", required = true, example = "1") @PathVariable(value = "id") long id) {
        T e = getPersistenceService().getById(id);
        beforeSetFk(e);
        setFkObject(e);
        customGetLogic(e);
        return RestApiResult.success(e);
    }
    @PostMapping(value = "")
    public Object add(@RequestBody T requestData) {
        requestData.setDeleted(false);
        transactionUtil.scope(()->{
            setDefaultValueWhenAdd(requestData);
            beforeAdd(requestData);
            validate(requestData);
            validateWhenAdd(requestData);
            getPersistenceService().save(requestData);
            afterAdd(requestData);
        });
        return RestApiResult.success(requestData);
    }
    @PutMapping(value = "")
    public Object update(@RequestBody T requestData) {
        transactionUtil.scope(()->{
            setDefaultValueWhenUpdate(requestData);
            beforeUpdate(requestData);
            validate(requestData);
            validateWhenUpdate(requestData);
            getPersistenceService().updateById(requestData);
            afterUpdate(requestData);
        });
        return RestApiResult.success(requestData);
    }
    @DeleteMapping(value = "/{id}")
    public Object delete(@ApiParam(value = "要删除数据的ID", required = true, example = "1") @PathVariable(value = "id") long id) {
        T e = getPersistenceService().getById(id);
        transactionUtil.scope(()-> {
            beforeDelete(e);
            e.setDeleted(Boolean.TRUE);
            getPersistenceService().updateById(e);
            afterDelete(e);
        });
        return RestApiResult.success(id);
    }
    @GetMapping("")
    public Object list(HttpServletRequest request) {
        int pageNo = HttpRequestUtil.getIntParameter(request, "pageNo", 1);
        int pageSize = HttpRequestUtil.getIntParameter(request, "pageSize", 10);
        QueryWrapper<T> criteria = new QueryWrapper<>();
        setConditions(criteria, request);
        setCustomConditions(criteria, request);
        setSortingRule(criteria, request);
        IPage<T> page = getPersistenceService().page(new Page<>(pageNo, pageSize),criteria);
        for(int i = 0; i < page.getRecords().size(); i++) {
            T e = page.getRecords().get(i);
            beforeSetFk(e);
            setFkObject(e);
            customListLogic(e);
        }
        customListLogic(page.getRecords());
        return RestApiResult.success(new PagedData(page));
    }
    @GetMapping("/suggest")
    public Object suggest(HttpServletRequest request) {
        QueryWrapper<T> criteria = new QueryWrapper<>();
        setConditions(criteria, request);
        setSuggestConditions(criteria, request);
        setSortingRule(criteria, request);
        List<T> list = getPersistenceService().list(criteria);
        return RestApiResult.success(list);
    }
    @RequestMapping(value = "/deleteItems")
     public Object deleteItems(HttpServletRequest request) {
        String idString = request.getParameter("ids");
        String[] ids = idString.split(",");
        if(ids.length>0) {
            for(String eid:ids){
                if(eid!=null && eid.trim().length()>0) {
                    T e = getPersistenceService().getById(eid);
                    transactionUtil.scope(()-> {
                        beforeDelete(e);
                        e.setDeleted(Boolean.TRUE);
                        getPersistenceService().updateById(e);
                        afterDelete(e);
                    });
                }
            }
        }
        return RestApiResult.success();
    }
}
