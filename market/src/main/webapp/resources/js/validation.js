/**
 * 상품 등록 폼 유효성 검사
 */

 function checkAddProduct(){
	 //alert("check");
	 
	//id 선택자를 사용해서 유효성 검사
	let productId = document.getElementById("productId");
	let pname = document.getElementById("pname");
	let unitPrice = document.getElementById("unitPrice");
	let unitsInStock = document.getElementById("unitsInStock");
	
	//정규표현식
	let regExpId = /^P[0-9]{4,11}/
	
	//상품 아이디 체크 - P와 숫자를 조합하여 5~12자까지 입력하세요.
	if(!regExpId.test(productId.value)){
		alert("[상품 코드]\nP와 숫자를 조합하여 5~12자까지 입력하세요.\n첫글자는 반드시 P로 시작하세요");
		productId.focus();
		productId.select();
		return false;
	}
	
	//상품명 체크 - 최소 4~12자까지 입력하세요.
	if(pname.value.length < 4 || pname.value.length > 12){
		alert("[상품명]\n최소 4~12까지 입력하세요.");
		pname.select();
		pname.focus();
		return false;
	}
	
	//상품 가격 체크 - 숫자만 입력하세요.
	if(unitPrice.value.length == 0 || isNaN(unitPrice.value)){
		alert("[가격]\n숫자만 입력하세요.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0 ){
		alert("[가격]\n음수는 입력할 수 없습니다.");
		unitPrice.select();
		return false;
	}
	
	//재고수 체크 - 숫자만 입력하세요.
	if(unitsInStock.value.length==0 || isNaN(unitsInStock.value)){
		alert("[재고]\n숫자만 입력하세요.");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	if(unitsInStock.value < 0 ){
		alert("[재고]\n음수는 입력할 수 없습니다.");
		unitsInStock.select();
		return false;  
	}

	document.newProduct.submit();	//폼을 전송
}