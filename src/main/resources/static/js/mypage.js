$(document).ready(function(){
    getmypageWebtoon();
    SessionCheck();
    SearchSetting();
    KeySearchSetting();
    logoSetting();
    mypageSetting();
})

async function getmypageWebtoon(){
    const webtoonIdArray = [];
    const email = await fetch("/api/v2/member-api/session", {method:"GET"}).then(response => response.text());
    const check = await fetch("/api/v2/favWebtoon-api/allbyEmail?email="+email,{method:"get"})
        .then(response => response.json()).then((data) => {
            $.each(data, function (idx){
                webtoonIdArray.push(data[idx].webtoonId);
            })
        })
    for (var i = 0; i<webtoonIdArray.length; i++){
        const myWebtoon = await fetch("/api/v2/webtoon-api/webtoon/single/"+String(webtoonIdArray[i]), {method: "GET"}).then(response => response.json()).then((data)=>{
            var innerhtml = '<div class="mypage-inner-container" id="mypage-inner-container">' +
                                '<img src='+data.webtoonThumbnail+' id="mypage-item-img">'+
                                '<div class="vertical-hr"></div>' +
                                '<div class="mypage-item-sources">' +
                                '<div id="mypage-item-name">' + data.webtoonName + '</div>' +
                                '<br>' +
                                '<div id="mypage-item-author">' + data.webtoonAuthor + '</div>' +
                                '<br>' +
                                '<div id="mypage-item-platform">' + data.platform + '</div>' +
                                '</div>' +
                                '<div class="vertical-hr"></div>' +
                                '<div class="mypage-item-summary-outer">' +
                                '<div id="mypage-item-summary">' + data.webtoonSummary + '</div>' +
                                '</div>' +
                                '<div class="vertical-hr"></div>' +
                                '<button onclick="delItem(this)" class="btn-delete" id=' + data.webtoonId + '>삭제</button>' +
                                '</div>'
                            $("#mypage_container").append(innerhtml);
        })
    }
}

function delItemSetting(){
    delItem();
}

async function delItem(e){
    const email = await fetch("/api/v2/member-api/session", {method:"GET"}).then(response => response.text());
    var delId = $(e).attr("id");
    if(confirm("삭제 하시겠습니까?") == true){
        fetch("/api/v2/favWebtoon-api/delfav?memberEmail=" + email + "&webtoonId=" + delId, {method:"delete"});
        location.reload(true);
    } else {
        console.log("cancel");
    }


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
    const res1=await fetch("/api/v2/member-api/session",{method:"GET"}).then(response => response.text());
    if(res1.startsWith("{")){
        console.log("login plz");
    }
    else {
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