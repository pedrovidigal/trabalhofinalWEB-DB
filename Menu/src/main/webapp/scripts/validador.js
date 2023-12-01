/**
 * Validação de formulario
 * @author pedro vidigal
 */

 function validar(){
	 let Codigo = frmNovo.codigo.value
	 let Nome = frmNovo.Nome.value
	 let Ingredientes = frmNovo.Ingredientes.value
	 let Tipo = frmNovo.Tipo.value
	 if (Nome === "") {
		 alert('preencha o campo nome')
		 frmNovo.Nome.focus()
		 return false
	 }else if (Codigo === ""){
		 alert ('preencha o campo Codigo')
		 frmNovo.Codigo.focus()
		 return false
	 }
	 else if (Ingredientes === ""){
		 alert ('preencha o campo ingredientes')
		 frmNovo.Ingredientes.focus()
		 return false
	 }else if (Tipo === ""){
		 alert ('preencha o campo Tipo')
		 frmNovo.Tipo.focus()
		 return false
	 }else {
		 document.forms["frmNovo"].submit()
	 }
 }