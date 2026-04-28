
const username = document.getElementById("username");
const name = document.getElementById("name");
const password = document.getElementById("password");
const passwordCheck = document.getElementById("passwordCheck");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");

const usernameError = document.getElementById("usernameError");
const nameError = document.getElementById("nameError");
const passwordError = document.getElementById("passwordError");
const passwordCheckError = document.getElementById("passwordCheckError");
const phoneError = document.getElementById("phoneError");
const emailError = document.getElementById("emailError");
const birthError = document.getElementById("birthError");

const isValid = true;

username.addEventListener("blur", function(){
    if(username.value.trim() != ""){
    } else {
        username.style.borderColor = "red";
        usernameError.innerText="ID를 입력해 주세요"
        usernameError.style.color = "red";
        usernameError.style.fontSize = "12px";
        isValid=false;
    }
    console.log("start")
    fetch(`./idCheck?username=${username.value}`)
    .then(res=> res.text())
    .then(res=>{
        if (res.trim()==='1'){
            console.log("중복 아님")
            username.style.borderColor = "blue";
            usernameError.innerText="사용 가능한 ID입니다."
            usernameError.style.color = "blue";
            usernameError.style.fontSize = "12px";
        } else {
            console.log("중복")
            username.style.borderColor = "red";
            usernameError.innerText="중복된 ID입니다."
            usernameError.style.color = "red";
            usernameError.style.fontSize = "12px";
        }
    })
    console.log("finish")
})


name.addEventListener("blur", function(){
    if(name.value != ""){
        name.style.borderColor = "blue";
        nameError.innerText=""
        nameError.style.fontSize = "12px";
    } else {
        name.style.borderColor = "red";
        nameError.innerText="이름을 입력해 주세요"
        nameError.style.color = "red";
        nameError.style.fontSize = "12px";
        isValid=false;
    }
})

password.addEventListener("input", function(){
    if(password.value === ""){
        password.style.borderColor = "red";
        passwordError.innerText="비밀번호을 입력해 주세요"
        password.style.Color = "red";
        passwordError.style.fontSize = "12px";
        isValid=false;
    } else if(password.value.length>7){
        password.style.borderColor = "blue";
        passwordError.innerText=""
        passwordError.style.fontSize = "12px";
    } else {
        password.style.borderColor = "red";
        passwordError.innerText="비밀번호을 확인해 주세요"
        password.style.Color = "red";
        passwordError.style.fontSize = "12px";
        isValid=false;
    }
})

passwordCheck.addEventListener("input", function(){
    if(passwordCheck.value === ""){
        passwordCheck.style.borderColor = "red";
        passwordCheckError.innerText="비밀번호을 입력해 주세요"
        passwordCheckError.style.Color = "red";
        passwordCheckError.style.fontSize = "12px";
        isValid=false;
    } else if(passwordCheck.value.length>7){
        if(password.value === passwordCheck.value){
            passwordCheck.style.borderColor = "blue";
            passwordCheckError.innerText="입력하신 비밀번호와 동일합니다."
            passwordCheckError.style.Color = "blue";
            passwordCheckError.style.fontSize = "12px";
        } else {
            passwordCheckError.style.borderColor = "red";
            passwordCheckError.innerText="입력하신 비밀번호와 다릅니다.."
            passwordCheckError.style.Color = "red";
            passwordCheckError.style.fontSize = "12px";
            isValid=false;
        }
    } else {
        passwordCheck.style.borderColor = "red";
        passwordCheckError.innerText="비밀번호을 확인해 주세요"
        passwordCheckError.style.fontSize = "12px";
        isValid=false;
    }
})

phone.addEventListener("blur", function(){
    if(phone.value != ""){
        phone.style.borderColor = "blue";
        phoneError.innerText=""
        phoneError.style.fontSize = "12px";
    } else {
        phone.style.borderColor = "red";
        phoneError.innerText="전화번호를 입력해 주세요"
        phoneError.style.color = "red";
        phoneError.style.fontSize = "12px";
        isValid=false;
    }
})

email.addEventListener("blur", function(){
    if(email.value != ""){
        email.style.borderColor = "blue";
        emailError.innerText=""
        emailError.style.fontSize = "12px";
    } else {
        email.style.borderColor = "red";
        emailError.innerText="email를 입력해 주세요"
        email.style.Color = "red";
        emailError.style.fontSize = "12px";
        isValid=false;
    }
})

birth.addEventListener("change", function(){
    if(birth.value != ""){
        birth.style.borderColor = "blue";
        birthError.innerText=""
        birthError.style.fontSize = "12px";
    } else {
        birth.style.borderColor = "red";
        birthError.innerText="생일을 선택해 주세요"
        birthError.style.color = "red";
        birthError.style.fontSize = "12px";
        isValid=false;
    }
})

btn.addEventListener("click", function(){
    let v = true;

    if (username.value.trim() === ""){
        v = false;
        console.log("ID를 확인해 주세요")
        username.style.borderColor = "red";
        usernameError.style.color = "red";
        usernameError.style.fontSize = "12px";
    }
            
    if (name.value.trim() === ""){
        console.log("이름을 확인해 주세요");
        name.style.borderColor = "red";
        nameError.style.color = "red";
        nameError.style.fontSize = "12px";
        v = false;
    } 

    if (password.value.trim() === ""){
        console.log("비밀번호를 확인해 주세요");
        password.style.borderColor = "red";
        passwordCheck.style.borderColor = "red";
        passwordCheckError.style.color = "red";    
        passwordCheckError.style.fontSize = "12px";
        v = false;
    }  
        
    if (phone.value.trim() === ""){
        console.log("전화번호를 확인해 주세요");
        phone.style.borderColor = "red";
        phoneError.style.color = "red";
        phoneError.style.fontSize = "12px";
        v = false;
    } 

    if (email.value === ""){
        console.log("email을 확인해 주세요");
        email.style.borderColor = "red";
        emailError.style.color = "red";
        emailError.style.fontSize = "12px";
        v = false;
    } 

    if (birth.value.trim() === ""){
        console.log("생일을 확인해 주세요");
        birth.style.borderColor = "red";
        birthError.style.color = "red";
        birthError.style.fontSize = "12px";
        v = false; 
    }
            
    if(v && isValid){
        console.log("회원가입 완료");
    } else {
        console.log("틀린 곳 확인해 주세요");
    }  
    
})
