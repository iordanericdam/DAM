document.addEventListener("DOMContentLoaded", function () {
  let inputNombre = document.querySelector("input#inputNombre");
  let inputApellidos = document.querySelector("input#inputApellidos");
  let boton = document.querySelector("#boton-agregar");
  let lista = document.querySelector("#listaUsuarios");
  let listaDatosUsuarios = [];

  boton.addEventListener("click", () => {
    /*Agregar datos  */
    listaDatosUsuarios.push("Eric", "Edurne", "Maria");
    listaDatosUsuarios.unshift("Juana");

    /* Mostrar datos */
    /* listaDatosUsuarios.forEach((item, index) => {
      console.log(`${index} ${item}`);
    }); */

    /* Busqueda de un elemento */
    let usuarioBuscar = listaDatosUsuarios.find((item) => {
      return item == "Eric";
    });

    if (usuarioBuscar != null) {
      console.log(usuarioBuscar);
    } else {
      console.log("No se a encontrado");
    }
    /* Busqueda de multiples elementos */

    let resultadoBusqueda = listaDatosUsuarios.filter((item) => {
      return item.includes("E");
    });

    if (resultadoBusqueda.length > 0) {
      resultadoBusqueda.forEach((item, index) => {
        console.log(`Elementos encontrados ${item.length}`);
        console.log(`${index} ${item}`);
      });
    }
  });

  boton.addEventListener("click", () => {
    if (inputNombre.value.length > 0 && inputApellidos.value.length > 0) {
      /* lista.innerHTML += `<li class="list-group-item">${inputNombre.value} ${inputApellidos.value}</li>`; */
      let nodo = document.createElement("li");
      nodo.textContent = `${inputNombre.value} ${inputApellidos.value}`;
      nodo.className = "animate__animated animate__backInLeft list-group-item";
      lista.append(nodo);
      inputNombre.value = "";
      inputApellidos.value = "";
    } else {
      Swal.fire({
        title: "Error!",
        text: "Do you want to continue",
        icon: "error",
        confirmButtonText: "Cool",
      });
    }
  });
});
