console.info("Reply Module....");

var replyService = (function(){

    function add(reply, callback, error){
        console.log("add reply.....");

        $.ajax({
           type:'post',
           url: '/replies/new',
           data: JSON.stringify(reply),
           contentType: "application/json; charset=UTF-8",
           success: function(result, status, xhr){
               if(callback){
                   callback(result);
               }
           } ,
            error: function(xhr, status, er){
               if(error){
                   error(er);
               }
            }
        })
    }

    function getList(param, callback, error){
        var bno = param.bno;

        var page = param.page || 1;

        $.getJSON("/replies/pages/" + bno + "/" + page ,
            function(data){
                if(callback){
                    callback(data);
                }
            }).fail(function(xhr, status, err){
                if(error){
                    error();
                }
        });
    }

    return {
        add:add,
        getList:getList
    };
})();