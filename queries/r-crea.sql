spool 2017-02-24-tablespaces-C.log
--Eliminar tablespace en cascada con sus objetos
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

spool off
