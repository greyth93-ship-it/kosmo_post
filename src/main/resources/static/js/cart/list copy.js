
const total = document.querySelector("#total"); //
const ch = document.querySelectorAll(".ch"); // 
const del = document.querySelector("#del");
const tdel = document.getElementsByClassName("tdel"); //
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

total.addEventListener("click", ()=>{
    ch.forEach((c)=>{
        c.checked=total.checked;
    });
})

ch.forEach(c=>{
    c.addEventListener("click", ()=>{
        let r=true;
        ch.forEach((e)=>{
            if(!e.checked){
                r=false;
            }
        })

        total.checked=r;

    })
})

for(let d of tdel){
    d.addEventListener("click",()=>{
        let pn = d.previousElementSibling.getAttribute("data-pn")
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
                let flag = confirm("선택항목을 삭제하시겠습니까?")
                if(flag){
                    d.parentElement.parentElement.remove();
                    
                }
            } else{
                alert("삭제 실패")
            }
        })
    })
}




del.addEventListener("click",()=>{
    
    let cb = document.querySelectorAll(".ch:checked")
    let p = new URLSearchParams();

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