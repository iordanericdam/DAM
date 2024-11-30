-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2024 a las 10:41:20
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `nombre`, `apellidos`, `correo`) VALUES
(19, 'Eric', 'Iordan', 'eric.iordan@correo.com'),
(20, 'Juan', 'Gomez', 'juan.gomez@correo.com'),
(21, 'Eric', 'Iordan', 'eric.iordan@correo.com'),
(22, 'Juan', 'Gomez', 'juan.gomez@correo.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `precio_total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `id_producto`, `descripcion`, `precio_total`) VALUES
(17, 4, 'The Red Lipstick is a classic and bold choice for adding a pop of color to your lips. With a creamy and pigmented formula, it provides a vibrant and long-lasting finish.', 12.99),
(18, 25, 'Fresh and vibrant green bell pepper, perfect for adding color and flavor to your dishes.', 1.29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `cantidad` varchar(100) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `descripcion`, `cantidad`, `precio`) VALUES
(1, 'Essence Mascara Lash Princess', 'The Essence Mascara Lash Princess is a popular mascara known for its volumizing and lengthening effects. Achieve dramatic lashes with this long-lasting and cruelty-free formula.', '5.0', 9.99),
(2, 'Eyeshadow Palette with Mirror', 'The Eyeshadow Palette with Mirror offers a versatile range of eyeshadow shades for creating stunning eye looks. With a built-in mirror, it\'s convenient for on-the-go makeup application.', '44.0', 19.99),
(3, 'Powder Canister', 'The Powder Canister is a finely milled setting powder designed to set makeup and control shine. With a lightweight and translucent formula, it provides a smooth and matte finish.', '59.0', 14.99),
(4, 'Red Lipstick', 'The Red Lipstick is a classic and bold choice for adding a pop of color to your lips. With a creamy and pigmented formula, it provides a vibrant and long-lasting finish.', '68.0', 12.99),
(5, 'Red Nail Polish', 'The Red Nail Polish offers a rich and glossy red hue for vibrant and polished nails. With a quick-drying formula, it provides a salon-quality finish at home.', '71.0', 8.99),
(6, 'Calvin Klein CK One', 'CK One by Calvin Klein is a classic unisex fragrance, known for its fresh and clean scent. It\'s a versatile fragrance suitable for everyday wear.', '17.0', 49.99),
(7, 'Chanel Coco Noir Eau De', 'Coco Noir by Chanel is an elegant and mysterious fragrance, featuring notes of grapefruit, rose, and sandalwood. Perfect for evening occasions.', '41.0', 129.99),
(8, 'Dior J\'adore', 'J\'adore by Dior is a luxurious and floral fragrance, known for its blend of ylang-ylang, rose, and jasmine. It embodies femininity and sophistication.', '91.0', 89.99),
(9, 'Dolce Shine Eau de', 'Dolce Shine by Dolce & Gabbana is a vibrant and fruity fragrance, featuring notes of mango, jasmine, and blonde woods. It\'s a joyful and youthful scent.', '3.0', 69.99),
(10, 'Gucci Bloom Eau de', 'Gucci Bloom by Gucci is a floral and captivating fragrance, with notes of tuberose, jasmine, and Rangoon creeper. It\'s a modern and romantic scent.', '93.0', 79.99),
(11, 'Annibale Colombo Bed', 'The Annibale Colombo Bed is a luxurious and elegant bed frame, crafted with high-quality materials for a comfortable and stylish bedroom.', '47.0', 1899.99),
(12, 'Annibale Colombo Sofa', 'The Annibale Colombo Sofa is a sophisticated and comfortable seating option, featuring exquisite design and premium upholstery for your living room.', '16.0', 2499.99),
(13, 'Bedside Table African Cherry', 'The Bedside Table in African Cherry is a stylish and functional addition to your bedroom, providing convenient storage space and a touch of elegance.', '16.0', 299.99),
(14, 'Knoll Saarinen Executive Conference Chair', 'The Knoll Saarinen Executive Conference Chair is a modern and ergonomic chair, perfect for your office or conference room with its timeless design.', '47.0', 499.99),
(15, 'Wooden Bathroom Sink With Mirror', 'The Wooden Bathroom Sink with Mirror is a unique and stylish addition to your bathroom, featuring a wooden sink countertop and a matching mirror.', '95.0', 799.99),
(16, 'Apple', 'Fresh and crisp apples, perfect for snacking or incorporating into various recipes.', '9.0', 1.99),
(17, 'Beef Steak', 'High-quality beef steak, great for grilling or cooking to your preferred level of doneness.', '96.0', 12.99),
(18, 'Cat Food', 'Nutritious cat food formulated to meet the dietary needs of your feline friend.', '13.0', 8.99),
(19, 'Chicken Meat', 'Fresh and tender chicken meat, suitable for various culinary preparations.', '69.0', 9.99),
(20, 'Cooking Oil', 'Versatile cooking oil suitable for frying, sautéing, and various culinary applications.', '22.0', 4.99),
(21, 'Cucumber', 'Crisp and hydrating cucumbers, ideal for salads, snacks, or as a refreshing side.', '22.0', 1.49),
(22, 'Dog Food', 'Specially formulated dog food designed to provide essential nutrients for your canine companion.', '40.0', 10.99),
(23, 'Eggs', 'Fresh eggs, a versatile ingredient for baking, cooking, or breakfast.', '10.0', 2.99),
(24, 'Fish Steak', 'Quality fish steak, suitable for grilling, baking, or pan-searing.', '99.0', 14.99),
(25, 'Green Bell Pepper', 'Fresh and vibrant green bell pepper, perfect for adding color and flavor to your dishes.', '89.0', 1.29),
(26, 'Green Chili Pepper', 'Spicy green chili pepper, ideal for adding heat to your favorite recipes.', '8.0', 0.99),
(27, 'Honey Jar', 'Pure and natural honey in a convenient jar, perfect for sweetening beverages or drizzling over food.', '25.0', 6.99),
(28, 'Ice Cream', 'Creamy and delicious ice cream, available in various flavors for a delightful treat.', '76.0', 5.49),
(29, 'Juice', 'Refreshing fruit juice, packed with vitamins and great for staying hydrated.', '99.0', 3.99),
(30, 'Kiwi', 'Nutrient-rich kiwi, perfect for snacking or adding a tropical twist to your dishes.', '1.0', 2.49);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_fav`
--

CREATE TABLE `productos_fav` (
  `id` int(11) NOT NULL,
  `id_producto` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos_fav`
--

INSERT INTO `productos_fav` (`id`, `id_producto`) VALUES
(14, 11),
(15, 12);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pedidos_productos_FK` (`id_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos_fav`
--
ALTER TABLE `productos_fav`
  ADD PRIMARY KEY (`id`),
  ADD KEY `productos_fav_productos_FK` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `productos_fav`
--
ALTER TABLE `productos_fav`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_productos_FK` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`);

--
-- Filtros para la tabla `productos_fav`
--
ALTER TABLE `productos_fav`
  ADD CONSTRAINT `productos_fav_productos_FK` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
