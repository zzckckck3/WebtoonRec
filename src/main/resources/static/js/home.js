$(document).ready(function(){
    getItem();
    gotoItem();
    categorySetting();
    //SessionCheck();
    SearchSetting();
    logoSetting();
    //mypageSetting();
})

function getItem(){
    Cleaning($("#webtoonlist"));
    for(var i = 0; i < 100; i++){
        fetch("/api/v1/webtoon-api/webtoon/"+i,{method:"GET"}).then((response) => response.json()).then((data) => {
                        var innerhtml = '<li class="item" id='+data.webtoonId +'><div id="item_img"><img src=' + data.webtoonThumbnail + '></div>' +
                                            '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data.webtoonName+'</a></span></br>'+
                                            '<span><a id="merchansub"></span></br></div></li>'
                            $("#webtoonlist").append(innerhtml);
        })
    }
    console.log()
}
function gotoItem(){
    $('#webtoonlist').on("click","li",function (){
        var id=$(this).attr('webtoonId');
        location.assign("./webtoon/"+webtoonId);
    })
}

function categorySetting(){
    $('#category_list').on("click","li",function(){

        if($(this).attr("id")=="default_category"&&$("#webtoonlist")!=null){
            getItem();
        }
        else if($(this).attr("id")!="default_category"){
            getTypedItem($(this).attr("id")); //li 의 id값 반환
        }

        var rep=document.getElementById("category_list");
        var categoryitems=rep.getElementsByTagName('li');
        for(var i=0; i<categoryitems.length; i++){
            categoryitems[i].style.color="black";
            categoryitems[i].style.backgroundColor="white";
            categoryitems[i].style.borderRadius="3px 3px";
        }
        $(this).css("color","white");
        $(this).css("background-color","black");
        $(this).css("border-radius","3px 3px");
    })
}
function Cleaning(bodytag){
    bodytag.empty();

}

function getTypedItem(dtype){
    Cleaning($("#webtoonlist"))
    /*if (dtype == 'kakaoPage'){
        for (var i=0;i<8600;i++){
            fetch("/api/v1/webtoon-api/webtoon/" + i,{method:"GET"}).then((response) => response.json()).then((data) => {
                //if (!data) { return; }
                if (data.platform == '카카오페이지'){
                    var innerhtml = '<li class="item" id='+data.webtoonId +'><div id="item_img"><img src=' + data.webtoonThumbnail + '></div>' +
                                    '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data.webtoonName+'</a></span></br>'+
                                    '<span><a id="merchansub"></span></br></div></li>'
                                    $("#webtoonlist").append(innerhtml);
                }
            })
        }
    }*/

    //url+="?offset=0&limit=30"
    /*fetch(url,{method:"GET"}).then((response) => response.json()).then(
        (data) => {
            $.each(data, function (idx) {[idx].imgSrc + '></div>' +
                        '<div id="item_text"><span><a id="merchansub">제목:</a> <a id="item_name">'+data[idx].name+'</a></span></br>'
                        +'<span><a id="merchansub"></span></br></div></li>'
                        $("#webtoonlist").append(innerhtml);
                var innerhtml = '<li class="item" id='+data[idx].item_ID +'><div id="item_img"><img src=' + data
            })
        }
    )*/
}

function logoSetting(){
    $("#logo").click(function(){
        var baseurl=window.location;
        window.location.assign(baseurl .protocol +"//"+baseurl .host);
    })
}

function SearchSetting(){
    $("#searchicon").on("click",function(){
        if($("#searchbar").find("input").val()){
            var url="/search/"+$("#searchbar").find("input").val();
            window.location.assign(url);
        }else{
            location.reload();
        }

    })
}


async function SessionCheck(){
    //shoplist 세팅 포함
    var baseurl=window.location;

    const res1=await fetch("/api/v1/members/session",{method:"GET"}).then(response => response.json());
    if(!res1.isauth){
        return false;
    }
    if(res1.iswhom !="[ROLE_ADMIN]"){
        $("#manager").remove();
    }
    if(res1.iswhom !="[ROLE_ANONYMOUS]"){
        $("#login-navi").text(res1.iswho + "님 안녕하세요");
        $("#login-navi").attr("href","#")
        $("#join-navi").text("로그아웃");
        $("#join-navi").attr("href","/logout");
        $("#scart").click(function (){
            window.location.assign(baseurl .protocol +"//"+baseurl .host+"/shopping-list");
        })
    }else{
        $("#scart").click(function (){
            alert("로그인이 필요한 서비스 입니다.")
        })
    }

}


function mypageSetting(){
    var baseurl=window.location;

    $("#comp_mypage").click(function (){
    if($("#login-navi").text()=="로그인"){
            alert("로그인이 필요한 서비스 입니다.")
    }else{
        var url=baseurl .protocol +"//"+baseurl .host+"/mypage"
        location.assign(url);
        }
    })

    $("#mypage").click(function (){
        if($("#login-navi").text()=="로그인"){
            alert("로그인이 필요한 서비스 입니다.")
        }else{
            var url=baseurl .protocol +"//"+baseurl .host+"/mypage"
            location.assign(url);
        }
    })
}

