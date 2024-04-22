console.log("Reply Module..")

var replyService = (function(){

    function add(reply,callback){
    console.log("reply...")

    $.ajax({
        type: "post",
        url: "/reply/new",
        data: JSON.stringify(reply),
        contentType: "application/json; charset=utf-8",

        success: function(result, status, xhr){
            if(callback){
                callback(result)
            }
        },
        error: function(xhr, status, er){
            if(error){
                error(er)
            }
        }
    })
    };

    function getList(param, callback, error){
        var bno = param.bno;

        var page = param.page || 1

        $.ajax({
            type: "get",
            url: "/reply/pages/" + bno + "/" + page,
            success: function(list,status,xhr){
                if(callback){
                    callback(list)
                }

            },
            error: function(xhr, status, err){
                if(error){
                    error();
                }
            }
        })
    }  //end getList

    function remove(rno, callback, error){
        $.ajax({
            type:"delete",
            url:"/reply/" + rno,
            success: function(msg, status, xhr){
                if(callback){
                    callback(msg)
                }
            },
            error: function(xhr, status, er){
                if(error){
                    error(er)
                }
            }
        })
    } //end remove
    function update(reply, callback, error){

        console.log("update RNO : " + reply.rno)
        $.ajax({
            type: "put",
            url: "/reply/" + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result)
                }
            },
            error: function(xhr,status,er){
                if(error){
                    error(er)
                }
            }
        })
      } // END update

    function get(rno, callback, error){
        console.log("get....")

        $.ajax({
            type: "get",
            url: "/reply/" + rno,

            success: function(data, status, xhr){
                if(callback){
                    callback(data)
                }
            },
            error: function(status, xhr,err){
            if(error){
                error(err)
            }

        }

        })

    }//end get

    function addd(reply, callback){
        $.ajax({
            type: "post",
            url: "/new",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            
            success: function(result, status, xhr){
                if(callback){
                    callback(result)
                }
            },

            error: function(xhr, status, er){
                if(error){
                    error(er)
                }
            }
        })
    }
    function deletee(rno, callback){
        $.ajax({
            type:"delete",
            url:"/reply/" + rno,
            data: "application/json; charset=utf-8"
        })
    }

    return{
        add: add,
        getList: getList,
        remove: remove,
        update: update,
        get: get
    };
})();