

/*
async function join(){
    var baseurl=window.location;
    url=baseurl .protocol +"//"+baseurl .host+"/user/signup-proc";
    let obj={
        "email":$("email").val(),
        "password":$("password").val()
    }

    await fetch(url,{method:"post",headers:{'Content-Type': 'application/json'},body:JSON.stringify(obj)}).then(response => {
        if(response.status==200){
            alert("회원가입이 완료되었습니다.");
            location.assign("/");
        } else {
            alert("오류가 발생하였습니다. 잠시 후에 다시 시도해주세요");
        }
    })
}
*/

async function join(){
    alert("회원가입이 완료되었습니다.");
    location.assign("/");
}