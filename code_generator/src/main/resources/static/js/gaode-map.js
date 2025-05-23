function createInfoWindow(SimpleInfoWindow, title, content){
    return new SimpleInfoWindow({
        infoTitle: '<strong>'+title+'</strong>',
        infoBody: '<p class="my-desc">'+content+'</p>',
        //基点指向marker的头部位置
        offset: new AMap.Pixel(0, -31)
    });
}

function showInfoWindow(SimpleInfoWindow, map, point, title, content) {
    var infoWin = createInfoWindow(SimpleInfoWindow, title,content);
    infoWin.open(map, [point.lng, point.lat]);
}

function createMarker(SimpleMarker, map, icon, lat, lng, clickCallback, containerClassName){
    if(containerClassName==null || containerClassName==undefined) containerClassName="normal";
    var marker = new SimpleMarker({
        containerClassNames:containerClassName,
        //iconLabel: '图标的标签',
        //自定义图标节点(img)的属性
        iconStyle: {
            src: icon,
            style: {
                width: '30px',
                height: '30px'
            }
        },

        //设置基点偏移
        offset: new AMap.Pixel(-10, -30),
        map: map,
        showPositionPoint: true,
        position: [lng, lat],
        zIndex: 200
    });
    if(clickCallback && clickCallback != null && clickCallback != undefined) {
        AMap.event.addListener(marker, 'click', clickCallback);
    }
    return marker;
}

function drawLine(map, points) {
    var arr = [];
    for(i = 0; i < points.length; i++) {
        var point = points[i];
        arr.push([point.lng, point.lat]);
    }
    var polyline = new AMap.Polyline({
        path: arr,          //设置线覆盖物路径
        strokeColor: "#3366FF", //线颜色
        strokeOpacity: 1,       //线透明度
        strokeWeight: 5,        //线宽
        strokeStyle: "solid",   //线样式
        strokeDasharray: [10, 5] //补充线样式
    });
    polyline.setMap(map);
}

function markerMove(marker, point, speed) {
    if(marker==null || marker==undefined) return;
    if(speed==null || speed==undefined) speed=100;
    marker.moveTo(new AMap.LngLat(point.lng, point.lat), speed);
}

function getMapGeoPoint(address, callback){
    console.log("读取经纬度！" + address);
    var geocoder = new AMap.Geocoder({
        //city: "010", //城市，默认：“全国”
        radius: 1000 //范围，默认：500
    });
    //地理编码,返回地理编码结果
    geocoder.getLocation(me.modelData.address, function(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            var geocodes = result.geocodes;
            if(geocodes!=null && geocodes!=undefined && geocodes.length>0) {
                var geo = geocodes[0];
                callback(geo.location.getLng(), geo.location.getLat());
                // me.modelData.lng=geo.location.getLng();
                // me.modelData.lat=geo.location.getLat();
                // me.modelData.mapLng=geo.location.getLng();
                // me.modelData.mapLat=geo.location.getLat();
            }
            //geocoder_CallBack(result);
        }
    });     
}

//项目相关==================
function showMap(centerPoint, createMarkerCallback) {
    map = new AMap.Map('container', mapOptions);
    map.addControl(new AMap.Scale({ visible: true}));
    map.addControl(new AMap.ToolBar({ visible: true }));
    map.addControl(new AMap.OverView({ visible: true }));

    AMapUI.loadUI(['overlay/SimpleMarker', 'overlay/SimpleInfoWindow'], createMarkerCallback);
}

function createFireOfficeMarker(SimpleMarker, SimpleInfoWindow, map, orgUnit) {
    return createMarker(SimpleMarker, map, 'images/fire_office.png', orgUnit.lat, orgUnit.lng, function(){
        showInfoWindow(SimpleInfoWindow, map, this.getPosition(), orgUnit.name, "电话："+orgUnit.tel+"<br />地址："+orgUnit.address);
    });
}
function createHydrantMarker(SimpleMarker, SimpleInfoWindow, map, hydrant){
    var cssClass = "normal";
    var icon = "images/icon_fire_hydrant_normal.png";
    if(hydrant.status!='正常') {
        icon = "images/icon_fire_hydrant_abnormal.png"
        cssClass = "abnormalHydrant";
    }
    var marker = createMarker(SimpleMarker, map, icon, hydrant.lat, hydrant.lng, function(){
        showInfoWindow(SimpleInfoWindow, map, this.getPosition(), "编号："+hydrant.no, 
            "当前状态：" + hydrant.status + 
            "<br />厂家：" + hydrant.provider +
            "<br />型号：" + hydrant.model +
            "<br />口径：" + hydrant.caliber +
            "<br />地址：" + hydrant.address);
    }, cssClass);
    marker.isShow = false;
    // if(hydrant.status!='正常') {
        
    // }    
    return marker;
}
function createAlarmMarker(SimpleMarker, SimpleInfoWindow, map, alarm){
    return createMarker(SimpleMarker, map, 'images/icon_fire.png', alarm.lat, alarm.lng, function(){
        showInfoWindow(SimpleInfoWindow, map, this.getPosition(), 
        "【" + alarm.type + "】编号：" + alarm.no, 
        "地址：" + alarm.address + "<br />描述：" + alarm.intro);
    });
}


function flashMarker(marker) {
    //console.log($(".abnormalHydrant").hasClass("hide"));
    if($(".abnormalHydrant").hasClass("hide")){
        $(".abnormalHydrant").removeClass("hide");
        $(".abnormalHydrant").show();
    }else{
        $(".abnormalHydrant").addClass("hide");
        $(".abnormalHydrant").hide();
    }
}
