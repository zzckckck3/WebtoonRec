$(document).ready(function(){
    //SessionCheck();
    SearchSetting();
    KeySearchSetting();
    logoSetting();
    var keyword = KeyWordCheck();
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
    console.log(resimage);
    $("#webtoon-image").attr("src",resimage);
    $("#webtoon-name").text(res.webtoonName);
    $("#webtoon-platform").text(res.platform);
    $("#webtoon-author").text(res.webtoonAuthor);
    $("#webtoon-summary").text(res.webtoonSummary);
    $("#webtoon-genre").text(res.webtoonGenre);
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

