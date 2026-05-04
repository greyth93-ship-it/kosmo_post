
const total = document.querySelector("#total"); 
const del = document.querySelector("#del");
const list = document.getElementById("list");

getList();

function getList(){
    fetch("./cartlist")
    .then(r=>r.text())
    .then(r=>{
        r = r.trim();
        list.innerHTML=r;
    })
}






list.addEventListener("click",(e)=>{
    if(e.target.classList.contains("tdel")){
        let pn = e.target.previousElementSibling.getAttribute("data-pn")
        let p = new URLSearchParams();
        p.append("goodsNo", pn);

        fetch("./delete",{
            method:"POST",
            body:p
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                // let flag = confirm("선택항목을 삭제하시겠습니까?")
                getList();

            } else{
                alert("삭제 실패")
            }
        })
    }

    if(e.target.classList.contains("ch")){
        let chs = document.getElementsByClassName("ch")
        let r = true;
        for(let c of chs){
            if(!c.checked){
                r=false;
            }
        } total.checked=r;
    } 

})



del.addEventListener("click",()=>{
    
    let cb = document.querySelectorAll(".ch:checked")
    let p = new URLSearchParams();
    let ch = document.querySelectorAll(".ch")

    if(cb.length === 0){
        alert("삭제할 상품을 선택해 주세요")
        return;
    }

    cb.forEach(r=>{
         
        p.append("goodsNo", r.getAttribute("data-pn"));
    })
    console.log(p.toString());

    fetch("./delete",{
        method:"POST",
        body:p
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            let flag = confirm("선택한 상품을 삭제하시겠습니까?")
            if(flag){
                cb.forEach(c =>{
                    c.parentElement.parentElement.remove();
                })
                alert("선택한 상품이 삭제되었습니다.")
                // location.reload="./list";
            } else {
                alert("삭제 실패")
             }
            
        } 
        
    })
})

total.addEventListener("click", ()=>{
    let ch = document.querySelectorAll(".ch")
    ch.forEach((c)=>{
        c.checked=total.checked;
    });
})