var thisKeyword = [];

$(document).ready(function(){
    SessionCheck();
    SearchSetting();
    gotoItem();
    KeySearchSetting();
    logoSetting();
    var keyword = KeyWordCheck();
    SearchByKeyWord(keyword);
    getWebtoon(keyword);
    //mypageSetting();
})

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

function KeyWordCheck(){
    var baseurl=window.location;
    var locate=baseurl .protocol +"//"+baseurl .host+"/webtoon/"
    var str=baseurl.toString();
    var Keyword=str.substr(locate.length,str.length);
    return Keyword;
}

async function getWebtoon(keyword){
    var url="/api/v2/webtoon-api/webtoon/single/"+keyword;
    const res=await fetch(url, {method: "get"}).then(response => response.json());
    var resimage = res.webtoonThumbnail;
    $("#webtoon-image").attr("src",resimage);
    $("#webtoon-name").text(res.webtoonName);
    $("#webtoon-platform").text(res.platform);
    $("#webtoon-author").text(res.webtoonAuthor);
    $("#webtoon-summary").text(res.webtoonSummary);
    $("#webtoon-genre").text(res.webtoonGenre);
}

function SearchByKeyWord(keyword){
    getItembykeyword(keyword);
}

async function getItembykeyword(keyword){
    var thisurl="/api/v2/webtoon-api/webtoon/single/"+keyword;
    const res=await fetch(thisurl, {method: "get"}).then(response => response.json());
    keyres = res.webtoonKeyword;
    keyres = keyres.replace("[", "");
    keyres = keyres.replace("]", "");
    keyres = keyres.replace(/\'/g, "");
    keyres = keyres.replace(/\ /g, "");
    keyres = keyres.split(',');
    console.log(keyres.length);
    for (var i = 0; i < keyres.length; i++){
        var url="/api/v2/webtoon-api/webtoon/allkeyword?keyword=" + keyres[i] + "&limit=200";
                await fetch(url,{method:"get"}).then(response => response.json()).then(
                    data => {
                        $.each(data, function (idx) {
                            var innerhtml = '<li class="item" id='+data[idx].webtoonId +'><div id="item_img"><img src=' + data[idx].webtoonThumbnail + '></div>' +
                                            '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data[idx].webtoonName+'</a></span></br>'+
                                            '<span><a id="merchansub"></span></br></div></li>'
                                            $("#webtoonlist").append(innerhtml);
                        })
                    }
                )
    }
}

function gotoItem(){
    $('#webtoonlist').on("click","li",function (){
        var webtoonId = $(this).attr('id');
        location.assign("/webtoon/"+webtoonId);
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

function addItem(keyword){

}