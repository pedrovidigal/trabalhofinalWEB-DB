/**
 * Confirmação de exclusão
 * @author pedro vidigal
 */

 function confirmar(codigo){
	 let resposta = confirm("Confirma a exclusão?")
	 if (resposta ===true){
		 //alert(codigo)
		 window.location.href = "delete?Codigo=" + codigo
	 }
 }