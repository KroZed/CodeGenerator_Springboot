common.env = {currentUser:null, channels: []}
common.getEnv = function (env, app, callback){
    common.currentUser(function (r){
        env.currentUser=r;
        Channel.getList({}, function (r){
            env.channels = r;
            for(let i = 0; i < env.channels.length; i++){
                env.channels[i].pic = "/img/ad-" + (i+1) + ".jpg";
            }
            if(callback){
                callback();
            }

        });
    }, false);
};