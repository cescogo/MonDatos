select   TABLESPACE_NAME,  Round(USED_SPACE/1024,0) AS USED_SPACE_MB,Round(TABLESPACE_SIZE/1024,0)as TABLESPACE_SIZE_MB,round(TABLESPACE_SIZE/1024-USED_SPACE/1024,0) as Free,Round(USED_PERCENT,2) as "%" From DBA_TABLESPACE_USAGE_METRICS;

--Cursor con nombre tables y indices que vengan en tablespace , para cada registro del cursor calcular la tasa de transaccion. y acumularla (los bytes);