/**
 * 
 */

const cart = document.getElementById("cart");
const goodsNo = document.getElementById("goodsNo");
const result = document.getElementById("result");

cart.addEventListener("click", ()=>{
	let pn = cart.getAttribute("data-pn")

	console.log(pn);

	const params = new URLSearchParams();
	params.append("goodsNo",pn);


	fetch("../cart/create",{
		method:"POST",
		body: params
	})
	.then(r=>r.text())
	.then(r=> {
		// 등록 성공이면 장바구니로 이동?
		r = r.trim();
		if(r>0){
			let flag = confirm("장바구니로 이동하시겠습니까?");
			if(flag){
				location.href="../cart/list";
			} else{
				location.href="";
			}
		}else{
			alert("이미 담긴 상품입니다.")
		}
	})
})