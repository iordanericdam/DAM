document.addEventListener("DOMContentLoaded", function () {
  let input1 = document.querySelector("#input1");
  let input4 = document.querySelector("#input4");
  let ejercicio1 = document.querySelector("#boton1");
  let ejercicio2 = document.querySelector("#boton2");
  let ejercicio3 = document.querySelector("#boton3");
  let ejercicio4 = document.querySelector("#boton4");
  let ejercicio5 = document.querySelector("#boton5");
  let parrafo1 = document.querySelector("#parrafo1");
  let parrafo2 = document.querySelector("#parrafo2");
  let parrafo3 = document.querySelector("#parrafo3");
  let parrafo4 = document.querySelector("#parrafo4");
  let parrafo5 = document.querySelector("#parrafo5");
  let parrafo5_1 = document.querySelector("#parrafo5-1");

  let saltoDeLinea = document.createElement("br");

  ejercicio1.addEventListener("click", (e) => {
    if (input1.value.length > 0) {
      parrafo1.textContent = "";
      comprobarParImpar(input1.value, parrafo1);
      input1.value = "";
    }
  });

  ejercicio2.addEventListener("click", (e) => {
    parrafo2.textContent = "";
    primerosVeinteNumeros();
  });

  ejercicio3.addEventListener("click", (e) => {
    let cadena = prompt("Introduce el texto");
    comprobarMayusculaMinuscula(cadena, parrafo3);
  });

  ejercicio4.addEventListener("click", (e) => {
    if (input4.value.length > 0) {
      parrafo1.textContent = "";
      remplazarTexto(input4.value, parrafo4);
      input4.value = "";
    }
  });

  ejercicio5.addEventListener("click", (e) => {
    numerosRandom(parrafo5);
  });

  function comprobarParImpar(numero, parrafo) {
    if (numero % 2 == 0) {
      console.log(`El ${numero} ES PAR! `);
      parrafo.innerHTML += `El ${numero} ES PAR! <br/> `;
    } else if (isNaN(numero % 2)) {
      parrafo.innerHTML += `Lo que ha introducido no es un numero`;
    } else {
      parrafo.innerHTML += `El ${numero} ES IMPAR! <br/> `;
    }
  }

  function primerosVeinteNumeros() {
    let numeros = [
      10, 40, 3, 9, 70, 28, 45, 99, 56, 44, 33, 99, 77, 45, 96, 47, 37, 68, 95,
      76,
    ];

    numeros.forEach((element) => {
      comprobarParImpar(element, parrafo2);
    });
  }

  function comprobarMayusculaMinuscula(cadena, parrafo) {
    parrafo.textContent = "";
    if (cadena === cadena.toUpperCase()) {
      parrafo.innerHTML += "Esta en mayusculas";
    } else if (cadena === cadena.toLowerCase()) {
      parrafo.textContent += "Esta en minusculas";
    } else {
      parrafo.textContent +=
        "Debe estar todo el texto en mayusculas o minusculas";
    }
  }

  function remplazarTexto(cadena, parrafo) {
    parrafo.textContent = cadena.replace(/ /g, "/");
  }

  function numerosRandom(parrafo) {
    let numeros = [];

    for (let i = 0; i < 10; i++) {
      Num = Math.floor(Math.random() * 50) + 1;
      numeros.push(Num);
    }
    let contador = 0;
    contador = comprobarNumerosMayores25(numeros);
    parrafo.textContent = numeros;
    parrafo.appendChild(saltoDeLinea);
    parrafo5_1.textContent = "";
    parrafo5_1.textContent += `Hay ${contador.length} numeros mayores que 25`;
  }

  function comprobarNumerosMayores25(numeros) {
    let contador = [];
    for (let i = 0; i < 10; i++) {
      if (numeros[i] >= 25) {
        contador.push(numeros[i]);
      }
    }
    return contador;
  }
});
