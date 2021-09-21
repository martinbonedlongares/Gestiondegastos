
--USUARIOS

INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Raul','$2a$10$PkHebxbh3IMniYV09VtQNu32xDLX8yZLkO0JX1/GNqjvyR0wMY7JS','RaulHiberus@gmail.com','665379845');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Diego','$2a$10$YQAzwUghK2aSkISs3ok3Cu4Ha4gcebPisgp6qlOcUjvpI4lbfr2QK','DiegoHiberus@gmail.com','655352261');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Sofia','$2a$10$Vj6jJOvVEtWqkIBWx5KIjuB3hkIcc0567UUblBbnoPXCM4n1mMMe6','SofiaHiberus@gmail.com','722161974');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Martin','$2a$10$H3yBhQpiyjqG02boZPcwlu7l5Je3Bu0E6N6mFb0Td4lxQT0GtyXW2','MartinHiberus@gmail.com','677826971');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Jose María','$2a$10$R/YwN2b8AKfwxu0upaIA/Onufw7A5wCKZfgDc87sIFuFKdn8CSt26','JosemaHiberus@gmail.com','646582521');


--#GRUPOS#

INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Mi Grupo', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Mi Grupo', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Mi Grupo', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Mi Grupo', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Mi Grupo', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Grupo Diego-Raul-Josema', CURDATE());
INSERT INTO grupo (nombre,fecha_creacion) VALUES ('Grupo Sofi-Martin', CURDATE());

--#USUARIO-GRUPO# 0=false >=0=true

INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (1,1,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (2,2,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (3,3,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (4,4,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (5,5,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (1,6,0);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (2,6,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (5,6,0);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (3,7,1);
INSERT INTO usuario_grupo (id_usuario,id_grupo,rol) VALUES (4,7,0);

--#MOVIMIENTO# categoria: Entretenimiento, Alimentacion, Ropa, Hogar, Higiene, Transporte, Comunicacion, Medicina, Regalo, Mascota

INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-12.0,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (12.0,'Alimentacion','Vendi 5 yatekomo caducados',CURDATE(),9);

INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-50,'Hogar','Aspiradora Turbo3000',CURDATE(),1);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-9.0,'Entretenimiento','2 Entradas Cruella',CURDATE(),2);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+1200.75,'Hogar','PAY-DAY BABY',CURDATE(),3);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-40,'Ropa','Pantalones Talla L y Camisa',CURDATE(),4);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-10,'Transporte','Recarga de tarjeta bus',CURDATE(),5);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+30,'Regalo','Propina de la abuela <3',CURDATE(),6);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (1.5,'Transporte','Monedas en el suelo, que suerte',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-11.9,'Regalo','Libro de Stephen King para Paloma',CURDATE(),8);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-1.8,'Alimentacion','Cafe con churros en Hiberus',CURDATE(),9);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+4.5,'Hogar','Deuda de mi hermano saldada',CURDATE(),10);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-45.5,'Entretenimiento','Cascos New Skill Kimera V2',CURDATE(),6);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+600.65,'Comunicacion','Resolución juicio del bar',CURDATE(),6);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-40.32,'Higiene','Productos rollo cremas, pasta de dientes etc',CURDATE(),8);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-0.9,'Entretenimiento','Karlson, oh... No sabes lo que es Karlson? Karlson es un...',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-61.2,'Alimentación','Liquidos de vaper',CURDATE(),9);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+120,'Regalo','Cumple YaY <3',CURDATE(),10);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-0.1,'Alimentacion','Propina del café',CURDATE(),10);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-102.8,'Comunicación','Factura Orange',CURDATE(),9);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-20.0,'Transporte','Gasolina',CURDATE(),5);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+5.5,'Regalo','Tarjeta reagalo hipercor',CURDATE(),6);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-60,'Alimentacion','Carro de la compra',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Café con "descuento" de Hiberus',CURDATE(),10);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (+20,'Higiene','Arreglar tuberia',CURDATE(),9);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-3.00,'Transporte','Mas viajes de tranvia T.T',CURDATE(),8);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-30.5,'Alimentacion','Cena UDON',CURDATE(),6);


--#PRESUPUESTOS#

INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (100,150,"2021-09-15","2021-09-22",1);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (1000,2000,"2021-09-15","2021-09-29",6);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (500,1500,"2021-09-15","2021-09-29",7); 
