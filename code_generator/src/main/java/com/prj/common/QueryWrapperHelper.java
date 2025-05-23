package com.prj.common;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prj.common.CriteriaOperatorEnum;
import com.prj.util.HttpRequestUtil;
import javax.servlet.http.HttpServletRequest;
public class QueryWrapperHelper {
    @SuppressWarnings("UnusedAssignment")
    public static void setCondition(QueryWrapper<?> criteria, HttpServletRequest request, String fieldName, String key, CriteriaOperatorEnum op) {
        String value = HttpRequestUtil.getParameter(request, key);
        if(null==value){
            return;
        }
        switch (op) {
            case Less:
                criteria = criteria.lt(fieldName, value);
                break;
            case Equals:
                criteria = criteria.eq(fieldName, value);
                break;
            case Greater:
                criteria = criteria.gt(fieldName, value);
                break;
            case NotEquals:
                criteria = criteria.ne(fieldName, value);
                break;
            case LessOrEqual:
                criteria = criteria.le(fieldName, value);
                break;
            case GreaterOrEquals:
                criteria = criteria.ge(fieldName, value);
                break;
            case Like:
                criteria = criteria.like(fieldName, value);
                break;
            default:
        }
    }
}
