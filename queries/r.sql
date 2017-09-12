spool 2017-02-24-tablespaces-C.log
--Eliminar tablespace en cascada con sus objetos
drop tablespace TBSP01 including contents and datafiles;

CREATE TABLESPACE TBSP01 datafile
'C:\oraclexe\app\oracle\oradata\XE\TBSP01.DBF'
size 10M REUSE AUTOEXTEND off;
CREATE TABLE PRUEBA_TBS01(DATOS NUMBER) TABLESPACE TBSP01;

spool off
