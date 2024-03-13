document.addEventListener("DOMContentLoaded", function () {
  // ----------- Ejercicio 1 ------------------
  let parrafo1 = document.querySelector("#parrafo1");
  let boton1 = document.querySelector("#Ejercicio1");
  let input1 = document.querySelector("#input1");

  boton1.addEventListener("click", () => {
    if (input1.value.length > 0) {
      parrafo1.textContent = "";
      ejercicio1(esPrimo(input1.value));
      input1.value = "";
    }
  });

  function esPrimo(numero) {
    if (numero <= 1) {
      return false;
    }

    for (let i = 2; i <= Math.sqrt(numero); i++) {
      if (numero % i === 0) {
        return false;
      }
    }

    return true;
  }

  function ejercicio1(esPrimo, parrafo) {
    if (esPrimo) {
      parrafo1.textContent += "El numero es primo";
    } else {
      parrafo1.textContent += "El numero no es primo";
    }
  }

  // ----------- Ejercicio 2 ------------------

  let parrafo2 = document.querySelector("#parrafo2");
  let botonCalcular = document.querySelector("#Calcular");
  let botonClear = document.querySelector("#Clear");
  let input2 = document.querySelector("#input2");

  botonCalcular.addEventListener("click", (e) => {
    if (input2.value.length > 0) {
      if (!isNaN(input2.value)) {
        calcularCelsiusfahrenheit(input2.value, parrafo2);
      } else {
        parrafo2.textContent = "Debes introducir un numero";
      }
    }
  });

  botonClear.addEventListener("click", (e) => {
    input2.value = "";
    parrafo2.textContent = "";
  });

  function calcularCelsiusfahrenheit(numero, parrafo) {
    let f;
    f = numero * 1.8 + 32;

    parrafo.textContent += `${numero}ºC equivale a ${f} en fahrenheit`;
  }

  // ----------- Ejercicio 3 ------------------

  let verde = document.querySelector("#verde");
  let rojo = document.querySelector("#rojo");
  let azul = document.querySelector("#azul");
  let amarillo = document.querySelector("#amarillo");
  let morado = document.querySelector("#morado");

  verde.addEventListener("click", (e) => {
    document.getElementById("mydiv").className = "verde";
  });
  rojo.addEventListener("click", (e) => {
    document.getElementById("mydiv").className = "rojo";
  });
  azul.addEventListener("click", (e) => {
    document.getElementById("mydiv").className = "azul";
  });
  amarillo.addEventListener("click", (e) => {
    document.getElementById("mydiv").className = "amarillo";
  });
  morado.addEventListener("click", (e) => {
    document.getElementById("mydiv").className = "morado";
  });

  // ----------- Ejercicio 4 ------------------

  let inputNombre = document.querySelector("#inputNombre");
  let inputApellidos = document.querySelector("#inputApellidos");
  let inputEmail = document.querySelector("#inputEmail");
  let selectEdad = document.querySelector("#edadSelect");

  let botonEjercicio4 = document.querySelector("#botonEjercicio4");

  botonEjercicio4.addEventListener("click", (e) => {
    console.log(inputNombre.value);
    console.log(inputApellidos.value);
    console.log(inputEmail.value);
    console.log(selectEdad.value);
    prompt("Cuantos años tienes?", "100");
  });
});
