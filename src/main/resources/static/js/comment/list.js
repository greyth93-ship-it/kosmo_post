
const review_list = document.getElementById("review_list");
const txt = document.getElementById("txt");
const btn = document.querySelector("#btn");
const update_btn = document.getElementById("update_btn");
const cu = document.getElementById("content_update")
const cn = document.getElementById("cn");


getList(review_list.getAttribute("data-gn"));
function getList(num){
    fetch(`/comment/list?goodsNo=${num}`)
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        review_list.innerHTML=r;
    })
}

// 수정
update_btn.addEventListener("click",(e)=>{
    let u = new FormData();
    u.append("commentContent", cu.value);
    u.append("commentNo",cn.value);

    fetch("../comment/update",{
            method:"POST",
            body:u
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                alert("수정성공")
                getList(review_list.getAttribute("data-gn"));
                cu.innerText=""
                // document.getElementById("close").click();
            } else{
                alert("수정실패")
            }
        })    
})

//삭제
review_list.addEventListener("click", (e)=>{
    if(e.target.classList.contains("del")){
        let n = e.target.parentElement.getAttribute("data-comment")
        
        let p = new FormData();
        p.append("commentNo", n)

        fetch("../comment/delete",{
            method:"POST",
            body:p
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                alert("삭제성공")
                getList(review_list.getAttribute("data-gn"));
            } else{
                alert("삭제실패")
            }
        })
    }

    if(e.target.classList.contains("edit")){
        let c = e.target.parentElement.parentElement.firstElementChild.innerText
        document.getElementById("content_update").innerText=c;
        c=e.target.parentElement.getAttribute("data-comment")
        cn.value=c;
    }
});


// 추가
btn.addEventListener("click",()=>{
    
    let p = new FormData();
    
    p.append("commentContent",txt.value)
    p.append("goodsNo", review_list.getAttribute("data-gn"))
    p.append("commentStar", 3)

    fetch("../comment/create",{
        method:"POST",
        body:p
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert("등록성공")
            getList(review_list.getAttribute("data-gn"));
        } else{
            alert("등록실패")
        }
        txt.value=""
    });
})