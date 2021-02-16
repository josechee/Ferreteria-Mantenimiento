DROP DATABASE IF EXISTS unpa;
CREATE DATABASE unpa;
use unpa;

/*
-- ----------------PROCEDIMIENTOS TIPO TELEFONO--------------------------
CREATE TABLE tbl_TipoTelefono(
		ID_TipoTelefono INT NOT NULL,
		Descripcion VARCHAR(45) NOT NULL,
        PRIMARY KEY (ID_TipoTelefono)
);
-- ------------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_TipoTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_TipoTelefono_Consultar_SP(IN In_ID_TipoTelefono VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_TipoTelefono 
	WHERE  ID_TipoTelefono = In_ID_TipoTelefono;
        
END//
DELIMITER ;


-- -------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_TipoTelefono_Insertar_SP;
DELIMITER //
CREATE PROCEDURE tbl_TipoTelefono_Insertar_SP(
    IN Input_ID_TipoTelefonor INT,
    IN Input_Descripcion VARCHAR(45)
)
BEGIN
DECLARE indicador INT DEFAULT 0;


INSERT INTO tbl_TipoTelefono(
        ID_TipoTelefono,
        Descripcion)
        VALUES(
        Input_ID_TipoTelefonor,
        Input_Descripcion
);

 -- SET Out_Indicador=indicador+1;
 SELECT 1;
END //
DELIMITER ;
-- ---------------------------------------------


-- -------------TABLA TIPO PRODUCTO-----------------------------
DROP TABLE IF EXISTS tbl_TipoProducto;
CREATE TABLE tbl_TipoProducto(
		ID_tipoProducto INT NOT NULL,
        Descripcion VARCHAR(45) NOT NULL,
        PRIMARY KEY (ID_tipoProducto)
);

-- -------------------
DROP PROCEDURE IF EXISTS TipoProducto_Consultar_SP;
DELIMITER //
CREATE PROCEDURE TipoProducto_Consultar_SP(IN In_ID INT)
BEGIN
	
	SELECT  * FROM tbl_TipoProducto 
	WHERE  ID_tipoProducto = In_ID;
        

END//
DELIMITER ;

-- ----------------------------------------------

DROP PROCEDURE IF EXISTS TipoProducto_Insertar_SP; 
DELIMITER //
CREATE PROCEDURE TipoProducto_Insertar_SP(
    IN Input_ID INT,
    IN Input_Descripcion VARCHAR(45)
    )
    
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE id INT DEFAULT 0;

INSERT INTO tbl_TipoProducto(
		ID_tipoProducto,
		Descripcion
        )
        VALUES(
        Input_ID,
        Input_Descripcion
);

-- SELECT Out_ID;
-- SET Out_ID=Input_ID;
-- SET Out_Indicador=indicador+1;
SELECT 1;
END //
DELIMITER ;


SET @_TipoProducto = 0;


-- call TipoProducto_Insertar_SP(5,'Componentes diversos',@_TipoProducto);
 -- SELECT @_ID_TipoProducto AS _IDTipoPro;
-- ----------------------------------------------------------------------
-- ------------

-- -----------------------------



-- --------------PROCEDIMIENTOS USUARIO-------------------------------
DROP TABLE IF EXISTS tbl_Usuario;
CREATE TABLE tbl_Usuario(
		ID_Usuario VARCHAR(36) NOT NULL,
		Usuario VARCHAR(45) NOT NULL,
        Contrasenia VARCHAR(45) NOT NULL,
        PRIMARY KEY (ID_Usuario)
);

-- -------------------------------------------

DROP PROCEDURE IF EXISTS Usuario_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Usuario_Consultar_SP(IN In_ID_Usuario VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_Usuario 
	WHERE  ID_Usuario = In_ID_Usuario;
        
END//
DELIMITER ;

-- ---------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_Usuario_Insertar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Usuario_Insertar_SP(
    IN Input_Usuario VARCHAR(45),
    IN Input_Contrasenia VARCHAR(45),
    INOUT Out_ID_Usuario VARCHAR(36)
)
BEGIN
-- DECLARE indicador INT DEFAULT 0;
DECLARE idUsuario varchar(36) DEFAULT ' ';
SET idUsuario= (SELECT UUID());

INSERT INTO tbl_Usuario(
		ID_Usuario,
        Usuario,
        Contrasenia)
        VALUES(
        idUsuario,
        Input_Usuario,
        Input_Contrasenia
);

SELECT idUsuario;
SET Out_ID_Usuario=idUsuario;
-- SET Out_Indicador=indicador+1;
-- SELECT 1;
END //
DELIMITER ;

-- ------------------------------------------------
DROP PROCEDURE IF EXISTS Usuario_Actualizar_SP;
DELIMITER //
CREATE PROCEDURE Usuario_Actualizar_SP(
			In Input_ID_Usuario VARCHAR(36),
			IN Input_Usuario VARCHAR(45),
			IN Input_Contrasenia VARCHAR(45)
            )
			
BEGIN
UPDATE tbl_usuario
SET     Usuario=Input_Usuario,
        Contrasenia=Input_Contrasenia
        
WHERE ID_Usuario=Input_ID_Usuario;
SELECT 1;

END //
DELIMITER ;
-- ---------

DROP PROCEDURE IF EXISTS Usuario_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Usuario_Eliminar_SP(IN In_ID_Usuario VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_usuario 
	WHERE ID_Usuario = In_ID_Usuario; 
	
    SELECT 1;
END //
DELIMITER ;





-- ----------PROCEDIMIENTOS TIPOEMPLEADO--------CATALOGO-----------
DROP TABLE IF EXISTS tbl_TipoEmpleado;
CREATE TABLE tbl_TipoEmpleado(
		ID_TipoEmpleado INT NOT NULL,
		Descripcion VARCHAR(45) NOT NULL,
        PRIMARY KEY (ID_TipoEmpleado)
);
-- -------------------------------------------


DROP PROCEDURE IF EXISTS tbl_TipoEmpleado_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_TipoEmpleado_Consultar_SP(IN In_ID_Usuario INT)
BEGIN
	
	SELECT  * FROM tbl_TipoEmpleado 
	WHERE  ID_TipoEmpleado = In_ID_Usuario;
        
END//
DELIMITER ;

-- -----------------------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_TipoEmpleado_Insertar_SP;
DELIMITER //
CREATE PROCEDURE tbl_TipoEmpleado_Insertar_SP(
    Input_ID_TipoEmpleado INT ,
    Input_Descripcion VARCHAR(45)
)
BEGIN


INSERT INTO tbl_TipoEmpleado(
		ID_TipoEmpleado,
        Descripcion)
        VALUES(
        Input_ID_TipoEmpleado,
        Input_Descripcion
);

SELECT 1;
END //
DELIMITER ;





-- ----------------PROCEDIMINETOS EMPLEADO-------------------------


DROP TABLE IF EXISTS tbl_Empleado;
CREATE TABLE tbl_Empleado(
		ID_Empleado VARCHAR(36) NOT NULL,
        ID_Usuario VARCHAR(36)  NOT NULL,
        ID_TipoEmpleado INT  NOT NULL,
		Nombre VARCHAR(45) NOT NULL,
        ApPaterno VARCHAR(45) NOT NULL,
        ApMaterno VARCHAR(45) NOT NULL,
        FechaNacimiento VARCHAR(45) NOT NULL,
		Calle VARCHAR(45) NOT NULL,
        Colonia VARCHAR(45) NOT NULL,
        Ciudad VARCHAR(45) NOT NULL,
        CodigoPostal INT NOT NULL,
        PRIMARY KEY (ID_Empleado),
        FOREIGN KEY (ID_TipoEmpleado) REFERENCES tbl_TipoEmpleado(ID_TipoEmpleado),      
        UNIQUE KEY (ID_Usuario),        
        FOREIGN KEY (ID_Usuario) REFERENCES tbl_Usuario(ID_Usuario)
);

-- ----------------------------------
DROP PROCEDURE IF EXISTS Empleado_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Empleado_Consultar_SP(IN In_ID_Empleado VARCHAR(8))
        
BEGIN
 SET @IdEmpleado = In_ID_Empleado; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_Empleado WHERE ID_Empleado like concat_ws('', @IdEmpleado , "%");
 SELECT 1;       
END//
DELIMITER ;


-- --------------------------------------------

-- -----------------------------------------

DROP PROCEDURE IF EXISTS Empleado_Insertar_SP;
DELIMITER //
CREATE PROCEDURE Empleado_Insertar_SP(
	IN Input_ID_Usuario VARCHAR (36),
    IN Input_ID_TipoEmpleado INT,
    IN Input_Nombre VARCHAR(45),
    IN Input_ApPaterno VARCHAR(45),
    IN Input_ApMaterno VARCHAR(45),
    IN FechaNacimiento VARCHAR(45),
    IN Input_Calle VARCHAR(45),
    IN Input_Colonia VARCHAR(45),
	IN Input_Ciudad VARCHAR(45),
    IN Input_CodigoPostal INT,
    INOUT Out_ID_Empleado VARCHAR(36)
)
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE idEmpleado varchar(36) DEFAULT ' ';
SET idEmpleado= (SELECT UUID());

INSERT INTO tbl_Empleado(
		ID_Empleado,
		ID_Usuario,
        ID_TipoEmpleado,
        Nombre,
        ApPaterno,
        ApMaterno,
        FechaNacimiento,
		Calle,
        Colonia,
        Ciudad,
        CodigoPostal)
        VALUES(
        idEmpleado,
        Input_ID_Usuario,
        Input_ID_TipoEmpleado,
        Input_Nombre,
        Input_ApPaterno,
        Input_ApMaterno,
        FechaNacimiento,
        Input_Calle,
        Input_Colonia,
        Input_Ciudad,
        Input_CodigoPostal
);

SELECT idEmpleado;
SET Out_ID_Empleado=idEmpleado;
-- SET Out_Indicador=indicador+1;
-- SELECT 1;
END //
DELIMITER ;

-- --------------------------------

DROP PROCEDURE IF EXISTS Empleado_Actualizar_SP;  -- ESTE ES EL BUENO
DELIMITER //
CREATE PROCEDURE Empleado_Actualizar_SP(
			IN Input_ID_Empleado VARCHAR (36),
			IN Input_ID_TipoEmpleado INT,
			IN Input_Nombre VARCHAR(45),
			IN Input_ApPaterno VARCHAR(45),
			IN Input_ApMaterno VARCHAR(45),
			IN FechaNacimiento VARCHAR(45),
			IN Input_Calle VARCHAR(45),
			IN Input_Colonia VARCHAR(45),
			IN Input_Ciudad VARCHAR(45),
			IN Input_CodigoPostal INT)
BEGIN

UPDATE tbl_empleado
SET     ID_TipoEmpleado=Input_ID_TipoEmpleado,
        Nombre=Input_Nombre,
        ApPaterno=Input_ApPaterno,
        ApMaterno=Input_ApMaterno,
        FechaNacimiento=FechaNacimiento,
		Calle=Input_Calle,
        Colonia=Input_Colonia,
        Ciudad=Input_Ciudad,
        CodigoPostal=Input_CodigoPostal
        
WHERE ID_Empleado=Input_ID_Empleado;
SELECT 1;

END //
DELIMITER ;

-- --------------------------------


-- ----------------------------------------------------
DROP PROCEDURE IF EXISTS Empleado_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Empleado_Eliminar_SP(IN In_ID_Empleado VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_Empleado 
	WHERE ID_Empleado = In_ID_Empleado; 
	
    SELECT 1;
END //
DELIMITER ;



-- ------------------PROCEDIMIENTOS EMPLEADO_TELEFONO-----------------


drop table if exists tbl_EmpleadoTelefono;

CREATE TABLE tbl_EmpleadoTelefono(
		ID_EmpleadoTelefono VARCHAR(36) NOT NULL,
        ID_Empleado VARCHAR(36) NOT NULL,
        ID_TipoTelefono INT NOT NULL,
		Lada VARCHAR(5) NOT NULL,
        Extension INT NULL,	-- null
		Numero VARCHAR(10) NOT NULL,
        PRIMARY KEY (ID_EmpleadoTelefono),
		FOREIGN KEY(ID_Empleado) REFERENCES tbl_Empleado(ID_Empleado),
        FOREIGN KEY(ID_TipoTelefono) REFERENCES tbl_TipoTelefono(ID_TipoTelefono)
);	
-- -----------------------

DROP PROCEDURE IF EXISTS EmpleadoTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE EmpleadoTelefono_Consultar_SP(IN In_ID_EmpleadoTelefono VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_EmpleadoTelefono 
	WHERE  ID_EmpleadoTelefono = In_ID_EmpleadoTelefono;
        
END//
DELIMITER ;
-- --------------------------------------------


-- -----------------------------------------------
DROP PROCEDURE IF EXISTS EmpleadoTelefono_Insertar_SP;
DELIMITER //
CREATE PROCEDURE EmpleadoTelefono_Insertar_SP(
    IN Input_ID_Empleado VARCHAR(36),
    IN Input_ID_TipoTelefono INT,
    IN Input_Lada VARCHAR(5),
	IN Input_Extension INT,
    IN Input_Numero VARCHAR(10)
)
BEGIN
DECLARE idEmpleadoTelefono varchar(36) DEFAULT ' ';
SET idEmpleadoTelefono= (SELECT UUID());

INSERT INTO tbl_EmpleadoTelefono(
		ID_EmpleadoTelefono,
        ID_Empleado,
        ID_TipoTelefono,
		Lada,
        Extension,
		Numero)
        VALUES(
        idEmpleadoTelefono,
        Input_ID_Empleado,
        Input_ID_TipoTelefono,
        Input_Lada,
        Input_Extension,
        Input_Numero
);

 SELECT 1;
-- SET Out_ID_ClienteTelefono=idClienteTelefono;
SELECT 1;
END //
DELIMITER ;

-- --=------------------------------------------------

DROP PROCEDURE IF EXISTS EmpleadoTelefono_Actualizar_SP;
DELIMITER //
CREATE PROCEDURE EmpleadoTelefono_Actualizar_SP(
    IN Input_ID_Empleado_Telefono VARCHAR(36),
    IN Input_Lada VARCHAR(5),
	IN Input_Extension INT,
    IN Input_Numero VARCHAR(10)
)
BEGIN

UPDATE tbl_empleadotelefono
SET     Lada=Input_Lada,
        Extension=Input_Extension,
		Numero=Input_Numero
        
WHERE ID_EmpleadoTelefono=Input_ID_Empleado_Telefono;
SELECT 1;
END //
DELIMITER ;




use unpa;

-- ---------------------PROCEDIMIENTOS CLIENTE---------------------------------------

CREATE TABLE tbl_Cliente(
		ID_Cliente VARCHAR(36) NOT NULL,
		Nombre VARCHAR(45) NOT NULL,
        ApPaterno VARCHAR(45) NOT NULL,
        ApMaterno VARCHAR(45) NOT NULL,
		Calle VARCHAR(45) NOT NULL,
        Colonia VARCHAR(45) NOT NULL,
        Ciudad VARCHAR(45) NOT NULL,
        CodigoPostal INT NOT NULL,
        PRIMARY KEY (ID_Cliente)
);

-- -------------------------------------------------------------------------

DROP PROCEDURE IF EXISTS Cliente_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Cliente_Consultar_SP(IN In_ID_Cliente VARCHAR(8))
        
BEGIN
 SET @IdCliente = In_ID_Cliente; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_Cliente WHERE ID_Cliente like concat_ws('', @IdCliente, "%");
 SELECT 1;       
END//
DELIMITER ;


-- -------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS Cliente_Insertar_SP;
DELIMITER //
CREATE PROCEDURE Cliente_Insertar_SP(
    IN Input_Nombre VARCHAR(45),
    IN Input_Apellidos VARCHAR(45),
    IN Input_Calle VARCHAR(45),
    IN Input_Colonia VARCHAR(45),
	IN Input_Ciudad VARCHAR(45),
    IN Input_CodigoPostal INT,
    INOUT Out_ID_Cliente VARCHAR(36)
)
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE idCliente varchar(36) DEFAULT ' ';
SET idCliente= (SELECT UUID());

INSERT INTO tbl_Cliente(
		ID_Cliente,
		Nombre,
        Apellidos,
		Calle,
        Colonia,
        Ciudad,
        CodigoPostal)
        VALUES(
        idCliente,
        Input_Nombre,
        Input_Apellidos,
        Input_Calle,
        Input_Colonia,
        Input_Ciudad,
        Input_CodigoPostal
);

SELECT idCliente;
SET Out_ID_Cliente=idCliente;
-- SET Out_Indicador=indicador+1;
-- SELECT 1;
END //
DELIMITER ;

SET @_ID_Cliente=" ";

-- call unpa.Cliente_Insertar_SP('Ozmar','Castillo Martinez','av. Libertad','Polanco Reforma','cdmx',11550,@_ID_Cliente);
-- SELECT @_ID_Cliente AS _ID_Venta;

-- --------------------------------------------------------------------------
-- ---------------------CLIENTE_TELEFONO---------------------------------
drop table if exists tbl_ClienteTelefono;


CREATE TABLE tbl_ClienteTelefono(
		ID_ClienteTelefono VARCHAR(36) NOT NULL,
        ID_Cliente VARCHAR(36) NOT NULL,
        ID_TipoTelefono INT NOT NULL,
		ID_Lada VARCHAR(5),
        Extension INT NULL,	-- null
		Numero VARCHAR(10) NOT NULL,
        PRIMARY KEY (ID_ClienteTelefono),
		FOREIGN KEY(ID_Cliente) REFERENCES tbl_cliente(ID_Cliente),
        FOREIGN KEY(ID_TipoTelefono) REFERENCES tbl_TipoTelefono(ID_TipoTelefono)
);	
-- -----------------------

DROP PROCEDURE IF EXISTS ClienteTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE ClienteTelefono_Consultar_SP(IN In_ID_Cliente VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_ClienteTelefono 
	WHERE  ID_ClienteTelefono = In_ID_Cliente;
        
END//
DELIMITER ;

-- -----
















------------------------------------------

DROP PROCEDURE IF EXISTS ClienteTelefono_Insertar_SP;
DELIMITER //
CREATE PROCEDURE ClienteTelefono_Insertar_SP(
    IN Input_ID_Cliente VARCHAR(36),
    IN Input_ID_TipoTelefono INT,
    IN Input_Lada VARCHAR(5),
	IN Input_Extension INT,
    IN Input_Numero VARCHAR(10)
)
BEGIN
-- DECLARE indicador INT DEFAULT 0;
DECLARE idClienteTelefono varchar(36) DEFAULT ' ';
SET idClienteTelefono= (SELECT UUID());

INSERT INTO tbl_ClienteTelefono(
		ID_ClienteTelefono,
        ID_Cliente,
        ID_TipoTelefono,
		Lada,
        Extension,	
		Numero)
        VALUES(
        idClienteTelefono,
        Input_ID_Cliente,
        Input_ID_TipoTelefono,
        Input_Lada,
        Input_Extension,
        Input_Numero
);
SELECT idClienteTelefono;
-- SET Out_ID_ClienteTelefono=idClienteTelefono;
-- SELECT 1;
END //
DELIMITER ;

-- --------------PROCEDIMIENTOS PROVEEDOR------------------

CREATE TABLE tbl_Proveedor(
		ID_Proveedor VARCHAR(36) NOT NULL,
		Nombre VARCHAR(45) NOT NULL,
     	Calle VARCHAR(45) NOT NULL,
        Colonia VARCHAR(45) NOT NULL,
        Ciudad VARCHAR(45) NOT NULL,
        CodigoPostal INT NOT NULL,
        PRIMARY KEY (ID_Proveedor)
);

-- ----------------------------------------------
DROP PROCEDURE IF EXISTS Proveedor_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Proveedor_Consultar_SP(IN In_ID_Proveedor VARCHAR(8))
        
BEGIN
 SET @IdUsuario = In_ID_Proveedor; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_Proveedor WHERE ID_Proveedor like concat_ws('', @IdUsuario, "%");
 SELECT 1;       
END//
DELIMITER ;


-- ----------------------
DROP PROCEDURE IF EXISTS Proveedor_ConsultarTelefono_SP;
DELIMITER //
CREATE PROCEDURE Proveedor_ConsultarTelefono_SP(IN In_ID_Proveedor VARCHAR(36))
        
BEGIN
SELECT  * FROM tbl_Proveedor 
	WHERE  ID_Proveedor = In_ID_Proveedor;
 SELECT 1;       
END//
DELIMITER ;


-- ---------------------------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_Proveedor_Actualizar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Proveedor_Actualizar_SP(
			IN input_Id_Proveedor VARCHAR (8), -- con las primeras 8 digitos del id
			IN Input_Nombre VARCHAR(45),
			IN Input_Calle VARCHAR(45),
			IN Input_Colonia VARCHAR(45),
			IN Input_Ciudad VARCHAR(45),
			IN Input_CodigoPostal INT)
BEGIN
SET @IdProveedor = input_Id_Proveedor;
UPDATE tbl_Proveedor
SET     Nombre=Input_Nombre,
     	Calle=Input_Calle,
        Colonia=Input_Colonia,
        Ciudad=Input_Ciudad,
        CodigoPostal=Input_CodigoPostal
        
WHERE ID_Proveedor like concat_ws('', @IdProveedor, "%");
SELECT 1;

END //
DELIMITER ;
-- ---------------------------------------------

DROP PROCEDURE IF EXISTS Proveedor_Actualizar_SP;  -- ESTE ES EL BUENO
DELIMITER //
CREATE PROCEDURE Proveedor_Actualizar_SP(
			IN input_Id_Proveedor VARCHAR (36),
			IN Input_Nombre VARCHAR(45),
			IN Input_Calle VARCHAR(45),
			IN Input_Colonia VARCHAR(45),
			IN Input_Ciudad VARCHAR(45),
			IN Input_CodigoPostal INT)
BEGIN

UPDATE tbl_Proveedor
SET     Nombre=Input_Nombre,
     	Calle=Input_Calle,
        Colonia=Input_Colonia,
        Ciudad=Input_Ciudad,
        CodigoPostal=Input_CodigoPostal
        
WHERE ID_Proveedor =input_Id_Proveedor;
SELECT 1;

END //
DELIMITER ;

-- call Proveedor_Consultar_SP('311c89e9');


-- call Proveedor_Actualizar_SP('311c89e9-70c7-11e8-9efa-28d244202eee','CAT','Av. Chapultepec','Loamas de Cahapultepec','CDMX',68400);
-- ----------------------------------------------------

DROP PROCEDURE IF EXISTS Proveedor_Insertar_SP;
DELIMITER //
CREATE PROCEDURE Proveedor_Insertar_SP(
    IN Input_Nombre VARCHAR(45),
    IN Input_Calle VARCHAR(45),
    IN Input_Colonia VARCHAR(45),
	IN Input_Ciudad VARCHAR(45),
    IN Input_CodigoPostal INT,
    INOUT Out_ID_Proveedor VARCHAR(36)
)
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE idProveedor varchar(36) DEFAULT ' ';
SET idProveedor= (SELECT UUID());

INSERT INTO tbl_Proveedor(
		ID_Proveedor,
		Nombre,
     	Calle,
        Colonia,
        Ciudad,
        CodigoPostal)
        VALUES(
        idProveedor,
        Input_Nombre,
        Input_Calle,
        Input_Colonia,
        Input_Ciudad,
        Input_CodigoPostal
);

SELECT idProveedor;
 SET Out_ID_Proveedor=idProveedor;
-- SET Out_Indicador=indicador+1;
-- SELECT 1;
END //
DELIMITER ;

SET @_ID_Proveedor = ' ';



-- call unpa.Producto_Insertar_SP('Truper','Guadalupe Vectoria','Portales','CDMX',68400,@_ID_Proveedor);

-- -------------------------------------------------
-- --------PROVEEDOR_TELEFONO-------------------------
-- ----------------------------------------------
DROP TABLE IF EXISTS tbl_ProveedorTelefono;
CREATE TABLE tbl_ProveedorTelefono(
		ID_ProveedorTelefono VARCHAR (36) NOT NULL,
        ID_Proveedor VARCHAR(36) NOT NULL,
        ID_TipoTelefono INT NOT NULL,
		Lada VARCHAR(5) NOT NULL,
        Extension INT NULL,	-- null
		Numero VARCHAR(10) NOT NULL,
        PRIMARY KEY (ID_ProveedorTelefono),
        FOREIGN KEY(ID_Proveedor) REFERENCES tbl_proveedor(ID_Proveedor),
        FOREIGN KEY(ID_TipoTelefono) REFERENCES tbl_TipoTelefono(ID_TipoTelefono)
);	

-- ---------------------------------------------------

DROP PROCEDURE IF EXISTS ProveedorTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Consultar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_ProveedorTelefono 
	WHERE  ID_Proveedor = In_ID_Proveedor;
        
END//
DELIMITER ;

-- ------------------------------------------

DROP PROCEDURE IF EXISTS ProveedorTelefono_Actualizar_SP;
DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Actualizar_SP(
    IN Input_ID_Proveedor_Telefono VARCHAR(36),
    IN Input_Lada VARCHAR(5),
	IN Input_Extension INT,
    IN Input_Numero VARCHAR(10)
)
BEGIN

UPDATE tbl_ProveedorTelefono
SET     Lada=Input_Lada,
        Extension=Input_Extension,
		Numero=Input_Numero
        
WHERE ID_ProveedorTelefono=Input_ID_Proveedor_Telefono;
SELECT 1;
END //
DELIMITER ;



-- ------------------------------------------------
DROP PROCEDURE IF EXISTS ProveedorTelefono_Insertar_SP;
DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Insertar_SP(
    IN Input_ID_Proveedor VARCHAR(36),
    IN Input_ID_TipoTelefono INT,
    IN Input_Lada VARCHAR(5),
	IN Input_Extension INT,
    IN Input_Numero VARCHAR(10)
)
BEGIN
 DECLARE indicador INT DEFAULT 0;
 DECLARE idProveedor varchar(36) DEFAULT ' ';
 SET idProveedor= (SELECT UUID());

INSERT INTO tbl_ProveedorTelefono(
		ID_ProveedorTelefono,
        ID_Proveedor,
        ID_TipoTelefono,
		Lada,
        Extension,
		Numero)
        VALUES(
        idProveedor,
        Input_ID_Proveedor,
        Input_ID_TipoTelefono,
        Input_Lada,
        Input_Extension,
        Input_Numero
);

-- SELECT idProveedor;
-- SET Out_ID_Proveedor=idProveedor;
SET indicador=indicador+1;
SELECT indicador;
END //
DELIMITER ;


-- SET @_ID_ProveedorTelefono = ' ';

-- -------------------------ACTUALIZAR-------------------------------------

-- ---------------------------------
-- -----------------------PROCEDIMIENTOS PRODUCTO--------------------------
-- --------------------------------------------------------------------
-- ---------------------------------------------------------------
-- -------------------------------------------------------------
DROP TABLE IF EXISTS  tbl_Producto;

CREATE TABLE tbl_Producto(
		ID_Producto  VARCHAR(36) NOT NULL,
        ID_Proveedor VARCHAR(36) NOT NULL,
        ID_tipoProducto INT NOT NULL,
        Nombre VARCHAR(45) NOT NULL,
		Existencia FLOAT NOT NULL,
        Precio FLOAT NOT NULL,
        Marca VARCHAR(45) NOT NULL,
        DescuentoPorciento INT NULL,	-- LO HICE CON VARCHAR PORQUE CON TIPO DATE SOLO INSERTABA 00-00-0000
        PRIMARY KEY (ID_Producto),
        FOREIGN KEY(ID_Proveedor) REFERENCES tbl_proveedor(ID_Proveedor),
        FOREIGN KEY(ID_tipoProducto) REFERENCES Tbl_TipoProducto(ID_tipoProducto)
);

-- ---------------------------------------------     

DROP PROCEDURE IF EXISTS Producto_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Producto_Consultar_SP(IN In_ID_Producto VARCHAR(8))
        
BEGIN
 SET @IdProducto = In_ID_Producto; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_Producto WHERE ID_Producto like concat_ws('',@IdProducto, "%");
 SELECT 1;       
END//
DELIMITER ;


-- --------------------------------------------------------------------

DROP PROCEDURE IF EXISTS Producto_Insertar_SP; 
DELIMITER //
CREATE PROCEDURE Producto_Insertar_SP(
    IN Input_ID_Proveedor VARCHAR(36),
	IN Input_ID_tipoProducto INT ,
    IN Input_Nombre VARCHAR(45),
    IN Input_Existencia FLOAT,
    IN Input_Precio FLOAT,
    IN Input_Marca VARCHAR(45),
    IN Input_DescuentoPorciento INT
)
BEGIN
DECLARE idProducto varchar(36) DEFAULT ' ';
SET idProducto= (SELECT UUID());

INSERT INTO tbl_Producto(
		ID_Producto,        
        ID_Proveedor,
        ID_tipoProducto,
        Nombre,
		Existencia,
        Precio,
        Marca,
        DescuentoPorciento)
        VALUES(
        idProducto,
        Input_ID_Proveedor,
        Input_ID_tipoProducto,
        Input_Nombre,
        Input_Existencia,
        Input_Precio,
        Input_Marca,
        Input_DescuentoPorciento
);

SELECT 1;


-- SELECT 1;
END //
DELIMITER ;


-- -------------PROCEDIMIENTOS PROVEEDOR_PRODUCTO-------------
-- ----------------------------------------------------------- ----------------------------------------------------------------
DROP TABLE IF EXISTS tbl_ProveedorProducto;

CREATE TABLE tbl_ProveedorProducto(   
	ID_Proveedor VARCHAR(36) NOT NULL,   
	ID_Producto VARCHAR(36) NOT NULL, 
    Cantidad FLOAT NOT NULL,        
	Subtotal FLOAT NOT NULL,         
	ImporteTotal FLOAT NOT NULL,        
	Fecha VARCHAR(10) NOT NULL,
    FOREIGN KEY(ID_Proveedor) REFERENCES tbl_Proveedor(ID_Proveedor),
    FOREIGN KEY(ID_Producto) REFERENCES tbl_Producto(ID_Producto)
    
);
-- -----------------------------
-- COMO PUEDO FILTRAR PARA ESTA CONSULTA
DROP PROCEDURE IF EXISTS ProveedorProducto_Consultar_SP;
DELIMITER //
CREATE PROCEDURE ProveedorProducto_Consultar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_ProveedorProducto 
	WHERE  ID_Proveedor = In_ID_Proveedor;
        

END//
DELIMITER ;
-- --------------------------------------------------

DROP PROCEDURE IF EXISTS ProveedorProducto_Insertar_SP; 
DELIMITER //
CREATE PROCEDURE ProveedorProducto_Insertar_SP(
	In_ID_Proveedor VARCHAR(36) ,   
	In_ID_Producto VARCHAR(36) , 
    In_Cantidad FLOAT ,        
	In_Subtotal FLOAT ,         
	In_ImporteTotal FLOAT ,        
	In_Fecha VARCHAR(10) 
    )
    
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE id INT DEFAULT 0;

INSERT INTO tbl_ProveedorProducto(
	ID_Proveedor  ,   
	ID_Producto, 
    Cantidad ,        
	Subtotal,         
	ImporteTotal,        
	Fecha)
        VALUES(
        In_ID_Proveedor,
        In_ID_Producto,
        In_Cantidad,
        In_Subtotal,
        In_ImporteTotal,
        In_Fecha       
);

SELECT 1;
END //
DELIMITER ;


-- -----------------------PROCEDIMIENTOS VENTA-----------------------------------------
drop table if exists tbl_venta;
CREATE TABLE tbl_venta(
		ID_Venta VARCHAR(36) NOT NULL,
		ID_Cliente VARCHAR(36) NOT NULL,
        ID_Empleado VARCHAR(36) NOT NULL,
        ImporteTotal FLOAT NOT NULL,
        FechaVenta VARCHAR(10) NOT NULL,	
        PRIMARY KEY (ID_Venta),
        FOREIGN KEY(ID_Cliente) REFERENCES tbl_cliente(ID_Cliente),
        FOREIGN KEY(ID_Empleado) REFERENCES tbl_empleado(ID_Empleado) -- idEmpleado -- ------------------
);

-- ------------------------------------------------------

DROP PROCEDURE IF EXISTS Venta_Consultar_SP;
DELIMITER //
CREATE PROCEDURE Venta_Consultar_SP(IN In_ID_Venta VARCHAR(8))
        
BEGIN
 SET @IdVenta = In_ID_Venta; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_venta WHERE ID_Venta like concat_ws('',@IdVenta, "%");
 SELECT 1;       
END//
DELIMITER ;



-- ---------------------------------
DROP PROCEDURE IF EXISTS Venta_Insertar_SP;
DELIMITER //
CREATE PROCEDURE Venta_Insertar_SP(
    IN Input_ID_Cliente VARCHAR(36),
    IN Input_ID_Empleado VARCHAR(36),
    IN Input_ImporteTotal FLOAT,
	IN Input_FechaVenta VARCHAR(10),
    INOUT Out_ID_Venta VARCHAR(36)
)
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE idVenta varchar(36) DEFAULT ' ';
SET idVenta= (SELECT UUID());

INSERT INTO tbl_venta(
		ID_Venta,
        ID_Cliente,
        ID_Empleado,
        ImporteTotal,
        FechaVenta)
        VALUES(
        idVenta,
        Input_ID_Cliente,
        Input_ID_Empleado,
        Input_ImporteTotal,
        Input_FechaVenta
);

SELECT idVenta;
SET Out_ID_Venta=idVenta;
-- SET Out_Indicador=indicador+1;
-- SELECT 1;
END //
DELIMITER ;

SET @_ID_Venta=" ";

-- ------------------------------------------------------------------
-- --------------------                           --------------------
-- --------------------PROCEDIMIENTO VENTA DETALLE -------------------

drop table if exists tbl_DetalleVenta;

CREATE TABLE tbl_DetalleVenta(
		ID_DetalleVenta VARCHAR(36) NOT NULL,
        ID_Venta VARCHAR(36) NOT NULL,
		ID_Producto VARCHAR(36) NOT NULL,
        Producto VARCHAR(45) NOT NULL,
        Precio FLOAT NOT NULL,
        Cantidad FLOAT NOT NULL,
        Subtotal FLOAT NOT NULL,	
		PRIMARY KEY (ID_DetalleVenta),
		FOREIGN KEY(ID_Venta) REFERENCES tbl_venta(ID_Venta),
        FOREIGN KEY(ID_Producto) REFERENCES tbl_Producto(ID_Producto)
);

 -- CON QUE CAMPO SE PUEDE HACER EL FILTRO EN ESTA PARTE
-- -------------------------------------------------

DROP PROCEDURE IF EXISTS DetalleVenta_Consultar_SP;
DELIMITER //
CREATE PROCEDURE DetalleVenta_Consultar_SP(IN In_ID_Venta VARCHAR(8))
        
BEGIN
 SET @IdVenta = In_ID_Venta; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_DetalleVenta WHERE ID_Venta like concat_ws('',@IdVenta, "%");
 SELECT 1;       
END//
DELIMITER ;


-- --------------------------------------------------------------

-- --------------------------------------------------------------

DROP PROCEDURE IF EXISTS DetalleVenta_Insertar_SP;

DELIMITER //

CREATE PROCEDURE DetalleVenta_Insertar_SP(
    IN Input_ID_Venta VARCHAR(36),
    IN Input_ID_Producto VARCHAR(36),
    IN Input_Producto VARCHAR(45),
    IN Input_Precio FLOAT,
	IN Input_Cantidad FLOAT,
    IN Input_Subtotal FLOAT,
    INOUT Out_ID_DetalleVenta VARCHAR(36)
)
BEGIN
DECLARE indicador INT DEFAULT 0;
DECLARE idDetalleVenta varchar(36) DEFAULT ' ';
SET idDetalleVenta= (SELECT UUID());

INSERT INTO tbl_DetalleVenta(
		ID_DetalleVenta,
        ID_Venta,
		ID_Producto,
        Producto,
        Precio,
        Cantidad,
        Subtotal)
        VALUES(
        idDetalleVenta,
        Input_ID_Venta,
        Input_ID_Producto,
        Input_Producto,
        Input_Precio,
        Input_Cantidad,
        Input_Subtotal
);
SELECT idDetalleVenta;
SET Out_ID_DetalleVenta=idDetalleVenta;
-- SELECT 1;
END //
DELIMITER ;
-- -------------------------------------------------


DROP PROCEDURE IF EXISTS Proveedor_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Proveedor_Eliminar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_Proveedor 
	WHERE ID_Proveedor = In_ID_Proveedor; 
	
    SELECT 1;
END //
DELIMITER ;

-- call Proveedor_Eliminar_SP('Proveedor_Eliminar_SP');
-- -------------------------------------------------------
DROP PROCEDURE IF EXISTS Proveedor_EliminarV2_SP;
DELIMITER //
CREATE PROCEDURE Proveedor_EliminarV2_SP(IN In_ID_Proveedor VARCHAR(8))
        
BEGIN
 SET @IdProveedor = In_ID_Proveedor; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 DELETE FROM tbl_Proveedor WHERE ID_Proveedor like concat_ws('',@IdProveedor, "%");
 SELECT 1;       
END//
DELIMITER ;


-- SELECT * FROM tbl_Proveedor;
-- call Proveedor_EliminarV2_SP('cc962698');


-- ---------------------------------------------------------------------

DROP PROCEDURE IF EXISTS ProveedorTelefono_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Eliminar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_ProveedorTelefono 
	WHERE ID_Proveedor = In_ID_Proveedor; 
	
    SELECT 1;
END //
DELIMITER ;
-- ----------------------------------------
-- ELIMINAR TELEFONO_EMPLEADO

DROP PROCEDURE IF EXISTS Empleado_Telefono_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Empleado_Telefono_Eliminar_SP(IN In_ID_Empleado VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_empleadotelefono 
	WHERE ID_Empleado = In_ID_Empleado; 
	
    SELECT 1;
END //
DELIMITER ;


call Empleado_Telefono_Eliminar_SP('99aa2c3c-7d97-11e8-ad57-28d244202eee');







-- -----------ELIMINAR TELEFONO Proveedor---------------------------

DROP PROCEDURE IF EXISTS Telefono_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Telefono_Eliminar_SP(IN In_ID_Proveedor_Telefono VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_ProveedorTelefono 
	WHERE ID_ProveedorTelefono = In_ID_Proveedor_Telefono; 
	
    SELECT 1;
END //
DELIMITER ;

-- ------------------------


-- ---------------------------

-- call Proveedor_Eliminar_SP('dc679f98-71a7-11e8-9efa-28d244202eee');

-- SELECT * FROM unpa.tbl_proveedor;
-- ------------------------------------
DROP PROCEDURE IF EXISTS Proveedor_ConsultarTodo_SP;

DELIMITER //
CREATE PROCEDURE Proveedor_ConsultarTodo_SP()
BEGIN  
     SELECT 
		ID_Proveedor,
		Nombre,
     	Calle,
        Colonia,
        Ciudad ,
        CodigoPostal
	 FROM
	   tbl_proveedor;
       
END//
DELIMITER ;

-- ---------------------------------------------------
DROP PROCEDURE IF EXISTS ProveedorTelefono_ConsultarTodo_SP;

DELIMITER //
CREATE PROCEDURE ProveedorTelefono_ConsultarTodo_SP()
BEGIN  
     SELECT 
		ID_ProveedorTelefono,
        ID_Proveedor,
        ID_TipoTelefono,
		Lada,
        Extension,	
		Numero
	 FROM 
	   tbl_ProveedorTelefono;
END//
DELIMITER ;

-- ----------------------------------------------
-- CONSULTAR TODOS LOS PRODUCTOS
DROP PROCEDURE IF EXISTS Producto_ConsultarTodo_SP;

DELIMITER //
CREATE PROCEDURE Producto_ConsultarTodo_SP(IN Input_Tipo_Producto int)
BEGIN  
     SELECT 
		ID_Producto,
		ID_Proveedor,
     	ID_tipoProducto,
        Nombre,
        Existencia,
        Precio,
        Marca,
        DescuentoPorciento
	 FROM
	   tbl_producto where ID_tipoProducto=Input_Tipo_Producto;
       
select 1;       
END//
DELIMITER ;

CALL Producto_ConsultarTodo_SP(1);
-- --------------------------------------------
use unpa;

CALL Telefono_Eliminar_SP('998f4583-7726-11e8-b76c-28d244202eee');
call ProveedorTelefono_Actualizar_SP('31a98988-70c7-11e8-9efa-28d244202eee','045',9,'54760814');

call Proveedor_ConsultarTodo_SP();

call Proveedor_Consultar_SP('f2053fed');
call Proveedor_Eliminar_SP('e04e6a25-776e-11e8-a8ab-28d244202eee');
call Empleado_Eliminar_SP('9fc223ad-7cad-11e8-bf9d-28d244202eee');

call Empleado_Consultar_SP('f2053fed');
CALL Usuario_Consultar_SP('0192b359-7cc6-11e8-9c3d-28d244202eee');

*/