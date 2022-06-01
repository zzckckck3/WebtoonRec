$(document).ready(function(){
    var keyword = KeyWordCheck();
    gotoItem();
    categorySetting();
    SearchByKeyWord(keyword);
    SessionCheck();
    SearchSetting();
    KeySearchSetting();
    logoSetting();
    //mypageSetting();
})

function KeyWordCheck(){
    var baseurl=window.location;
    var locate=baseurl .protocol +"//"+baseurl .host+"/keysearch/"
    var str=baseurl.toString();
    var Keyword=str.substr(locate.length,str.length);
    Keyword=decodeURI(Keyword);
    $("#keyword-searchbar").find("input").attr("value",Keyword)
    return Keyword;
}

function SearchByKeyWord(keyword){
    getItembykeyword(keyword);
}

async function getItembykeyword(keyword){
    var url="/api/v2/webtoon-api/webtoon/allkeyword?keyword=" + keyword + "&limit=200";
    await fetch(url,{method:"get"}).then(response => response.json()).then(
        data => {
            var baseurl=window.location
            $.each(data, function (idx) {
                var innerhtml = '<li class="item" id='+data[idx].webtoonId +'><div id="item_img"><img src=' + data[idx].webtoonThumbnail + '></div>' +
                                '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data[idx].webtoonName+'</a></span></br>'+
                                '<span><a id="merchansub"></span></br></div></li>'
                                $("#webtoonlist").append(innerhtml);
            })
        }
    )
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

function KeySearchSetting(){
    $("#keyword-searchicon").on("click",function(){
        if($("#keyword-searchbar").find("input").val()){
            var url="/keysearch/"+$("#keyword-searchbar").find("input").val();
            window.location.assign(url);
        }else{
            location.reload();
        }

    })
}

async function SessionCheck(){
    var baseurl=window.location;
    const res1=await fetch("./api/v2/member-api/session",{method:"GET"}).then(response => response.text());
    if(res1.startsWith("{")){
        console.log("login plz");
    }
    else {
        console.log(res1);
        $("#login-navi-btn").text(res1 + "님 안녕하세요");
        $("#login-navi").attr("href","#")
        $("#join-navi-btn").text("로그아웃");
        $("#join-navi").attr("href","/user/logout");
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

