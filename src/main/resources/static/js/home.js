var itemOffset = 1;
var itemLimit = 100;
var selectedPlatform = "";
$(document).ready(function(){
    getRecommendItem();
    getItem();
    gotoItem();
    gotoItem2();
    categorySetting();
    SessionCheck();
    SearchSetting();
    KeySearchSetting();
    logoSetting();
    mypageSetting();

})

function previousPage(){
    if(itemOffset > 100){
        itemOffset = itemOffset - 100;
    }
    if(selectedPlatform == "default_category"){
        getItem();
    }
    else if(selectedPlatform == "naverWebtoon"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "kakaoWebtoon"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "kakaoPage"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "lezhinComics"){
        getTypedItem(selectedPlatform);
    }

}

function nextPage(){
    if(itemOffset < 8500){
        itemOffset = itemOffset + 100;
    }
    if(selectedPlatform == "default_category"){
        getItem();
    }
    else if(selectedPlatform == "naverWebtoon"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "kakaoWebtoon"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "kakaoPage"){
        getTypedItem(selectedPlatform);
    }
    else if(selectedPlatform == "lezhinComics"){
        getTypedItem(selectedPlatform);
    }
}

async function getRecommendItem(){
    const webtoonIdArray = [];
    const email = await fetch("/api/v2/member-api/session", {method:"GET"}).then(response => response.text());
    if(email.startsWith("{")){
        for (var i = 0; i<5; i++){
            var randomselect = Math.floor(Math.random() * 8000)
            await fetch("/api/v2/webtoon-api/webtoon/single/" + randomselect, {method:"GET"})
                .then(response => response.json()).then((data) => {
                    var innerhtml = '<li class="recommenditem" id='+data.webtoonId +'><div id="recommenditem_img"><img src=' + data.webtoonThumbnail + '></div>' +
                                    '<div id="recommenditem_text"><a id="item_name">'+ data.webtoonName+'</a></span></br>'
                                    $("#recommendlist").append(innerhtml);
                })
        }
        return;
    }
    const check = await fetch("/api/v2/favWebtoon-api/allbyEmail?email="+email,{method:"get"})
        .then(response => response.json()).then((data) => {
            if(data == null){return;}
            $.each(data, function (idx){
                webtoonIdArray.push(data[idx].webtoonId);
            })
        })
    if(check == null){
        for (var i = 0; i<5; i++){
            var randomselect = Math.floor(Math.random() * 8000)
            await fetch("/api/v2/webtoon-api/webtoon/single/" + randomselect, {method:"GET"})
                .then(response => response.json()).then((data) => {
                    var innerhtml = '<li class="recommenditem" id='+data.webtoonId +'><div id="recommenditem_img"><img src=' + data.webtoonThumbnail + '></div>' +
                                    '<div id="recommenditem_text"><a id="item_name">'+ data.webtoonName+'</a></span></br>'
                                    $("#recommendlist").append(innerhtml);
                })
        }
        return;
    }
    const recWebtoonArr = [];
    for (var i = 0; i<webtoonIdArray.length; i++){
        await fetch("/api/v2/webtoon-api/webtoon/single/" + webtoonIdArray[i], {method:"GET"})
            .then(response => response.json()).then((data) => {
                    recWebtoonArr.push(data.webtoonKeyword);
                })
    }

    for(var k = 0; k < recWebtoonArr.length; k++){
        recWebtoonArr[k] = recWebtoonArr[k].replace("[", "");
        recWebtoonArr[k] = recWebtoonArr[k].replace("]", "");
        recWebtoonArr[k] = recWebtoonArr[k].replace(/\'/g, "");
        recWebtoonArr[k] = recWebtoonArr[k].replace(/\ /g, "");
        recWebtoonArr[k] = recWebtoonArr[k].split(',');
    }
    var recKeywordAll = recWebtoonArr.join();
    recKeywordAll = recKeywordAll.split(',');
    recKeywordSelect1 = recKeywordAll[Math.floor(Math.random() * recKeywordAll.length)];
    recKeywordSelect2 = recKeywordAll[Math.floor(Math.random() * recKeywordAll.length)];

    var url1="/api/v2/webtoon-api/webtoon/allkeyword?keyword=" + recKeywordSelect1 + "&limit=20";
    var url2="/api/v2/webtoon-api/webtoon/allkeyword?keyword=" + recKeywordSelect2 + "&limit=20";
    var url = "";
    var randomselect = Math.floor(Math.random() * 2 + 1)
    if(randomselect == 1){ url = url1; }
    else if(randomselect == 2){ url = url2; }
    fetch(url,{method:"get"}).then(response => response.json()).then(
        data => {
            $.each(data, function(idx){
                if(idx > 4){
                    return;
                }
                var innerhtml = '<li class="recommenditem" id='+data[idx].webtoonId +'><div id="recommenditem_img"><img src=' + data[idx].webtoonThumbnail + '></div>' +
                                '<div id="recommenditem_text"><a id="item_name">'+ data[idx].webtoonName+'</a></span></br>'
                                $("#recommendlist").append(innerhtml);
            })
        })
}

function getItem(){
    Cleaning($("#webtoonlist"));    //offset은 1부터 시작
    fetch("./api/v2/webtoon-api/webtoon/all?offset="+itemOffset+"&limit="+itemLimit,{method:"GET"}).then((response) => response.json()).then((data) => {
        $.each(data, function (idx) {
                    var innerhtml = '<li class="item" id='+data[idx].webtoonId +'><div id="item_img"><img src=' + data[idx].webtoonThumbnail + '></div>' +
                                        '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data[idx].webtoonName+'</a></span></br>'+
                                        '<span><a id="merchansub"></span></br></div></li>'
                        $("#webtoonlist").append(innerhtml);
        })
        var divmargin = '<li class="item_margin"><div"> </div></li>';
        $("#webtoonlist").append(divmargin);
    })
}

function gotoItem(){
    $('#webtoonlist').on("click","li",function (){
        var webtoonId = $(this).attr('id');
        location.assign("/webtoon/"+webtoonId);
    })
}
function gotoItem2(){
    $('#recommendlist').on("click","li",function (){
        var webtoonId = $(this).attr('id');
        location.assign("/webtoon/"+webtoonId);
    })
}

function categorySetting(){
    $('#category_list').on("click","li",function(){

        if($(this).attr("id")=="default_category"&&$("#webtoonlist")!=null){
            selectedPlatform = $(this).attr("id");
            itemOffset = 1;
            itemLimit = 100;
            getItem();
        }
        else if($(this).attr("id")!="default_category"){
            itemOffset = 1;
            itemLimit = 100;
            selectedPlatform = $(this).attr("id");
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
    var thisPlatform = "";
    if (dtype == "naverWebtoon"){
        thisPlatform = "네이버 웹툰"
    }
    else if(dtype == "kakaoWebtoon"){
        thisPlatform = "카카오웹툰"
    }
    else if(dtype == "kakaoPage"){
        thisPlatform = "카카오페이지"
    }
    else if(dtype == "lezhinComics"){
        thisPlatform = "레진코믹스"
    }

    var url="/api/v2/webtoon-api/webtoon/allplatform?limit="+itemLimit+"&offset="+itemOffset+"&platform="+thisPlatform;
    fetch(url,{method:"GET"}).then((response) => response.json()).then((data) =>{
        $.each(data, function (idx) {
                        var innerhtml = '<li class="item" id='+data[idx].webtoonId +'><div id="item_img"><img src=' + data[idx].webtoonThumbnail + '></div>' +
                                        '<div id="item_text"><span><a id="merchansub"></a> <a id="item_name">'+ data[idx].webtoonName+'</a></span></br>'+
                                        '<span><a id="merchansub"></span></br></div></li>'
                                        $("#webtoonlist").append(innerhtml);
                        })
                        var divmargin = '<li class="item_margin"><div"> </div></li>';
                        $("#webtoonlist").append(divmargin);
    })
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

