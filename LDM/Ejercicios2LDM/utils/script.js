document.addEventListener("DOMContentLoaded", function () {
  // ----------- Ejercicio 1 ------------------
  let parrafo1 = document.querySelector("#parrafo1");
  let boton1 = document.querySelector("#Ejercicio1");
  let input1 = document.querySelector("#input1");

  boton1.addEventListener("click", () => {
    if (input1.value.length > 0 && !isNaN(input1.value)) {
      parrafo1.textContent = "";
      ejercicio1(esPrimo(input1.value));
      input1.value = "";
    } else {
      console.log("El dato no es un numero");
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
  let porDefecto = document.querySelector("#defaultBoton");

  verde.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "verde";
  });
  rojo.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "rojo";
  });
  azul.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "azul";
  });
  amarillo.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "amarillo";
  });
  morado.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "morado";
  });
  porDefecto.addEventListener("click", (e) => {
    document.getElementById("ejercicio3").className = "colorDeFondo";
  });

  // ----------- Ejercicio 4 ------------------

  let inputNombre = document.querySelector("#inputNombre");
  let inputApellidos = document.querySelector("#inputApellidos");
  let inputEmail = document.querySelector("#inputEmail");
  let selectEdad = document.querySelector("#edadSelect");
  let infoNombre = document.querySelector("#infoNombre");
  let params = `scrollbars=no,resizable=no,status=no,location=no,toolbar=no,menubar=no,
width=0,height=0,left=-1000,top=-1000`;

  let botonEjercicio4 = document.querySelector("#botonEjercicio4Submit");
  // no se seguir

  botonEjercicio4.addEventListener("click", (e) => {
    window.open("./../infoEjercicio4.html", "test", params);
    parrafo1.textContent = "aaaa";
    infoNombre.textContent = inputNombre.value;
    console.log(inputNombre.value);
    console.log(inputApellidos.value);
    console.log(inputEmail.value);
    console.log(selectEdad.value);
    prompt("Cuantos años tienes?", "100");
  });

  // ----------- Ejercicio 5 ------------------

  let botonEjercicio5 = document.querySelector("#botonEjercicio5");

  botonEjercicio5.addEventListener("click", (e) => {
    let nombre = prompt("¿Como te llamas?");
    let edad = prompt("¿Cuantos años tienes?");
    if (edad != null && nombre != null) {
      alert(`Hola ${nombre} has vivido ${calcularEdad(edad)} dias`);
    }

    function calcularEdad(edad) {
      return edad * 365;
    }
  });
});
