
--USUARIOS

INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Raul','RaulHiberus','RaulHiberus@gmail.com','665379845');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Diego','NotDaiggo','RaulHiberus@gmail.com','655352261');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Sofia','LaSofi','SofiaHiberus@gmail.com','722161974');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Martin','Martinxo','MartinHiberus@gmail.com','677826971');
INSERT INTO usuario (nombre,contrasenya,correo,telefono) VALUES ('Jose María','ElXema','JosemaHiberus@gmail.com','646582521');


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

--#MOVIMIENTO#

INSERT INTO movimiento (cantidad,concepto,info,fecha,id_usuario_grupo) VALUES (-100,'Alimentacion','Compra de 5 yatekomo',CURDATE(),7);
INSERT INTO movimiento (cantidad,concepto,info,fecha,id_usuario_grupo) VALUES (100,'Alimentacion','Vendi 5 yatekomo caducados',CURDATE(),9);

--#PRESUPUESTOS#

INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (100,150,"2021-09-15","2021-09-22",1);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (1000,2000,"2021-09-15","2021-09-29",6);
INSERT INTO presupuesto (cantidad_inicio,cantidad_final,fecha_inicio,fecha_final,id_grupo) VALUES (500,1500,"2021-09-15","2021-09-29",7); 
