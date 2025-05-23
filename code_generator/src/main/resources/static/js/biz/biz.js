

common.syserr = console.error;
common.getCurrentUser = function(b, f){
    common.currentUser(f, b);
};
let Project = {};
(function () {
    Project.getSuggestDataList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "project/suggest"
                , type: "GET"
                , data: criteria
                , cb: function (r) { 
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Project.getSuggestDataList",e);
        }
    },
    Project.getList = function (criteria, successCallback) {
        try {
            if(!criteria.pageNo){criteria.pageNo = 1;}
            if(!criteria.pageSize){ criteria.pageSize = 999999; }
            common.callApi({
                url: HOST + API_PREFIX + "project"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r.data);}
            });
        }catch (e) {
            common.syserr("Project.getList",e);
        }
    },
    Project.getPagedList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "project"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("Project.getPagedList",e);
        }
    },
    Project.getById = function (id, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "project/" + id
                , type: "GET"
                , cb: function (r) {
                
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Project.getById",e);
        }
    },
    Project.add = function (e, successCallback) {
        try {
    
                            e.owner=null;
            e.template=null;
            common.callApi({
                url: HOST + API_PREFIX + "project"
                , data: JSON.stringify(e)
                , type: "POST"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Project.add",e);
        }
    },
    Project.update = function (e, successCallback) {
        try {
            //处理外键
            //处理日期时间
    
                            e.owner=null;
            e.template=null;
             common.callApi({
                url: HOST + API_PREFIX + "project"
                , data: JSON.stringify(e)
                , type: "PUT"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Project.update",e);
        }
    },
    Project.delete = function (e, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "project/"+e.id
                , type: "DELETE"
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("Project.delete",e);
        }
    },
    Project.save = function (e, successCallback) {
        if(e.id){ Project.update(e, successCallback); } else { Project.add(e, successCallback); }
    }
}());


common.syserr = console.error;
common.getCurrentUser = function(b, f){
    common.currentUser(f, b);
};
let User = {};
(function () {
    User.getSuggestDataList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "user/suggest"
                , type: "GET"
                , data: criteria
                , cb: function (r) { 
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("User.getSuggestDataList",e);
        }
    },
    User.getList = function (criteria, successCallback) {
        try {
            if(!criteria.pageNo){criteria.pageNo = 1;}
            if(!criteria.pageSize){ criteria.pageSize = 999999; }
            common.callApi({
                url: HOST + API_PREFIX + "user"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r.data);}
            });
        }catch (e) {
            common.syserr("User.getList",e);
        }
    },
    User.getPagedList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "user"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("User.getPagedList",e);
        }
    },
    User.getById = function (id, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "user/" + id
                , type: "GET"
                , cb: function (r) {
                
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("User.getById",e);
        }
    },
    User.add = function (e, successCallback) {
        try {
    
                            common.callApi({
                url: HOST + API_PREFIX + "user"
                , data: JSON.stringify(e)
                , type: "POST"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("User.add",e);
        }
    },
    User.update = function (e, successCallback) {
        try {
            //处理外键
            //处理日期时间
    
                             common.callApi({
                url: HOST + API_PREFIX + "user"
                , data: JSON.stringify(e)
                , type: "PUT"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("User.update",e);
        }
    },
    User.delete = function (e, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "user/"+e.id
                , type: "DELETE"
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("User.delete",e);
        }
    },
    User.save = function (e, successCallback) {
        if(e.id){ User.update(e, successCallback); } else { User.add(e, successCallback); }
    }
}());


common.syserr = console.error;
common.getCurrentUser = function(b, f){
    common.currentUser(f, b);
};
let Template = {};
(function () {
    Template.getSuggestDataList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "template/suggest"
                , type: "GET"
                , data: criteria
                , cb: function (r) { 
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Template.getSuggestDataList",e);
        }
    },
    Template.getList = function (criteria, successCallback) {
        try {
            if(!criteria.pageNo){criteria.pageNo = 1;}
            if(!criteria.pageSize){ criteria.pageSize = 999999; }
            common.callApi({
                url: HOST + API_PREFIX + "template"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r.data);}
            });
        }catch (e) {
            common.syserr("Template.getList",e);
        }
    },
    Template.getPagedList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "template"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("Template.getPagedList",e);
        }
    },
    Template.getById = function (id, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "template/" + id
                , type: "GET"
                , cb: function (r) {
                
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Template.getById",e);
        }
    },
    Template.add = function (e, successCallback) {
        try {
    
                            common.callApi({
                url: HOST + API_PREFIX + "template"
                , data: JSON.stringify(e)
                , type: "POST"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Template.add",e);
        }
    },
    Template.update = function (e, successCallback) {
        try {
            //处理外键
            //处理日期时间
    
                             common.callApi({
                url: HOST + API_PREFIX + "template"
                , data: JSON.stringify(e)
                , type: "PUT"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("Template.update",e);
        }
    },
    Template.delete = function (e, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "template/"+e.id
                , type: "DELETE"
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("Template.delete",e);
        }
    },
    Template.save = function (e, successCallback) {
        if(e.id){ Template.update(e, successCallback); } else { Template.add(e, successCallback); }
    }
}());


common.syserr = console.error;
common.getCurrentUser = function(b, f){
    common.currentUser(f, b);
};
let TemplateFile = {};
(function () {
    TemplateFile.getSuggestDataList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "templateFile/suggest"
                , type: "GET"
                , data: criteria
                , cb: function (r) { 
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("TemplateFile.getSuggestDataList",e);
        }
    },
    TemplateFile.getList = function (criteria, successCallback) {
        try {
            if(!criteria.pageNo){criteria.pageNo = 1;}
            if(!criteria.pageSize){ criteria.pageSize = 999999; }
            common.callApi({
                url: HOST + API_PREFIX + "templateFile"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r.data);}
            });
        }catch (e) {
            common.syserr("TemplateFile.getList",e);
        }
    },
    TemplateFile.getPagedList = function (criteria, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "templateFile"
                , type: "GET"
                , data: criteria
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("TemplateFile.getPagedList",e);
        }
    },
    TemplateFile.getById = function (id, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "templateFile/" + id
                , type: "GET"
                , cb: function (r) {
                
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("TemplateFile.getById",e);
        }
    },
    TemplateFile.add = function (e, successCallback) {
        try {
    
                            e.template=null;
            common.callApi({
                url: HOST + API_PREFIX + "templateFile"
                , data: JSON.stringify(e)
                , type: "POST"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("TemplateFile.add",e);
        }
    },
    TemplateFile.update = function (e, successCallback) {
        try {
            //处理外键
            //处理日期时间
    
                            e.template=null;
             common.callApi({
                url: HOST + API_PREFIX + "templateFile"
                , data: JSON.stringify(e)
                , type: "PUT"
                , cb: function (r) {
                    successCallback(r);
                }
            });
        }catch (e) {
            common.syserr("TemplateFile.update",e);
        }
    },
    TemplateFile.delete = function (e, successCallback) {
        try {
            common.callApi({
                url: HOST + API_PREFIX + "templateFile/"+e.id
                , type: "DELETE"
                , cb: function (r) { successCallback(r);}
            });
        }catch (e) {
            common.syserr("TemplateFile.delete",e);
        }
    },
    TemplateFile.save = function (e, successCallback) {
        if(e.id){ TemplateFile.update(e, successCallback); } else { TemplateFile.add(e, successCallback); }
    }
}());

