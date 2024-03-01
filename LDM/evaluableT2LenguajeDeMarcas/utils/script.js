document.addEventListener("DOMContentLoaded", function () {
  let inputNombre = document.querySelector("#inputNombre");
  let inputApellidos = document.querySelector("#inputApellidos");
  let inputCorreo = document.querySelector("#inputCorreo");
  let selectDepartamento = document.querySelector("#selectDepartamento");
  let boton = document.querySelector("#guardarDatos");
  let lista = document.querySelector("#listaUsuarios");

  let parrafoNombre = document.querySelector("#parrafoNombre");
  let parrafoApellidos = document.querySelector("#parrafoApellidos");
  let parrafoCorreo = document.querySelector("#parrafoCorreo");
  let pDepartamento = document.querySelector("#parrafoDepartamento");

  boton.addEventListener("click", (e) => {
    if (
      inputNombre.value.length > 0 &&
      inputApellidos.value.length > 0 &&
      inputCorreo.value.length > 0
    ) {
      /* parrafoNombre.textContent = inputNombre.value;
      parrafoApellidos.textContent = inputApellidos.value;
      parrafoCorreo.textContent = inputCorreo.value;
      pDepartamento.textContent = selectDepartamento.value; */

      let nodo = document.createElement("li");
      nodo.textContent = `${inputNombre.value} ${inputApellidos.value}`;
      nodo.className = "animate__animated animate__backInLeft list-group-item";
      lista.append(nodo);

      inputNombre.value = "";
      inputApellidos.value = "";
      inputCorreo.value = "";
     
    }
  });
});
