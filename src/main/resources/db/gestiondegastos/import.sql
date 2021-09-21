
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

INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (100,'Alimentacion','Vendi 5 yatekomo caducados',CURDATE(),9);

INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Hogar','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,categoria,concepto,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);


--#PRESUPUESTOS#

INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (100,150,"2021-09-15","2021-09-22",1);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (1000,2000,"2021-09-15","2021-09-29",6);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (500,1500,"2021-09-15","2021-09-29",7); 
