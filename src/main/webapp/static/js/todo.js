window.onload = function() {
	
	var test3 = document.querySelector('#test3');
	console.log("test"+test3);
	test3.addEventListener("click",function(){
		var todotop = document.querySelector(".doing");
		var testele = document.querySelector(".element3");

		todotop.appendChild(testele);
	},false)
	
}
