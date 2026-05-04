
const add = document.getElementById("add");
const result = document.getElementById("result");
const create = document.getElementById("create");


// create.addEventListener("click", ()=>{
//     let form = new FormData();
//     form.append("boardTitle","ajax title");
//     form.append("boardWriter","ajax writer");
//     form.append("boardContent", "ajax content");

//     fetch("./create",{
//         method:"POST",
//         body:form
//     }).then(res=>res.text())
//     .then(res=>console.log(res));
// })

let idx = result.getAttribute("data-file-size");
if(idx==undefined){
	idx=0;
}

add.addEventListener("click", function(){

    if(idx > 4){
        alert("5개까지만 추가할 수 있어요");
        return;
    } 
    
    let d = document.createElement("div");
    d.id=`id${idx}`;

    let i = document.createElement("input");
    i.type="file";
    i.name="attach";
    i.classList.add("form-control");
    
    let b = document.createElement("button");
    b.type="button";
    b.innerText="DELETE";
    b.setAttribute("data-id",`id${idx}`);
    b.addEventListener("click",function(){
        d.remove();
    })

    
    d.append(i);
    d.append(b);



    result.append(d);

    idx++

    

})
