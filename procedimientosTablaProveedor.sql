-- procedimientos tabla proveedor

-- crear tabla proveedor
CREATE TABLE tbl_Proveedor(
		ID_Proveedor VARCHAR(36) NOT NULL,
		Nombre VARCHAR(45) NOT NULL,
     	Calle VARCHAR(45) NOT NULL,
        Colonia VARCHAR(45) NOT NULL,
        Ciudad VARCHAR(45) NOT NULL,
        CodigoPostal INT NOT NULL,
        PRIMARY KEY (ID_Proveedor)
);

-- 1. consultar proveedor lo consulta solo con los 8 digitos
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

-- call Proveedor_Consultar_SP('7973f5f9'); 

-- 1.1. consultar proveedor por nombre
DROP PROCEDURE IF EXISTS Proveedor_ConsultarConNombre_SP;
DELIMITER //
CREATE PROCEDURE Proveedor_ConsultarConNombre_SP(IN In_Nombre_Proveedor VARCHAR(45))
        
BEGIN
 SET @IdUsuario = In_Nombre_Proveedor; 
 -- SELECT concat_ws('', @IdUsuario, "%");        
 SELECT * FROM tbl_Proveedor WHERE Nombre like concat_ws('', @IdUsuario, "%");
 SELECT 1;       
END//
DELIMITER ;

 call Proveedor_ConsultarConNombre_SP('FERRE_CHEE');

-- ----------------------------------------------------------------
-- 3. actualizar datos del proveedor
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


-- 4. actualizar datos del proveedor #ESTE ES EL BUENO
DROP PROCEDURE IF EXISTS Proveedor_Actualizar_SP;  
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

-- 5. insertar datos del proveedor o agregar un proveedor a la base de datos
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

-- 6. eliminar proveedor
DROP PROCEDURE IF EXISTS Proveedor_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE Proveedor_Eliminar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_Proveedor 
	WHERE ID_Proveedor = In_ID_Proveedor; 
	
    SELECT 1;
END //
DELIMITER ;
-- PROCEDIMIENTOS TELEFONO PROVEEDOR
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

-- 2. consultar telefono del proveedor de la tabla del proveedor [tbl_Proveedor]
-- este solo me regresa un 1 por el select 1
DROP PROCEDURE IF EXISTS Proveedor_ConsultarTelefono_SP; 
DELIMITER //
CREATE PROCEDURE Proveedor_ConsultarTelefono_SP(IN In_ID_Proveedor VARCHAR(36))
        
BEGIN
SELECT  * FROM tbl_Proveedor 
	WHERE  ID_Proveedor = In_ID_Proveedor;
 SELECT 1;       
END//
DELIMITER ;

##call Proveedor_ConsultarTelefono_SP('7973f5f9-7007-11eb-b5d2-28d244202eee');
-- 3. consultar telefono del proveedor de la tabla del proveedor telefono [tbl_ProveedorTelefono]
##Este si me regresa los tres telefonos del proveedor con el ID_Proveedor
DROP PROCEDURE IF EXISTS ProveedorTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Consultar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_ProveedorTelefono 
	WHERE  ID_Proveedor = In_ID_Proveedor;
        
END//
DELIMITER ;

-- call ProveedorTelefono_Consultar_SP('7973f5f9-7007-11eb-b5d2-28d244202eee');

-- 4 consultar a todos los proveedores
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

call Proveedor_ConsultarTodo_SP();

-- 5. actualizar telefono del proveedor
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


-- 6. insertar telefono del proveedor
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

-- 7. eliminar telefono del proveedor
DROP PROCEDURE IF EXISTS ProveedorTelefono_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE ProveedorTelefono_Eliminar_SP(IN In_ID_Proveedor VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_ProveedorTelefono 
	WHERE ID_Proveedor = In_ID_Proveedor; 
	
    SELECT 1;
END //
DELIMITER ;
