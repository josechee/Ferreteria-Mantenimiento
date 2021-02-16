DROP DATABASE IF EXISTS unpa;
CREATE DATABASE unpa;
use unpa;

-- Storage Procedure tipoTelefono
-- --crear tabla tipo telefono
CREATE TABLE tbl_TipoTelefono(
		ID_TipoTelefono INT NOT NULL,
		Descripcion VARCHAR(45) NOT NULL,
        PRIMARY KEY (ID_TipoTelefono)
);

-- 1. consultar tipo telefono---------------------
DROP PROCEDURE IF EXISTS tbl_TipoTelefono_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_TipoTelefono_Consultar_SP(IN In_ID_TipoTelefono VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_TipoTelefono 
	WHERE  ID_TipoTelefono = In_ID_TipoTelefono;
        
END//
DELIMITER ;

-- 2. insertar tipo telefono
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

call tbl_TipoTelefono_Insertar_SP(1,'Telefono Personal');
call tbl_TipoTelefono_Insertar_SP(2,'Telefono Casa');
call tbl_TipoTelefono_Insertar_SP(3,'Telefono Oficina');