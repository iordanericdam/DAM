document.addEventListener("DOMContentLoaded", function () {
  fetch("https://dummyjson.com/products")
    .then((response) => response.json())
    .then((data) => {
      const products = data.products;
      const productList = document.getElementById("lista_productos");
      let select = document.querySelector("#select");
      const btnSelect = document.querySelector("#btnSelect");
      const input = document.querySelector("#input");
      const selectCategoria = document.querySelector("#selectCategoria");

      showProducts(products, productList);

      btnSelect.addEventListener("click", (e) => {
        let valorFiltro = select.value;
        console.log(valorFiltro); // Traza para eliminar
      });

      select.addEventListener("change", (e) => {
        if (select.value == "marca") {
          input.style.display = "inline";
          input.placeholder = "Escriba la marca";
        } else if (select.value == "categoria") {
          selectCategoria.style.display = "inline";
        } else {
          input.style.display = "none";
        }
      });

      function showProducts(products, productList) {
        products.forEach((item) => {
          productList.innerHTML += `<div class="card col-2 m-2" style="width: 18rem;">
          </br>
          <img src="${item.thumbnail}" class="card-img-top" alt="Imagen de producto">
          <div class="card-body">
            <h5 class="card-title">${item.title}</h5>
            <p class="card-text">${item.description}</p>
            <p class="card-text">Percio: ${item.price}€</p>
            <a href="#" class="btn btn-primary">Añadir a la cesta</a>
          </div>
        </div>
        `;
          console.log(item.category);
        });
      }
    })
    .catch((error) => {
      console.error("Error fetching data:", error);
    });
});
