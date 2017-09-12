spool 2017-02-24-tablespaces-C.log
--Eliminar tablespace en cascada con sus objetos
drop tablespace TBSP01 including contents and datafiles;

CREATE TABLESPACE TBSP01 datafile
'C:\oraclexe\app\oracle\oradata\XE\TBSP01.DBF'
size 10M REUSE AUTOEXTEND off;
CREATE TABLE PRUEBA_TBS01(DATOS NUMBER) TABLESPACE TBSP01;
--BLOQUE DE COMANDOS PL/SQL
DECLARE 
  X NUMBER :=0;
BEGIN
WHILE X<100000 LOOP INSERT INTO PRUEBA_TBS01(DATOS)VALUES (1000000);
COMMIT;
X:= X+1;
END LOOP;
END;
/
select count (*) from PRUEBA_TBS01;
spool off
