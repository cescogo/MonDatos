select a.bytes, (a.bytes*b.bytes)/1024/1024 total_usado_mbfrom
(SELECT sum(data_length) bytes FROM all_tab_columns where table_name = 'USERS' group by table_name) a,
(select count(*) bytes from test) b;